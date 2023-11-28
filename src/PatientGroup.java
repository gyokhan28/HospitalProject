import java.io.IOException;
import java.util.List;

public class PatientGroup {
    private final List<Doctor> doctorList;
    private final List<Appointment> appointmentList;
    private final List<Patient> patientList;

    public PatientGroup() throws IOException {
        this.doctorList = DoctorFileManager.loadDoctors();
        this.appointmentList = AppointmentsFileManager.loadAppointments();
        this.patientList = PatientFileManager.loadPatients();
    }

    protected void groupPatientsByDoctorName() {
        System.out.println("Showing grouped patients list by doctor name:");
        for (Doctor doctor : doctorList) {
            boolean doctorPrinted = false;
            for (int j = 0; j < appointmentList.size(); j++) {
                if (doctor.getId() == appointmentList.get(j).getDoctorId()) {
                    if (!doctorPrinted) {
                        System.out.print("\nDr." + doctor.getFirstName() + " " + doctor.getLastName() + ": ");
                    }
                    doctorPrinted = true;
                    for (Patient patient : patientList) {
                        if (patient.getId() == appointmentList.get(j).getPatientId()) {
                            System.out.print(patientList.get(j) + " ");
                        }
                    }
                }
            }
        }
    }

    protected void groupPatientsBySpeciality() {
        System.out.println("Showing grouped patients by speciality:");
        for (Doctor doctor : doctorList) {
            boolean specialityPrinted = false;
            for (Appointment appointment : appointmentList) {
                if (doctor.getId() == appointment.getDoctorId()) {
                    if (!specialityPrinted) {
                        System.out.println("\n" + doctor.getSpeciality() + ": ");
                    }
                    specialityPrinted = true;
                    for (Patient patient : patientList) {
                        if (appointment.getPatientId() == patient.getId()) {
                            System.out.println(patient.getFirstName() + " " + patient.getLastName() + " " + appointment.getDate() + " " + appointment.getTime());
                        }
                    }
                }
            }
        }
    }
}
