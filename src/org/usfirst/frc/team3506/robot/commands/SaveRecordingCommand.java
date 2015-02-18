package org.usfirst.frc.team3506.robot.commands;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SaveRecordingCommand extends Command {

    

	public SaveRecordingCommand() {
		// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

	// Called just before this Command runs the first time
	protected void initialize() {
		try {
			File file = new File(RobotMap.COMMANDS_FILE);
			FileOutputStream fs = new FileOutputStream(file);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(Robot.inputs);
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
