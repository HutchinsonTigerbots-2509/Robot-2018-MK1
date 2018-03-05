package org.usfirst.frc.team2509.robot.commands;

import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.subsystems.Wrist;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WristHalfDown extends Command {
	private Wrist wrist = Robot.wrist;
    public WristHalfDown() {
    	requires(Robot.wrist);
//    	requires(wrist);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	wrist.getMotor().set(-0.5);
//    	wrist.Down();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return wrist.getEncoder().get()<(-22);
    }

    // Called once after isFinished returns true
    protected void end() {
    	wrist.getMotor().set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}