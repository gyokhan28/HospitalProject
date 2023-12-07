import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LoginPatient {
    public LoginPatient() {
    }

    protected static void verify() throws IOException {
        System.out.print("Enter patient ID: ");
        Scanner sc = new Scanner(System.in);
        int id = 0;
        boolean formatFlag = false;
        while (!formatFlag) {
            try {
                id = sc.nextInt();
                formatFlag = true;
            } catch (InputMismatchException e) {
                System.out.println("You must enter an integer!");
                sc.next();
            }
        }
        System.out.print("Enter name: ");
        sc.nextLine();
        String name = sc.nextLine();
        boolean isFound = false;
        for (Patient patient : Setup.getPatientList()) {
            if (id == (patient.getId()) && name.equalsIgnoreCase(patient.getFirstName())) {
                System.out.println("Logged in as " + patient.getFirstName() + " " + patient.getLastName() + "!");
                PatientMenu.showMenu(patient);
                isFound = true;
                break;
            }
        }
        if(!isFound) {
            System.out.println("Incorrect ID or patient name! Please try again!");
            verify();
        }
    }

    protected static Patient returnPatient(int patientID) {
        for (Patient patient : Setup.getPatientList()) {
            if (patientID == patient.getId()) {
                return patient;
            }
        }
        return null;
    }
}