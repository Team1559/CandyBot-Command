// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Chassis extends SubsystemBase {
    private static final int LEFT_DRIVE_MOTOR  = 1;
    private static final int RIGHT_DRIVE_MOTOR = 7;
    private DifferentialDrive differential;

    /** Creates a new ExampleSubsystem. */
    public Chassis() {
        WPI_TalonSRX leftMotor = new WPI_TalonSRX(LEFT_DRIVE_MOTOR);
        WPI_TalonSRX rightMotor = new WPI_TalonSRX(RIGHT_DRIVE_MOTOR);
        differential = new DifferentialDrive(leftMotor, rightMotor);
    }

    public void drive(double speedY, double steering) {

        //differential.arcadeDrive(speedY, steering);
        differential.tankDrive(speedY, steering);
    }

    @Override
    public void periodic() {

        // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }
    public void reset(){}
}
