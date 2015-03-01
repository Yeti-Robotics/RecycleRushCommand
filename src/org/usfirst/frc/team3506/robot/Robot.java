
package org.usfirst.frc.team3506.robot;

import java.util.ArrayList;
import java.util.List;

import org.usfirst.frc.team3506.robot.autonomi.AutonomousCommandGroup;
import org.usfirst.frc.team3506.robot.autonomi.SimpleAutonomousCommandGroup;
import org.usfirst.frc.team3506.robot.commands.LoadRecordingCommand;
import org.usfirst.frc.team3506.robot.commands.RecordCommand;
import org.usfirst.frc.team3506.robot.commands.arm.ResetArmEncoderCommand;
import org.usfirst.frc.team3506.robot.commands.drive.DriveUntilDistanceAwayCommand;
import org.usfirst.frc.team3506.robot.commands.drive.DriveUntilElapsedTimeCommand;
import org.usfirst.frc.team3506.robot.commands.drive.UniversalDriveCommand;
import org.usfirst.frc.team3506.robot.domain.RobotInput;
import org.usfirst.frc.team3506.robot.subsystems.ArmSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.ClawSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.CompressorSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.DriveTrainSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.ElevatorSubsystem;
//import org.yetirobotics.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.subsystems.NavigationSensorSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	int session;
	public static OI oi;
	public static DriveTrainSubsystem driveTrain;
	public static ArmSubsystem arm;
	public static ClawSubsystem claw;
	public static CompressorSubsystem compressor;
	public static ElevatorSubsystem elevator;
	public static NavigationSensorSubsystem navSensor;
	public static boolean recording = false;
	public static boolean playing = false;
	public static RobotInput input;
//	public static RobotInput previousInput = new RobotInput();
	public static List<RobotInput> inputs = new ArrayList<RobotInput>();

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	driveTrain = new DriveTrainSubsystem();
		arm = new ArmSubsystem();
		claw = new ClawSubsystem();
		compressor = new CompressorSubsystem();
		elevator = new ElevatorSubsystem();
		navSensor = new NavigationSensorSubsystem();
    	// OI always constructed last
    	oi = new OI();
    	SmartDashboard.putData(new ResetArmEncoderCommand());
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putData("Gyro", navSensor.getGyro());
		SmartDashboard.putNumber("Sonar", navSensor.getSonarVoltage());
		SmartDashboard.putNumber("Arm Encoder", arm.getArmEncoderDistance());
	}

    public void autonomousInit() {
        autonomousCommand = /*navSensor.autoSwitchState() ? new AutonomousCommandGroup() :*/ new SimpleAutonomousCommandGroup();
        
        
        autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        SmartDashboard.putBoolean("switch state",navSensor.autoSwitchState());
        SmartDashboard.putString("Autocommand running", autonomousCommand.getName());
        SmartDashboard.putNumber("sensor voltage", navSensor.getDistanceFromObstacle());
    	Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        SmartDashboard.putData(new RecordCommand());
        SmartDashboard.putData("Load recording", new LoadRecordingCommand());
        SmartDashboard.putBoolean("Is Recording", recording);
		SmartDashboard.putData("Gyro", navSensor.getGyro());
		SmartDashboard.putNumber("Sonar", navSensor.getSonarVoltage());
		SmartDashboard.putNumber("Left Drive Encoder", driveTrain.getLeftEncoderDistance());
		SmartDashboard.putNumber("Right Drive Encoder", driveTrain.getRightEncoderDistance());
		SmartDashboard.putBoolean("Recording", recording);
		SmartDashboard.putNumber("Inputs", inputs.size());
		SmartDashboard.putData("Gyro", navSensor.getGyro());
		SmartDashboard.putNumber("Sonar", navSensor.getSonarVoltage());
		SmartDashboard.putNumber("Arm Encoder", arm.getArmEncoderDistance());
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	/*new SaveArmEncoderPositionCommand().start();*/
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        driveTrain.logEncoder();
        
        arm.log();
        if (!playing) {
			input = new RobotInput();
			input.setButtonState(true, 10, oi.getLeftDriveJoy());
			input.setButtonState(true, 4, oi.getLeftDriveJoy());
			input.setLeftY(oi.getLeftY());
			input.setRightY(oi.getRightY());
		}
		
		if (recording) {
			inputs.add(input);
		}
     }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    }
}
