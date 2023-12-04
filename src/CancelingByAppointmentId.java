import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CancelingByAppointmentId {
    List<Appointment> appointmentsList;
    PreviewOfRecordedHours previewOfRecordedHours = new PreviewOfRecordedHours();
    AppointmentsFileManager appointmentsFileManager = new AppointmentsFileManager();

    public CancelingByAppointmentId() throws IOException {
        this.appointmentsList = AppointmentsFileManager.loadAppointments("Appointments.csv");
    }

    public void cancelAppointment(int patientID) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean isFoundPatientInTheList = returnIfPatientInTheList(patientID);
        if (isFoundPatientInTheList) {
            previewOfRecordedHours.showRecordedHours(patientID);
            System.out.print("Enter AppointmentID you want to cancel: ");
            int appointmentId = Integer.parseInt(sc.next());
            boolean isFoundIDIsCorrect = checkIfTheIDIsCorrect(appointmentId, patientID);
            if (isFoundIDIsCorrect) {
                appointmentsList.removeIf(appointment -> appointment.getAppointmentId()==appointmentId);
                appointmentsFileManager.writeAppointments(appointmentsList, "Appointments.csv");
                System.out.println("Yor appointment is canceled!");
            }else{
                System.out.println("Wrong Input!");
                System.out.println("Your reserved appointment times are:");
                System.out.println();
                cancelAppointment(patientID);
            }
        } else {
            System.out.println("You don't have any doctor appointments");
        }
    }

    private boolean returnIfPatientInTheList(int patientID) {
        boolean isFound = false;
        for (Appointment appointment : appointmentsList) {
            if (patientID == appointment.getPatientId()) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }

    public boolean checkIfTheIDIsCorrect(int appointmentID, int patientID) throws IOException {
        boolean isFound = false;
        List<Appointment> appointmentsByPatient = previewOfRecordedHours.returnAppointmentListByPatientID(patientID);
        if (!appointmentsByPatient.isEmpty()) {
            for (Appointment appointment : appointmentsByPatient) {
                if (appointmentID == appointment.getAppointmentId()) {
                    isFound = true;
                    break;
                }
            }
        }
        return isFound;
    }
}

