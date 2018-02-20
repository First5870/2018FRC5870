package org.usfirst.frc.team5870.autonomous;

import org.usfirst.frc.team5870.robot.commands.DriveForward;
import org.usfirst.frc.team5870.robot.commands.GetDuinoSensorData;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * @author Eric Klassen 
 */

public class Autonomous extends CommandGroup{
	String switches;
	//public I2C rioI2C;
	
	
	public static int position = 0;
	
	//private Ultrasonic ultra;
	private Encoder enc;
	
	public Autonomous(int position, Encoder enc) {
		this.position = position;
		//this.ultra = ultra;
		this.enc = enc;
		autonomousDoSomething();
		addParallel(new GetDuinoSensorData());
		DriverStation ds = DriverStation.getInstance();
		switches = ds.getGameSpecificMessage();
	}
	
	public void autonomousDoSomething() {
		switch (position){
		case 0://Starting in center
			
			if(switches.charAt(0) == 'L') {
				
			}else if(switches.charAt(0) == 'R') {
				
			}
			
			break;
		case 1://Starting on left side
			
			if(switches.charAt(0) == 'L') {
				
			}else if(switches.charAt(0) == 'R') {
				
			}
	
			break;
		case 2: //Starting on right side
			
			if(switches.charAt(0) == 'L') {
				
			}else if(switches.charAt(0) == 'R') {
				
			}
			
			break;
		}
	

	}
	
	
	/*
	 * Desc: Gets range between an object and the robot using an ultrasonic sensor
	 * Params: n/a
	 * Returns: n/a
	 * Requires: n/a
	 
	private double getUltrasonicData() {
		double range = ultra.getRangeInches();
		System.out.println(range);
		
		SmartDashboard.putNumber("Range",range);//Send number to console
		
		return range;
	}
	*/
	
	/*
	 * Desc: Gets distance the robot has traveled using an encoder
	 * Params: n/a
	 * Returns: n/a
	 * Requires: n/a
	private double getEncoderData() {
		double distance = enc.getDistance();
		System.out.println(distance);
		
		SmartDashboard.putNumber("Range",distance);//Send number to console
		
		return distance;
	}
	*/
}

