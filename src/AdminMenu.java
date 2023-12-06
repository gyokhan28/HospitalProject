import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {

    static List<Patient>patientList;
    static List<Doctor>doctorList;
    Setup setup;

    public AdminMenu() throws IOException {
        patientList=setup.getPatientList();
        doctorList=setup.getDoctorList();
        showMenu();
    }
    public static void showMenu() throws IOException {
        System.out.println("Logged in as Administrator!");
        System.out.println("1. Add new doctor");
        System.out.println("2. Add new patient");
        System.out.println("0. Exit.");
        chooseAnOption();
    }
    public static void chooseAnOption() throws IOException {
        Scanner sc = new Scanner(System.in);
        String choice = "";
        System.out.print("Enter your choice: ");
        do {
            choice = sc.next();
            switch (choice) {
                case "1" -> {
                    System.out.println("***  Add new doctor *** ");
                    System.out.println();
                    AddNewDoctor.addNewDoctor();
                    showMenu();
                }
                case "2" -> {
                    System.out.println("*** Add new patient ***");
                    System.out.println();
                    AddNewPatient addNewPatient = new AddNewPatient(patientList);
                    addNewPatient.addNewPatient();
                    showMenu();
                }
                case "0" -> System.out.println("Exit!");

                default -> System.out.print("Wrong input! Try again: ");
            }
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("0"));
    }
}