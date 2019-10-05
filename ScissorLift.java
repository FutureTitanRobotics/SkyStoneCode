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

@TeleOp(name="ScissorLift", group="Linear Opmode")
//@Disabled
public class ScissorLift extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    
    DcMotor slmotor;
            
    @Override
    public void runOpMode() {// Start the code ("INIT" is pressed)
        telemetry.addData("Status", "Initialized");// Show text on the phone that we've pressed the "INIT" button
        telemetry.update();

        // create 2 new motors (l and r for left and right)
        slmotor = hardwareMap.get(DcMotor.class, "scissor_lift");
        
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            //Make forward and backward movement the up and down on the right joystick of the controller.
            boolean up = gamepad2.y;
            //Turn or rotate with the left joystick
            boolean down = gamepad2.x;

            if (up) {
                slmotor.setPower(0.3);
                sleep(3);
                slmotor.setPower(0);
            }
            if (down) {
                slmotor.setPower(-0.3);
                sleep(3);
                slmotor.setPower(0);
            }
        }
        slmotor.setPower(0); // Stop all motors at the end of the game
            
        // Show the elapsed game time at the end of the match
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.update();
    }
}