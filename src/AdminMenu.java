import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {
    static List<Patient> patientList;
    List<Doctor> doctorList;

    public AdminMenu() throws IOException {
        patientList = PatientFileManager.loadPatients();
        doctorList = DoctorFileManager.loadDoctors();
    }

    public static void showMenu() throws IOException {
        System.out.println("1. Add new doctor");
        System.out.println("2. Add new patient");
        System.out.println("0. Exit.");
        chooseAnOption();
    }

    public static void chooseAnOption() throws IOException {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        System.out.print("Enter your choice: ");
        do {
            choice = sc.nextInt();
            switch (choice) {
                case 0 -> System.out.println("Exit!");
                case 1 -> {
                    System.out.println("***  Add new doctor *** ");
                    System.out.println();
                    AddNewDoctor.addNewDoctor();
                    showMenu();
                }
                case 2 -> {
                    System.out.println("*** Add new patient ***");
                    System.out.println();
                    AddNewPatient addNewPatient = new AddNewPatient(patientList);
                    addNewPatient.addNewPatient();
                    showMenu();
                }
                default -> System.out.print("Wrong input! Try again: ");
            }
        } while (choice != 0 && choice != 1 && choice != 2);
    }
}