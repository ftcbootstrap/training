package org.ftcTeam.opmodes.level3;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.ftcTeam.configurations.TankDriveRobotWithSensors;
import org.ftcbootstrap.ActiveOpMode;


/**
 * Note:  It is assumed that the proper registrar is used for this set of demos. To confirm please
 * search for "Enter your custom registrar"  in  {@link org.ftcTeam.FTCTeamControllerActivity}
 * <p/>
 */

@Autonomous
public class MotorStopOnTouch1 extends ActiveOpMode {

    private TankDriveRobotWithSensors robot;

    /**
     * Implement this method to define the code to run when the Init button is pressed on the Driver station.
     */
    @Override
    protected void onInit() {

        robot = TankDriveRobotWithSensors.newConfig(hardwareMap, getTelemetryUtil());

    }

    /**
     * Implement this method to define the code to run when the Start button is pressed on the Driver station.
     * This method will be called on each hardware cycle just as the loop() method is called for event based Opmodes
     *
     * @throws InterruptedException
     */
    @Override
    protected void activeLoop() throws InterruptedException {

        //run motor full power (1) until the touch sensor is pressed
        if ( robot.touch.isPressed() ) {
            robot.leftMotor.setPower(0);
            setOperationsCompleted();
        }
        else{
            robot.leftMotor.setPower(1);
        }

    }

}
