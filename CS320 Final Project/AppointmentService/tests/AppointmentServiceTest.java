/*
Author: David Diaz
SNHU CS320
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AppointmentServiceTest {
    @Test
    public void testAddAppointment() {
        AppointmentService appointmentService = new AppointmentService();
        Appointment appointment = new Appointment("1", new Date(), "Saturday");
        appointmentService.addAppointment(appointment);
        Assert.assertEquals(1, appointmentService.getAppointments().size());
    }

    @Test
    public void testDuplicateAppointmentID() {
        AppointmentService appointmentService = new AppointmentService();
        Appointment appointment1 = new Appointment("1", new Date(), "Saturday");
        appointmentService.addAppointment(appointment1);
        Appointment appointment2 = new Appointment("1", new Date(), "Sunday");
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment(appointment2);
        });
    }

    @Test
    public void testRemoveAppointment() {
        AppointmentService appointmentService = new AppointmentService();
        Appointment appointment = new Appointment("1", new Date(), "Saturday");
        appointmentService.addAppointment(appointment);
        Assert.assertEquals(1, appointmentService.getAppointments().size());
        appointmentService.deleteAppointment("1");
        Assert.assertEquals(0, appointmentService.getAppointments().size());
    }

    @Test
    public void testFindMissingID() {
        AppointmentService appointmentService = new AppointmentService();
        Assert.assertNull(appointmentService.getAppointment("1"));
    }
}
