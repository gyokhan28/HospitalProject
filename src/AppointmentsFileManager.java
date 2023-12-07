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
            Patient patient = LoginPatient.returnPatient(Integer.parseInt(info[1]));
            Doctor doctor = LoginDoctor.returnDoctor(Integer.parseInt(info[5]));
            appointmentList.add(new Appointment(Integer.parseInt(info[0]), patient, info[2], info[3], Integer.parseInt(info[4]), doctor));
        }
        return appointmentList;
    }

    public static void writeAppointments(List<Appointment> appointments, String fileName) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        for (Appointment appointment : appointments) {
            bufferedWriter.write(appointment.getAppointmentId() + "," + appointment.getPatient().getId() + "," + appointment.getTypeOfExamination() + "," + appointment.getDate() + "," + appointment.getTime() + "," + appointment.getDoctor().getId());
            bufferedWriter.newLine();

        }
        bufferedWriter.close();
    }

}