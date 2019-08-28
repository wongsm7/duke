import java.util.Scanner;

/**
 * Takes care of the Ui.
 */
public class Ui {
    private Scanner scanner;

    /**
     * Constructor for Ui.
     */
    public Ui() {
        scanner = new Scanner(System.in);
    }

    /**
     * Method to read the next line.
     * @return A string representing the next line
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Method to print out a line.
     */
    public void showLine() {
        System.out.println("____________________________________________________________");
    }

    /**
     * Method to display error.
     * @param message which is the error message
     */
    public void showError(String message) {
        System.out.println(message);
    }

    /**
     * Method to display the welcome message.
     */
    public void showWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }

    /**
     * Method to print a message.
     * @param message to be printed
     */
    public void println(String message) {
        System.out.println(message);
    }

    /**
     * Method to print a task.
     * @param task to be printed
     */
    public void println(Task task){
        System.out.println(task);
    }

}