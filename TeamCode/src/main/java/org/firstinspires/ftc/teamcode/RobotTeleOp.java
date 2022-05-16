package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.button.Button;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "TeleOp")
@Disabled
public class RobotTeleOp extends CommandOpMode{
    private static final double WHEEL_DIAMETER_IN = 100;
    private static final double SPIN_SPD = 0.2;
    private static final double ARM_SPIN_SPD = 0.5;
    //Subsystems
    private MotorEx m_left, m_right, m_spin, m_armmotor;
    private Arm m_arm;
    private SpinWheel m_spinWheel;
    private Drivetrain m_drive;

    //Joysticks
    private GamepadEx driverOp, toolOp;

    //Buttons
    private Button m_spinButton;
    private Button m_grabButton;
    private Button m_releaseButton;
    private Button m_liftButton;
    private Button m_armButton, m_backArmButton;

    //Commands
    private DefaultDrive m_driveCommand;
    private Spin m_spinCommand;
    private RotateArm m_armCommand, m_backArmCommand;


    @Override
    public void initialize(){
        //Motors
        m_left = new MotorEx(hardwareMap, "leftDrive");
        m_right = new MotorEx(hardwareMap, "rightDrive");
        m_spin = new MotorEx(hardwareMap, "duckSpinner");
        m_armmotor = new MotorEx(hardwareMap, "arm");

        //Gamepads
        driverOp = new GamepadEx(gamepad1);
        toolOp = new GamepadEx(gamepad2);

        //Subsystems
        m_spinWheel = new SpinWheel(m_spin, SPIN_SPD);
        m_drive = new Drivetrain(m_left, m_right, WHEEL_DIAMETER_IN);
        m_arm = new Arm(m_armmotor);

        //Commands
        m_spinCommand = new Spin(m_spinWheel, 1);
        m_armCommand = new RotateArm(m_arm, ARM_SPIN_SPD);
        m_backArmCommand = new RotateArm(m_arm, -ARM_SPIN_SPD);

        m_driveCommand = new DefaultDrive(m_drive, () -> driverOp.getLeftY(), () -> driverOp.getRightX());

        m_spinButton = (new GamepadButton(toolOp, GamepadKeys.Button.A)).
                whenHeld(m_spinCommand);

        m_armButton = (new GamepadButton(toolOp, GamepadKeys.Button.RIGHT_BUMPER)).
                whenHeld(m_armCommand);
        m_backArmButton = (new GamepadButton(toolOp, GamepadKeys.Button.LEFT_BUMPER)).
                whenHeld(m_backArmCommand);


        register(m_drive);
        m_drive.setDefaultCommand(m_driveCommand);

    }
}
