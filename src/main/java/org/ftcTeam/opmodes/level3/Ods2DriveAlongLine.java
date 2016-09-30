package org.ftcTeam.opmodes.level3;

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
public class Ods2DriveAlongLine extends ActiveOpMode {

    private TankDriveRobotWithSensors robot;
    private TankDriveToODS tankDriveToODS;

    /**
     * Implement this method to define the code to run when the Init button is pressed on the Driver station.
     */
    @Override
    protected void onInit() {
        //specify configuration name save from scan operation
        robot = TankDriveRobotWithSensors.newConfig(hardwareMap, getTelemetryUtil());
        tankDriveToODS = new TankDriveToODS(this, robot.ods, robot.leftMotor, robot.rightMotor);

    }


    /**
     * Implement this method to define the code to run when the Start button is pressed on the Driver station.
     * This method will be called on each hardware cycle just as the loop() method is called for event based Opmodes
     *  @throws InterruptedException
     */
    @Override
    protected void activeLoop() throws InterruptedException {

        boolean targetTimeReached = false;

        double power = 0.1;
        //brightness assumes fixed distance from the target
        //i.e. line follow or stop on white line
        double targetBrightness = 0.5;
        double targetTime = 5;  //seconds

        //Line follow from the left of the line
        targetTimeReached =  tankDriveToODS.lineFollowForTime( power, targetBrightness, targetTime, DriveDirection.PIVOT_FORWARD_RIGHT);

        if ( targetTimeReached) {
            setOperationsCompleted();
        }


    }


}
