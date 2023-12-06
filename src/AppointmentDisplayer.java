import java.util.List;
import java.util.Scanner;

public class AppointmentDisplayer {
    private final int personalDoctorId;
    private final List<Doctor> doctorList;
    private final List<Appointment> appointmentList;
    Setup setup;

    public AppointmentDisplayer(int id, List<Doctor> doctorList){
        this.appointmentList = setup.getAppointmentList();
        this.doctorList = doctorList;
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
                    System.out.print("You did not enter a correct id! Try again (1-" + doctorList.size() + "):");
                    choice = sc.next();
                }
            }
        }
    }

    public void showAppointments(int id) {
        boolean isFound = false;
        for (Appointment a : appointmentList) {
            if (id == a.getDoctorId()) {
                System.out.println("App. ID:" + a.getAppointmentId() + ", patient: " + a.getPatient().getFirstName()+ " " + a.getPatient().getLastName() + ", Ex. type: " + a.getTypeOfExamination() + ", Date: " + a.getDate() + ", Time: " + a.getTime());
            }
        }
        if (!isFound) {
            for(;;) {
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