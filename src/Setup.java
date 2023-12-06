import java.io.IOException;
import java.util.List;

public class Setup {
    private final List<Doctor>doctorList;
    private final List<Patient>patientList;
    private final List<Appointment>appointmentList;

    public Setup() throws IOException {
        doctorList = DoctorFileManager.loadDoctors();
        patientList = PatientFileManager.loadPatients("Patients.csv");
        appointmentList = AppointmentsFileManager.loadAppointments("Appointments.csv");
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }


    public List<Patient> getPatientList() {
        return patientList;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }


}
