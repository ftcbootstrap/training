package org.ftcTeam.opmodes.level3;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.ftcTeam.configurations.TankDriveRobotWithSensors;
import org.ftcbootstrap.ActiveOpMode;
import org.ftcbootstrap.components.operations.motors.MotorToTouch;


/**
 * Note:  It is assumed that the proper registrar is used for this set of demos. To confirm please
 * search for "Enter your custom registrar"  in  {@link org.ftcTeam.FTCTeamControllerActivity}
 * <p/>
 */

@Autonomous
public class MotorStopOnTouch2 extends ActiveOpMode {

    private TankDriveRobotWithSensors robot;
    private MotorToTouch motorToTouch;

    /**
     * Implement this method to define the code to run when the Init button is pressed on the Driver station.
     */
    @Override
    protected void onInit() {

        robot = TankDriveRobotWithSensors.newConfig(hardwareMap, getTelemetryUtil());

        //create an operation to control a motor from a touch sensor
        motorToTouch = new MotorToTouch( "motor1" , this, robot.leftMotor, robot.touch);

    }

    /**
     * Implement this method to define the code to run when the Start button is pressed on the Driver station.
     * This method will be called on each hardware cycle just as the loop() method is called for event based Opmodes
     *
     * @throws InterruptedException
     */
    @Override
    protected void activeLoop() throws InterruptedException {

        boolean targetReached = false;
        //run motor at power 1  until the touch sensor is pressed
        targetReached = motorToTouch.runToTarget(1);

        if ( targetReached) {
            setOperationsCompleted();
        }

    }

}
