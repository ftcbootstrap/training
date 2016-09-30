package org.ftcTeam.opmodes.level2;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.ftcTeam.configurations.TankDriveRobotWithClaw;
import org.ftcbootstrap.ActiveOpMode;
import org.ftcbootstrap.components.operations.servos.GamePadClaw;
import org.ftcbootstrap.components.operations.servos.GamePadServo;


/**
 * Note:  It is assumed that the proper registrar is used for this set of demos. To confirm please
 * search for "Enter your custom registrar"  in  {@link org.ftcTeam.FTCTeamControllerActivity}
 * <p/>
 */

@TeleOp
public class TeleopClaw extends ActiveOpMode {

    private TankDriveRobotWithClaw robot;

    private GamePadClaw claw;

    /**
     * Implement this method to define the code to run when the Init button is pressed on the Driver station.
     */
    @Override
    protected void onInit() {

        robot = TankDriveRobotWithClaw.newConfig(hardwareMap, getTelemetryUtil());

    }

    /**
     * Implement this method to define the code to run when the Play button is pressed on the Driver station.
     * This code will run once.
     */
    @Override
    protected void onStart() throws InterruptedException {
        super.onStart();

        //operate the claw with GamePadServo.Control. Use the X and B buttons for up and down and the  X and B buttons for left and right
        claw = new GamePadClaw(this, gamepad1, robot.leftClaw, robot.rightClaw, GamePadServo.Control.X_B, 0.8);

    }

    /**
     * Implement this method to define the code to run when the Start button is pressed on the Driver station.
     * This method will be called in a loop on each hardware cycle
     */
    @Override
    protected void activeLoop() throws InterruptedException {

        //take readings from gamepad and translate to servo operations
        claw.update();

    }

}
