import java.io.IOException;

public abstract class Command {
    public abstract void execute(TaskList listOfTasks, Ui ui, Storage storage) throws DukeException, IOException;

    public abstract boolean isExit();
}
