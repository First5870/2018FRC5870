package org.usfirst.frc.team5870.robot.subsystems;

import org.usfirst.frc.team5870.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Belt extends Subsystem {
	private Victor beltMotor1 = new Victor(RobotMap.BELT_MOTOR);

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public void power(double power) {
		beltMotor1.set(power);
	}
	

}

