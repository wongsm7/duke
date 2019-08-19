import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Duke {
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
        List<Task> listOfTasks = new ArrayList<>();
        while(sc.hasNext()) {
            try {
                String[] temp = sc.nextLine().split(" ");
                if (temp[0].equals("bye")) {
                    if(temp.length > 1) {
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
                    if(temp.length < 2) {
                        throw new DukeException("No task number entered");
                    }
                    int index = Integer.parseInt(temp[1]) - 1;
                    if(index < 0 || index > listOfTasks.size() - 1){
                        throw new DukeException("Invalid task number");
                    }
                    listOfTasks.get(index).setDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(listOfTasks.get(index));
                } else if (temp[0].equals("todo")) {
                    if(temp.length < 2) {
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
                } else if (temp[0].equals("event")) {
                    if(temp.length < 2) {
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
                } else if (temp[0].equals("deadline")) {
                    if(temp.length < 2) {
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
                    Deadline d = new Deadline(temp2, time);
                    listOfTasks.add(d);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(d);
                    System.out.println("Now you have " + listOfTasks.size() + " tasks in the list.");
                } else if(temp[0].equals("delete")) {
                    if(temp.length < 2) {
                        throw new DukeException("No index entered");
                    }
                    int index = Integer.parseInt(temp[1]) - 1;
                    if(index < 0 || index >= listOfTasks.size()){
                        throw new DukeException("Invalid index");
                    }
                    Task removed = listOfTasks.remove(index);
                    System.out.println("Noted. I've removed this task:");
                    System.out.println(removed);
                    System.out.println("Now you have " + listOfTasks.size() + " tasks in the list.");
                }
                else {
                    throw new DukeException("I'm sorry, but I don't know what that means :-(");
                }
            }
            catch(DukeException e){
                System.out.println(e);
            }
        }
    }
}
