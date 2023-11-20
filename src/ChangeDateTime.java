import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ChangeDateTime {
    List<Appointment> appointmentsList;
    PreviewOfRecordedHours previewOfRecordedHours = new PreviewOfRecordedHours();
    AppointmentsFileManager appointmentsFileManager = new AppointmentsFileManager();

    public ChangeDateTime() throws IOException {
        this.appointmentsList = appointmentsFileManager.loadAppointments("Appointments.csv");
    }

    public void changeDateAnaTimeForAppointment(int patientID) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean isFoundPatientInTheList = returnIfPatientInTheList(patientID);
        if (isFoundPatientInTheList) {
            previewOfRecordedHours.showRecordedHours(patientID);
            System.out.print("Enter AppointmentID you want to change the date of: ");
            int appointmentId = Integer.parseInt(sc.next());
            boolean isFoundIDIsCorrect = checkIfTheIDIsCorrect(appointmentId, patientID);
            if (isFoundIDIsCorrect) {
                for (Appointment appointment : appointmentsList) {
                    if (appointmentId == appointment.getAppointmentId()) {
                        System.out.print("Enter new date for appointment: ");
                        String newData = sc.next();
                        appointment.setDate(newData);
                    }
                }
                appointmentsFileManager.writeAppointments(appointmentsList);
                System.out.println("Yor new date is updated!");
            }else{
                System.out.println("Wrong Input!");
                System.out.println("Your reserved appointment times are:");
                System.out.println();
                changeDateAnaTimeForAppointment(patientID);
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
                }
            }
        }
        return isFound;
    }
}

