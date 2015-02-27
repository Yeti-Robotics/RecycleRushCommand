package org.usfirst.frc.team3506.robot.autonomi;

import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.arm.MoveArmDownCommand;
import org.usfirst.frc.team3506.robot.commands.arm.MoveArmHalfUpCommand;
import org.usfirst.frc.team3506.robot.commands.arm.MoveArmUpCommand;
import org.usfirst.frc.team3506.robot.commands.arm.ResetArmEncoderCommand;
import org.usfirst.frc.team3506.robot.commands.claw.CloseClawCommand;
import org.usfirst.frc.team3506.robot.commands.claw.OpenClawCommand;
import org.usfirst.frc.team3506.robot.commands.drive.DriveUntilDistanceAwayCommand;
import org.usfirst.frc.team3506.robot.commands.drive.UniversalDriveCommand;
import org.usfirst.frc.team3506.robot.commands.elevator.LiftElevatorCommand;
import org.usfirst.frc.team3506.robot.commands.elevator.LowerElevatorCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

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
    	addSequential(new LowerElevatorCommand());

        addSequential(new CloseClawCommand());
        addSequential(new WaitCommand(0.1));
        addSequential(new MoveArmUpCommand());
        addSequential(new OpenClawCommand());
        addSequential(new DriveUntilDistanceAwayCommand(RobotMap.TOTE_PICKUP_VOLTAGE, 0.3));
        addSequential(new LiftElevatorCommand());
        
        addSequential(new WaitCommand(0.2));
        addSequential(new UniversalDriveCommand(90, 0, 0.3));
    	addSequential(new UniversalDriveCommand(0, 7, 0.3));
    	addSequential(new LowerElevatorCommand());
    	addSequential(new UniversalDriveCommand(0, -3, 0.3));
    }
}
