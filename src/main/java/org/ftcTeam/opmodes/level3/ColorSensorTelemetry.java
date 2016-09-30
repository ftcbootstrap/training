package org.ftcTeam.opmodes.level3;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.ftcTeam.configurations.TankDriveRobotWithSensors;
import org.ftcbootstrap.ActiveOpMode;
import org.ftcbootstrap.components.ColorSensorComponent;



/**
 * Note:  It is assumed that the proper registrar is used for this set of demos. To confirm please
 * search for "Enter your custom registrar"  in  {@link org.ftcTeam.FTCTeamControllerActivity}
 * <p/>
 */

@Autonomous
public class ColorSensorTelemetry extends ActiveOpMode {

    private TankDriveRobotWithSensors robot;

    private ColorSensorComponent colorSensorComponent;


    /**
     * Implement this method to define the code to run when the Init button is pressed on the Driver station.
     */
    @Override
    protected void onInit() {

        //specify configuration name save from scan operation
        robot = TankDriveRobotWithSensors.newConfig(hardwareMap, getTelemetryUtil());

        colorSensorComponent = new ColorSensorComponent(this, robot.mrColor, ColorSensorComponent.ColorSensorDevice.MODERN_ROBOTICS_I2C);
        //bug work around.  always turn it off at init and then set it again in onStart
        colorSensorComponent.enableLed(false);

    }

    @Override
    protected void onStart() throws InterruptedException {
        super.onStart();

        //enable LED to allow sensor to measure reflective light coming off of a color surface
        //big work around.  always turn it off at init and them set it again later
        colorSensorComponent.enableLed(true);
    }

    /**
     * Implement this method to define the code to run when the Start button is pressed on the Driver station.
     * This method will be called on each hardware cycle just as the loop() method is called for event based Opmodes
     *  @throws InterruptedException
     */
    @Override
    protected void activeLoop() throws InterruptedException {

        boolean isRed = colorSensorComponent.isRed(5, 2, 2);
        telemetry.addData("1: isRed 5, 2, 2 ", isRed);
        boolean isBlue = colorSensorComponent.isBlue(10, 2, 2);
        telemetry.addData("2: isBlue 10, 2, 2 ", isBlue);

        telemetry.addData("3: Red  ", colorSensorComponent.getR());
        telemetry.addData("3: Green", colorSensorComponent.getG());
        telemetry.addData("3: Blue ", colorSensorComponent.getB());
        telemetry.addData("3: Hue", colorSensorComponent.getHSCValues()[0]);


        //send any telemetry that may have been added in the above operations
        telemetry.update();

    }

}
