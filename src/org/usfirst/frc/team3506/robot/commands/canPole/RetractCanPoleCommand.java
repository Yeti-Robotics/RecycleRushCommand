package org.usfirst.frc.team3506.robot.commands.canPole;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RetractCanPoleCommand extends Command {

    public RetractCanPoleCommand() {
    	requires(Robot.canPole);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.canPole.retractPole();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
