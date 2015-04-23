package org.usfirst.frc.team3506.robot.autonomi;

import org.usfirst.frc.team3506.robot.commands.canPole.ExtendCanPoleCommand;
import org.usfirst.frc.team3506.robot.commands.drive.UniversalDriveCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class LowerCanPoleDriveForwardCommandGroup extends CommandGroup {
    
    public  LowerCanPoleDriveForwardCommandGroup() {
    	addSequential(new ExtendCanPoleCommand());
    	addSequential(new WaitCommand(1.0));
    	addSequential(new UniversalDriveCommand(0, 3, 0.5));
    }
}
