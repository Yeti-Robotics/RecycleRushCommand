package org.usfirst.frc.team3506.robot.autonomi;

import org.usfirst.frc.team3506.robot.commands.arm.MoveArmUpCommand;
import org.usfirst.frc.team3506.robot.commands.arm.ResetArmEncoderCommand;
import org.usfirst.frc.team3506.robot.commands.claw.CloseClawCommand;
import org.usfirst.frc.team3506.robot.commands.drive.DriveUntilElapsedTimeCommand;
import org.usfirst.frc.team3506.robot.commands.elevator.LowerElevatorCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SimpleAutonomousCommandGroup extends CommandGroup {
    
    public  SimpleAutonomousCommandGroup() {
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
    	
    	/*Pick up can
    	 * Drive under tote
    	 * Pick up tote
    	 * Move arm down for next set
    	 * Repeat
    	 */
    	
    	addSequential(new ResetArmEncoderCommand());
    	addSequential(new LowerElevatorCommand()); //This controls the can pole now

        addSequential(new CloseClawCommand());
        addSequential(new MoveArmUpCommand());
        addSequential(new DriveUntilElapsedTimeCommand(1.55, -0.3));
        
    }
}
