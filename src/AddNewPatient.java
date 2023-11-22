import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AddNewPatient {
    private List<Patient>patientList;
    private final PatientFileManager patientFileManager = new PatientFileManager();

    public AddNewPatient(List<Patient> patientList) {
        this.patientList = patientList;
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
        patientList.add(newPatient);
        writePatientInFile(patientList);
        System.out.println("Тhe new patient is added!");
        System.out.println();
    }
    private int returnLastID() throws IOException {
       patientList = PatientFileManager.loadPatients();
        return patientList.get(patientList.size() - 1).getId();
    }
    private void writePatientInFile(List<Patient> patients) throws IOException {
        patientFileManager.writePatient(patients);
    }
}
