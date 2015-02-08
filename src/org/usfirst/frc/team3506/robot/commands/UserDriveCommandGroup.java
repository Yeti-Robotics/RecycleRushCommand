package org.usfirst.frc.team3506.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class UserDriveCommandGroup extends CommandGroup {
    
    public  UserDriveCommandGroup() {
    	addParallel(new BinaryJoystickDriveCommand());
    	//addParallel(new OperateArmCommand());
    	addParallel(new TurnOnCompressorCommand());
    }
}
