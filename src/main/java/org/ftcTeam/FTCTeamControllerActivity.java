package org.ftcTeam;

import com.qualcomm.robotcore.eventloop.opmode.OpModeRegister;

import org.firstinspires.ftc.robotcontroller.internal.FtcRobotControllerActivity;
import org.ftcTeam.opmodes.TrainingBeginnerRegistrar;
import org.ftcTeam.training.*;

public class FTCTeamControllerActivity extends FtcRobotControllerActivity {


  @Override
  protected OpModeRegister createOpModeRegister() {

        return new TrainingBeginnerRegistrar();

  }


}
