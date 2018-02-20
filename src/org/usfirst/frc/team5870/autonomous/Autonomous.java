package org.usfirst.frc.team5870.autonomous;

import org.usfirst.frc.team5870.robot.Robot;
import org.usfirst.frc.team5870.robot.commands.AutoDirection;
import org.usfirst.frc.team5870.robot.commands.AutoDrive;
import org.usfirst.frc.team5870.robot.commands.DriveForward;
import org.usfirst.frc.team5870.robot.commands.GetDuinoSensorData;
import org.usfirst.frc.team5870.robot.commands.GetEncoderData;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// ALLOWS TO USE LEFT AND RIGHT WITHOUT REFERENCING Direction.(l/r)
import static org.usfirst.frc.team5870.autonomous.Direction.*;

/*
 * @author Eric Klassen
 * @author Dennis Krasnov
 * @author David Pop
 */

public class Autonomous extends CommandGroup {
	String switches;
	int turnNum = 0;
	// public I2C rioI2C;

	// Amount right side is infront of left side
	private double tiltedLeft() {
		// return encR.getDistance() - encL.getDistance; TODO: when have encoders
		return 0;
	}

	// Moving straight ( adjusting if moved off track, implement into auto code)
	// double leftCoefficient = 1;
	// double rightCoefficient = 1;
	// double delta = 0.2;
	//
	// // moving straight code...
	// double tl = tiltedLeft();
	// if (Math.abs(tl) > someArbitraryNumber) { // 2 rotations over the other to
	// avoid choppiness
	//// leftCoefficient = 1 + scale(tl) * delta; // use this if too choppy, scale
	// any number to 0 -> 1
	//
	// leftCoefficient = 1 + delta;
	// rightCoefficient = 1 - delta;
	//
	// if (leftCoefficient > 1) {
	// leftCoefficient = 1;
	// }
	//
	// if (rightCoefficient > 1) {
	// rightCoefficient = 1;
	// }
	// } else {
	// leftCoefficient = 1;
	// rightCoefficient = 1;
	// }
	// move @ speed * left and right coefficients

	public static Direction position = STARTING_CENTRE;

	// private Ultrasonic ultra;

	public Autonomous(Direction position) {
		this.position = position;
		// this.ultra = ultra;
		autonomousDoSomething();
		addParallel(new GetDuinoSensorData());
		addParallel(new GetEncoderData());
		DriverStation ds = DriverStation.getInstance();
		switches = ds.getGameSpecificMessage();

	}

	private void drive(int pulses) {
		double empiricalCoefficcient = 1;

	}

	private void driveUntil(int sensor, int centimetres) {
		while (Robot.RIObyte[sensor] > centimetres) {
			addSequential(new AutoDrive(1, 1));
		}
		addSequential(new AutoDrive(0, 0));
	}

	private void driveUntil(int sensor1, int sensor2, int centimetres) {
		while (Robot.RIObyte[sensor1] > centimetres && Robot.RIObyte[sensor2] > centimetres) {
			addSequential(new AutoDrive(1, 1));
		}
		addSequential(new AutoDrive(0, 0));
	}

	private void turn(double degreesRight) {
		while (true) {
			addSequential(new AutoDrive(-0.25, 0.25));
		}
	}

	private void turn(Direction direction) {
		// use direction val
		while (true) {
			addSequential(new AutoDrive(-0.25, 0.25));
		}
	}

	public void autonomousDoSomething() {
		// example of driving x amount
		// encoder1.reset();
		// encoder2.reset();
		//
		// while ((Robot.leftDistance + Robot.rightDistance) / 2 < 100) {
		// drive sequential(left * leftCoefficient, right * rightCoefficient);
		// }
		// drive sequential(0, 0);

		// example turning
		// double goalLeft = 50; // turning radius * pi / 2
		// encoder1.reset();
		// encoder2.reset();
		// while (goal left not reached) {
		// move left motor
		//
		// if right encoder not at 0, move to 0
		// }

		switch (position) {
		// Riobyte[0] = Front Ultrasonic
		// Riobyte[1] = Left Ultrasonic
		// Riobyte[2] = Right Ultrasonic

		case STARTING_CENTRE:

			if (switches.charAt(0) == 'L') {
				drive(5);
				turn(LEFT);

				drive(2);
				turn(RIGHT);

				drive(3);
				turn(RIGHT);

				// TODO: deliver

				turn(LEFT);
				drive(1);

			} else if (switches.charAt(0) == 'R') {
				drive(5);
				turn(RIGHT);

				drive(2);
				turn(LEFT);

				drive(3);
				turn(LEFT);

				// TODO: deliver

				turn(RIGHT);
				drive(1);

			}

			break;
		case STARTING_LEFT:

			if (switches.charAt(0) == 'L') {
				drive(2);
				turn(RIGHT);
				
				drive(3);
				// TODO
				
				turn(LEFT);
				drive(2);
			} else if (switches.charAt(0) == 'R') {
				// FIXME: this should be different from left....? 
				drive(2);
				turn(LEFT);
				
				drive(3);
				// TODO
				
				turn(RIGHT);
				drive(2);
			}

			break;
		case STARTING_RIGHT:

			if (switches.charAt(0) == 'L') {
				drive(2);
				turn(RIGHT);
				
				drive(3);
				
				// TODO
				
				turn(LEFT);
				drive(2);
			} else if (switches.charAt(0) == 'R') {
				drive(2);
				turn(LEFT);
				
				drive(3);
				
				// TODO
				
				turn(RIGHT);
				drive(2);

			}

			break;
		}
	}

	/*
	 * Desc: Gets range between an object and the robot using an ultrasonic sensor
	 * Params: n/a Returns: n/a Requires: n/a
	 * 
	 * private double getUltrasonicData() { double range = ultra.getRangeInches();
	 * System.out.println(range);
	 * 
	 * SmartDashboard.putNumber("Range",range);//Send number to console
	 * 
	 * return range; }
	 */

	/*
	 * Desc: Gets distance the robot has traveled using an encoder Params: n/a
	 * Returns: n/a Requires: n/a private double getEncoderData() { double distance
	 * = enc.getDistance(); System.out.println(distance);
	 * 
	 * SmartDashboard.putNumber("Range",distance);//Send number to console
	 * 
	 * return distance; }
	 */

}
