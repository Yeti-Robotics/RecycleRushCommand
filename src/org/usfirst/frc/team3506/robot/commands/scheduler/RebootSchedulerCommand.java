package org.usfirst.frc.team3506.robot.commands.scheduler;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.commands.drive.UserDriveCommand;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 */
public class RebootSchedulerCommand extends Command {

    public RebootSchedulerCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Scheduler.getInstance().removeAll();
    	//Scheduler.getInstance().add(new BinaryJoystickDriveCommand());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
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
