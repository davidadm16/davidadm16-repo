/*
Author: David Diaz
SNHU CS320
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AppointmentTest {
    @Test
    public void testAppointment() {
        Appointment appointment = new Appointment("1", new Date(), "Saturday");
        Assert.assertEquals("1", appointment.getAppointmentID());
        Assert.assertEquals(new Date(), appointment.getDate());
        Assert.assertEquals("Saturday", appointment.getDescription());
    }

    @Test
    public void testAppointmentIDTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678910", new Date(), "Saturday");
        });
    }

    @Test
    public void testAppointmentDateBeforeToday() {
        assertThrows(IllegalArgumentException.class, () -> {
            long MILLIS_IN_A_DAY = 1000L * 60 * 60 * 24;
            // Calculate yesterday's time in milliseconds
            long yesterdayMillis = new Date().getTime() - MILLIS_IN_A_DAY;
            // Create a Date object for yesterday
            Date yesterday = new Date(yesterdayMillis);

            Appointment appointment = new Appointment("1", yesterday, "Saturday");
        });
    }

    @Test
    public void testAppointmentDescriptionTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1", new Date(), "Saturday is the best day of the week and is much better than Sunday");
        });
    }

    @Test
    public void testAppointmentNullID() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, new Date(), "Saturday");
        });
    }

    @Test
    public void testAppointmentNullDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1", null, "Saturday");
        });
    }

    @Test
    public void testAppointmentNullDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1", new Date(), null);
        });
    }
}
