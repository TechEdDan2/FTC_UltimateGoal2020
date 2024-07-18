//OUR TEAM CODE 4/19/2021

/////////////////////
//
//  ROBOT SETUP
//
////////////////////

package org.firstinspires.ftc.teamcode.teamBot;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * This is Team 8818 Hit the Switch's code for the
 *  robot with a slide drive (H - Drive) style setup
 *  for the 2020 - 2021 season
 *
 * Motor Setup:
 *  Back left Motor - backLeft  - port 0 on REV Control Hub
 *  Back right Motor - backRight - port 1 on REV Control Hub
 *  Front left Motor - frontLeft - port 2 on REV Control Hub
 *  Front right Motor - frontRight - port 3 on REV Control Hub
 *  Middle Motor - middle - port 0 on REV Expansion Hub
 *  Intake Motor - intake - port 1 on REV Expansion Hub
 *  Launch Motor - launch - port 2 on REV Expansion Hub
 *  *Wobble Goal Motor - wobbleGoal - port 3 on REV Expansion Hub
 */
public class TeamRobotSetup {
    //Variables for Mechanisms on the team robot
    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor middle;
   // private DcMotor intake;
   // private DcMotor launch;
   // private ColorSensor color;
    private double ticksPerRotation;

    //Add the param of type HardwareMap which we will name hwMap
    // this comes from the FTC SDK to help with configuration
    public void init(HardwareMap hwMap) {

        //Setting up all motors for the chassis, collection and launcher (alt+shift or )
        backLeft = hwMap.get(DcMotor.class, "backLeft");
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);//run at a targeted velocity
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);//
        //backLeft.setDirection(DcMotorSimple.Direction.REVERSE); //Reverses the rotational direction
        ticksPerRotation = backLeft.getMotorType().getTicksPerRev();

        frontLeft = hwMap.get(DcMotor.class, "frontLeft");
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);//run at a targeted velocity
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);//
        //frontLeft.setDirection(DcMotorSimple.Direction.REVERSE); //Reverses the rotational direction
        ticksPerRotation = frontLeft.getMotorType().getTicksPerRev();

        //The Right side motors and the middle will not be reversed
        backRight = hwMap.get(DcMotor.class, "backRight");
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);//run at a targeted velocity
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);//
        backRight.setDirection(DcMotorSimple.Direction.REVERSE); //Reverses the rotational direction
        ticksPerRotation = backRight.getMotorType().getTicksPerRev();

        frontRight = hwMap.get(DcMotor.class, "frontRight");
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);//run at a targeted velocity
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);//
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE); //Reverses the rotational direction
        ticksPerRotation = frontRight.getMotorType().getTicksPerRev();

        middle = hwMap.get(DcMotor.class, "middle");
        middle.setMode(DcMotor.RunMode.RUN_USING_ENCODER);//run at a targeted velocity
        middle.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);//
        //middle.setDirection(DcMotorSimple.Direction.REVERSE); //Reverses the rotational direction
        ticksPerRotation = middle.getMotorType().getTicksPerRev();

        //Commented out until we build these parts.
//        intake = hwMap.get(DcMotor.class, "intake");
//        intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);//run at a targeted velocity
//        intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);//
//        intake.setDirection(DcMotorSimple.Direction.REVERSE); //Reverses the rotational direction
//        ticksPerRotation = intake.getMotorType().getTicksPerRev();

//        launch = hwMap.get(DcMotor.class, "launch");
//        launch.setMode(DcMotor.RunMode.RUN_USING_ENCODER);//run at a targeted velocity
//        launch.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);//
//        launch.setDirection(DcMotorSimple.Direction.REVERSE); //Reverses the rotational direction
//        ticksPerRotation = launch.getMotorType().getTicksPerRev();

    }//End of init

    //Methods
    //ADDED in CHAPTER 7
    /**
     * This method will allow us to set the motor's speed
     * @param speed - double value that will be used to see speed of motor
     */
    public void setMotorSpeed(double speed){
        backLeft.setPower(speed);
    }

    /**
     * This method will be used to move the robot forward or backward
     * at a given power level.
     *
     * @param speed - double value that will be used to set the motor speed
     */
    public void driveForward(double speed){
        backLeft.setPower(speed);
        frontLeft.setPower(speed);
        backRight.setPower(speed);
        frontRight.setPower(speed);
    }

    /**
     * This method will be used to move the robot side to side
     * at a given power level.
     *
     * @param speed - double value that will be used to set the motor speed
     */
    public void driveSlide(double speed){
        middle.setPower(speed);
    }

    /**
     * This method will be used to move the robot in circles
     * at a given power level.
     *
     * @param speed - double value that will be used to set the motor speed
     */
    public void driveSpin(double speed){
        backLeft.setPower(-speed);
        frontLeft.setPower(-speed);
        backRight.setPower(speed);
        frontRight.setPower(speed);
    }

    /**
     * This method will return the number of ticks which
     *  can be calculated for rotation.
     * @return Will return the current position for the motor
     */
    public double getMotorRotations(){
        return backLeft.getCurrentPosition()/ticksPerRotation;
    }//End of method

    /**
     * This method will reset the encoder count.
     */
    public void resetEncoder(){ ticksPerRotation = 0; }


}//End of Class
