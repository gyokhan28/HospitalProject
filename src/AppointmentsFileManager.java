import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentsFileManager {

    public static List<Appointment> loadAppointments(String fileName) throws IOException {
        List<Appointment> appointmentList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] info = line.split(",");
            appointmentList.add(new Appointment(Integer.parseInt(info[0]), Integer.parseInt(info[1]), info[2], info[3], Integer.parseInt(info[4]), Integer.parseInt(info[5])));
        }
        return appointmentList;
    }

}
