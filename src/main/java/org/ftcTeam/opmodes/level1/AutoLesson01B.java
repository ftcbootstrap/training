package org.ftcTeam.opmodes.level1;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.ftcTeam.configurations.MotorAndServoRobot;
import org.ftcbootstrap.ActiveOpMode;
import org.ftcbootstrap.components.operations.motors.MotorToTime;


/**
 * Note:  It is assumed that the proper registrar is used for this set of demos. To confirm please
 * search for "Enter your custom registrar"  in  {@link org.ftcTeam.FTCTeamControllerActivity}
 * <p/>
 */

@Autonomous
public class AutoLesson01B extends ActiveOpMode {

    private MotorAndServoRobot robot;
    private MotorToTime motorToTime;

    /**
     * Implement this method to define the code to run when the Init button is pressed on the Driver station.
     */
    @Override
    protected void onInit() {

        robot = MotorAndServoRobot.newConfig(hardwareMap, getTelemetryUtil());
        motorToTime = new MotorToTime("motor with timer" , this ,robot.motor1 );

    }

    /**
     * Implement this method to define the code to run when the Start button is pressed on the Driver station.
     * This method will be called on each hardware cycle just as the loop() method is called for event based Opmode
     */
    @Override
    protected void activeLoop() throws InterruptedException {

            boolean targetReached = false;
            //run motor at power 1 for 3 seconds
            double power = 1;
            double targetTime = 3;

            targetReached = motorToTime.runToTarget(power, targetTime);

            if (targetReached) {
                setOperationsCompleted();
            }

        }

}
