package org.usfirst.frc.team3506.robot.autonomi;

import org.usfirst.frc.team3506.canPole.ExtendCanPoleCommand;
import org.usfirst.frc.team3506.robot.commands.drive.UniversalDriveCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LowerElevatorDriveForwardCommandGroup extends CommandGroup {
    
    public  LowerElevatorDriveForwardCommandGroup() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new ExtendCanPoleCommand());
    	addSequential(new UniversalDriveCommand(0, 3, 0.5));
    }
}
