package rpimc;

public class Motor2 extends Motor {

	public void left() {
		state = 3;
		leftMotorBaclward.setState(true);
		rightMotorBaclward.setState(false);
		leftMotorForward.setState(false);
		rightMotorForward.setState(true);
	}

	public void right() {
		state = 4;
		leftMotorBaclward.setState(false);
		rightMotorBaclward.setState(true);
		rightMotorForward.setState(false);
		leftMotorForward.setState(true);
	}
}
