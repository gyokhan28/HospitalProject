import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class AddNewPatient {

    public AddNewPatient() {
    }
    public void addNewPatient() throws IOException {
        Scanner sc = new Scanner(System.in);
        Patient newPatient = new Patient();
        newPatient.setId(returnLastID()+1);
        System.out.print("Enter First name on patient:");
        String firstName = sc.next();
        newPatient.setFirstName(firstName);
        System.out.print("Enter Last name on patient:");
        String lastName = sc.next();
        newPatient.setLastName(lastName);
        System.out.print("Enter age on patient:");
        int age = sc.nextInt();
        newPatient.setAge(age);
        Setup.getPatientList().add(newPatient);
        writePatientInFile(Setup.getPatientList());
        System.out.println("Тhe new patient is added!");
        System.out.println();
    }
    private int returnLastID() {
        return Setup.getPatientList().get(Setup.getPatientList().size() - 1).getId();
    }
    private void writePatientInFile(List<Patient> patients) throws IOException {
        PatientFileManager.writePatient(patients,"Patients.csv");
    }
}