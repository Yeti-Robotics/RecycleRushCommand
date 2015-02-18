package org.usfirst.frc.team3506.robot.commands;

import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.arm.MoveArmDownCommand;
import org.usfirst.frc.team3506.robot.commands.arm.MoveArmUpCommand;
import org.usfirst.frc.team3506.robot.commands.arm.ResetArmEncoderCommand;
import org.usfirst.frc.team3506.robot.commands.claw.CloseClawCommand;
import org.usfirst.frc.team3506.robot.commands.claw.OpenClawCommand;
import org.usfirst.frc.team3506.robot.commands.drive.DriveUntilDistanceAwayCommand;
import org.usfirst.frc.team3506.robot.commands.drive.UniversalDriveCommand;
import org.usfirst.frc.team3506.robot.commands.elevator.LiftElevatorCommand;
import org.usfirst.frc.team3506.robot.commands.elevator.LowerElevatorCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCommandGroup extends CommandGroup {
    
    public  AutonomousCommandGroup() {
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
    	
    	int numTargets = 1;
    	addSequential(new ResetArmEncoderCommand());
    	addSequential(new LowerElevatorCommand());
    	for (int i = 1; i <= numTargets; i++) {
        	addSequential(new CloseClawCommand());
        	addParallel(new MoveArmUpCommand());
        	addSequential(new DriveUntilDistanceAwayCommand(RobotMap.TOTE_PICKUP_VOLTAGE, 0.3));
        	if (i > 1) {
        		addSequential(new LowerElevatorCommand());
        	} else {
        		addSequential(new LiftElevatorCommand());
        	}
        	if (i < numTargets || numTargets == 1) {
            	addSequential(new MoveArmUpCommand());
            	addSequential(new OpenClawCommand());
        		addParallel(new MoveArmDownCommand());
        		
            	addSequential(new LiftElevatorCommand());
        		addParallel(new MoveArmDownCommand());
            	addSequential(new UniversalDriveCommand(0, /*placeholder*/0.5, 0.1));
        		addParallel(new MoveArmDownCommand());
        		addSequential(new DriveUntilDistanceAwayCommand(RobotMap.CAN_PICKUP_VOLTAGE, 0.3));
        		addSequential(new MoveArmDownCommand());
        	}
    	}
//      addSequential(new UniversalDriveCommand(90, 0, 0.3));
//    	addParallel(new LowerElevatorCommand());
//    	addSequential(new UniversalDriveCommand(0, /*placeholder*/3, 0.3));
//    	addSequential(new UniversalDriveCommand(0, /*placeholder*/-2, -0.3));
    }
}