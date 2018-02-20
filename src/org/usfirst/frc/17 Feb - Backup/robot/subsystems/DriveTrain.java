package org.usfirst.frc.team5870.robot.subsystems;

import org.usfirst.frc.team5870.robot.DriveType;
import org.usfirst.frc.team5870.robot.Robot;
import org.usfirst.frc.team5870.robot.RobotMap;
//import org.usfirst.frc.team5870.robot.commands.HaloDriveWithJoystick;
//import org.usfirst.frc.team5870.robot.commands.TankDriveWithJoystick;
import org.usfirst.frc.team5870.robot.commands.JustDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Auto-executing driving subsystem
 * @author Dennis Krasnov
 * 
 */
public class DriveTrain extends Subsystem {

	private SpeedController leftMotorGroup = new SpeedControllerGroup(
			new Spark(RobotMap.leftMotors[0]), new Spark(RobotMap.leftMotors[1]), new Spark(RobotMap.leftMotors[2]));
//	new Spark(RobotMap.FRONT_LEFT_MOTOR), new Spark(RobotMap.MIDDLE_LEFT_MOTOR), new Spark(RobotMap.BACK_LEFT_MOTOR));
	
	
	private SpeedController rightMotorGroup = new SpeedControllerGroup(
			new Spark(RobotMap.rightMotors[0]), new Spark(RobotMap.rightMotors[1]), new Spark(RobotMap.rightMotors[2]));
//	new Spark(RobotMap.FRONT_RIGHT_MOTOR), new Spark(RobotMap.MIDDLE_RIGHT_MOTOR), new Spark(RobotMap.BACK_RIGHT_MOTOR));

	private DifferentialDrive driveSystem = new DifferentialDrive(leftMotorGroup, rightMotorGroup);

	// Logging purposes only
	private double currentLeftPower = 0;
	private double currentRightPower = 0;
	
	public DriveTrain() {
		// Naming sensors for live window
		addChild("Drive", driveSystem);
	}
			
	// When no other command is running
    public void initDefaultCommand() {
//    	setDefaultCommand(new HaloDriveWithJoystick());
    	setDefaultCommand(new JustDrive());
    }
    
    /**
     * Explicit drive
     * @param left - power of left side: -1 to 1
     * @param right - power of right side: -1 to 1
     */
	public void drive(double left, double right) {
		driveSystem.tankDrive(left, right);
		currentLeftPower = left;
		currentRightPower = right;
	}

	/**
	 * Implicit drive using joystick
	 * @param joy - driving joystick
	 */
	public void drive(Joystick joy) {
		drive(-joy.getY(), -joy.getThrottle());
		// DifferentialDrive(new Spark(0), new Spark(1)); is default that only works for 2? 4? actuators
	}
	
	/**
	 * Log important data
	 */
	public void log() {
		SmartDashboard.putNumber("Left power", currentLeftPower);
		SmartDashboard.putNumber("Right power", currentRightPower);
	}
}

