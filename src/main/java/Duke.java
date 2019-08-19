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
            String[] temp = sc.nextLine().split(" ");
            if(temp[0].equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }
            else if(temp[0].equals("list")) {
                int count = 1;
                for(Task t : listOfTasks) {
                    System.out.println(count + ". " + t);
                    count++;
                }
            }
            else if(temp[0].equals("done")) {
                listOfTasks.get(Integer.valueOf(temp[1]) - 1).setDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(listOfTasks.get(Integer.valueOf(temp[1]) - 1));
            }
            else {
                String temp2 = Arrays.toString(temp);
                temp2 = temp2.substring(1, temp2.length()-1).replaceAll(",", "");
                System.out.println("added: " + String.join(",", temp2));
                listOfTasks.add(new Task(temp));
            }
        }
    }
}
