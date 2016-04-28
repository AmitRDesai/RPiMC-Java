package rpimc;

public class FollowLine {
	public static void follow(double angle, int type1, int type2, float slope1,
			float slope2) throws InterruptedException {
		if (type1 == 0 && type2 == 0) {
			// System.out.println("0 to 0\n" + "slope 2:" + slope2 + " slope 1:"
			// + slope1);
			if (slope2 < slope1)
				Start.motor.right();
			else
				Start.motor.left();
		} else if (type1 == 0 && type2 == 1) {
			// System.out.println("0 to 1\n" + "slope 2:" + slope2 + " slope 1:"
			// + slope1);
			slope1 = (-1 / slope1);
			if (slope2 > slope1)
				angle = 180 - angle;
			Start.motor.left();
		} else if (type1 == 0 && type2 == 2) {
			// System.out.println("0 to 2\n" + "slope 2:" + slope2 + " slope 1:"
			// + slope1);
			angle = 180 - angle;
			if (slope2 < slope1)
				Start.motor.left();
			else
				Start.motor.right();
		} else if (type1 == 0 && type2 == 3) {
			// System.out.println("0 to 3\n" + "slope 2:" + slope2 + " slope 1:"
			// + slope1);
			slope1 = (-1 / slope1);
			if (slope2 < slope1)
				angle = 180 - angle;
			Start.motor.right();
		} else if (type1 == 1 && type2 == 0) {
			slope1 = (-1 / slope1);
			// System.out.println("1 to 0\n" + "slope 2:" + slope2 + " slope 1:"
			// + slope1);
			if (slope2 < slope1)
				angle = 180 - angle;
			Start.motor.right();
		} else if (type1 == 1 && type2 == 1) {
			// System.out.println("1 to 1\n" + "slope 2:" + slope2 + " slope 1:"
			// + slope1);
			if (slope2 < slope1)
				Start.motor.right();
			else
				Start.motor.left();
		} else if (type1 == 1 && type2 == 2) {
			slope1 = (-1 / slope1);
			// System.out.println("1 to 2\n" + "slope 2:" + slope2 + " slope 1:"
			// + slope1);
			if (slope2 > slope1)
				angle = 180 - angle;
			Start.motor.left();
		} else if (type1 == 1 && type2 == 3) {
			// System.out.println("1 to 3\n" + "slope 2:" + slope2 + " slope 1:"
			// + slope1);
			angle = 180 - angle;
			if (slope2 < slope1)
				Start.motor.left();
			else
				Start.motor.right();
		} else if (type1 == 2 && type2 == 0) {
			// System.out.println("2 to 0\n" + "slope 2:" + slope2 + " slope 1:"
			// + slope1);
			angle = 180 - angle;
			if (slope2 < slope1)
				Start.motor.left();
			else
				Start.motor.right();
		} else if (type1 == 2 && type2 == 1) {
			slope1 = (-1 / slope1);
			// System.out.println("2 to 1\n" + "slope 2:" + slope2 + " slope 1:"
			// + slope1);
			if (slope2 < slope1)
				angle = 180 - angle;
			Start.motor.right();
		} else if (type1 == 2 && type2 == 2) {
			// System.out.println("2 to 2\n" + "slope 2:" + slope2 + " slope 1:"
			// + slope1);
			if (slope2 < slope1)
				Start.motor.right();
			else
				Start.motor.left();
		} else if (type1 == 2 && type2 == 3) {
			slope1 = (-1 / slope1);
			// System.out.println("2 to 3\n" + "slope 2:" + slope2 + " slope 1:"
			// + slope1);
			if (slope2 > slope1)
				angle = 180 - angle;
			Start.motor.left();
		} else if (type1 == 3 && type2 == 0) {
			slope1 = (-1 / slope1);
			// System.out.println("3 to 0\n" + "slope 2:" + slope2 + " slope 1:"
			// + slope1);
			if (slope2 > slope1)
				angle = 180 - angle;
			Start.motor.left();
		} else if (type1 == 3 && type2 == 1) {
			// System.out.println("3 to 1\n" + "slope 2:" + slope2 + " slope 1:"
			// + slope1);
			angle = 180 - angle;
			if (slope2 < slope1)
				Start.motor.left();
			else
				Start.motor.right();
		} else if (type1 == 3 && type2 == 2) {
			slope1 = (-1 / slope1);
			// System.out.println("3 to 2\n" + "slope 2:" + slope2 + " slope 1:"
			// + slope1);
			if (slope2 < slope1)
				angle = 180 - angle;
			Start.motor.right();
		} else if (type1 == 3 && type2 == 3) {
			// System.out.println("3 to 3\n" + "slope 2:" + slope2 + " slope 1:"
			// + slope1);
			if (slope2 < slope1)
				Start.motor.right();
			else
				Start.motor.left();
		}
		Thread.sleep((long) (Math.abs(5 * angle)));
	}
}
