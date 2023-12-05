import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LoginPatient {
    protected static List<Patient> patientList;

    public LoginPatient() throws IOException {
        verify();
    }
    protected static Patient returnPatient(int patientID){
        for (Patient patient:patientList) {
            if(patientID==patient.getId()){
                return patient;
            }
        }
        return null;
    }


    protected static void verify() throws IOException {
        patientList = PatientFileManager.loadPatients("Patients.csv");
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