import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Setup setup = new Setup();
        System.out.println(setup.getDoctorList());
        System.out.println(setup.getPatientList());
        List<Appointment>appointmentList=AppointmentsFileManager.loadAppointments("Appointments.csv");
        System.out.println(setup.getAppointmentList());
        System.out.print("How would you like to sign up as? (1-Doctor/2-Patient):");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        UserLoginSelector.showSelector(sc,choice);
        System.out.println();
    }
}

