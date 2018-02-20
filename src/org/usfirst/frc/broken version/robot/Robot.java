/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5870.robot;

import org.usfirst.frc.team5870.autonomous.Autonomous;
import org.usfirst.frc.team5870.robot.subsystems.Belt;
import org.usfirst.frc.team5870.robot.subsystems.ChassisSystem;
import org.usfirst.frc.team5870.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Main class containg all subsystems and controls
 * @author Eric Klassen
 * 
 */
public class Robot extends IterativeRobot { 
	//Choose driving mode
	public static final DriveType driveType = DriveType.TRIGGER;
	
//	public static ChassisSystem chassis = new ChassisSystem(driveType);
	public static DriveTrain drive = new DriveTrain();
	public static Belt belt = new Belt();
	public static IO io;
//	public static Intake inTake;
	
	
	
	public static CameraServer webcam;
	//Encoder enc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);//Encoder 0, 1 are the port numbers for the two digital inputs

	//Ultrasonic ultra = new Ultrasonic(10,10); // creates the ultra object and assigns ultra to be an ultrasonic sensor which uses DigitalOutput 1 for 
    // the echo pulse and DigitalInput 1 for the trigger pulse
	
	Command autonomousCommand;//Command for autonomous
	SendableChooser<Command> chooser = new SendableChooser<>();

	private Joystick m_rightStick;

	/*
	 * Runs once when the robot starts 
	 * (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.IterativeRobotBase#robotInit()
	 */
	@Override
	public void robotInit() {
		io = new IO();

		
		webcam = CameraServer.getInstance();
		webcam.startAutomaticCapture("cam0", 0);
	}
	
	/*
	private double getUltrasonicData() {
		double range = ultra.getRangeInches();
		System.out.println(range);
		
		SmartDashboard.putNumber("Range",range);//Send number to console
		
		return range;
	}
	*/
	
	
	/*
	 * Runs once when autonomous starts 
	 * (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.IterativeRobotBase#autonomousInit()
	 */
	@Override
	public void autonomousInit() {
//		
//		autonomousCommand = new Autonomous(0, enc); //autonomous is set to center by default
//		
//		String autoSelected = SmartDashboard.getString("Auto Mode","Default");//Get selected preference
//		switch (autoSelected) {
//		
//		case "Left Side"://Starting from left side
//			autonomousCommand = new Autonomous(1, enc);
//			break;
//		case "Right Side"://Starting from right side
//			autonomousCommand = new Autonomous(2, enc);
//		case "Center"://Stating from center
//			autonomousCommand = new Autonomous(0, enc);
//			break;
//		}
//		
//		// schedule the autonomous command (example)
//		if (autonomousCommand != null)
//			autonomousCommand.start();
	}


	
	//When autonomous is running
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	//When teleop is running
	@Override
	public void teleopPeriodic() {
		
		Scheduler.getInstance().run();
		log();
		//Tank drive
//		m_myRobot.tankDrive(m_leftStick.getY(), m_rightStick.getY());
	}

	
	/**
	 * Log important data to Smart Dashboard
	 */
	private void log() {
		// TODO: add other subsystems
	}
}
