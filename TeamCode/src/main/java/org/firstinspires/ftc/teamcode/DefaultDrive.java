package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandBase;

import java.util.function.DoubleSupplier;

public class DefaultDrive extends CommandBase{
    private final Drivetrain m_drive;
    private final DoubleSupplier m_forward, m_rotation;

    public DefaultDrive(Drivetrain drivetrain, DoubleSupplier forward, DoubleSupplier rotation){
        m_drive = drivetrain;
        m_forward = forward;
        m_rotation = rotation;

        addRequirements(m_drive);
    }

    @Override
    public void execute(){
        m_drive.arcadeDrive(m_forward.getAsDouble(), m_rotation.getAsDouble());
    }
}
