// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.DTXboxController;
import frc.robot.subsystems.Chassis;

import java.util.ArrayList;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class DriveCommand extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private Chassis m_chassis;
    private DTXboxController m_Xbox;

    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem
     *                  The subsystem used by this command.
     */
    public DriveCommand(Chassis subsystem, DTXboxController controller) {
        m_chassis = subsystem;
        m_Xbox = controller;

        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        //m_chassis.drive(m_Xbox.getLeftStickYSquared(), m_Xbox.getRightStickXSquared());
         m_chassis.drive(m_Xbox.getLeftStickYSquared(), m_Xbox.getRightStickYSquared());
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
    
}
