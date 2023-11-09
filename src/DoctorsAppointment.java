import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorsAppointment {
    private int appointmentId;
    private int patientId;
    private String typeOfExamination;
    private String date;
    private int time;
    private int doctorID;
    protected List<DoctorsAppointment> doctorsAppointments;
    protected List<Doctor> doctorList;
    AppointmentFileManager appointmentFileManager;

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientDd(int patientDd) {
        this.patientId = patientDd;
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

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public DoctorsAppointment(int patientId) {
        this.doctorsAppointments = new ArrayList<>();
        this.doctorList = new ArrayList<>();
        addNewHour(patientId);
    }

    public DoctorsAppointment(int appointmentId, int patientId, String typeOfExamination, String date, int time, int doctorID) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.typeOfExamination = typeOfExamination;
        this.date = date;
        this.time = time;
        this.doctorID = doctorID;
        this.doctorsAppointments = new ArrayList<>();
        this.doctorList = new ArrayList<>();
    }
    public void createDoctorsAppointment() throws IOException {
        appointmentFileManager = new AppointmentFileManager();
        doctorsAppointments = appointmentFileManager.loadAppointmentList("Appointments copy.csv");
    }


    public void addNewHour(int IDPatient) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Appointments copy.csv",true))) {

                bw.write(returnLastID()+1+";" + IDPatient + ";" + returnTypeOfExamination() + ";" + returnDoctorID(doctorList) + ";" + returnDoctorID(doctorList));
                bw.newLine();

            System.out.println("File is updated!");
        } catch (IOException e) {
            System.err.println("Error writing in file: " + e.getMessage());
        }

    }

    public String returnTypeOfExamination() {
        System.out.println("Please select the type of doctor's examination: ");
        System.out.println("1. Initial.");
        System.out.println("2. Secondary");
        System.out.println("3. Consultation");
        System.out.println("4. Procedure");
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    return "Initial";
                }
                case 2 -> {

                    return "Secondary";
                }
                case 3 -> {
                    return "Consultation";
                }
                case 4 -> {
                    return "Procedure";
                }
                default -> System.out.print("Wrong input! Try again: ");
            }
        } while (true);
    }

    public int returnDoctorID(List<Doctor> doctorList) {
        System.out.print("Please enter the name of the doctor you wish to see: ");
        Scanner sc = new Scanner(System.in);
        String doctorName = sc.next();
        // doctors=doctorList;
        for (Doctor doctor : doctorList) {
            if (doctorName.equalsIgnoreCase(doctor.getFirstName())) {
                return doctor.getId();
            }
        }
        System.out.println("There is no doctor with that name. Please, try again");
        returnDoctorID(doctorList);
        return -1;
    }
    public int returnLastID() throws IOException {
        createDoctorsAppointment();
        return doctorsAppointments.get(doctorsAppointments.size()-1).getAppointmentId();
    }
}
