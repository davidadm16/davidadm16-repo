import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class TaskService {
    private Map<String, Task> tasks;

    public TaskService() {
        tasks = new HashMap<>();
    }

    // The getTask() method to retrieve the contact.
    public Task getTask(String taskID) {
        return tasks.get(taskID);
    }

    // The addTask() method to add a new task
    public void addTask(Task newTask) {
        String id = newTask.getTaskID();

        if (tasks.containsKey(id)) {
            throw new IllegalArgumentException("Task ID must be unique.");
        }

        tasks.put(id, newTask);
    }

    // The deleteTask() method to delete a task
    public void deleteTask(String taskID) {
        if (tasks.remove(taskID) == null) {
            throw new IllegalArgumentException("Task ID not found.");
        }
    }

    // Generic updateTask() method used to simplify other update methods
    private void updateTask(String taskID, Consumer<Task> updater) {
        Task task = tasks.get(taskID);

        if (task == null) {
            throw new IllegalArgumentException("Task ID not found.");
        }

        updater.accept(task);
    }

    // The updateName() method to update the name if the task exists
    public void updateName(String taskID, String newName) {
        updateTask(taskID, t -> t.setName(newName));
    }

    // The updateLastName() method to update the description if the task exists
    public void updateDescription(String taskID, String newDescription) {
        updateTask(taskID, t -> t.setDescription(newDescription));
    }

    // The getTasks() method returns the list of tasks.
    public List<Task> getTasks() {
        return new ArrayList<>(tasks.values());
    }
}
