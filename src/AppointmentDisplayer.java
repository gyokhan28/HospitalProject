import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AppointmentDisplayer {
    private final int personalDoctorId;
    private List<Doctor> doctorList;
    private final List<Appointment> appointmentList;
    private final List<Patient> patientList;

    public AppointmentDisplayer(int id, List<Doctor> doctorList) throws IOException {
        AppointmentsFileManager appointmentsFileManager = new AppointmentsFileManager();
        PatientFileManager patientFileManager = new PatientFileManager();
        appointmentList = appointmentsFileManager.loadAppointments("Appointments.csv");
        patientList = patientFileManager.loadPatients("Patients.csv");
        this.doctorList = doctorList;
        this.personalDoctorId = id;
    }

    public void loadAppointmentsForSelectedDoctor() {
        System.out.print("Who's appointments would you like to see? (1-Yours/2-Someone else's):");
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            choice = sc.next();
            switch (choice) {
                case "1":
                    System.out.println("Showing your appointments:");
                    showAppointments(personalDoctorId);
                    break;
                case "2":
                    System.out.println("Enter doctor id:");
                    Scanner idScanner = new Scanner(System.in);
                    int id = idScanner.nextInt();
                    showAppointments(id);
                default:
                    System.out.print("Wrong input! Try again:");
                    sc.next();
            }
        } while (!choice.equals("1") && !choice.equals("2"));
    }

    public void showAppointments(int id) {
        boolean isFound = false;
        for (Appointment a : appointmentList) {
            if (id == a.getDoctorId()) {
                isFound = true;
                String patientFirstName = "", patientLastName = "";
                for (Patient p : patientList) {
                    if (a.getPatientId() == p.getId()) {
                        patientFirstName = p.getFirstName();
                        patientLastName = p.getLastName();
                    }
                }
                System.out.println("App. ID:" + a.getAppointmentId() + ". Patient:" + patientFirstName + " " +
                        patientLastName + " Ex. type:" + a.getTypeOfExamination() + " Date:" +
                        a.getDate() + " Time:" + a.getTime());
            }
        }
        if (!isFound) {
            System.out.print("There is no doctor associated with this ID! Try again: ");
            Scanner sc = new Scanner(System.in);
            int newId = sc.nextInt();
            showAppointments(newId);
        }
    }
}
