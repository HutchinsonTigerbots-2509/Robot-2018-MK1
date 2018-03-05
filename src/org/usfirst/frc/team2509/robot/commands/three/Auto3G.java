package org.usfirst.frc.team2509.robot.commands.three;

import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.subsystems.Arm;
import org.usfirst.frc.team2509.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2509.robot.subsystems.Gripper;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto3G extends Command {
	Arm arm = Robot.arm;
	DriveTrain driveTrain = Robot.drivetrain;
	Gripper grip =  Robot.gripper;
	
    public Auto3G() {
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	grip.retract();//Picks Up the box
    	arm.armThreadMid.start();//Starts armThreadMid
    	
    	driveTrain.driveForward(240);//drives forward 240 inches
    	driveTrain.rotate(90);//turns right
    	driveTrain.driveForward(222);//drives forward 222 inches
    	driveTrain.rotate(90);//turns right
    	driveTrain.driveForward(90);//drives forward 90 inches
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	arm.armThreadMid.stop();//Stops armThreadMid
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
