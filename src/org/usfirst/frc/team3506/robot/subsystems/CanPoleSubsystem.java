package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CanPoleSubsystem extends Subsystem {
	
	private DoubleSolenoid piston1, piston2;

	public CanPoleSubsystem() {
    	piston1 = new DoubleSolenoid(RobotMap.SOLENOID_CAN_POLE_PORT1[0], RobotMap.SOLENOID_CAN_POLE_PORT1[1]);
        piston2 = new DoubleSolenoid(RobotMap.SOLENOID_CAN_POLE_PORT2[0], RobotMap.SOLENOID_CAN_POLE_PORT2[1]);
	}
	
    public void initDefaultCommand() {
    }
    
    public void extendPole() {
    	piston1.set(Value.kForward);
    	piston2.set(Value.kForward);
    }
    
    public void retractPole() {
    	piston1.set(Value.kReverse);
    	piston2.set(Value.kReverse);
    }
}

