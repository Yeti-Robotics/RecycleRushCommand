package org.usfirst.frc.team3506.canPole;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ExtendCanPoleCommand extends Command {

    public ExtendCanPoleCommand() {
    	requires(Robot.canPole);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.canPole.extendPole();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
