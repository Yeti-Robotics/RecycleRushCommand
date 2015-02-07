package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClawArm extends Subsystem {
    private Encoder armEncoder;
    private Talon leftArm, rightArm, beltMotor;
    private DigitalInput binInClawSwitch;
    private DoubleSolenoid rightClaw, leftClaw;
    public ClawArm(){
    	armEncoder = new Encoder(RobotMap.ENCODER_ARM[0], RobotMap.ENCODER_ARM[1]);
    	leftArm = new Talon(RobotMap.TALON_LEFT_ARM_PORT);
    	rightArm = new Talon(RobotMap.TALON_RIGHT_ARM_PORT);
    	beltMotor = new Talon(RobotMap.TALON_CLAW_BELT_PORT);
    	binInClawSwitch = new DigitalInput(RobotMap.LIMIT_SWITCH_BIN_IN_CLAW_PORT);
    	rightClaw = new DoubleSolenoid(RobotMap.SOLENOID_RIGHT_CLAW_PORT[0], RobotMap.SOLENOID_RIGHT_CLAW_PORT[1]);
    	leftClaw = new DoubleSolenoid(RobotMap.SOLENOID_LEFT_CLAW_PORT[0], RobotMap.SOLENOID_LEFT_CLAW_PORT[1]);
    }
    public void moveArm(double speed){
    	leftArm.set(speed);
    	rightArm.set(speed);
    }
    public void closeClaw(){
    	leftClaw.set(Value.kForward);
    	rightClaw.set(Value.kForward);
    }
    public void openClaw(){
    	leftClaw.set(Value.kOff);
    	rightClaw.set(Value.kOff);
    }
    public void setBeltMotor(double speed){
    	beltMotor.set(speed);
    }
    public boolean getBinInClawSwitchPos(){
    	return binInClawSwitch.get();
    }
    public double getArmEncoderDistance(){
    	return armEncoder.getDistance();
    }
    public void initDefaultCommand() {
    }
}

