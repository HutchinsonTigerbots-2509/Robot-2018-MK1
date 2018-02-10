/*----------------------------------------------------------------------------*/

/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2509.robot;

import org.usfirst.frc.team2509.robot.commands.ArmHigh;
import org.usfirst.frc.team2509.robot.commands.ArmMid;
import org.usfirst.frc.team2509.robot.commands.ShiftDrive;
import org.usfirst.frc.team2509.robot.commands.one.Auto1I;
import org.usfirst.frc.team2509.robot.commands.three.Auto3B;
import org.usfirst.frc.team2509.robot.commands.three.Auto3D;
import org.usfirst.frc.team2509.robot.commands.three.Auto3J;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick OperatorStick;
	public Joystick CoOperatorStick;
	private JoystickButton ShiftButton;
	private JoystickButton MidArmButton;
	private JoystickButton HighArmButton;
	public SendableChooser<String> chooser = new SendableChooser<>();
	public String defaultAuto = "Default";
	public String X1 = "1X";
	public String AB1 = "1AB";
	public String CF1 = "1CF";
	public String IH1 = "1IH";
	public String X2 = "2X";
	public String AB2 = "2AB";
	public String CD2 = "2CD";
	public String AB3 = "3AB";
	public String DE3 = "3DE";
	public String GJ3 = "3GJ";
	private Command autoCommand;
	
	/**
	 * CREATING BUTTONS - 
	 * <p>One type of button is a joystick button which is any button on a joystick.
	 * You create one by telling it which joystick it's on and which button number it is.
	 * <p>Joystick stick = new Joystick(port);
	 * <p>Button button = new JoystickButton(stick, buttonNumber);
	 * <p>There are a few additional built in buttons you can use. Additionally,
	 * by subclassing Button you can create custom triggers and bind those to
	 * commands the same as any other Button.
	 * 
	 * <p>TRIGGERING COMMANDS WITH BUTTONS
	 * <p>Once you have a button, it's trivial to bind it to a button in one of three ways:
	 * <p>Start the command when the button is pressed and let it run the command until 
	 * it is finished as determined by it's isFinished method.
	 * <p>button.whenPressed(new ExampleCommand());
	 * <p>Run the command while the button is being held down and interrupt it once the 
	 * button is released.
	 * <p>button.whileHeld(new ExampleCommand());
	 * <p>Start the command when the button is released and let it run the command until 
	 * it is finished as determined by it's isFinished method.
	 * <p>button.whenReleased(new ExampleCommand());
	 * 
	 */
	public OI() {
		OperatorStick = new Joystick(0);
		CoOperatorStick = new Joystick(1);
		ShiftButton = new JoystickButton(OperatorStick, 2);
		ShiftButton.whenPressed(new ShiftDrive());
		MidArmButton = new JoystickButton(OperatorStick, 3);
		MidArmButton.whileHeld(new ArmMid());
		HighArmButton = new JoystickButton(OperatorStick, 4);
		HighArmButton.whileHeld(new ArmHigh());
		chooser.addDefault("Default Auto", defaultAuto);
			chooser.addObject("1X", X1);
			chooser.addObject("1AB", AB1);
			chooser.addObject("1CF", CF1);
			chooser.addObject("1IH", IH1);
			chooser.addObject("2X", X2);
			chooser.addObject("2AB", AB2);
			chooser.addObject("2CD", CD2);
			chooser.addObject("3AB", AB3);
			chooser.addObject("3DE", DE3);
			chooser.addObject("3GJ", GJ3);
			SmartDashboard.putData("Auto choices", chooser);
			
			
		
	}
	/**
	 * When called constantly updates the SmartDashboard
	 */
	public Thread UpdateDashboard = new Thread(()->{
		while(true) {
			SmartDashboard.putNumber("Left Encoder", Robot.drivetrain.getLeftEncoder().get());
			SmartDashboard.putNumber("Right Encoder", Robot.drivetrain.getRightEncoder().get());
			SmartDashboard.putNumber("Gyro", Robot.drivetrain.getNavX().getAngle());
			SmartDashboard.putBoolean("Lower Limit", Robot.arm.getLowerLimit().get());
			SmartDashboard.putBoolean("Middle Limit", Robot.arm.getMiddleLimit().get());
			SmartDashboard.putBoolean("Upper Limit", Robot.arm.getUpperLimit().get());
		}
	});
	public Command getAutonomous(String autoChoice, String gameData){
		SmartDashboard.putString("Game Data", gameData);
		switch(autoChoice) {
		case "1X":
			autoCommand = null;
			break;
		case "1AB":
			if(gameData.charAt(0)=='L') {
				autoCommand = null;
			}else if(gameData.charAt(0)=='R') {
				autoCommand = null;
			}
			break;
		case "1CF":
			if(gameData.charAt(0)=='L') {
				autoCommand = null;
			}else if(gameData.charAt(0)=='R') {
				autoCommand = null;
			}
			break;
		case "1IH":
			if(gameData.charAt(1)=='L') {
				autoCommand = new Auto1I();
			}else if(gameData.charAt(1)=='R') {
				autoCommand = null;
			}
			break;
		case "2X":
			autoCommand = null;
			break;
		case "2AB":
			if(gameData.charAt(0)=='L') {
				autoCommand = null;
			}else if(gameData.charAt(0)=='R') {
				autoCommand = null;
			}
		case "2CD":
			if(gameData.charAt(0)=='L') {
				autoCommand = null;
			}else if(gameData.charAt(0)=='R') {
				autoCommand = null;
			}
		case "3AB":
			if(gameData.charAt(0)=='L') {
				autoCommand = null;
			}else if(gameData.charAt(0)=='R') {
				autoCommand = new Auto3B();
			}
		case "3DE":
			if(gameData.charAt(0)=='L') {
				autoCommand = null;
			}else if(gameData.charAt(0)=='R') {
				autoCommand = new Auto3D();
			}
		case "3GJ":
			if(gameData.charAt(1)=='L') {
				autoCommand = null;
			}else if(gameData.charAt(1)=='R') {
				autoCommand = new Auto3J();
			}
			break;
		case "Default":
			default:
				if(gameData.charAt(0)=='L') {
					autoCommand = null;
				}else if(gameData.charAt(0)=='R') {
					autoCommand = null;
				}
				break;
		}
			return autoCommand;
			
	}
}
