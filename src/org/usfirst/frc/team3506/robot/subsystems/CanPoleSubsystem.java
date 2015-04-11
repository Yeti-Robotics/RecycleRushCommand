package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CanPoleSubsystem extends Subsystem {
	
	private DoubleSolenoid piston;

    public void initDefaultCommand() {
        piston = new DoubleSolenoid(RobotMap.SOLENOID_CAN_POLE_PORT[0], RobotMap.SOLENOID_CAN_POLE_PORT[1]);
    }
    
    public void extendPole() {
    	piston.set(Value.kForward);
    }
    
    public void retractPole() {
    	piston.set(Value.kReverse);
    }
}

