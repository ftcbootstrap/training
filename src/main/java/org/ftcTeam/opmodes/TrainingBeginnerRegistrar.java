package org.ftcTeam.opmodes;

import org.ftcTeam.opmodes.level1.GamePadMotorAndServo;
import org.ftcTeam.opmodes.level1.MoveServoToPosition;
import org.ftcTeam.opmodes.level1.RunMotorForTime;
import org.ftcTeam.opmodes.level1.RunMotorToEncoderTarget;
import org.ftcTeam.training.level1.*;
import org.ftcbootstrap.BootstrapRegistrar;
import org.ftcbootstrap.demos.TelemetryTest;

/**
 * Register Op Modes
 */
public class TrainingBeginnerRegistrar extends BootstrapRegistrar {


  protected Class[] getOpmodeClasses() {
    Class[] classes = {

            GamePadMotorAndServo.class,
            RunMotorForTime.class,
            MoveServoToPosition.class,
            RunMotorToEncoderTarget.class,
            TelemetryTest.class

    };

    return classes;

  }
}
