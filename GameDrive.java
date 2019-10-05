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
        lmotor = hardwareMap.get(DcMotor.class, "left_drive");
        rmotor = hardwareMap.get(DcMotor.class, "right_drive");

        // the right motor has been reversed because when building, it is flipped over relative to the left one.
        lmotor.setDirection(DcMotor.Direction.REVERSE);
        rmotor.setDirection(DcMotor.Direction.FORWARD);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            //Make forward and backward movement the up and down on the right joystick of the controller.
            double fb = gamepad1.right_stick_y;
            //Turn or rotate with the left joystick
            double turn = gamepad1.right_stick_x;

            if(turn < -0.1) {
                lmotor.setPower(turn); //make the speed on the motor equal to the power on the joystick to spin left or right
                rmotor.setPower(-turn);
            }
            if(turn > 0.1) {
                lmotor.setPower(-turn); //make the speed on the motor equal to the power on the joystick to spin left or right
                rmotor.setPower(turn);
            }
            else if(fb > 0.1 || fb < -0.1) {
                lmotor.setPower(fb); //if you want to go forward or backwards, move the motors the same way as the joystick says
                rmotor.setPower(fb);
            }
            else {
                lmotor.setPower(0); // If the joystick is not being moved, stop all motors
                rmotor.setPower(0);
            }
        }

        lmotor.setPower(0); // Stop all motors at the end of the game
        rmotor.setPower(0);

        // Show the elapsed game time at the end of the match
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.update();
    }
}