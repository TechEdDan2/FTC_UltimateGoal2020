////////////////////////////
//
// AUTO SAMPLE
//
///////////////////////////
package org.firstinspires.ftc.teamcode.opmodes8818;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;
import org.firstinspires.ftc.teamcode.teamBot.TeamRobotSetup;

import java.sql.SQLOutput;

/**
 * The AutoBasicLine program will have the robot move forward for
 *  a set amount of time, stop, slide to the right, stop again,
 *  and then move backward for a set amount of time, stop a
 *  third time, and then it will spin in place.
 *
 *  Note: this is a non-sensor program and will only use time.
 *
 * @author DNelson
 * @version 3/9/2021 v1
 */


@Autonomous (name="Teambot: Auto Drive By Time", group="Teambot")
//@Disabled
public class AutoBasicLine extends LinearOpMode {
    //Add an instance of the TeamRobotSetup
    TeamRobotSetup htsSlide = new TeamRobotSetup();

    /* Declare OpMode members. */
    private ElapsedTime runtime = new ElapsedTime();

    //Constant Power Levels
    static final double     FORWARD_SPEED = 0.2;
    static final double     TURN_SPEED    = 0.3;

    @Override
    public void runOpMode() {
        /*
         * Initialize the drive system variables.
         * The init() method of the hardware class does all the work here
         */
        htsSlide.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Step through each leg of the path, ensuring that the
        //  Auto mode has not been stopped along the way.

        // Step 1:  Drive forward for 2 seconds
        // Call the driveForward method and pass it the FORWARD_SPEED constant.
        htsSlide.driveForward(FORWARD_SPEED);
        runtime.reset();//resets the timer
        //While the timer hasn't reached the end of the time condition, the
        //  telemetry data will be sent to the driver station (phone).
        //  The %2.5f is a formatter place holder the "2" refers to two spaces
        //  before displaying the floating point number of seconds and the
        //  .5 refers to how many places after the decimal to display for
        //  seconds (5 places)
        while (opModeIsActive() && (runtime.seconds() < 2)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        // Step 2:  Stop for 1.3 seconds
        // Call the driveForward method and pass it 0.0 to stop the motors
        htsSlide.driveForward(0.0);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.3)) {
            telemetry.addData("Path", "Leg 2: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();

        }

        //Step 3: Slide to the right for 1.5 seconds
        // Call the driveSlide method and pass it the FORWARD_SPEED constant.
        htsSlide.driveSlide(FORWARD_SPEED);
        runtime.reset();
        while(opModeIsActive() && (runtime.seconds()<1.5)){
            telemetry.addData("Path", "Leg 3: %2.5f S elapsed", runtime.seconds());
            telemetry.update();
        }

        // Step 4:  Stop for 1.3 seconds
        htsSlide.driveForward(0.0);
        htsSlide.driveSlide(0.0);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.3)) {
            telemetry.addData("Path", "Leg 4: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();

        }

        // Step 5:  Drive Backwards for 1 Second
        htsSlide.driveForward(-FORWARD_SPEED);//Negative constant will move backward
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.0)) {
            telemetry.addData("Path", "Leg 5: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        // Step 6:  Stop for 1.3 seconds
        //Stop both motors to make sure nothing unintended is moving
        htsSlide.driveForward(0.0);
        htsSlide.driveSlide(0.0);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.3)) {
            telemetry.addData("Path", "Leg 4: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();

        }

        //Step 7: Spin for 2 seconds
        htsSlide.driveSpin(TURN_SPEED);
        runtime.reset();
        while(opModeIsActive() && (runtime.seconds() < 5.0)){
            telemetry.addData("WOOOOOOO", "I've been spinning for ", runtime.seconds());
            telemetry.update();
        }

        // Step 8:  Stop
        htsSlide.driveSpin(0.0);
        htsSlide.driveForward(0.0);
        htsSlide.driveSlide(0.0);
        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);
    }//END OF RUN OPMODE
}//END OF CLASS
