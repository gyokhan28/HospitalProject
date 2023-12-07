import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PreviewOfRecordedHours {
    protected List<Appointment>appointmentsList = new ArrayList<>();
    protected Setup setup;

    public PreviewOfRecordedHours() throws IOException {
        this.appointmentsList = setup.getAppointmentList();
    }
    public void showRecordedHours(int id){
        boolean isHave = false;
        for (Appointment appointment:appointmentsList) {
            if(id== appointment.getPatient().getId()){
                System.out.println("Appointment ID: "+appointment.getAppointmentId()+ " Type of examination: "+appointment.getTypeOfExamination()+" Date: "+appointment.getDate()+" Time: "+appointment.getTime()+" Doctor ID: "+appointment.getDoctor().getId());
                isHave=true;
            }
        }
        if (!isHave) {
            System.out.println("You don't have any doctor appointments");
        }
    }
}
