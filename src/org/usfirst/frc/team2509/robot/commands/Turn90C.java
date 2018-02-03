package org.usfirst.frc.team2509.robot.commands;

import com.kauailabs.navx.frc.AHRS;


import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.RobotMap;
import org.usfirst.frc.team2509.robot.OI;
import org.usfirst.frc.team2509.robot.subsystems.DriveTrain;


/**
 *
 */
public class Turn90C extends Command {
 AHRS turnController =  Robot.ahrs;
 DriveTrain dt = Robot.drivetrain;
		 
    public Turn90C() {
    	dt.rotateNavX(90.0f);
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	
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
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
