import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PatientFileManager {

    public static List<Patient> loadPatients(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        List<Patient> patientList = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] info = line.split(",");
            patientList.add(new Patient(Integer.parseInt(info[0]), info[1], info[2], Integer.parseInt(info[3])));
        }
        return patientList;
    }
}
