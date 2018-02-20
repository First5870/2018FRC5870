package org.usfirst.frc.team5870.robot;

import org.usfirst.frc.team5870.robot.commands.EmergencyStop;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Input and teleop behaviour
 * @author Dennis Krasnov
 *
 */
public class IO {
	public Joystick driveStick1 = new Joystick(RobotMap.DRIVE_JOYSTICK1);
	public Joystick driveStick2 = new Joystick(RobotMap.DRIVE_JOYSTICK2);
	public JoystickButton btnStartBelt = new JoystickButton(driveStick2, RobotMap.BTN_START_BELT);
	public JoystickButton btnStopBelt = new JoystickButton(driveStick2, RobotMap.BTN_STOP_BELT);
	
	public IO() {
		smartDashboardInit();
		
		// Buttons
		JoystickButton driverEmergencyStop = new JoystickButton(driveStick2, 5);
		JoystickButton ShiftyRight=new JoystickButton(driveStick2,2);
		JoystickButton ShiftyLeft=new JoystickButton (driveStick2,3);
		
		
		// Behaviour
		driverEmergencyStop.whenPressed(new EmergencyStop()); // TODO: ensure stays off while pressed
	}
	
	/**
	 * Add buttons to Smart Dashboard
	 */
	private void smartDashboardInit() {
		SmartDashboard.putData("EMERGENCY STOP", new EmergencyStop());
		
		
	}
	
	
	public Joystick getJoystick(int joystickNum) {
		
		
		switch (joystickNum) {
		case 0:
			return driveStick1;	
		case 1:
			return driveStick2;
		}
		
		return null;
	}
	
	
	
}
