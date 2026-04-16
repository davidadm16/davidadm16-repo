import java.util.Date;

public class Appointment {
    private final String appointmentID;
    private Date appointmentDate;
    private String description;

    public Appointment(String appointmentID, Date appointmentDate, String description) {
        if (appointmentID == null || appointmentID.length() > 10) {
            throw new IllegalArgumentException("Appointment ID must be non-null and no longer than 10 characters");
        }
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Date must be non-null and cannot be before today");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must be non-null and no longer than 50 characters");
        }

        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    public String getAppointmentID() { return appointmentID; }

    public Date getDate() { return appointmentDate; }

    public String getDescription() { return description; }
}
