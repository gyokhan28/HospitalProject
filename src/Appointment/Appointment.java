package Appointment;

import Doctor.Doctor;
import Patient.Patient;

public class Appointment {
    private int appointmentId;
    public Patient patient;
    private String typeOfExamination;
    private String date;
    private int time;
    private Doctor doctor;

    public Appointment(int appointmentId, Patient patient, String typeOfExamination, String date, int time, Doctor doctor) {
        setAppointmentId(appointmentId);
        setPatient(patient);
        setTypeOfExamination(typeOfExamination);
        setDate(date);
        setTime(time);
        setDoctor(doctor);
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

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Appointment:" +
                "App. ID:" + appointmentId +
                ", Patient ID:" + patient.getId() +
                ", Examination type:" + typeOfExamination +
                ", Date:" + date +
                ", Time: " + time/100 + ":" +time%100 +
                ", Doctor ID:" + doctor.getId();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Appointment)) {
            return false;
        }
        Appointment appointmentRight = (Appointment) obj;
        if (this.appointmentId == appointmentRight.getAppointmentId() &&
                this.patient.getId() == appointmentRight.patient.getId() &&
                this.typeOfExamination.equals(appointmentRight.getTypeOfExamination()) &&
                this.date.equals(appointmentRight.getDate()) &&
                this.time == appointmentRight.getTime() &&
                this.doctor.getId() == appointmentRight.doctor.getId()) {
            return true;
        } else {
            return false;
        }


    }
}