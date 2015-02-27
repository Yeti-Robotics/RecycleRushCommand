package org.usfirst.frc.team3506.robot.commands.drive;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UniversalDriveCommand extends Command {
	private double forwardDistance;
	private double turnAngle;
	private double distance;
	private double speed;
	private boolean isDone;

    public UniversalDriveCommand(double turnAngle, double distance, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	this.turnAngle = turnAngle;
    	this.distance = distance;
    	this.speed = -speed;
    	forwardDistance = 0;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.resetEncoders();
    	if (distance < 0) {
    		speed = -speed;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		forwardDistance = (Robot.driveTrain.getLeftEncoderDistance()+Robot.driveTrain.getRightEncoderDistance())/2.0;
		
    	if(turnAngle==0){
    		if (distance < 0) {
        		if(forwardDistance>distance){
        			isDone = false;
        		}else{
        			isDone = true;
        		}
    		}
    		else {
    			if(forwardDistance<distance){
        			isDone = false;
        		}else{
        			isDone = true;
        		}
    		}
    		
    		Robot.driveTrain.moveRightTrain(speed);
    		Robot.driveTrain.moveLeftTrain(speed);
    		
    	}else if(turnAngle<0){
    		Robot.driveTrain.moveRightTrain(speed);
    		Robot.driveTrain.moveLeftTrain(-speed);
    		if((Robot.driveTrain.getRightEncoderDistance()+Math.abs(Robot.driveTrain.getLeftEncoderDistance()))/2.0 < Robot.driveTrain.getTotalTurnDistance(turnAngle)){
    			isDone = false;
    		}else{
    			isDone = true;
    		}
    	}else if(turnAngle>0){
    		Robot.driveTrain.moveLeftTrain(speed);
    		Robot.driveTrain.moveRightTrain(-speed);
    		if((Math.abs(Robot.driveTrain.getRightEncoderDistance())+Robot.driveTrain.getLeftEncoderDistance())/2.0 < Robot.driveTrain.getTotalTurnDistance(turnAngle)){
    			isDone = false;
    		}else{
    			isDone = true;
    		}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isDone;
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