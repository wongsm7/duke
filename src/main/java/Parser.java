import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Parser {
    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");

    public static Command parse(String input) throws DukeException {
        String[] temp = input.split(" ");
        if (temp[0].equals("todo")) {
            if (temp.length < 2) {
                throw new DukeException("The description of a todo cannot be empty.");
            }
            String temp2 = "";
            for (int i = 1; i < temp.length; i++) {
                temp2 = temp2 + temp[i] + " ";
            }
            return new AddCommand(new Todo(temp2));
        } else if (temp[0].equals("event")) {
            if (temp.length <= 2) {
                throw new DukeException("The description of a event cannot be empty.");
            }
            String temp2 = "";
            String time = "";
            int index = 0;
            for (int i = 1; i < temp.length; i++) {
                if (temp[i].equals("/at")) {
                    index = i + 1;
                    break;
                } else {
                    temp2 = temp2 + temp[i] + " ";
                }
            }
            for (int j = index; j < temp.length; j++) {
                time = time + temp[j] + " ";
            }
            return new AddCommand(new Event(temp2, time));
        } else if (temp[0].equals("deadline")) {
            if (temp.length <= 2) {
                throw new DukeException("The description of a deadline cannot be empty.");
            }
            String temp2 = "";
            String time = "";
            int index = 0;
            for (int i = 1; i < temp.length; i++) {
                if (temp[i].equals("/by")) {
                    index = i + 1;
                    break;
                } else {
                    temp2 = temp2 + temp[i] + " ";
                }
            }
            for (int j = index; j < temp.length; j++) {
                time = time + temp[j] + " ";
            }
            LocalDateTime dateTime = null;
            try {
                dateTime = LocalDateTime.parse(time.trim(), dtf);
            } catch (DateTimeParseException e){
                throw new DukeException("Please enter deadline in dd/mm/yyyy HHmm format");
            }
           return new AddCommand(new Deadline(temp2, dateTime));
        } else if (temp[0].equals("bye")) {
            return new ExitCommand();
        } else if (temp[0].equals("done")) {
            return new DoneCommand(Integer.parseInt(temp[1]) - 1);
        } else if (temp[0].equals("list")) {
            return new ListCommand();
        } else if (temp[0].equals("delete")) {
            return new DeleteCommand(Integer.parseInt(temp[1]) - 1);
        } else {
            throw new DukeException("I'm sorry, but I don't know what that means :-(");
        }
    }
}

