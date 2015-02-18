package org.usfirst.frc.team3506.robot.commands.drive;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UserDriveCommand extends Command {
	private double leftY;
	private double rightY;
    public UserDriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.oi.isArcadeMode()) {
//	    	double leftMotorSpeed;
//	    	double rightMotorSpeed;
//	    	double moveValue = Robot.oi.getLeftY();
//	    	double rotateValue = Robot.oi.getRightX();
//	        if (moveValue > 0.0) {
//	            if (rotateValue > 0.0) {
//	                leftMotorSpeed = moveValue - rotateValue;
//	                rightMotorSpeed = Math.max(moveValue, rotateValue);
//	            } else {
//	                leftMotorSpeed = Math.max(moveValue, -rotateValue);
//	                rightMotorSpeed = moveValue + rotateValue;
//	            }
//	        } else {
//	            if (rotateValue > 0.0) {
//	                leftMotorSpeed = -Math.max(-moveValue, rotateValue);
//	                rightMotorSpeed = moveValue + rotateValue;
//	            } else {
//	                leftMotorSpeed = moveValue - rotateValue;
//	                rightMotorSpeed = -Math.max(-moveValue, -rotateValue);
//	            }
//	        }
//	    	Robot.driveTrain.joystickDrive(-leftMotorSpeed, -rightMotorSpeed);
    		Robot.driveTrain.joystickDrive(Robot.oi.getLeftY(), Robot.oi.getRightX());
    	} else {
    		Robot.driveTrain.joystickDrive(Robot.oi.getLeftY(), Robot.oi.getRightY());
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
