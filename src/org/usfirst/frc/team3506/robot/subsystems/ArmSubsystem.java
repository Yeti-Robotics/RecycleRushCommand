package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.arm.OperateArmCommand;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ArmSubsystem extends Subsystem {
    private Encoder armEncoderLeft, armEncoderRight;
    private Talon leftArm, rightArm;
    private static double armPosition;
    
    public ArmSubsystem(){
    	armEncoderLeft = new Encoder(RobotMap.ENCODER_ARM_LEFT[0], RobotMap.ENCODER_ARM_LEFT[1]);
    	armEncoderLeft.setDistancePerPulse(RobotMap.DEGREES_PER_PULSE);
    	armEncoderRight = new Encoder(RobotMap.ENCODER_ARM_RIGHT[0], RobotMap.ENCODER_ARM_RIGHT[1]);
    	leftArm = new Talon(RobotMap.TALON_LEFT_ARM_PORT);
    	rightArm = new Talon(RobotMap.TALON_RIGHT_ARM_PORT);
    }
    public void moveArm(double speed){
    	leftArm.set(speed);
    	rightArm.set(-speed);
    }
    public void stopArm() {
    	leftArm.stopMotor();
    	rightArm.stopMotor();
    }
    public int getArmEncoderDistance(){
    	return armEncoderLeft.get();
    }
    public void resetArmEncoder(){
    	armEncoderLeft.reset();
    	armEncoderRight.reset();
    }
    public void incrementArmPosition(double inc){
    	armPosition += inc;
    }
    public double getIncrementedArmPosition(){
    	return armPosition;
    }
    public void log(){
    		SmartDashboard.putNumber("Arm Encoder Left", armEncoderLeft.get());
    		SmartDashboard.putNumber("Arm Encoder Right", armEncoderRight.get());
    }
    public void initDefaultCommand() {
    	setDefaultCommand(new OperateArmCommand());
    }
}

