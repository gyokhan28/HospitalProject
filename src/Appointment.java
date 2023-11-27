public class Appointment {
    private final int appointmentId;
    private final int patientId;
    private final String typeOfExamination;
    private String date;
    private final int time;
    private final int doctorId;

    public Appointment(int appointmentId, int patientId, String typeOfExamination, String date, int time, int doctorId) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.typeOfExamination = typeOfExamination;
        this.date = date;
        this.time = time;
        this.doctorId = doctorId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getTypeOfExamination() {
        return typeOfExamination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public int getDoctorId() {
        return doctorId;
    }

    @Override
    public String toString() {
        return "Appointment:" +
                "App. ID:" + appointmentId +
                ", Patient ID:" + patientId +
                ", Examination type:" + typeOfExamination +
                ", Date:" + date +
                ", Time:" + time +
                ", Doctor ID:" + doctorId;
    }


}
