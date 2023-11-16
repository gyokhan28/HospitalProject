import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class DoctorMenu {
    private int id;
    private String firstName, lastName;
    private List<Doctor> doctorList;
    private AppointmentDisplayer appointmentDisplayer;
    private AppointmentSorter appointmentSorter;

    public DoctorMenu(int id, String firstName, String lastName, List<Doctor> doctorList) throws IOException {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.doctorList = doctorList;
        appointmentDisplayer = new AppointmentDisplayer(id, doctorList);
        appointmentSorter = new AppointmentSorter(id, doctorList, firstName, lastName);
        System.out.println("\nLogged in as " + firstName + " " + lastName + "!");
    }

    public void showMenu() throws IOException {
        System.out.println("\n1.Show reserved appointments for medical examination");
        System.out.println("2.Sort reserved examinations");
        System.out.println("3.Group patients\n");
        selectMenuOption();
    }

    public void selectMenuOption() throws IOException {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        System.out.print("Enter your choice: ");
        do {
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    appointmentDisplayer.loadAppointmentsForSelectedDoctor();
                    showMenu();
                    break;
                case 2:
                    appointmentSorter.sortChoice();
                    break;
                case 3:
                    System.out.println("3.Group");
                    break;
                default:
                    System.out.print("Wrong input! Try again: ");
            }
        } while (choice != 1 && choice != 2 && choice != 3);
    }
}
