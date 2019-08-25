public class Event extends Task {

    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
        this.type = "E";
    }

    public Event(String description, String done, String at){
        super(description, done);
        this.at = at;
        this.type = "E";
    }

    public String getAt(){
        return this.at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}