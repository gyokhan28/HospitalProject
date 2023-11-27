import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {
    List<Patient>patientList;
    List<Doctor>doctorList;
    public AdminMenu() throws IOException {
        patientList=PatientFileManager.loadPatients();
        doctorList=DoctorFileManager.loadDoctors("Doctors.csv");
        showMenu();
    }
    public void showMenu() throws IOException {
        System.out.println("Logged in as Administrator!");
        System.out.println("1. Add new doctor");
        System.out.println("2. Add new patient");
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
                    System.out.println("***  Add new doctor *** ");


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
        } while (choice != 1 && choice != 2);
    }
}