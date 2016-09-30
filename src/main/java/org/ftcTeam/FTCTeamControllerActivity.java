package org.ftcTeam;

import com.qualcomm.robotcore.eventloop.opmode.OpModeRegister;

import org.firstinspires.ftc.robotcontroller.internal.FtcRobotControllerActivity;
import org.ftcTeam.opmodes.*;

public class FTCTeamControllerActivity extends FtcRobotControllerActivity {


  @Override
  protected OpModeRegister createOpModeRegister() {

      return new Level1Registrar();
      //return new Level2Registrar();
      //return new Level3Registrar();
      //return new Level4Registrar();

  }


}
