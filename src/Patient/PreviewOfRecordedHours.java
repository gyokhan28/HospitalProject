package Patient;

import Appointment.Appointment;
import Main.Setup;

public class PreviewOfRecordedHours {
    public static void showRecordedHours(int id){
        boolean isHave = false;
        for (Appointment appointment: Setup.getAppointmentList()) {
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
