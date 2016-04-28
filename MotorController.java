package rpimc;

import java.util.ArrayList;

import com.rpimc.hari.rpimc.Command;
import com.rpimc.hari.rpimc.Line;

public class MotorController {
	private Command command;
	public static int scale = 3;

	public MotorController(Command command) {
		this.command = command;
	}

	public void execute() {
		if (command.forward == 1 && Motor.state != 1) {
			System.out.println("Forward");
			Start.motor.forword();
		} else if (command.backward == 1 && Motor.state != 2) {
			System.out.println("Backward");
			Start.motor.backword();
		} else if (command.left == 1 && Motor.state != 3) {
			System.out.println("Left");
			Start.motor.left();
		} else if (command.right == 1 && Motor.state != 4) {
			System.out.println("Right");
			Start.motor.right();
		} else if (command.stop == 1 && Motor.state != 0) {
			System.out.println("Stop");
			Start.motor.stop();
		} else if (command.msg.equals("exit")) {
			System.exit(0);
		} else if (command.msg.equals("change")) {
			if (command.data.equals("1"))
				Start.motor = new Motor1();
			else if (command.data.equals("2"))
				Start.motor = new Motor2();
		} else if (command.msg.endsWith("scale")) {
			scale = Integer.parseInt(command.data);
		} else if (command.msg.equals("v_line")) {

			System.out.println("virtul line");
			ArrayList<Line> lines = command.lines;
			Start.motor.forword();
			try {
				Thread.sleep((long) (scale * lines.get(0).lenght()));
				int i;
				for (i = 1; i < lines.size(); i++) {
					double angle = Line.angle(lines.get(i - 1), lines.get(i));
					FollowLine.follow(angle, lines.get(i - 1).getType(), lines.get(i).getType(), lines.get(i).slope(),
							lines.get(i - 1).slope());
					Start.motor.forword();
					Thread.sleep((long) (scale * lines.get(i).lenght()));
				}
				Thread.sleep((long) (scale * lines.get(i).lenght()));
				Start.motor.stop();
			} catch (Exception e) {
				Start.motor.stop();
				System.out.println(e.getMessage());
			}
		}
	}
}