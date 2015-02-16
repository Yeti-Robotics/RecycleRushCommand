package org.usfirst.frc.team3506.robot.commands.drive;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveUntilDistanceAwayCommand extends Command {

	private double distanceAway, speed;
    public DriveUntilDistanceAwayCommand(double distanceAway, double speed) {
    	requires(Robot.navSensor);
    	requires(Robot.driveTrain);
    	this.distanceAway = distanceAway;
    	this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.navSensor.getDistanceFromObstacle() >= distanceAway) {
			Robot.driveTrain.driveStraight(speed);
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.navSensor.getDistanceFromObstacle() <= distanceAway;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
