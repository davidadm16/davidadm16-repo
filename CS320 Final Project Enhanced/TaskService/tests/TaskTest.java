import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TaskTest {
    @Test
    public void testTask() {
        Task task = new Task("1", "Doctor", "Visit the doctor");
        Assert.assertEquals("1", task.getTaskID());
        Assert.assertEquals("Doctor", task.getName());
    }

    @Test
    public void testTaskIDTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678910", "Doctor", "Visit the doctor");
        });
    }

    @Test
    public void testNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1", "DoctorTestingLengthTooLong", "Visit the doctor");
        });
    }

    @Test
    public void testDescriptionTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1", "Doctor", "Visit the doctor, This is to add length for the description");
        });
    }

    @Test
    public void testNameChange() {
        Task task = new Task("1", "Doctor", "Visit the doctor");
        Assert.assertEquals("Doctor", task.getName());
        task.setName("Hospital");
        Assert.assertEquals("Hospital", task.getName());
    }

    @Test
    public void testDescriptionChange() {
        Task task = new Task("1", "Doctor", "Visit the doctor");
        Assert.assertEquals("Visit the doctor", task.getDescription());
        task.setDescription("Visit the hospital");
        Assert.assertEquals("Visit the hospital", task.getDescription());
    }

    @Test
    public void testInvalidNameChange() {
        Task task = new Task("1", "Doctor", "Visit the doctor");
        Assert.assertEquals("Doctor", task.getName());
        assertThrows(IllegalArgumentException.class, () -> {
            task.setName(null);
        });
    }

    @Test
    public void testInvalidDescriptionChange() {
        Task task = new Task("1", "Doctor", "Visit the doctor");
        Assert.assertEquals("Visit the doctor", task.getDescription());
        assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription(null);
        });
    }
}
