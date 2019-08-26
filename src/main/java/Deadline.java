import java.time.LocalDateTime;

public class Deadline extends Task {

    protected LocalDateTime by;

    public Deadline(String description, LocalDateTime by) {
        super(description);
        this.by = by;
        this.type = "D";
    }

    public Deadline(String description, String done, LocalDateTime by){
        super(description, done);
        this.by = by;
        this.type = "D";
    }

    public String getBy(){
        return by.format(OUT_DTF);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.format(OUT_DTF) + ")";
    }
}