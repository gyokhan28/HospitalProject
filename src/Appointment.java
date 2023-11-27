public class Appointment {
    private int appointmentId;
    private int patientId;
    private String typeOfExamination;
    private String date;
    private int time;
    private int doctorId;

    public Appointment(int appointmentId, int patientId, String typeOfExamination, String date, int time, int doctorId) {
        setAppointmentId(appointmentId);
        setPatientId(patientId);
        setTypeOfExamination(typeOfExamination);
        setDate(date);
        setTime(time);
        setDoctorId(doctorId);
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
        return "Appointment:" +
                "App. ID:" + appointmentId +
                ", Patient ID:" + patientId +
                ", Examination type:" + typeOfExamination +
                ", Date:" + date +
                ", Time:" + time +
                ", Doctor ID:" + doctorId;
    }


}