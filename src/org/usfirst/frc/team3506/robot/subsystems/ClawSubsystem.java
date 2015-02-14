package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClawSubsystem extends Subsystem {
    
    private DoubleSolenoid claw2, claw1;
    private Relay beltMotor;
    
    public ClawSubsystem(){
    	claw2 = new DoubleSolenoid(RobotMap.SOLENOID_RIGHT_CLAW_PORT[0], RobotMap.SOLENOID_RIGHT_CLAW_PORT[1]);
    	claw1 = new DoubleSolenoid(RobotMap.SOLENOID_LEFT_CLAW_PORT[0], RobotMap.SOLENOID_LEFT_CLAW_PORT[1]);
    	beltMotor = new Relay(RobotMap.SPIKE_CLAW_BELT_PORT);
    }
    public void closeClaw(){
    	claw1.set(Value.kReverse);
    	claw2.set(Value.kForward);
    }
    public void openClaw(){
    	claw1.set(Value.kForward);
    	claw2.set(Value.kReverse);
    }
    public void setBeltMotorForward(){
    		beltMotor.set(Relay.Value.kReverse);
    }
    public void setBeltMotorReverse(){
    		beltMotor.set(Relay.Value.kForward);
    }
    public void setBeltMotorOff(){
    		beltMotor.set(Relay.Value.kOff);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

