import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentFileManager {
    public List<DoctorsAppointment> loadAppointmentList(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        List<DoctorsAppointment> doctorsAppointmentList = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] info = line.split(";");
            doctorsAppointmentList.add(new DoctorsAppointment (Integer.parseInt(info[0]),Integer.parseInt(info[1]), info[2], info[3], Integer.parseInt(info[4]),Integer.parseInt(info[5])));
        }
        return doctorsAppointmentList;
    }
}
