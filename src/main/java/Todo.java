public class Todo extends Task {

    public Todo(String description) {
        super(description);
        this.type = "T";
    }

    public Todo(String description, String done) {
        super(description, done);
        this.type = "T";
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}