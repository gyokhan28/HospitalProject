import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class DoctorMenu {
    private AppointmentDisplayer appointmentDisplayer;
    private AppointmentSorter appointmentSorter;

    public DoctorMenu(int id, String firstName, String lastName, List<Doctor> doctorList) throws IOException {
        appointmentDisplayer = new AppointmentDisplayer(id, doctorList);
        appointmentSorter = new AppointmentSorter(id, doctorList, firstName, lastName);
        System.out.println("\nLogged in as " + firstName + " " + lastName + "!");
    }

    public void showMenu() throws IOException {
        System.out.println("\n1.Show reserved appointments for medical examination\n2.Sort reserved examinations\n3.Group patients\n");
        selectMenuOption();
    }

    public void selectMenuOption() throws IOException {
        Scanner sc = new Scanner(System.in);
        String choice;
        System.out.print("Enter your choice: ");
        do {
            choice = sc.nextLine();
            switch (choice) {
                case "1" -> {
                    appointmentDisplayer.loadAppointmentsForSelectedDoctor();
                    showMenu();
                }
                case "2" -> {
                    appointmentSorter.sortChoice();
                    showMenu();
                }
                case "3" -> {
                    PatientGroup.showGroupingMenu();
                    showMenu();
                }
                default -> System.out.print("Wrong input! Try again: ");
            }
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3"));
    }
}
