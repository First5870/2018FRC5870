package org.usfirst.frc.team5870.robot.commands;

import org.usfirst.frc.team5870.robot.Robot;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GetDuinoSensorData extends Command {
	double time;
//	public I2C rioI2C;
//	byte[] RIObyte = new byte[5]; // TODO: make int if necesary
//	Timer timer;
	
    public GetDuinoSensorData() {
//		timer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	if(timer.hasPeriodPassed(0.5)) {
    		Robot.io.rioI2C.readOnly(Robot.RIObyte , 4);
    		System.out.println(Robot.RIObyte[0] +" "+ Robot.RIObyte[1] +" "+ + Robot.RIObyte[2] +" "+ Robot.RIObyte[3] +" "+ "\n  \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n ");
//    	}
		SmartDashboard.putNumber("Distance 1", Robot.RIObyte[0]);
		SmartDashboard.putNumber("Distance 2", Robot.RIObyte[1]);
		SmartDashboard.putNumber("Distance 3", Robot.RIObyte[2]);
		SmartDashboard.putNumber("Distance 4", Robot.RIObyte[3]);
		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
