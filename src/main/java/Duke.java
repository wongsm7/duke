import java.io.IOException;

/**
 * A program that keeps track of a person's tasks.
 */
public class Duke {
    private Storage storage;
    private TaskList listOfTasks;
    private Ui ui;

    /**
     * Constructor for Duke.
     * @param filePath a String representing the file path
     */
    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        listOfTasks = new TaskList(storage.load());
    }

    /**
     * Method to run the program.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine(); // show the divider line ("_______")
                Command c = Parser.parse(fullCommand);
                c.execute(listOfTasks, ui, storage);
                isExit = c.isExit();
            } catch (DukeException | IOException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    /**
     * Main method.
     */
    public static void main(String[] args) {
        new Duke("D:\\CS2103T\\duke\\docs\\duke.txt").run();
    }
}