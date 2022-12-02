package frc.robot.commands;

import java.util.function.Consumer;
import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class InputCommand<E> extends CommandBase {
    private final Supplier<E> supplier;
    private final Consumer<E> consumer;

    public InputCommand(Supplier<E> supplier, Consumer<E> consumer, Subsystem... requirements) {
        this.supplier = supplier;
        this.consumer = consumer;
        addRequirements(requirements);
    }

    @Override
    public void execute() {
        this.consumer.accept(this.supplier.get());
    }
}
