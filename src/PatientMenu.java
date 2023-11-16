import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class PatientMenu {
    protected int id;
    protected String firstName, lastName;

    private List<Patient> patientList;
    private List<Appointment> appointmentsList;

    public PatientMenu(int id, String firstName, String lastName, List<Patient> patientList) throws IOException {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patientList = patientList;
        showMenu();

    }

    public void showMenu() throws IOException {
        System.out.println("Logged in as " + firstName + " " + lastName + "!");
        System.out.println("1. Book a new doctor's appointment.");
        System.out.println("2. View of recorded hours for a patient.");
        System.out.println("3. Change the date/time of a recorded appointment.");
        System.out.println("4. Canceling an appointment.");
        chooseAnOption();
    }

    public void chooseAnOption() throws IOException {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        System.out.print("Enter your choice: ");
        do {
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("***  Book a new doctor's appointment *** ");
                    AppointmentAdder appointmentAdder = new AppointmentAdder();
                    appointmentAdder.addNewHour(id);
                    showMenu();
                }
                case 2 -> {
                    System.out.println("*** View of recorded hours for a " + firstName + " " + lastName + " ***");
                    System.out.println();
                    PreviewOfRecordedHours recordedHours = new PreviewOfRecordedHours();
                    recordedHours.showRecordedHours(id);
                    showMenu();
                }
                case 3 -> {
                    System.out.println("***  Change the date/time of a recorded appointment *** ");
                    System.out.println();
                    ChangeDateTime changeDateTime = new ChangeDateTime();
                    changeDateTime.changeDateAnaTimeForAppointment(id);
                    showMenu();
                }
                case 4 -> {
                    System.out.println("*** Canceling an appointment ***");
                    CancelingByAppointmentId cancelingByAppointmentId = new CancelingByAppointmentId();
                    cancelingByAppointmentId.cancelAppointment(id);
                    showMenu();
                }

                default -> System.out.print("Wrong input! Try again: ");
            }
        } while (choice != 1 && choice != 2 && choice != 3);
    }
}
