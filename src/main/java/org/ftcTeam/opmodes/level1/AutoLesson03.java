package org.ftcTeam.opmodes.level1;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.ftcTeam.configurations.MotorAndServoRobot;
import org.ftcbootstrap.ActiveOpMode;
import org.ftcbootstrap.components.operations.motors.MotorToEncoder;
import org.ftcbootstrap.components.utils.MotorDirection;


/**
 * Note:  It is assumed that the proper registrar is used for this set of demos. To confirm please
 * search for "Enter your custom registrar"  in  {@link org.ftcTeam.FTCTeamControllerActivity}
 * <p/>
 */

@Autonomous
public class AutoLesson03 extends ActiveOpMode {

    private MotorAndServoRobot robot;
    private MotorToEncoder motorToEncoder;

    boolean targetReached;

    /**
     * Implement this method to define the code to run when the Init button is pressed on the Driver station.
     */
    @Override
    protected void onInit() {

        robot = MotorAndServoRobot.newConfig(hardwareMap, getTelemetryUtil());
        motorToEncoder = new MotorToEncoder(  this, robot.motor1);

        getTelemetryUtil().addData("Init", getClass().getSimpleName() + " initialized.");
        getTelemetryUtil().sendTelemetry();
    }

    /**
     * Implement this method to define the code to run when the Start button is pressed on the Driver station.
     * This method will be called on each hardware cycle just as the loop() method is called for event based Opmodes
     */
    @Override
    protected void activeLoop() throws InterruptedException {

            MotorDirection direction = MotorDirection.MOTOR_FORWARD;
            DcMotor.RunMode mode = DcMotor.RunMode.RUN_USING_ENCODER;
            //run full power (1)  move forward for and 8000 encoder count
            targetReached = motorToEncoder.runToTarget(1, 8000,direction,mode);

            if (targetReached) {
                setOperationsCompleted();
            }

        }

}
