import java.time.format.DateTimeFormatter;

public class Task {
    protected String description;
    protected boolean isDone;
    protected String type;
    protected final DateTimeFormatter OUT_DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public Task(String description, String done){
        this.description = description;
        if (done.equals("1")) {
            this.isDone = true;
        } else {
            this.isDone = false;
        }
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void setDone() {
        this.isDone = true;
    }

    public String getType(){
        return this.type;
    }

    public String getIsDone(){
        if(isDone){
            return "1";
        }
        else{
            return "0";
        }
    }

    public String getDescription(){
        return this.description;
    }

    @Override
    public String toString() {
        return getStatusIcon() + " " + description;
    }
}