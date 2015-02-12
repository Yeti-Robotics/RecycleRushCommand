package org.usfirst.frc.team3506.robot.commands.arm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SaveArmEncoderPositionCommand extends Command {
	FileOutputStream stream = null;
	File file;
	String encoderPosition;
	Double encoderPositionValue;
    public SaveArmEncoderPositionCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	encoderPosition = new String();
    	encoderPositionValue = new Double(Robot.arm.getArmEncoderDistance());
    	encoderPosition = encoderPositionValue.toString();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	try{
    		file = new File(RobotMap.SAVE_FILE_NAME);
    		stream = new FileOutputStream(file);
    		if(!file.exists()){
    			file.createNewFile();
    		}
    		
    		byte[] encoderPositionInBytes = encoderPosition.getBytes();
    		stream.write(encoderPositionInBytes);
    		stream.flush();
    		stream.close();
    		System.out.println("Arm position saved: "+encoderPositionValue);
    	} catch (IOException e){
    		e.printStackTrace();
    	} finally{
    		try{
    			if(stream != null){
    				stream.close();
    			}
    		} catch (IOException e){
    			e.printStackTrace();
    		}
    	}
    	
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
    }
}
