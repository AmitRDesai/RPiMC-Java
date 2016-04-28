package rpimc;

import java.io.ObjectInputStream;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.rpimc.hari.rpimc.Command;

public class Start {

	public static Command_Q queue;
	public static Motor motor;
	static Connection con;
	final static Lock lock = new ReentrantLock();
	final static Condition notFull = lock.newCondition();
	final static Condition notEmpty = lock.newCondition();
	final static Object obj = new Object();

	public static void main(String[] args) {
		// System.out.println(ManagementFactory.getRuntimeMXBean().getName());
		Motor.initilize();
		motor = new Motor1();
		//queue = new Command_Q();
		con = ConnectionManager.connect();

		if (con != null)
			System.out.println("Connected");

		new Thread(new CommadReciever(con)).start();
		//new Thread(new ExecuterThread()).start();
	}

	public static class ExecuterThread extends Thread {

		@Override
		public void run() {
			while (true) {
				try {
					lock.lock();
					while (queue.isEmpty())
						notEmpty.await();
					Command command = queue.deQ();
					notFull.signal();
					lock.unlock();
					MotorController motorController = new MotorController(
							command);
					motorController.execute();
				} catch (Exception e) {
					System.out.println(e.getMessage());
					obj.notify();
				}
			}
		}
	}

	public static class CommadRecieverV2 implements Runnable {

		@Override
		public void run() {
			while (true) {
				Command command;
				try {
					ObjectInputStream ois = new ObjectInputStream(
							con.getInputStream());
					command = (Command) ois.readObject();
					while (queue.isFull())
						notFull.await();
					queue.enQ(command);
					notEmpty.signal();
					lock.unlock();
				} catch (Exception e) {
					System.out.println(e.getMessage());
					return;
				}
			}
		}
	}

	public static class ExitApp implements Runnable {

		@Override
		public void run() {
			try {
				obj.wait();
				System.exit(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}