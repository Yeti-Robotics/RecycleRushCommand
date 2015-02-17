package org.usfirst.frc.team3506.robot.commands.arm;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OperateArmCommand extends Command {
	double armEncoderChange;
    public OperateArmCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	armEncoderChange = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double speed = 0.0;
    	double encoderDistance = Robot.arm.getArmEncoderDistance();
    	if (Robot.oi.getRightDriveJoy().getRawButton(4)) {
    		double upSpeed = RobotMap.DEFAULT_ARM_SPEED;
    		double distToStop = encoderDistance - RobotMap.MIN_ARM_DISTANCE;
    		if (distToStop < 50) {
    			upSpeed *= distToStop / 50;
    		}
    		speed += upSpeed;
    	}
    	if (Robot.oi.getRightDriveJoy().getRawButton(5)) {
    		double downSpeed = -RobotMap.DEFAULT_ARM_SPEED;
    		double distToStop = RobotMap.MAX_ARM_DISTANCE - encoderDistance;
    		if (distToStop < 50) {
    			downSpeed *= distToStop / 50;
    		}
    		speed += downSpeed;
    	}
    	Robot.arm.moveArm(speed);
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
    	Robot.arm.incrementArmPosition(Robot.arm.getArmEncoderDistance());
    	System.out.println("OperateArmCommand interrupted: arm position successfully interrupted.");
    }
}
