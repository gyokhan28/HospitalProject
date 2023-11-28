import javax.print.Doc;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorFileManager {

    public static List<Doctor> loadDoctors() throws IOException {
        List<Doctor> doctorList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Doctors.csv"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] info = line.split(",");
            doctorList.add(new Doctor(Integer.parseInt(info[0]), info[1], info[2], info[3]));
        }
        return doctorList;
    }
    public void writeDoctor(List<Doctor> doctors) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Doctors new.csv"));
        for (Doctor doctor : doctors) {
            bufferedWriter.write(doctor.getId() + "," + doctor.getFirstName() + "," + doctor.getLastName() + "," + doctor.getSpeciality());
            bufferedWriter.newLine();

        }
        bufferedWriter.close();
    }
}
