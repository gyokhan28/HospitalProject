import java.util.List;
import java.util.Scanner;

public class AppointmentDisplayer {
    private final int personalDoctorId;

    public AppointmentDisplayer(int id, List<Doctor> doctorList) {

        this.personalDoctorId = id;
    }

    public void loadAppointmentsForSelectedDoctor() {
        System.out.print("Who's appointments would you like to see? (press Enter to see yours):");
        Scanner sc = new Scanner(System.in);
        String choice;
        choice = sc.nextLine();
        if (choice.isEmpty()) {
            System.out.println("Showing your appointments:");
            showAppointments(personalDoctorId);
        } else {
            while (true) {
                try {
                    int newId = Integer.parseInt(choice);
                    showAppointments(newId);
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("You did not enter a correct id! Try again (1-" + Setup.getDoctorList().size() + "):");
                    choice = sc.next();
                }
            }
        }
    }

    public void showAppointments(int id) {
        boolean isFound = false, doctorPrinted = false;
        for (Appointment a : Setup.getAppointmentList()) {
            if (id == a.getDoctor().getId()) {
                if (personalDoctorId == a.getDoctor().getId()) {
                    doctorPrinted = true;
                }
                if (!doctorPrinted) {
                    System.out.println("Showing appointments of Dr." + a.getDoctor().getFirstName() + " " + a.getDoctor().getLastName() + " (ID " + a.getDoctor().getId() + "):");
                    doctorPrinted = true;
                }
                System.out.println("App. ID:" + a.getAppointmentId() + ", patient: " + a.getPatient().getFirstName() + " " + a.getPatient().getLastName() + ", Ex. type: " + a.getTypeOfExamination() + ", Date: " + a.getDate() + ", Time: " + a.getTime());
                isFound = true;
            }
        }
        if (!isFound) {
            for (; ; ) {
                System.out.print("Doctor not found/No appointments found! Try again with another doc. ID:");
                Scanner sc = new Scanner(System.in);
                if (sc.hasNextInt()) {
                    showAppointments(sc.nextInt());
                    break;
                }
            }
        }
    }
}