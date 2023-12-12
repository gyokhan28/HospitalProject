package Admin;

import FileManagement.PatientFileManager;
import Main.Setup;
import Patient.Patient;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AddNewPatient {

    public AddNewPatient() {
    }

    public void addNewPatient() throws IOException {
        Scanner sc = new Scanner(System.in);
        Patient newPatient = new Patient();
        newPatient.setId(returnLastID() + 1);
        System.out.print("Enter First name of patient:");
        String firstName = sc.next();
        newPatient.setFirstName(firstName);
        System.out.print("Enter Last name of patient:");
        String lastName = sc.next();
        newPatient.setLastName(lastName);
        System.out.print("Enter age:");
        int age;
        while (true) {
            try {
                age = Integer.parseInt(sc.next());
                break;
            } catch (NumberFormatException e) {
                System.out.print("You must enter an integer! Try again:");
            }
        }
        newPatient.setAge(age);
        Setup.getPatientList().add(newPatient);
        writePatientInFile(Setup.getPatientList());
        System.out.println("Тhe new patient ("+newPatient.getFirstName()+" "+newPatient.getLastName()+") was added successfully!");
        System.out.println();
    }
    private int returnLastID() {
        return Setup.getPatientList().get(Setup.getPatientList().size() - 1).getId();
    }

    private void writePatientInFile(List<Patient> patients) throws IOException {
        PatientFileManager.writePatient(patients, "Patients.csv");
    }
}