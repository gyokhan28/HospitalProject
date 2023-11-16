import java.io.*;
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

    public void writeAppointments(List<Appointment> appointments) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Appointments new copy.csv"));
        for (Appointment appointment : appointments) {
            bufferedWriter.write(appointment.getAppointmentId() + "," + appointment.getPatientId() + "," + appointment.getTypeOfExamination() + "," + appointment.getDate() + "," + appointment.getTime() + "," + appointment.getDoctorId());
            bufferedWriter.newLine();

        }
        bufferedWriter.close();
    }

}
