package org.usfirst.frc.team3506.robot.commands.arm;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousMoveArmCommand extends Command {
	private double targetDegreePosition, currentDegreePosition, speed;
    public AutonomousMoveArmCommand(double degrees, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.arm);
    	targetDegreePosition = degrees;
    	this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	currentDegreePosition = Robot.arm.getIncrementedArmPosition();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(currentDegreePosition>targetDegreePosition){
    		Robot.arm.moveArm(-speed); // Reverse depending on default position (up or down)
    	}else{
    		Robot.arm.moveArm(speed);
    	}
    	currentDegreePosition = Robot.arm.getArmEncoderDistance();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(currentDegreePosition-targetDegreePosition)<5;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.arm.incrementArmPosition(Robot.arm.getArmEncoderDistance());
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
