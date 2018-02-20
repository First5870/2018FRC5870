package org.usfirst.frc.team5870.robot.commands;

import org.usfirst.frc.team5870.robot.Robot;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class GetDuinoSensorData extends Command {
	double time;
	public I2C rioI2C;
	byte[] RIObyte;
	Timer timer;
	
    public GetDuinoSensorData() {
    	RIObyte =  new byte[5];
		this.rioI2C = new I2C(I2C.Port.kMXP, 1);
		timer = new Timer();
		
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(timer.hasPeriodPassed(0.5)) {
    		rioI2C.readOnly(RIObyte , 4);
    		System.out.println(RIObyte[0] +" "+ RIObyte[1] +" "+ + RIObyte[2] +" "+ RIObyte[3] +" "+ "\n  \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n ");
    	}
    	
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
