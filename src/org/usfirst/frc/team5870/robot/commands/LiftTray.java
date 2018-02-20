package org.usfirst.frc.team5870.robot.commands;

import org.usfirst.frc.team5870.robot.Robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;

/*
 * This is supposed to be for the pneumatics that run the extension of the conveyor belt
 * Actual functionality currently is non-existant and is just for testing method calls
 * 
 * 
 */
public class LiftTray extends Command{

	public LiftTray() {
		
	}
	
//	private void testing() {
//		Solenoid testSolenoid = new Solenoid(1);
//		
//		testSolenoid.set(true);//Enables solenoid output
//		
//		//Double solenoids:
//		
//		DoubleSolenoid exDSolenoid =  new DoubleSolenoid(1, 2);//Values are two port numbers
//		exDSolenoid.set(DoubleSolenoid.Value.kOff);//Neither output active
//		exDSolenoid.set(DoubleSolenoid.Value.kForward);//Forward channel enabled
//		exDSolenoid.set(DoubleSolenoid.Value.kReverse);//Backward channel enabled
//		
//		Compressor c = new Compressor(0);
//		
//
//	}
	
	// Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
