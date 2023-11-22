import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class PatientGroup {
    private List<Doctor> doctorList;
    private List<Appointment> appointmentList;
    private List<Patient> patientList;
    public PatientGroup() throws IOException {
        this.doctorList = DoctorFileManager.loadDoctors("Doctors.csv");
        this.appointmentList = AppointmentsFileManager.loadAppointments("Appointments.csv");
        this.patientList = PatientFileManager.loadPatients();
    }
    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    protected void groupPatientsByDoctorName(){
        System.out.println("Showing grouped patients list by doctor name:");
        for (Doctor doctor : doctorList) {
            boolean doctorPrinted = false;
            for (int j = 0; j < appointmentList.size(); j++) {
                if (doctor.getId() == appointmentList.get(j).getDoctorId()) {
                    if(!doctorPrinted) {
                        System.out.println("\nDr." + doctor.getFirstName() + " " + doctor.getLastName() + "'s patient list:");
                    }
                    doctorPrinted = true;
                    for (Patient patient : patientList) {
                        if (patient.getId() == appointmentList.get(j).getPatientId()) {
                            System.out.println(patientList.get(j));
                        }
                    }
                }
            }
        }
    }
}
