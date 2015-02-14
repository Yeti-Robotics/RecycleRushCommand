package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClawSubsystem extends Subsystem {
    
	private DigitalInput binInClawSwitch;
    private DoubleSolenoid rightClaw, leftClaw;
    private Relay beltMotor;
    
    public ClawSubsystem(){
    	binInClawSwitch = new DigitalInput(RobotMap.LIMIT_SWITCH_BIN_IN_CLAW_PORT);
    	rightClaw = new DoubleSolenoid(RobotMap.SOLENOID_RIGHT_CLAW_PORT[0], RobotMap.SOLENOID_RIGHT_CLAW_PORT[1]);
    	leftClaw = new DoubleSolenoid(RobotMap.SOLENOID_LEFT_CLAW_PORT[0], RobotMap.SOLENOID_LEFT_CLAW_PORT[1]);
    	beltMotor = new Relay(RobotMap.SPIKE_CLAW_BELT_PORT);
    }
    public void closeClaw(){
    	leftClaw.set(Value.kForward);
    	rightClaw.set(Value.kForward);
    }
    public void openClaw(){
    	leftClaw.set(Value.kReverse);
    	rightClaw.set(Value.kReverse);
    }
    public boolean getBinInClawSwitchPos(){
    	return binInClawSwitch.get();
    }
    public void setBeltMotorForward(){
    		beltMotor.set(Relay.Value.kForward);
    }
    public void setBeltMotorReverse(){
    		beltMotor.set(Relay.Value.kReverse);
    }
    public void setBeltMotorOff(){
    		beltMotor.set(Relay.Value.kOff);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

