package org.ftcTeam.opmodes;

import org.ftcTeam.opmodes.level1.*;
import org.ftcbootstrap.BootstrapRegistrar;

/**
 * Register Op Modes
 */
public class Level1Registrar extends BootstrapRegistrar {


  protected Class[] getOpmodeClasses() {
    Class[] classes = {

            TeleopLesson01.class,
            AutoLesson01A.class,
            AutoLesson01B.class,
            AutoLesson02.class,
            AutoLesson03.class
    };

    return classes;

  }
}
