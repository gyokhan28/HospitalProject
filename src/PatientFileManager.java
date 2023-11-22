import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PatientFileManager {

    public static List<Patient> loadPatients() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Patients.csv"));
        List<Patient> patientList = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] info = line.split(",");
            patientList.add(new Patient(Integer.parseInt(info[0]), info[1], info[2], Integer.parseInt(info[3])));
        }
        return patientList;
    }
    public void writePatient(List<Patient> patients) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Patients new.csv"));
        for (Patient patient : patients) {
            bufferedWriter.write(patient.getId() + "," + patient.getFirstName() + "," + patient.getLastName() + "," + patient.getAge());
            bufferedWriter.newLine();

        }
        bufferedWriter.close();
    }
}
