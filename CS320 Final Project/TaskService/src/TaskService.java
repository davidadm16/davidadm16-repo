/*
Author: David Diaz
SNHU CS320
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TaskService {
    private List<Task> tasks;

    public TaskService() {
        tasks = new ArrayList<>();
    }

    // The getTask() method to retrieve the contact.
    public Task getTask(String taskID)
    {
        for(Task task : tasks) {
            if (Objects.equals(task.getTaskID(), taskID)) {
                return task;
            }
        }
        return null;
    }

    // The addTask() method to add a new task
    public void addTask(Task newTask)
    {
        //Search for matching taskID to verify if taskID is already set to an existing task
        Task foundTask = getTask(newTask.getTaskID());

        //If a matching task is found then it means that the task ID has already been set
        if(foundTask != null) {
            throw new IllegalArgumentException("Task ID must be unique.");
        }

        //If no match was found than it can be added with no issues.
        tasks.add(newTask);
    }

    // The deleteTask() method to delete a task
    public void deleteTask(String taskID)
    {
        Task task = getTask(taskID);
        //Throw the exception if it does not exist.
        if (task == null) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        else {
            // Otherwise, remove the contact from the contacts.
            tasks.remove(task);
        }
    }

    // The updateName() method to update the name if the task exists
    public void updateName(String taskID, String newName)
    {
        // Get the task by using the task ID.
        Task task = getTask(taskID);

        // If the task is null, throw an error
        if (task == null)
        {
            throw new IllegalArgumentException("Task ID not found.");
        }

            task.setName(newName);
    }

    // The updateLastName() method to update the description if the task exists
    public void updateDescription(String taskID, String description)
    {
        // Get the contact by using the contact ID.
        Task task = getTask(taskID);

        // If the task is null, throw an error
        if (task == null)
        {
            throw new IllegalArgumentException("Task ID not found.");
        }

        task.setDescription(description);
    }

    // The getTasks() method returns the list of tasks.
    public List<Task> getTasks()
    {
        return tasks;
    }
}
