package org.ftcTeam.configurations;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.ftcbootstrap.RobotConfiguration;
import org.ftcbootstrap.components.utils.TelemetryUtil;

/**
 * It is assumed that there is a configuration on the phone running the Robot Controller App with the same name as this class and
 * that  configuration is the one that is marked 'activated' on the phone.
 * It is also assumed that the device names in the 'init()' method below are the same  as the devices named for the
 * saved configuration on the phone.
 */
public class TankDriveRobotWithClaw extends RobotConfiguration {

    //motors
    public DcMotor leftMotor;
    public DcMotor rightMotor;

    //servo
    public Servo leftClaw;
    public Servo rightClaw;

    /**
     * Assign your class instance variables to the saved device names in the hardware map
     *
     * @param hardwareMap
     * @param telemetryUtil
     */
    @Override
    protected void init(HardwareMap hardwareMap, TelemetryUtil telemetryUtil) {

        setTelemetry(telemetryUtil);

        leftMotor = (DcMotor) getHardwareOn("leftMotor", hardwareMap.dcMotor);
        rightMotor = (DcMotor) getHardwareOn("rightMotor", hardwareMap.dcMotor);
        rightMotor.setDirection(DcMotor.Direction.REVERSE);

        leftClaw = (Servo) getHardwareOn("leftClaw", hardwareMap.servo);
        rightClaw = (Servo) getHardwareOn("rightClaw", hardwareMap.servo);

    }


    /**
     * Factory method for this class
     *
     * @param hardwareMap
     * @param telemetryUtil
     * @return
     */
    public static TankDriveRobotWithClaw newConfig(HardwareMap hardwareMap, TelemetryUtil telemetryUtil) {

        TankDriveRobotWithClaw config = new TankDriveRobotWithClaw();
        config.init(hardwareMap, telemetryUtil);
        return config;

    }



}
