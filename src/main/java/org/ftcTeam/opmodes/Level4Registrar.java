package org.ftcTeam.opmodes;

import org.ftcTeam.opmodes.level4.*;
import org.ftcbootstrap.BootstrapRegistrar;

/**
 * Register Op Modes
 */
public class Level4Registrar extends BootstrapRegistrar {


  protected Class[] getOpmodeClasses() {
    Class[] classes = {

            StateMachineOperations1.class,
            StateMachineOperations2.class,
            StateMachineOperations3.class,
            StateMachineOperations4.class
    };

    return classes;

  }
}
