import java.awt.*;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LoginPatient {
    public class LoginDoctor {
        PatientFileManager patientFileManager;
        protected List<Patient> patientList;

        public LoginDoctor() throws IOException {
            patientFileManager = new PatientFileManager();
            patientList = patientFileManager.loadDoctors("Patients.csv");
            verify();
        }

        protected void verify() {
            System.out.println("Enter patient ID:");
            Scanner sc = new Scanner(System.in);
            int id= -1;
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
            for(Patient patientsList:patientList) {
                if (id==(patientsList.getId())&& name.equalsIgnoreCase(patientsList.getFirstName())) {
                    System.out.println("Welcome "+patientsList.getFirstName());
                    return;
                }
            }
        }
    }
}