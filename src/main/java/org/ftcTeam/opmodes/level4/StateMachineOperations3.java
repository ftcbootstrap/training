package org.ftcTeam.opmodes.level4;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.ftcTeam.configurations.TankDriveRobotWithSensors;
import org.ftcbootstrap.ActiveOpMode;
import org.ftcbootstrap.components.operations.motors.TankDriveToEncoder;
import org.ftcbootstrap.components.utils.DriveDirection;

/**
 * Note:  It is assumed that the proper registrar is used for this set of demos. To confirm please
 * search for "Enter your custom registrar"  in  {@link org.ftcTeam.FTCTeamControllerActivity}
 * <p/>
 */

@Autonomous
public class StateMachineOperations3 extends ActiveOpMode {

    private TankDriveRobotWithSensors robot;

    private TankDriveToEncoder tankDriveToEncoder;

    private int step;

    /**
     * Implement this method to define the code to run when the Init button is pressed on the Driver station.
     */
    @Override
    protected void onInit() {

        robot = TankDriveRobotWithSensors.newConfig(hardwareMap, getTelemetryUtil());

        tankDriveToEncoder = new TankDriveToEncoder(this, robot.leftMotor, robot.rightMotor);

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

        boolean targetReached = false;

        switch (step) {
            case 1:
                //drive power  forward
                targetReached = tankDriveToEncoder.runToTarget(.65, 10000,
                        DriveDirection.DRIVE_FORWARD, DcMotor.RunMode.RUN_TO_POSITION);
                if (targetReached) {
                    step++;
                }
                break;

            case 2:
                //1st turn right
                targetReached = tankDriveToEncoder.runToTarget(0.4, 5050,
                        DriveDirection.PIVOT_FORWARD_RIGHT,DcMotor.RunMode.RUN_TO_POSITION);
                if (targetReached) {
                    step++;
                }
                break;

            case 3:
                //drive   forward
                targetReached = tankDriveToEncoder.runToTarget(.65, 4000,
                        DriveDirection.DRIVE_FORWARD,DcMotor.RunMode.RUN_TO_POSITION);
                if (targetReached) {
                    step++;
                }
                break;

            case 4:
                //2nd turn right
                targetReached = tankDriveToEncoder.runToTarget(0.4, 5050,
                        DriveDirection.PIVOT_FORWARD_RIGHT,DcMotor.RunMode.RUN_TO_POSITION);
                if (targetReached) {
                    step++;
                }
                break;

            case 5:
                //drive forward
                targetReached = tankDriveToEncoder.runToTarget(.65, 5500,
                        DriveDirection.DRIVE_FORWARD,DcMotor.RunMode.RUN_TO_POSITION);
                if (targetReached) {
                    step++;
                }
                break;


            case 6:
                //3rd turn right
                targetReached = tankDriveToEncoder.runToTarget(0.4, 5050,
                        DriveDirection.PIVOT_FORWARD_RIGHT,DcMotor.RunMode.RUN_TO_POSITION);
                if (targetReached) {
                    step++;
                }
                break;


            case 7:
                //drive  forward
                targetReached = tankDriveToEncoder.runToTarget(.65, 7250,
                        DriveDirection.DRIVE_FORWARD,DcMotor.RunMode.RUN_TO_POSITION);
                if (targetReached) {
                    step++;
                }
                break;


            case 8:
                //PIVOT BACK
                targetReached = tankDriveToEncoder.runToTarget(0.4, 5050,
                        DriveDirection.PIVOT_BACKWARD_RIGHT,DcMotor.RunMode.RUN_TO_POSITION);
                if (targetReached) {
                    step++;
                }
                break;

            case 9:
                //PARK
                targetReached = tankDriveToEncoder.runToTarget(.65, 1500,
                        DriveDirection.DRIVE_BACKWARD,DcMotor.RunMode.RUN_TO_POSITION);
                if (targetReached) {
                    step++;
                }
                break;


            default:
                setOperationsCompleted();
                break;

        }


    }



}
