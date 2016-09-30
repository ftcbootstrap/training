package org.ftcTeam.opmodes.level2;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.ftcTeam.configurations.TankDriveRobotWithClaw;
import org.ftcbootstrap.ActiveOpMode;
import org.ftcbootstrap.components.operations.motors.TankDriveToTime;
import org.ftcbootstrap.components.utils.DriveDirection;


/**
 * Note:  It is assumed that the proper registrar is used for this set of demos. To confirm please
 * search for "Enter your custom registrar"  in  {@link org.ftcTeam.FTCTeamControllerActivity}
 * <p/>
 */

@Autonomous
public class AutoDrive01 extends ActiveOpMode {

    private TankDriveRobotWithClaw robot;
    private TankDriveToTime tankDriveToTime;

    /**
     * Implement this method to define the code to run when the Init button is pressed on the Driver station.
     */
    @Override
    protected void onInit() {

        robot = TankDriveRobotWithClaw.newConfig(hardwareMap, getTelemetryUtil());

        //create an operation to perform a tank drive
        tankDriveToTime = new TankDriveToTime(this, robot.leftMotor, robot.rightMotor);

    }

    /**
     * Implement this method to define the code to run when the Start button is pressed on the Driver station.
     * This method will be called on each hardware cycle just as the loop() method is called for event based Opmode
     */
    @Override
    protected void activeLoop() throws InterruptedException {

        boolean targetReached = false;
        //drive forward at power 1 for 3 seconds
        double power = 1;
        double targetTime = 3;

        targetReached = tankDriveToTime.runToTarget(power, targetTime, DriveDirection.DRIVE_FORWARD);

        if (targetReached) {
            setOperationsCompleted();
        }

    }


}
