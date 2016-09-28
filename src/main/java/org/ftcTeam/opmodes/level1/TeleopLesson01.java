package org.ftcTeam.opmodes.level1;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.ftcTeam.configurations.MotorAndServoRobot;
import org.ftcbootstrap.ActiveOpMode;
import org.ftcbootstrap.components.operations.motors.GamePadMotor;
import org.ftcbootstrap.components.operations.servos.GamePadServo;


/**
 * Note:  It is assumed that the proper registrar is used for this set of demos. To confirm please
 * search for "Enter your custom registrar"  in  {@link org.ftcTeam.FTCTeamControllerActivity}
 * <p/>
 */

@TeleOp
public class TeleopLesson01 extends ActiveOpMode {

    private MotorAndServoRobot robot;

    private GamePadMotor motorFromStick;
    private GamePadServo yaButtonServo;

    /**
     * Implement this method to define the code to run when the Init button is pressed on the Driver station.
     */
    @Override
    protected void onInit() {

        robot = MotorAndServoRobot.newConfig(hardwareMap, getTelemetryUtil());

    }

    /**
     * Implement this method to define the code to run when the Play button is pressed on the Driver station.
     * This code will run once.
     */
    @Override
    protected void onStart() throws InterruptedException {
        super.onStart();

        motorFromStick = new GamePadMotor(this,  gamepad1, robot.motor1, GamePadMotor.Control.LEFT_STICK_Y);

        double initialPosition = 0.3;
        yaButtonServo = new GamePadServo(this,gamepad1,robot.servo1, GamePadServo.Control.Y_A , initialPosition );

    }

    /**
     * Implement this method to define the code to run when the Start button is pressed on the Driver station.
     * This method will be called in a loop on each hardware cycle
     */
    @Override
    protected void activeLoop() throws InterruptedException {

        //update the motor with the gamepad joystick values
        motorFromStick.update();
        //update the servo with the gamepad y/a button values
        yaButtonServo.update();

    }

}
