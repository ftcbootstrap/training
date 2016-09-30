package org.ftcTeam.opmodes.level4;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.ftcTeam.configurations.TankDriveRobotWithSensors;
import org.ftcbootstrap.ActiveOpMode;
import org.ftcbootstrap.components.operations.motors.TankDriveToEncoder;
import org.ftcbootstrap.components.operations.motors.TankDriveToTime;
import org.ftcbootstrap.components.utils.DriveDirection;

/**
 * Note:  It is assumed that the proper registrar is used for this set of demos. To confirm please
 * search for "Enter your custom registrar"  in  {@link org.ftcTeam.FTCTeamControllerActivity}
 * <p/>
 */

@Autonomous
public class StateMachineOperations1 extends ActiveOpMode {

    private TankDriveRobotWithSensors robot;

    private TankDriveToEncoder tankDriveToEncoder;
    private TankDriveToTime tankDriveToTime;

    private int step;

    /**
     * Implement this method to define the code to run when the Init button is pressed on the Driver station.
     */
    @Override
    protected void onInit() {

        robot = TankDriveRobotWithSensors.newConfig(hardwareMap, getTelemetryUtil());

        tankDriveToEncoder = new TankDriveToEncoder(this, robot.leftMotor, robot.rightMotor);
        tankDriveToTime = new TankDriveToTime(this, robot.leftMotor, robot.rightMotor);

        step = 1;
    }


    /**
     * Implement this method to define the code to run when the Start button is pressed on the Driver station.
     * This method will be called on each hardware cycle just as the loop() method is called for event based Opmodes
     *
     * @throws InterruptedException
     */
    @Override
    protected void activeLoop() throws InterruptedException {

        switch (step) {
            case 1:
                //Drive to encoder position
                if (tankDriveToEncoder.runToTarget(.65, 10000,
                        DriveDirection.DRIVE_FORWARD, DcMotor.RunMode.RUN_TO_POSITION)) {
                    step++;
                }
                break;

            case 2:
                //Drive for time
                if (tankDriveToTime.runToTarget( 0.3 , 2 , DriveDirection.DRIVE_FORWARD)) {
                    step++;
                }
                break;

            default:
                setOperationsCompleted();
                break;

        }


    }



}
