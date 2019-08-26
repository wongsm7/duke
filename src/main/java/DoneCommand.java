import java.io.IOException;

public class DoneCommand extends Command {
    private int index;
    public DoneCommand(int index){
        this.index = index;
    }
    @Override
    public void execute(TaskList listOfTasks, Ui ui, Storage storage) throws DukeException, IOException {
        if (index < 0 || index > listOfTasks.getSize() - 1) {
            throw new DukeException("Invalid task number");
        }
        listOfTasks.getListOfTasks().get(index).setDone();
        storage.writeToFile(listOfTasks.getListOfTasks());
        ui.println("Nice! I've marked this task as done:");
        ui.println(listOfTasks.getListOfTasks().get(index));
    }

    public boolean isExit(){
        return false;
    }
}
