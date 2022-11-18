package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class Auger extends SubsystemBase{
    private double speed = 0.1;
    private static final int AUGER_MOTOR = 5;
    private WPI_TalonSRX augerMotor;
    private boolean running = false;
    public Auger (){
        augerMotor =  new WPI_TalonSRX(AUGER_MOTOR);
    }
    public void runAuger (){
        running = true;
        System.out.println("agur start");
    }
    public void stopAuger() {
        running = false;
        System.out.println("Stopped augerd");
    }
    public void disAuger(){
        running = false;
    }
    @Override
    public void periodic(){
        if (running == true){
            augerMotor.set(ControlMode.PercentOutput, speed);
            //System.out.println("Start speed = " +speed);
        }
        else {           
            augerMotor.set(ControlMode.PercentOutput, 0);
           // System.out.println("Stop speed = " +speed);
    }
    }
}

