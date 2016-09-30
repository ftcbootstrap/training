package org.ftcTeam.opmodes.level4;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.ftcTeam.configurations.TankDriveRobotWithSensors;
import org.ftcbootstrap.ActiveOpMode;
import org.ftcbootstrap.components.operations.motors.TankDriveToODS;
import org.ftcbootstrap.components.utils.DriveDirection;


/**
 * Note:  It is assumed that the proper registrar is used for this set of demos. To confirm please
 * search for "Enter your custom registrar"  in  {@link org.ftcTeam.FTCTeamControllerActivity}
 * <p/>
 */

@Autonomous
public class StateMachineOperations2 extends ActiveOpMode {

    private TankDriveRobotWithSensors robot;
    private TankDriveToODS tankDriveToODS;

    private int step;


    /**
     * Implement this method to define the code to run when the Init button is pressed on the Driver station.
     */
    @Override
    protected void onInit() {

        //specify configuration name save from scan operation
        robot = TankDriveRobotWithSensors.newConfig(hardwareMap, getTelemetryUtil());
        tankDriveToODS = new TankDriveToODS(this, robot.ods, robot.leftMotor, robot.rightMotor);

        step = 1;
    }


    /**
     * Implement this method to define the code to run when the Start button is pressed on the Driver station.
     * This method will be called on each hardware cycle just as the loop() method is called for event based Opmodes
     *  @throws InterruptedException
     */
    @Override
    protected void activeLoop() throws InterruptedException {

        double power;
        double targetBrightness;
        double targetTime;

        switch (step) {
            case 1:

                //Drive forward until ods detects line
                power = 0.2;
                targetBrightness = 0.5;
                if ( tankDriveToODS.runToTarget(power, targetBrightness, DriveDirection.DRIVE_FORWARD)) {
                    step++;
                }
                break;

            case 2:

                //Line follow from the left of the line
                power = 0.1;
                targetBrightness = 0.5;
                targetTime = 5;  //seconds
                if ( tankDriveToODS.lineFollowForTime( power, targetBrightness, targetTime, DriveDirection.PIVOT_FORWARD_RIGHT)) {
                    step++;
                }
                break;

            default:
                setOperationsCompleted();
                break;

        }
    }



}
