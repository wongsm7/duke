import java.util.Arrays;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public Task(String[] arr) {
        this.isDone = false;
        this.description = Arrays.toString(arr);
        this.description = this.description.substring(1, this.description.length()-1).replaceAll(",", "");
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void setDone() {
        this.isDone = true;
    }

    @Override
    public String toString() {
        return getStatusIcon() + " " + description;
    }
}