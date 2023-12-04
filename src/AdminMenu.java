import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {

    static List<Patient>patientList;
    static List<Doctor>doctorList;

    public AdminMenu() throws IOException {
        patientList=PatientFileManager.loadPatients("Patients.csv");
        doctorList=DoctorFileManager.loadDoctors();
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
        int choice = 0;
        System.out.print("Enter your choice: ");
        do {
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("***  Add new doctor *** ");
                    System.out.println();
                    AddNewDoctor addNewDoctor = new AddNewDoctor(doctorList);
                    addNewDoctor.addNewDoctor();
                    showMenu();
                }
                case 2 -> {
                    System.out.println("*** Add new patient ***");
                    System.out.println();
                    AddNewPatient addNewPatient = new AddNewPatient(patientList);
                    addNewPatient.addNewPatient();
                    showMenu();
                }
                case 0 -> System.out.println("Exit!");

                default -> System.out.print("Wrong input! Try again: ");
            }
        } while (choice != 1 && choice != 2 && choice != 0);
    }
}