
package org.usfirst.frc.team3506.robot;

import org.usfirst.frc.team3506.robot.commands.arm.GetEncoderArmPositionCommand;
import org.usfirst.frc.team3506.robot.commands.arm.ResetArmEncoderCommand;
import org.usfirst.frc.team3506.robot.commands.arm.SaveArmEncoderPositionCommand;
import org.usfirst.frc.team3506.robot.commands.drive.UserDriveCommandGroup;
import org.usfirst.frc.team3506.robot.subsystems.Arm;
import org.usfirst.frc.team3506.robot.subsystems.Claw;
import org.usfirst.frc.team3506.robot.subsystems.DriveTrain;
import org.usfirst.frc.team3506.robot.subsystems.Elevator;
import org.usfirst.frc.team3506.robot.subsystems.NavigationSensorSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.RobotCompressor;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static DriveTrain driveTrain;
	public static Arm arm;
	public static Claw claw;
	public static RobotCompressor compressor;
	public static Elevator elevator;
	public static NavigationSensorSubsystem navSensor;

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	new ResetArmEncoderCommand().start();
		new GetEncoderArmPositionCommand().start();
    	driveTrain = new DriveTrain();
		arm = new Arm();
		claw = new Claw();
		compressor = new RobotCompressor();
		elevator = new Elevator();
		navSensor = new NavigationSensorSubsystem();
    	// OI always constructed last
    	oi = new OI();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        new GetEncoderArmPositionCommand().start();
        new UserDriveCommandGroup().start();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	new SaveArmEncoderPositionCommand().start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        driveTrain.logEncoder();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    }
}
