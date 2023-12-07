import java.io.IOException;
import java.util.List;

public abstract class Setup {
    private static List<Doctor> doctorList;
    private static List<Patient> patientList;
    private static List<Appointment> appointmentList;

    public static void loadLists() throws IOException {
        doctorList = DoctorFileManager.loadDoctors();
        patientList = PatientFileManager.loadPatients("Patients.csv");
        appointmentList = AppointmentsFileManager.loadAppointments("Appointments.csv");
    }

    public static List<Doctor> getDoctorList() {
        return doctorList;
    }


    public static List<Patient> getPatientList() {
        return patientList;
    }

    public static List<Appointment> getAppointmentList() {
        return appointmentList;
    }


}
