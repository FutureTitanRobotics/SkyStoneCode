/*---------------------------------------------------------------------------
* Copyright 2019 Future Titan Robotics. All rights reserved.
* This program and its rights belong to FTC team 14328 Future Titan Robotics.
* Copying of this program without permission is not acceptable however may
* not be enforced. Please ask before using any part of this program.
*///-------------------------------------------------------------------------

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="TankWheels", group="Linear Opmode")
//@Disabled
public class GameDrive extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    //private DcMotor lmotor = null; // looking at the First sample programs, these are irrelevant. I don't want to remove them in case they are used later.
    //private DcMotor rmotor = null;

    DcMotor lmotor;
    DcMotor rmotor;

    @Override
    public void runOpMode() {// Start the code ("INIT" is pressed)
        telemetry.addData("Status", "Initialized");// Show text on the phone that we've pressed the "INIT" button
        telemetry.update();

        // create 2 new motors (l and r for left and right)
        lfmotor = hardwareMap.get(DcMotor.class, "left_drive_front");
        lbmotor = hardwareMap.get(DcMotor.class, "left_drive_back");
        rfmotor = hardwareMap.get(DcMotor.class, "right_drive_front");
        rbmotor = hardwareMap.get(DcMotor.class, "right_drive_back");

        // the right motor has been reversed because when building, it is flipped over relative to the left one.
        lfmotor.setDirection(DcMotor.Direction.REVERSE);
        lbmotor.setDirection(DcMotor.Direction.REVERSE);
        rfmotor.setDirection(DcMotor.Direction.FORWARD);
        rbmotor.setDirection(DcMotor.Direction.FORWARD);
        

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            lfmotor.setPower(1);
            lbmotor.setPower(0);
            sleep(1000);
            lfmotor.setPower(0);
            lbmotor.setPower(0);
            sleep(500);
            lfmotor.setPower(1);
            sleep(1000);
            lfmotor.setPower(0);
            lbmotor.setPower(1);
            sleep(1000);
            lbmotor.setPower(0);
        lmotor.setPower(0); // Stop all motors at the end of the game
        rmotor.setPower(0);

        // Show the elapsed game time at the end of the match
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.update();
    }
}
