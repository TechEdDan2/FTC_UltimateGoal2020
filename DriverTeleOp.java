//////////////////////////
//
// SAMPLE Driver
//
//////////////////////////


package org.firstinspires.ftc.teamcode.opmodes8818;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.teamBot.TeamRobotSetup;

/**
 * This program will be used to drive the
 *  team robot using a logitech game controller
 *
 * @author DNelson
 * @version 3/16/2021
 */
@TeleOp
//@Disabled
public class DriverTeleOp extends OpMode {
    //Create an instance of the TeamRobotSetup
    TeamRobotSetup htlSlideBot = new TeamRobotSetup();

    @Override
    public void init(){
        htlSlideBot.init(hardwareMap);
        telemetry.addData("Welcome Team 8818, Hit the Switch!",
                "Program Initialized");
        telemetry.update();
    }//END OF INIT

    @Override
    public void loop(){
        //Variables
        double motorSpeed = 0.0;

        //This Code will drive the robot forward or backward
        //Dead Zone is added to the if condition
        if(gamepad1.left_stick_y > 0.2 || gamepad1.left_stick_y < -0.2){
            motorSpeed = gamepad1.left_stick_y;
            htlSlideBot.driveForward(motorSpeed);
            telemetry.addData("Gamepad Y Value", gamepad1.left_stick_y);

        }else if(gamepad1.left_stick_x > 0.2 || gamepad1.left_stick_x < -0.2){
            //This Code will let the driver slide right or left
            motorSpeed = gamepad1.left_stick_x;
            htlSlideBot.driveSlide(motorSpeed);
            telemetry.addData("Gamepad X Value", gamepad1.left_stick_x);

        }else if(gamepad1.right_stick_x > 0.2 || gamepad1.right_stick_x < -0.2){
            //This Code will let the driver turn the robot
            motorSpeed = gamepad1.right_stick_x;
            htlSlideBot.driveSpin(motorSpeed);
            telemetry.addData("Gamepad Y Value", gamepad1.right_stick_x);

        }else{
            //Stop robot from moving
            htlSlideBot.driveForward(0.0);
            htlSlideBot.driveSlide(0.0);
            htlSlideBot.driveSpin(0.0);//Not really needed
            telemetry.addData("Robot Stopped", "True" );
        }

    }//END OF LOOP

}//END OF CLASS
