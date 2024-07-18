/////////////////////
//
// Current AUTO
//
///////////////////
package org.firstinspires.ftc.teamcode.opmodes8818;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.teamBot.TeamRobotSetup;


@Autonomous(name="Teambot: Auto Drive to Line")
//@Disabled
public class AutoOptionOne extends LinearOpMode {
    //Add the TeamRobotSetup to control the robot
    TeamRobotSetup slideBot = new TeamRobotSetup();

    //Timer
    private ElapsedTime runtime = new ElapsedTime();

    //Variables
    static final double FORWARD_SPEED = 0.2;
    static final double TURN_SPEED = 0.3;
    
    @Override
    public void runOpMode(){

    }


}
