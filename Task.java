package taskreminder;

public class Task {
    private String title;
    private String dueDate;  // Stores in DD/MM/YYYY format as string
    private boolean completed;

    public Task(String title, String dueDate, boolean completed) {
        this.title = title;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public String getTitle() { return title; }
    public String getDueDate() { return dueDate; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}
