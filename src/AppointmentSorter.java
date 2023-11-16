import java.io.IOException;
import java.util.*;

public class AppointmentSorter {
    private final int personalDoctorId;
    private final List<Doctor> doctorList;
    private final List<Appointment> appointmentList;
    private final List<Patient> patientList;
    private Scanner sc;

    public AppointmentSorter(int id, List<Doctor> doctorList) throws IOException {
        appointmentList = AppointmentsFileManager.loadAppointments("Appointments.csv");
        patientList = PatientFileManager.loadPatients("Patients.csv");
        this.doctorList = doctorList;
        this.personalDoctorId = id;
    }

    public void sortChoice() throws IOException {
        System.out.println("==== Sorting Menu ==== ");
        System.out.print("1.Ascending/2.Descending order:");
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            choice = sc.next();
            switch (choice) {
                case "1":
                    System.out.println("\n1.Sort by patient name");
                    System.out.println("2.Sort by appointment hour");
                    System.out.println("3.Sort by patient ID");
                    System.out.print("\nEnter your choice:");
                    handleMenuChoice(sc.next());
                    break;
                case "2":
                    //////////////////
                default:
                    System.out.print("Wrong input! Try again: ");
                    sc.nextLine();
            }
        } while (!choice.equals("1") && !choice.equals("2"));
    }

    public void handleMenuChoice(String choice) throws IOException {
        sc = new Scanner(System.in);
        do {
            switch (choice) {
                case "1":
                    System.out.print("Enter ID:");
                    String id = sc.nextLine();
                    if (id.isEmpty()) {
                        printSortedAppointments(personalDoctorId);
                    } else {
                        System.out.println("Sorting by patient name:");
                        printSortedAppointments(Integer.parseInt(id));
                    }
                    break;
                case "2":

                default:
                    System.out.print("Wrong input! Try again: ");
                    sc.nextLine();
            }
        } while (!choice.equals("1") && !choice.equals("2"));
    }

    public void printSortedAppointments(int id) throws IOException {
        AppointmentPatientAssociation apa = new AppointmentPatientAssociation();
        apa.combineAllInfo();
        List<AppointmentPatientAssociation> sorted = apa.getSortedList(id);
        for (AppointmentPatientAssociation appointmentPatientAssociation : sorted) {
            System.out.println(appointmentPatientAssociation);
        }
    }
}
