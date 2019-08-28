import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest {
    private Storage storage;
    private Ui ui;
    private TaskList listOfTasks;

    @Test
    public void setDoneTest() {
        Task t = new Task("buy book");
        t.setDone();
        assertEquals("1", t.getIsDone());
    }
    @Test
    public void getDescriptionTest() {
        Task t = new Task("buy book");
        assertEquals("buy book", t.getDescription());
    }

    @Test
    public void getTypeTest() {
        Todo t  = new Todo("buy book");
        assertEquals("T", t.getType());
        Event e = new Event("buy book", "bookstore");
        assertEquals("E", e.getType());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
        Deadline d = new Deadline("buy book", LocalDateTime.parse("12/09/2019 1800", dtf));
        assertEquals("D", d.getType());
    }
}