// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.Button;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Auger;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    // The robot's subsystems and commands are defined here...
    private final Chassis chassis;
    private final DTXboxController controller;
    private final DriveCommand driveCommand;
    private final Shooter shooter;
    private final Command shooterStart;
    private final Command shooterStop;
    private final Auger auger;
    private final Command runAuger;
    private final Command stopAuger;

    /**
     * The container for the robot. Contains subsystems, OI devices, and
     * commands.
     */
    public RobotContainer() {
        // Configure the button bindings
        controller = new DTXboxController(0);

        chassis = new Chassis();
        shooter = new Shooter();
        auger = new Auger();
        
        driveCommand = new DriveCommand(chassis, controller);
        shooterStart = new RunCommand(shooter::shooterStart, shooter);
        shooterStop = new InstantCommand(shooter::shooterStop, shooter);
        runAuger = new RunCommand(auger::runAuger, auger);
        stopAuger = new InstantCommand(auger::stopAuger, auger);

        chassis.setDefaultCommand(driveCommand);

        controller.aButton.whenPressed(shooterStart);
        controller.bButton.whenPressed(shooterStop);
        controller.xButton.whenPressed(runAuger);
        controller.yButton.whenPressed(stopAuger);

        Button speedUp = new Button(() -> controller.getDpad() == 0);
        Button speedDown = new Button(() -> controller.getDpad() == 180);
        speedUp.whenPressed(new InstantCommand(shooter::shootSpeedUp, shooter));
        speedDown.whenPressed(new InstantCommand(shooter::shootSpeedDown, shooter));
        
        configureButtonBindings();

    }
    public void resetAll(){
            shooter.disShooter();
            auger.disAuger();
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be
     * created by instantiating a {@link GenericHID} or one of its subclasses
     * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and
     * then passing it to a
     * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // An ExampleCommand will run in autonomous
        return null;
    }
}
