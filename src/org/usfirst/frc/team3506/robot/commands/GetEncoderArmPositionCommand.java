package org.usfirst.frc.team3506.robot.commands;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GetEncoderArmPositionCommand extends Command {
	File file;
	FileInputStream stream;
	String content;
	char[] array;
	double result;
    public GetEncoderArmPositionCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	file = new File(RobotMap.SAVE_FILE_NAME);
    	stream = null;
    	result = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	try{
    		stream = new FileInputStream(file);
    		array = new char[stream.available()];
    		System.out.println("Total file size to read (in bytes): "+stream.available());
    		int content;
    		int arrayIndex = 0;
    		while ((content = stream.read()) != -1){
    			// convert to char and display it
    			System.out.print((char) content);
    			array[arrayIndex] = (char) content;
    		}
    		this.content = new String(array);
    		int periodIndex = this.content.indexOf(".");
    		for(int i=periodIndex-1; i>=0; i--){
    			result+=Math.pow((int)this.content.charAt(i), 1+i-periodIndex);
    		}
    		for(int j=periodIndex+1; j<=this.content.length(); j++){
    			result+=Math.pow((int)this.content.charAt(j), -(j-periodIndex));
    		}
    		RobotMap.armEncoderPosition = result;
    		System.out.println("Arm encoder postion successfully recorded");
    	} catch (IOException e){
    		e.printStackTrace();
    	} finally{
    		try{
    			if(stream != null){
    				stream.close();
    			}
    		} catch (IOException ex){
    			ex.printStackTrace();
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
