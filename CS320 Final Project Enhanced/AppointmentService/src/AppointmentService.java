import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private Map<String, Appointment> appointments;

    public AppointmentService() {
        appointments = new HashMap<>();
    }

    // The getAppointment() method to retrieve the appointment.
    public Appointment getAppointment(String appointmentID) {
        return appointments.get(appointmentID);
    }

    // The addAppointment() method to add a new appointment
    public void addAppointment(Appointment newAppointment) {
        String id = newAppointment.getAppointmentID();

        // Check if ID already exists
        if (appointments.containsKey(id)) {
            throw new IllegalArgumentException("Appointment ID must be unique.");
        }

        appointments.put(id, newAppointment);
    }

    // The deleteAppointment() method to delete an appointment
    public void deleteAppointment(String appointmentID) {
        if (!appointments.containsKey(appointmentID)) {
            throw new IllegalArgumentException("Appointment ID not found.");
        }

        appointments.remove(appointmentID);
    }

    // The getAppointments() method returns the list of appointments.
    public List<Appointment> getAppointments() {
        return new ArrayList<>(appointments.values());
    }
}
