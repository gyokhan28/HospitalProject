import java.io.IOException;
import java.util.*;

public class AppointmentSorter {
    private final int personalDoctorId;
    private final List<Doctor> doctorList;
    private final List<Appointment> appointmentList;
    private final List<Patient> patientList;

    public AppointmentSorter(int id, List<Doctor> doctorList) throws IOException {
        appointmentList = AppointmentsFileManager.loadAppointments("Appointments.csv");
        patientList = PatientFileManager.loadPatients("Patients.csv");
        this.doctorList = doctorList;
        this.personalDoctorId = id;
    }

    public void sortChoice() throws IOException {
        System.out.print("Who's patients would you like to sort in alphabetical order? (1-Yours/2-Someone else's): ");
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            choice = sc.next();
            switch (choice) {
                case "1":
                    System.out.println("Showing your sorted appointments: ");
                    printSortedAppointments(personalDoctorId);
                    break;
                case "2":
                    System.out.print("Enter doctor id: ");
                    Scanner idScanner = new Scanner(System.in);
                    int id = idScanner.nextInt();
                    printSortedAppointments(id);
                    break;
                default:
                    System.out.print("Wrong input! Try again: ");
                    sc.next();
            }
        } while (!choice.equals("1") && !choice.equals("2"));
    }

    public List<Appointment> getPatientsById(int id, List<Appointment> appointmentList) {
        List<Appointment> docAppointmentList = new ArrayList<>();
        for (Appointment a : appointmentList) {
            if (a.getDoctorId() == id) {
                docAppointmentList.add(a);
            }
        }
        return docAppointmentList;
    }


    public void printSortedAppointments(int id) throws IOException {
        List<Appointment> docAppointmentList = getPatientsById(id, appointmentList);


    }
}
