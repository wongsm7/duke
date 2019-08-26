public class ExitCommand extends Command{
    @Override
    public void execute(TaskList listOfTasks, Ui ui, Storage storage) throws DukeException {
        ui.println("Bye. Hope to see you again soon!");
    }

    public boolean isExit(){
        return true;
    }
}
