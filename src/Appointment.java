public class Appointment {
    private int appointmentId;
    private int patientId;
    private String typeOfExamination;
    private String date;
    private int time;
    private int doctorId;

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

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getTypeOfExamination() {
        return typeOfExamination;
    }

    public void setTypeOfExamination(String typeOfExamination) {
        this.typeOfExamination = typeOfExamination;
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

    public void setTime(int time) {
        this.time = time;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", patientId=" + patientId +
                ", typeOfExamination='" + typeOfExamination + '\'' +
                ", date='" + date + '\'' +
                ", time=" + time +
                ", doctorId=" + doctorId +
                '}';
    }
}
