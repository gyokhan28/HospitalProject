import java.io.IOException;
import java.util.Scanner;

public class CancelingByAppointmentId {

    public static void cancelAppointment(int patientID) throws IOException {
        Scanner sc = new Scanner(System.in);
        PreviewOfRecordedHours.showRecordedHours(patientID);
        System.out.print("Enter AppointmentID you want to cancel: ");
        int appointmentId = Integer.parseInt(sc.next());
        boolean isFoundIDIsCorrect = checkIfTheIDIsCorrect(appointmentId, patientID);
        if (isFoundIDIsCorrect) {
            Setup.getAppointmentList().removeIf(appointment -> appointment.getAppointmentId() == appointmentId);
            AppointmentsFileManager.writeAppointments(Setup.getAppointmentList(), "Appointments.csv");
            System.out.println("Yor appointment is canceled!");
        } else {
            System.out.println("Wrong Input!");
            System.out.println("Your reserved appointment times are:");
            System.out.println();
            cancelAppointment(patientID);
        }
    }

    public static boolean checkIfTheIDIsCorrect(int appointmentID, int patientID) {
        boolean isFound = false;
        for (Appointment appointment : Setup.getAppointmentList()) {
            if ((appointmentID == appointment.getAppointmentId()) && (patientID == appointment.getPatient().getId())) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }
}

