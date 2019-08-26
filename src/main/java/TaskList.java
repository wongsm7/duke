import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> listOfTasks;

    public TaskList() {
        this.listOfTasks = new ArrayList<>();
    }

    public TaskList(List<Task> taskList) {
        this.listOfTasks = taskList;
    }

    public Task deleteTask(int index) throws DukeException {
        if (index < 0 || index >= listOfTasks.size()) {
            throw new DukeException("Invalid index");
        }
        return listOfTasks.remove(index - 1);
    }

    public void addTask(Task task) {
        listOfTasks.add(task);
    }

    public Task removeTask(int index){
        return listOfTasks.remove(index);
    }

    public List<Task> getListOfTasks(){
        return listOfTasks;
    }

    public int getSize(){
        return listOfTasks.size();
    }
}
