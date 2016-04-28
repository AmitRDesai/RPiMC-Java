package rpimc;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;

public abstract class Motor {
	protected static GpioPinDigitalOutput leftMotorForward, leftMotorBaclward;
	protected static GpioPinDigitalOutput rightMotorForward,
			rightMotorBaclward;
	public static int state = 0;

	public static void initilize() {
		GpioController gpioController = GpioFactory.getInstance();
		leftMotorForward = gpioController
				.provisionDigitalOutputPin(RaspiPin.GPIO_00);
		leftMotorBaclward = gpioController
				.provisionDigitalOutputPin(RaspiPin.GPIO_01);
		rightMotorForward = gpioController
				.provisionDigitalOutputPin(RaspiPin.GPIO_03);
		rightMotorBaclward = gpioController
				.provisionDigitalOutputPin(RaspiPin.GPIO_04);
	}

	abstract public void left();

	abstract public void right();

	public void forword() {
		state = 1;
		leftMotorBaclward.setState(false);
		rightMotorBaclward.setState(false);
		leftMotorForward.setState(true);
		rightMotorForward.setState(true);
	}

	public void backword() {
		state = 2;
		leftMotorForward.setState(false);
		rightMotorForward.setState(false);
		leftMotorBaclward.setState(true);
		rightMotorBaclward.setState(true);

	}

	public void stop() {
		state = 0;
		leftMotorBaclward.setState(false);
		rightMotorBaclward.setState(false);
		leftMotorForward.setState(false);
		rightMotorForward.setState(false);
	}
}
