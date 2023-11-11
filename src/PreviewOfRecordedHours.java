import java.io.IOException;
import java.util.List;

public class PreviewOfRecordedHours {
    List<Appointment>appointmentsList;
    AppointmentsFileManager appointmentsFileManager = new AppointmentsFileManager();

    public PreviewOfRecordedHours() throws IOException {
        this.appointmentsList = appointmentsFileManager.loadAppointments("Appointments.csv");
    }
    public void showRecordedHours(int id){
        boolean isHave = false;

        for (Appointment appointment:appointmentsList) {
            if(id== appointment.getPatientId()){
                System.out.println("Type of examination: "+appointment.getTypeOfExamination()+" Date: "+appointment.getDate()+" Time: "+appointment.getTime()+" Doctor ID: "+appointment.getDoctorId());
                isHave=true;
            }
        }
        if (!isHave) {
            System.out.println("You don't have any doctor appointments");
        }
    }
}
