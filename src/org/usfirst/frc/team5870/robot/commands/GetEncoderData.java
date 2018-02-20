package org.usfirst.frc.team5870.robot.commands;

import org.usfirst.frc.team5870.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GetEncoderData extends Command{
	
	int count;
	double wheelCircumference = 18.846;//In inches
	
	
    public GetEncoderData() {
    	Robot.io.leftEncode.setDistancePerPulse(wheelCircumference);
    	Robot.io.rightEncode.setDistancePerPulse(wheelCircumference);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.leftDistance = Robot.io.leftEncode.getDistance();
    	Robot.rightDistance = Robot.io.rightEncode.getDistance();
    	System.out.println(Robot.leftDistance);
    	System.out.println(Robot.rightDistance);
    	
    	SmartDashboard.putNumber("Left distance", Robot.leftDistance);
		SmartDashboard.putNumber("Right distance", Robot.rightDistance);
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
