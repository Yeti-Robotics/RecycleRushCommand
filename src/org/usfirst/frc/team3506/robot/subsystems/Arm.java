package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
    private Encoder armEncoder;
    private Talon leftArm, rightArm;
    private static double armPosition;
    
    public Arm(){
    	armEncoder = new Encoder(RobotMap.ENCODER_ARM[0], RobotMap.ENCODER_ARM[1]);
    	armEncoder.setDistancePerPulse(RobotMap.DEGREES_PER_PULSE);
    	leftArm = new Talon(RobotMap.TALON_LEFT_ARM_PORT);
    	rightArm = new Talon(RobotMap.TALON_RIGHT_ARM_PORT);
    	armPosition = RobotMap.armEncoderPosition; 
    }
    public void moveArm(double speed){
    	leftArm.set(speed);
    	rightArm.set(speed);
    }
    public double getArmEncoderDistance(){
    	return armEncoder.getDistance();
    }
    public void resetArmEncoder(){
    	armEncoder.reset();
    }
    public void incrementArmPosition(double inc){
    	armPosition += inc;
    }
    public double getIncrementedArmPosition(){
    	return armPosition;
    }
    public void initDefaultCommand() {
    }
}

