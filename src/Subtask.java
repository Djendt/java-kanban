public class Subtask extends Task {
    protected Integer epicID;

    public Integer getEpicID() {
        return epicID;
    }

    public Subtask(String name, String description, int epicID) {
        super(name, description);
        this.epicID = epicID;
    }
}
