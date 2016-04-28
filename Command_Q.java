package rpimc;

import com.rpimc.hari.rpimc.Command;

public class Command_Q {
	public Command command[];
	private final int MAX = 128;
	private int fornt = -1, rear = -1;

	public Command_Q() {
		command = new Command[MAX];
	}

	public boolean isEmpty() {
		if (fornt == -1 & rear == -1)
			return true;
		else
			return false;
	}

	public boolean isFull() {
		if (fornt == rear % MAX + 1)
			return true;
		else
			return false;
	}

	public boolean enQ(Command c) {
		// System.out.println("f:" + fornt + ",r:" + rear);
		if (fornt == -1) {
			fornt = rear = 0;
			command[fornt] = c;
			return true;
		} else {
			int next = rear % MAX + 1;
			rear = next;
			command[rear] = c;
			return true;
		}
	}

	public Command deQ() {
		Command c = null;
		// System.out.println("f:" + fornt + ",r:" + rear);
		c = command[fornt];
		if (fornt == rear)
			fornt = rear = -1;
		else
			fornt = fornt % MAX + 1;
		return c;
	}

	public void flush() {
		fornt = rear = -1;
	}
}
