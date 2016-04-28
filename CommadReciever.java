package rpimc;

import java.io.ObjectInputStream;

import com.rpimc.hari.rpimc.Command;

public class CommadReciever extends Thread{
	private Connection con;

	public CommadReciever(Connection con) {
		this.con = con;

	}
	@Override
	public void run() {
		// Scanner sc=new Scanner(con.getInputStream());
				while (true) {
					Command command;
					try {
						ObjectInputStream ois = new ObjectInputStream(
								con.getInputStream());
						command = (Command) ois.readObject();
						MotorController motorController = new MotorController(command);
						motorController.execute();
						//Start.queue.enQ(command);
					} catch (Exception e) {
						System.out.println(e.getMessage());
						return;
					}
				}
	}
	
}
