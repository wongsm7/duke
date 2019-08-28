import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DukeTest {
    private Storage storage;
    private Ui ui;
    private TaskList listOfTasks;

    @Test
    public void TaskListTest() throws DukeException {
        listOfTasks = new TaskList();
        listOfTasks.addTask(new Todo("todo buy bread"));
        assertEquals("todo buy bread", listOfTasks.getListOfTasks().get(0).getDescription());
        listOfTasks.removeTask(0);
        assertEquals(0, listOfTasks.getSize());
    }

    @Test
    public void UiTest(){
        ui = new Ui();
        ui.showWelcome();
        ui.showLine();
    }

    @Test
    public void ExitTest() {
        Command c = new ExitCommand();
        assertEquals(true, c.isExit());
    }

}