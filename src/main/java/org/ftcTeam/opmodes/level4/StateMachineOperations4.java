package org.ftcTeam.opmodes.level4;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.ftcTeam.configurations.TankDriveRobotWithSensors;
import org.ftcbootstrap.ActiveOpMode;
import org.ftcbootstrap.components.ColorSensorComponent;
import org.ftcbootstrap.components.ServoComponent;
import org.ftcbootstrap.components.operations.motors.TankDriveToEncoder;
import org.ftcbootstrap.components.utils.DriveDirection;

/**
 * Note:  It is assumed that the proper registrar is used for this set of demos. To confirm please
 * search for "Enter your custom registrar"  in  {@link org.ftcTeam.FTCTeamControllerActivity}
 * <p/>
 */

@Autonomous
public class StateMachineOperations4 extends ActiveOpMode {

    private TankDriveRobotWithSensors robot;

    private TankDriveToEncoder tankDriveToEncoder;

    private ServoComponent leftServoComponent;
    private ServoComponent rightServoComponent;

    private ColorSensorComponent colorSensorComponent;

    private int step;

    /**
     * Implement this method to define the code to run when the Init button is pressed on the Driver station.
     */
    @Override
    protected void onInit() {

        robot = TankDriveRobotWithSensors.newConfig(hardwareMap, getTelemetryUtil());

        tankDriveToEncoder = new TankDriveToEncoder(this, robot.leftMotor, robot.rightMotor);

        leftServoComponent = new ServoComponent(this,  robot.leftServo,  .3);
        rightServoComponent = new ServoComponent(this,  robot.rightServo,  .7);

        colorSensorComponent = new ColorSensorComponent(this, robot.mrColor, ColorSensorComponent.ColorSensorDevice.MODERN_ROBOTICS_I2C);
        //disable LED to allow sensor to measure light project from the beacon
        colorSensorComponent.enableLed(false);



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
                //Drive forward
                targetReached = tankDriveToEncoder.runToTarget(.65, 6000,
                        DriveDirection.DRIVE_FORWARD, DcMotor.RunMode.RUN_TO_POSITION);
                if (targetReached) {
                    step++;
                }
                break;

            case 2:
                //turn right 45 degrees
                targetReached = tankDriveToEncoder.runToTarget(0.4, 2525,
                        DriveDirection.PIVOT_FORWARD_RIGHT,DcMotor.RunMode.RUN_TO_POSITION);
                if (targetReached) {
                    step++;
                }
                break;

            case 3:
                //full power forward
                targetReached = tankDriveToEncoder.runToTarget(.65, 9000,
                        DriveDirection.DRIVE_FORWARD,DcMotor.RunMode.RUN_TO_POSITION);
                if (targetReached) {
                    step++;
                }
                break;

            case 4:
                //2nd turn right another  45 degrees
                targetReached = tankDriveToEncoder.runToTarget(0.4, 5050,
                        DriveDirection.PIVOT_FORWARD_RIGHT,DcMotor.RunMode.RUN_TO_POSITION);
                if (targetReached) {
                    step++;
                }
                break;

            case 5:
                //drive close to beacon
                targetReached = tankDriveToEncoder.runToTarget(.65, 5500,
                        DriveDirection.DRIVE_FORWARD,DcMotor.RunMode.RUN_TO_POSITION);
                if (targetReached) {
                    step++;
                }
                break;


            case 6:
                //Detect beacon color
                boolean isRed = colorSensorComponent.isRed(5, 2, 2);
                boolean isBlue = colorSensorComponent.isBlue(10, 2, 2);

                if ( isRed ) {
                    leftServoComponent.updateServoTargetPosition(0.7);
                }
                else if ( isBlue ) {
                    rightServoComponent.updateServoTargetPosition(0.3);
                }

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
