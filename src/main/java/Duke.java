import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Duke {
    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            try {
                List<Task> listOfTasks = importTask();
                String[] temp = sc.nextLine().split(" ");
                if (temp[0].equals("bye")) {
                    if (temp.length > 1) {
                        throw new DukeException("I'm sorry, but I don't know what that means :-(");
                    }
                    System.out.println("Bye. Hope to see you again soon!");
                    break;
                } else if (temp[0].equals("list")) {
                    int count = 1;
                    for (Task t : listOfTasks) {
                        System.out.println(count + ". " + t);
                        count++;
                    }
                } else if (temp[0].equals("done")) {
                    if (temp.length < 2) {
                        throw new DukeException("No task number entered");
                    }
                    int index = Integer.parseInt(temp[1]) - 1;
                    if (index < 0 || index > listOfTasks.size() - 1) {
                        throw new DukeException("Invalid task number");
                    }
                    listOfTasks.get(index).setDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(listOfTasks.get(index));
                    writeToFile(listOfTasks);
                } else if (temp[0].equals("todo")) {
                    if (temp.length < 2) {
                        throw new DukeException("The description of a todo cannot be empty.");
                    }
                    String temp2 = "";
                    for (int i = 1; i < temp.length; i++) {
                        temp2 = temp2 + temp[i] + " ";
                    }
                    Todo t = new Todo(temp2);
                    listOfTasks.add(t);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(t);
                    System.out.println("Now you have " + listOfTasks.size() + " tasks in the list.");
                    writeToFile(listOfTasks);
                } else if (temp[0].equals("event")) {
                    if (temp.length < 2) {
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
                    Event e = new Event(temp2, time);
                    listOfTasks.add(e);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(e);
                    System.out.println("Now you have " + listOfTasks.size() + " tasks in the list.");
                    writeToFile(listOfTasks);
                } else if (temp[0].equals("deadline")) {
                    if (temp.length < 2) {
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
                    LocalDateTime dateTime = LocalDateTime.parse(time.trim(), dtf);
                    Deadline d = new Deadline(temp2, dateTime);
                    listOfTasks.add(d);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(d);
                    System.out.println("Now you have " + listOfTasks.size() + " tasks in the list.");
                    writeToFile(listOfTasks);
                } else if (temp[0].equals("delete")) {
                    if (temp.length < 2) {
                        throw new DukeException("No index entered");
                    }
                    int index = Integer.parseInt(temp[1]) - 1;
                    if (index < 0 || index >= listOfTasks.size()) {
                        throw new DukeException("Invalid index");
                    }
                    Task removed = listOfTasks.remove(index);
                    System.out.println("Noted. I've removed this task:");
                    System.out.println(removed);
                    System.out.println("Now you have " + listOfTasks.size() + " tasks in the list.");
                    writeToFile(listOfTasks);
                } else {
                    throw new DukeException("I'm sorry, but I don't know what that means :-(");
                }
            } catch (DukeException de) {
                System.out.println(de);
            } catch (IOException ie) {
                System.out.println("IOException");
            } catch (DateTimeParseException dtpe) {
                System.out.println("Please enter deadline in dd/mm/yyyy HHmm format");
            }
        }
    }

    public static List<Task> importTask() throws FileNotFoundException{
        List<Task> tempList = new ArrayList<>();
        File file = new File("D:\\CS2103T\\duke\\docs\\duke.txt");
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String[] token = fileScanner.nextLine().split("\\|");
                if (token.length <= 2) {
                    throw new DukeException("Invalid line");
                }
                if(token[0].equals("T")){
                    tempList.add(new Todo(token[2], token[1]));
                } else if(token[0].equals("D")) {
                    tempList.add(new Deadline(token[2], token[1], LocalDateTime.parse(token[3], dtf)));
                } else if(token[0].equals("E")){
                    tempList.add(new Event(token[2], token[1], token[3]));
                } else{
                    throw new DukeException("Invalid task type");
                }
            }
            return tempList;
        }
        catch(DukeException de){
            System.out.println(de.getMessage());
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        return tempList;
    }

    public static void writeToFile(List<Task> tasks) throws IOException, FileNotFoundException {
        File file = new File("D:\\CS2103T\\duke\\docs\\duke.txt");
        PrintWriter pw = new PrintWriter(file);
        String output = "";
        for (Task t : tasks) {
            if (t.getType().equals("T")) {
                output += t.getType() + "|" + t.getIsDone() + "|" + t.getDescription() + "\n";
            } else if (t.getType().equals("E")) {
                output += t.getType() + "|" + t.getIsDone() + "|" + t.getDescription() + "|"
                        + ((Event) t).getAt() + "\n";
            } else if (t.getType().equals("D")) {
                output += t.getType() + "|" + t.getIsDone() + "|" + t.getDescription() + "|"
                           + ((Deadline) t).getBy() + "\n";
            }
        }
        pw.write(output);
        pw.close();
    }
}
