package org.usfirst.frc.team3506.robot.commands;

import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.drive.DriveUntilDistanceAwayCommand;
import org.usfirst.frc.team3506.robot.commands.elevator.LiftElevatorCommand;
import org.usfirst.frc.team3506.robot.commands.elevator.LowerElevatorCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutomousCommandGroup extends CommandGroup {
    
    public  AutomousCommandGroup() {
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
    	
    	
    	/*INSERT PICK UP CAN CODE HERE*/
    	addSequential(new DriveUntilDistanceAwayCommand(RobotMap.TOTE_PICKUP_DISTANCE, 0.3));
    	addSequential(new LiftElevatorCommand());
    	/*INSERT LOWER ARM CODE HERE*/
    	/*INSERT DRIVE TO NEXT TOTE SET CODE HERE*/
    	
    	/*INSERT PICK UP CAN CODE HERE*/
    	addSequential(new DriveUntilDistanceAwayCommand(RobotMap.TOTE_PICKUP_DISTANCE, 0.3));
    	addSequential(new LowerElevatorCommand());
    	addSequential(new LiftElevatorCommand());
    	/*INSERT LOWER ARM CODE HERE*/
    	/*INSERT DRIVE TO NEXT TOTE SET CODE HERE*/
    	
    }
}
