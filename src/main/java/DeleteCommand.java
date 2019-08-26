import java.io.IOException;

public class DeleteCommand extends Command{
    private int index;
    public DeleteCommand(int index){
        this.index = index;
    }
    @Override
    public void execute(TaskList listOfTasks, Ui ui, Storage storage) throws DukeException, IOException {
        if (index < 0 || index >= listOfTasks.getSize()) {
            throw new DukeException("Invalid index");
        }
        Task temp = listOfTasks.removeTask(index);
        System.out.println("Noted. I've removed this task:");
        System.out.println(temp);
        System.out.println("Now you have " + listOfTasks.getSize() + " tasks in the list.");
        storage.writeToFile(listOfTasks.getListOfTasks());
    }

    public boolean isExit(){
        return false;
    }
}
