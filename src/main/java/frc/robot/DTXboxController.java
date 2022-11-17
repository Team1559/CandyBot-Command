package frc.robot;

import java.util.Timer;
import java.util.TimerTask;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;

public class DTXboxController {
    public enum RumbleSide {
        LEFT(true, false),
        RIGHT(false, true),
        BOTH(true, true);

        private final boolean isLeft;
        private final boolean isRight;

        RumbleSide(boolean isLeft, boolean isRight) {
            this.isLeft = isLeft;
            this.isRight = isRight;
        }
    }

    private class RumbleTask extends TimerTask {
        @Override
        public void run() {
            long currentTime = System.currentTimeMillis();
            if (currentTime >= leftTimeout) {
                leftPower = 0;
            }
            if (currentTime >= rightTimeout) {
                rightPower = 0;
            }
            controller.setRumble(RumbleType.kLeftRumble, leftPower);
            controller.setRumble(RumbleType.kRightRumble, rightPower);
        }
    }

    private static final Timer RUMBLE_TIMER = new Timer("Xbox_Rumble");

    private final XboxController controller;
    
    public final Button aButton = new Button(this::getAButton);
    public final Button bButton = new Button(this::getBButton);
    public final Button xButton = new Button(this::getXButton);
    public final Button yButton = new Button(this::getYButton);
    
    private long leftTimeout;
    private long rightTimeout;
    private double leftPower;
    private double rightPower;

    public DTXboxController(int port) {
        this.controller = new XboxController(port);
        //JoystickButton buttonA = new JoystickButton(controller, XboxController.Button.kA.value);
        RUMBLE_TIMER.scheduleAtFixedRate(new RumbleTask(), 10, 20);
    }

    public int getDpad() {
        return this.controller.getPOV();
    }

    /**
     * Sets the rumble on the controller
     *
     * @param duration
     *                 Time in seconds for the rumble to last
     */
    public void startRumble(double duration) {
        startRumble(duration, 1);
    }

    /**
     * Sets the rumble on the controller
     *
     * @param duration
     *                 Time in seconds for the rumble to last
     * @param side
     *                 What side the ruble on <code>LEFT<code>, <code>RIGHT<code>,
     *                 <code>BOTH<code>
     */
    public void startRumble(double duration, RumbleSide side) {
        startRumble(duration, 1, side);
    }

    /**
     * Sets the rumble on the controller
     *
     * @param duration
     *                 Time in seconds for the rumble to last
     * @param power
     *                 Strength of rumble. Values range from 0-1
     */
    public void startRumble(double duration, double power) {
        startRumble(duration, power, RumbleSide.BOTH);
    }

    /**
     * Sets the rumble on the controller
     *
     * @param duration
     *                 Time in seconds for the rumble to last
     * @param power
     *                 Strength of rumble. Values range from 0-1
     * @param side
     *                 What side the ruble on <code>LEFT<code>, <code>RIGHT<code>,
     *                 <code>BOTH<code>
     */
    public void startRumble(double duration, double power, RumbleSide side) {
        long timeout = (long) (1_000 * duration) + System.currentTimeMillis();
        if (side.isLeft) {
            this.leftPower = power;
            this.leftTimeout = timeout;
        }
        if (side.isRight) {
            this.rightPower = power;
            this.rightTimeout = timeout;
        }
    }

    /**
     * Stops the rumble on both sides
     */
    public void stopRumble() {
        stopRumble(RumbleSide.BOTH);
    }

    /**
     * Stops the rumble on a certain side
     *
     * @param side
     *             What side to stop the ruble on <code>LEFT<code>,
     *             <code>RIGHT<code>, <code>BOTH<code>
     */
    public void stopRumble(RumbleSide side) {
        if (side.isLeft) {
            leftTimeout = Long.MIN_VALUE;
        }
        if (side.isRight) {
            rightTimeout = Long.MIN_VALUE;
        }
    }

    public boolean getAButton() {
        return this.controller.getAButton();
    }

    public boolean getBButton() {
        return this.controller.getBButton();
    }

    public boolean getXButton() {
        return this.controller.getXButton();
    }

    public boolean getYButton() {
        return this.controller.getYButton();
    }

    public boolean getStartButton() {
        return this.controller.getStartButton();
    }

    public boolean getBackButton() {
        return this.controller.getBackButton();
    }

    public boolean getLeftStickButton() {
        return this.controller.getLeftStickButton();
    }

    public boolean getRightStickButton() {
        return this.controller.getRightStickButton();
    }

    public boolean getLeftBumper() {
        return this.controller.getLeftBumper();
    }

    public boolean getRightBumper() {
        return this.controller.getRightBumper();
    }

    public boolean getAButtonPressed() {
        return this.controller.getAButtonPressed();
    }

    public boolean getBButtonPressed() {
        return this.controller.getBButtonPressed();
    }

    public boolean getXButtonPressed() {
        return this.controller.getXButtonPressed();
    }

    public boolean getYButtonPressed() {
        return this.controller.getYButtonPressed();
    }

    public boolean getStartButtonPressed() {
        return this.controller.getStartButtonPressed();
    }

    public boolean getBackButtonPressed() {
        return this.controller.getBackButtonPressed();
    }

    public boolean getLeftStickButtonPressed() {
        return this.controller.getLeftStickButtonPressed();
    }

    public boolean getRightStickButtonPressed() {
        return this.controller.getRightStickButtonPressed();
    }

    public boolean getLeftBumperPressed() {
        return this.controller.getLeftBumperPressed();
    }

    public boolean getRightBumperPressed() {
        return this.controller.getRightBumperPressed();
    }

    public boolean getAButtonReleased() {
        return this.controller.getAButtonReleased();
    }

    public boolean getBButtonReleased() {
        return this.controller.getBButtonReleased();
    }

    public boolean getXButtonReleased() {
        return this.controller.getXButtonReleased();
    }

    public boolean getYButtonReleased() {
        return this.controller.getYButtonReleased();
    }

    public boolean getStartButtonReleased() {
        return this.controller.getStartButtonReleased();
    }

    public boolean getBackButtonReleased() {
        return this.controller.getBackButtonReleased();
    }

    public boolean getLeftStickButtonReleased() {
        return this.controller.getLeftStickButtonReleased();
    }

    public boolean getRightStickButtonReleased() {
        return this.controller.getRightStickButtonReleased();
    }

    public boolean getLeftBumperReleased() {
        return this.controller.getLeftBumperReleased();
    }

    public boolean getRightBumperReleased() {
        return this.controller.getRightBumperReleased();
    }

    public double getLeftStickX() {
        return this.controller.getLeftX();
    }

    public double getLeftStickY() {
        return -this.controller.getLeftY();
    }

    public double getRightStickX() {
        return this.controller.getRightX();
    }

    public double getRightStickY() {
        return -this.controller.getRightY();
    }

    public double getLeftTrigger() {
        return this.controller.getLeftTriggerAxis();
    }

    public double getRightTrigger() {
        return this.controller.getRightTriggerAxis();
    }

    public double getLeftStickXSquared() {
        return squareAxis(getLeftStickX());
    }

    public double getLeftStickYSquared() {
        return squareAxis(getLeftStickY());
    }

    public double getRightStickXSquared() {
        return squareAxis(getRightStickX());
    }

    public double getRightStickYSquared() {
        return squareAxis(getRightStickY());
    }

    public double getLeftTriggerSquared() {
        return squareAxis(getLeftTrigger());
    }

    public double getRightTriggerSquared() {
        return squareAxis(getRightTrigger());
    }

    private static double squareAxis(double d) {
        return Math.copySign(d * d, d);
    }
}
