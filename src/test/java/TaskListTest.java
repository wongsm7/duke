import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskListTest {
    private Storage storage;
    private Ui ui;
    private TaskList listOfTasks;

    @Test
    public void addTaskTest() {
        listOfTasks = new TaskList();
        listOfTasks.addTask(new Todo("todo buy bread"));
        assertEquals("todo buy bread", listOfTasks.getListOfTasks().get(0).getDescription());
        assertEquals(1, listOfTasks.getSize());
    }

    @Test
    public void removeTaskTest() throws DukeException {
        listOfTasks = new TaskList();
        listOfTasks.addTask(new Todo("todo buy bread"));
        listOfTasks.addTask(new Todo("todo buy butter"));
        listOfTasks.removeTask(1);
        assertEquals(1, listOfTasks.getSize());
        assertEquals("todo buy bread", listOfTasks.getListOfTasks().get(0).getDescription());
    }
}