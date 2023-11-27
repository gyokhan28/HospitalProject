import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LoginPatient {
    PatientFileManager patientFileManager;

    protected List<Patient> patientList;

    public LoginPatient() throws IOException {
        patientList = PatientFileManager.loadPatients();
        verify();
    }

    protected void verify() throws IOException {
        System.out.println("Enter patient ID:");
        Scanner sc = new Scanner(System.in);
        int id = -1;
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
        System.out.println("Enter name:");
        sc.nextLine();
        String name = sc.nextLine();
        for (Patient patient : patientList) {
            if (id == (patient.getId()) && name.equalsIgnoreCase(patient.getFirstName())) {
                PatientMenu patientMenu = new PatientMenu(patient.getId(), patient.getFirstName(), patient.getLastName(), patientList);
                return;
            }
        }
        System.out.println("Incorrect ID or patientname! Please try again!");
        verify();
    }
}