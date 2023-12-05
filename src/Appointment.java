public class Appointment {
    private int appointmentId;
    //private int patientId;
    public Patient patient;
    private String typeOfExamination;
    private String date;
    private int time;
    private int doctorId;

    public Appointment(int appointmentId, Patient patient, String typeOfExamination, String date, int time, int doctorId) {
        setAppointmentId(appointmentId);
        setPatient(patient);
        setTypeOfExamination(typeOfExamination);
        setDate(date);
        setTime(time);
        setDoctorId(doctorId);
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
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
                ", Patient ID:" + patient.getId() +
                ", Examination type:" + typeOfExamination +
                ", Date:" + date +
                ", Time:" + time +
                ", Doctor ID:" + doctorId;
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Appointment)) {
            return false;
        }
        Appointment appointmentRight = (Appointment)obj;
        if(this.appointmentId==appointmentRight.getAppointmentId()&&
       this.patient.getId()==appointmentRight.patient.getId()&&
        this.typeOfExamination.equals(appointmentRight.getTypeOfExamination())&&
        this.date.equals(appointmentRight.getDate())&&
        this.time==appointmentRight.getTime()&&
        this.doctorId==appointmentRight.getDoctorId()){
            return true;
        }else{
            return false;
        }


    }
}