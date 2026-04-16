/*
Author: David Diaz
SNHU CS320
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AppointmentService {
    private List<Appointment> appointments;

    public AppointmentService() {
        appointments = new ArrayList<>();
    }

    // The getAppointment() method to retrieve the appointment.
    public Appointment getAppointment(String appointmentID)
    {
        for(Appointment appointment : appointments) {
            if (Objects.equals(appointment.getAppointmentID(), appointmentID)) {
                return appointment;
            }
        }
        return null;
    }

    // The addAppointment() method to add a new appointment
    public void addAppointment(Appointment newAppointment)
    {
        //Search for matching appointmentID to verify if appointmentID is already set to an existing appointment
        Appointment foundAppointment = getAppointment(newAppointment.getAppointmentID());

        //If a matching task is found then it means that the task ID has already been set
        if(foundAppointment != null) {
            throw new IllegalArgumentException("Appointment ID must be unique.");
        }

        //If no match was found than it can be added with no issues.
        appointments.add(newAppointment);
    }

    // The deleteAppointment() method to delete an appointment
    public void deleteAppointment(String appointmentID)
    {
        Appointment appointment = getAppointment(appointmentID);
        //Throw the exception if it does not exist.
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment ID not found.");
        }
        else {
            // Otherwise, remove the appointment from the appointments.
            appointments.remove(appointment);
        }
    }

    // The getAppointments() method returns the list of appointments.
    public List<Appointment> getAppointments()
    {
        return appointments;
    }
}
