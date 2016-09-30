package org.ftcTeam.opmodes.level2;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.ftcTeam.configurations.TankDriveRobotWithClaw;
import org.ftcbootstrap.ActiveOpMode;
import org.ftcbootstrap.components.operations.motors.TankDriveToEncoder;
import org.ftcbootstrap.components.utils.DriveDirection;


/**
 * Note:  It is assumed that the proper registrar is used for this set of demos. To confirm please
 * search for "Enter your custom registrar"  in  {@link org.ftcTeam.FTCTeamControllerActivity}
 * <p/>
 */

@Autonomous
public class AutoDrive02 extends ActiveOpMode {

    private TankDriveRobotWithClaw robot;
    private TankDriveToEncoder tankDriveToEncoder;

    /**
     * Implement this method to define the code to run when the Init button is pressed on the Driver station.
     */
    @Override
    protected void onInit() {

        robot = TankDriveRobotWithClaw.newConfig(hardwareMap, getTelemetryUtil());

        tankDriveToEncoder = new TankDriveToEncoder(this, robot.leftMotor, robot.rightMotor);

    }

    /**
     * Implement this method to define the code to run when the Start button is pressed on the Driver station.
     * This method will be called on each hardware cycle just as the loop() method is called for event based Opmode
     */
    @Override
    protected void activeLoop() throws InterruptedException {

        boolean targetReached = false;
        //drive forward at .65 power until 10000 encoder position
        double power = .65;
        int targetEncoderValue = 1000;
        DriveDirection direction =  DriveDirection.DRIVE_FORWARD;
        DcMotor.RunMode mode = DcMotor.RunMode.RUN_TO_POSITION;

        targetReached =
                tankDriveToEncoder.runToTarget(power, targetEncoderValue, direction, mode);

        if (targetReached) {
            setOperationsCompleted();
        }


    }


}
