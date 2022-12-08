package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    private static final int SHOOTER_MOTOR = 3;
    private static final double SPEED_INCREMENT = 0.05;
    private static final double IDEAL_SPEED = 0.87;
    private double speed;
    private WPI_TalonSRX shooterMotor;
    private boolean running = false;

    public Shooter() {
        shooterMotor = new WPI_TalonSRX(SHOOTER_MOTOR);
        shooterMotor.setInverted(true);
        speed = 0;
    }

    public void shootSpeedUp() {
        // System.out.println("Shooter speed up: " +speed);
        speed += SPEED_INCREMENT;
        if (speed > 1) {
            speed = 1;
        }
    }

    public void shootSpeedDown() {
        // System.out.println("Shooter speed down: " +speed);
        speed -= SPEED_INCREMENT;
        if (speed < SPEED_INCREMENT) {
            speed = SPEED_INCREMENT;
        }
    }

    public void shooterStop() {
        running = false;

    }

    public void shooterStart() {
        running = true;
    }

    public void disShooter() {
        running = false;
    }
    public void spinShooter(){
        speed = IDEAL_SPEED;
        running = true;
    }
    public void shooterTrigger(double speedS) {
        shooterMotor.set(ControlMode.PercentOutput, speedS);
        System.out.println("Shooter speed = " + speedS);
    }

    @Override
    public void periodic() {

        if (running == true) {
            shooterMotor.set(ControlMode.PercentOutput, speed);
            // System.out.println("Start speed = " +speed);
        } else {
            shooterMotor.set(ControlMode.PercentOutput, 0);
            // System.out.println("Stop speed = " +speed);
        }

    }
}
