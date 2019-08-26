import java.io.IOException;

public class AddCommand extends Command{
    private Task task;
    public AddCommand(Task task){
        this.task = task;
    }
    @Override
    public void execute(TaskList listOfTasks, Ui ui, Storage storage) throws DukeException, IOException {
        listOfTasks.addTask(task);
        ui.println("Got it. I've added this task:");
        ui.println(task);
        ui.println("Now you have " + listOfTasks.getSize() + " tasks in the list.");
        storage.writeToFile(listOfTasks.getListOfTasks());
    }

    public boolean isExit(){
        return false;
    }
}
