public class Task {
    private final String taskID;
    private String name;
    private String description;

    public Task(String taskID, String name, String description) {
        if (taskID == null || taskID.length() > 10) {
            throw new IllegalArgumentException("Task ID must be non-null and no longer than 10 characters");
        }
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name must be non-null and no longer than 20 characters");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must be non-null and no longer than 50 characters");
        }

        this.taskID = taskID;
        this.name = name;
        this.description = description;
    }

    public String getTaskID() { return taskID; }

    public String getName() { return name; }

    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }
}