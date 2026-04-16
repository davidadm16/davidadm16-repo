/*
Author: David Diaz
SNHU CS320
 */

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TaskServiceTest {
    @Test
    public void testAddTask() {
        TaskService taskService = new TaskService();
        Task task = new Task("1", "Doctor", "Visit the doctor");
        taskService.addTask(task);
        Assert.assertEquals(1, taskService.getTasks().size());
    }

    @Test
    public void testDuplicateTaskID() {
        TaskService taskService = new TaskService();
        Task task1 = new Task("1", "Doctor", "Visit the doctor");
        taskService.addTask(task1);
        Task task2 = new Task("1", "Dog", "Walk the dog");
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask(task2);
        });
    }

    @Test
    public void testRemoveTask() {
        TaskService taskService = new TaskService();
        Task task = new Task("1", "Doctor", "Visit the doctor");
        taskService.addTask(task);
        Assert.assertEquals(1, taskService.getTasks().size());
        taskService.deleteTask("1");
        Assert.assertEquals(0, taskService.getTasks().size());
    }

    @Test
    public void testUpdateTask() {
        TaskService taskService = new TaskService();
        Task task = new Task("1", "Doctor", "Visit the doctor");
        taskService.addTask(task);
        Assert.assertEquals("Doctor", task.getName());
        Assert.assertEquals("Visit the doctor", task.getDescription());
        taskService.updateName("1", "Dog");
        taskService.updateDescription("1", "Walk the dog");
        Assert.assertEquals("Dog", task.getName());
        Assert.assertEquals("Walk the dog", task.getDescription());
    }

    @Test
    public void testFindMissingID() {
        TaskService taskService = new TaskService();
        Assert.assertNull(taskService.getTask("1"));
    }
}
