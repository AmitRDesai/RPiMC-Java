package rpimc;

public class Motor1 extends Motor {

	public void left() {
		state = 3;
		leftMotorBaclward.setState(false);
		rightMotorBaclward.setState(false);
		leftMotorForward.setState(false);
		rightMotorForward.setState(true);
	}

	public void right() {
		state = 4;
		leftMotorBaclward.setState(false);
		rightMotorBaclward.setState(false);
		rightMotorForward.setState(false);
		leftMotorForward.setState(true);

	}
}
