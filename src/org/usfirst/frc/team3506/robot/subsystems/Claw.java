package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem {
    
	private DigitalInput binInClawSwitch;
    private DoubleSolenoid rightClaw, leftClaw;
    private Talon beltMotor;
    
    public Claw(){
    	binInClawSwitch = new DigitalInput(RobotMap.LIMIT_SWITCH_BIN_IN_CLAW_PORT);
    	rightClaw = new DoubleSolenoid(RobotMap.SOLENOID_RIGHT_CLAW_PORT[0], RobotMap.SOLENOID_RIGHT_CLAW_PORT[1]);
    	leftClaw = new DoubleSolenoid(RobotMap.SOLENOID_LEFT_CLAW_PORT[0], RobotMap.SOLENOID_LEFT_CLAW_PORT[1]);
    	beltMotor = new Talon(RobotMap.TALON_CLAW_BELT_PORT);
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
    public void setBeltMotor(double speed){
    	beltMotor.set(speed);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

