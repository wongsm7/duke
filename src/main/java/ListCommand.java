public class ListCommand extends Command{
    @Override
    public void execute(TaskList listOfTasks, Ui ui, Storage storage) throws DukeException {
        if(listOfTasks.getSize() <= 0){
            throw new DukeException("No tasks in the list");
        }
        int count = 1;
        for (Task t : listOfTasks.getListOfTasks()) {
            ui.println(count + ". " + t);
            count++;
        }
    }

    public boolean isExit(){
        return false;
    }
}
