package org.ftcTeam.opmodes;

import org.ftcTeam.opmodes.level2.*;
import org.ftcbootstrap.BootstrapRegistrar;

/**
 * Register Op Modes
 */
public class Level2Registrar extends BootstrapRegistrar {


  protected Class[] getOpmodeClasses() {
    Class[] classes = {

            AutoDrive01.class,
            AutoDrive02.class,
            TeleopClaw.class,
            TeleopDrive.class
    };

    return classes;

  }
}
