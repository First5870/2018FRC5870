package org.usfirst.frc.team5870.robot;

/**
 * Hardware-level mapping of inputs and outputs
 * @author Dennis Krasnov
 *
 */
public class RobotMap {
	// Controllers
	public static final int DRIVE_JOYSTICK1 = 0;
	public static final int DRIVE_JOYSTICK2 = 1;

	public static final int BTN_START_BELT = 0;
	public static final int BTN_STOP_BELT = 1;
	//public static final int INTAKE_START=1;
//	public static final int INTAKE_LEFT=3;
//	public static final int INTAKE_RIGHT=2;
//	public static final boolean INTAKE_CHECK=false;
	
	// Drive train
	public static final int[] leftMotors = {7, 8, 9};
	public static final int[] rightMotors = {0, 1, 2};
	
	public static final int BELT_MOTOR = 7;
	
}
