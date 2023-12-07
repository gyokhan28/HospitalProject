import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class DoctorMenu {
    private final AppointmentDisplayer appointmentDisplayer;
    private final AppointmentSorter appointmentSorter;

    public DoctorMenu(int id, String firstName, String lastName, List<Doctor> doctorList) {
        appointmentDisplayer = new AppointmentDisplayer(id, doctorList);
        appointmentSorter = new AppointmentSorter(id, firstName, lastName);
    }

    public void showMenu() throws IOException {
        System.out.println("\n1.Show reserved appointments for medical examination\n2.Sort reserved examinations\n3.Group patients\n0.Exit\n");
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
                case "0" -> {
                    System.out.println("Closing the R & G Hospital Program...");
                    Effects.wait(2500);
                    System.out.println("Clearing data...");
                    Effects.wait(1500);
                    System.out.println("Exiting...");
                }
                default -> System.out.print("Wrong input! Try again: ");
            }
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("0"));
    }
}
