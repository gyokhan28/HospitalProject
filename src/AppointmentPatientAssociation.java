import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AppointmentPatientAssociation {
    private int patientId, appointmentId, time, doctorId;
    private String firstName, lastName, date, typeOfExamination;
    private List<Appointment> appointmentList;
    private List<Patient> patientList;

    public AppointmentPatientAssociation() throws IOException {
        appointmentList = AppointmentsFileManager.loadAppointments("Appointments.csv");
        patientList = PatientFileManager.loadPatients("Patients.csv");
    }


    public List<AppointmentPatientAssociation> appointmentPatientAssociations = new ArrayList<>();

    public AppointmentPatientAssociation(int patientId, int appointmentId, String firstName, String lastName, String typeOfExamination, String date, int time, int doctorId) {
        setPatientId(patientId);
        setAppointmentId(appointmentId);
        setFirstName(firstName);
        setLastName(lastName);
        setTypeOfExamination(typeOfExamination);
        setDate(date);
        setTime(time);
        setDoctorId(doctorId);
    }

    public void combineAllInfo() throws IOException {
        for (Appointment appointment : appointmentList) {
            for (Patient patient : patientList) {
                if (appointment.getPatientId() == patient.getId()) {
                    firstName = patient.getFirstName();
                    lastName = patient.getLastName();
                    appointmentId = appointment.getAppointmentId();
                    typeOfExamination = appointment.getTypeOfExamination();
                    date = appointment.getDate();
                    time = appointment.getTime();
                    doctorId = appointment.getDoctorId();
                    appointmentPatientAssociations.add(new AppointmentPatientAssociation(patient.getId(), appointmentId, firstName, lastName, typeOfExamination, date, time, doctorId));
                }
            }
        }
    }
    public List<AppointmentPatientAssociation> getSortedList(int doctorId) {
        List<AppointmentPatientAssociation> resultList = new ArrayList<>();
        for (AppointmentPatientAssociation a : appointmentPatientAssociations) {
            if (a.getDoctorId() == doctorId) {
                resultList.add(a);
            }
        }
        Comparator<AppointmentPatientAssociation> nameComparator = Comparator.comparing(AppointmentPatientAssociation::getFirstName).thenComparing(AppointmentPatientAssociation::getLastName);
        resultList.sort(nameComparator);
        return resultList;
    }

    @Override
    public String toString() {
        return
                "Patient ID:" + patientId +
                ", App ID:" + appointmentId +
                ", Time:" + time +
                ", First Name:" + firstName +
                ", Last Name:" + lastName +
                ", Date:" + date +
                ", Time:" + time +
                ", Type of ex.:" + typeOfExamination;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTypeOfExamination() {
        return typeOfExamination;
    }

    public void setTypeOfExamination(String typeOfExamination) {
        this.typeOfExamination = typeOfExamination;
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
}
