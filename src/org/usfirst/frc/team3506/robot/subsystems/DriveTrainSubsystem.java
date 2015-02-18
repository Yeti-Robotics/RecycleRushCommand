package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.drive.UserDriveCommand;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrainSubsystem extends Subsystem {
	private Talon motor3, motor2, motor4, motor1;
	private Encoder leftEncoder, rightEncoder;
	private RobotDrive drive;
	public DriveTrainSubsystem(){
		motor3 = new Talon(RobotMap.TALON_RIGHT_FRONT_WHEEL_PORT);
		motor4 = new Talon(RobotMap.TALON_RIGHT_REAR_WHEEL_PORT);
		motor2 = new Talon(RobotMap.TALON_LEFT_REAR_WHEEL_PORT);
		motor1 = new Talon(RobotMap.TALON_LEFT_FRONT_WHEEL_PORT);
		drive = new RobotDrive(motor1, motor2, motor3, motor4);
		leftEncoder = new Encoder(RobotMap.ENCODER_LEFT_DRIVE_TRAIN_PORT[0], RobotMap.ENCODER_LEFT_DRIVE_TRAIN_PORT[1]);
		rightEncoder = new Encoder(RobotMap.ENCODER_RIGHT_DRIVE_TRAIN_PORT[0], RobotMap.ENCODER_RIGHT_DRIVE_TRAIN_PORT[1]);
		leftEncoder.setDistancePerPulse(RobotMap.DISTANCE_PER_PULSE);
		rightEncoder.setDistancePerPulse(RobotMap.DISTANCE_PER_PULSE);
	}
	
	public void joystickDrive(double left, double right){
		if (Robot.oi.isArcadeMode()){
			drive.arcadeDrive(-left, -right, true);
		} else {
			moveRightTrain(right);
			moveLeftTrain(left);
		}
	}
	
	public void driveStraight(double speed) {
		moveRightTrain(speed);
		moveLeftTrain(speed);
	}
	
	public void moveRightTrain(double speed){
		motor4.set(speed);
		motor3.set(speed);
	}
	
	public void moveLeftTrain(double speed){
		motor2.set(-speed);
		motor1.set(-speed);
	}
	
	public void resetEncoders(){
		leftEncoder.reset();
		rightEncoder.reset();
	}
	
	public double getLeftEncoderDistance(){
		return leftEncoder.getDistance();
	}
	
	public double getRightEncoderDistance(){
		return rightEncoder.getDistance();
	}
	
	public double getLeftEncoderRate(){
		return leftEncoder.getRate();
	}
	
	public double getRightEncoderRate(){
		return rightEncoder.getRate();
	}
	
	public double getTotalTurnDistance(double degrees){
		double rad = convertToRadians(degrees);
		return rad*(RobotMap.ROBOT_DIAMETER_FT)/2.0;
	}
	
	private double convertToRadians(double degrees){
		return 2*Math.PI*(degrees/360.0);
	}
	
	public void logEncoder(){
		SmartDashboard.putData("Left Encoder", leftEncoder);
		SmartDashboard.putData("Right Encoder", rightEncoder);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new UserDriveCommand());
    }
}

