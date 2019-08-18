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
        List<String> listOfStrings = new ArrayList<>();
        while(sc.hasNext()) {
            String temp = sc.nextLine();
            if(temp.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }
            else if(temp.equals("list")) {
                int count = 1;
                for(String s : listOfStrings) {
                    System.out.println(count + ". " + s);
                    count++;
                }
            }
            else {
                System.out.println("added: " + temp);
                listOfStrings.add(temp);
            }
        }
    }
}
