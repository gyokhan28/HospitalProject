import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PreviewOfRecordedHours {
    List<Appointment>appointmentsList;

    public PreviewOfRecordedHours() throws IOException {
        this.appointmentsList =AppointmentsFileManager.loadAppointments("Appointments.csv");
    }
    public void showRecordedHours(int id){
        boolean isHave = false;
        for (Appointment appointment:appointmentsList) {
            if(id== appointment.getPatientId()){
                System.out.println("Appointment ID: "+appointment.getAppointmentId()+ " Type of examination: "+appointment.getTypeOfExamination()+" Date: "+appointment.getDate()+" Time: "+appointment.getTime()+" Doctor ID: "+appointment.getDoctorId());
                isHave=true;
            }
        }
        if (!isHave) {
            System.out.println("You don't have any doctor appointments");
        }
    }

    public List<Appointment> returnAppointmentListByPatientID(int id){
        List<Appointment>appointmentsByPatient = new ArrayList<>();
        for (Appointment appointment:appointmentsList) {
            if(id== appointment.getPatientId()){
                appointmentsByPatient.add(new Appointment(appointment.getAppointmentId(),appointment.getPatientId(),appointment.getTypeOfExamination(),appointment.getDate(),appointment.getTime(),appointment.getDoctorId()));
            }
        }
        return appointmentsByPatient;
    }
}
