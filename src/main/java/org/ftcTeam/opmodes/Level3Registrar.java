package org.ftcTeam.opmodes;

import org.ftcTeam.opmodes.level3.*;
import org.ftcbootstrap.BootstrapRegistrar;

/**
 * Register Op Modes
 */
public class Level3Registrar extends BootstrapRegistrar {


  protected Class[] getOpmodeClasses() {
    Class[] classes = {

            MotorStopOnTouch1.class,
            MotorStopOnTouch2.class,
            Ods1DriveToLine.class,
            Ods2DriveAlongLine.class,
            ColorSensorTelemetry.class
    };

    return classes;

  }
}
