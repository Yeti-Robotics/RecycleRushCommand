package org.usfirst.frc.team3506.robot.commands.drive;

import org.usfirst.frc.team3506.robot.commands.arm.OperateArmCommand;
import org.usfirst.frc.team3506.robot.commands.compressor.TurnOnCompressorCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class UserDriveCommandGroup extends CommandGroup { 
    public  UserDriveCommandGroup() {
    	addParallel(new BinaryJoystickDriveCommand());
    	addParallel(new OperateArmCommand());
    	addParallel(new TurnOnCompressorCommand());
    }
}
