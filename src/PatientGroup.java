import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class PatientGroup {
    private static List<Doctor> doctorList;
    private static List<Appointment> appointmentList;
    private static List<Patient> patientList;

    protected static void showGroupingMenu() throws IOException {
        System.out.print("\n1.Group by doctor name\n2.Group by speciality\n3.Group by date of appointment:\nEnter your choice:");
        Scanner sc = new Scanner(System.in);
        PatientGroup.loadLists();
        String choice;
        do {
            choice = sc.next();
            switch (choice) {
                case "1" -> PatientGroup.groupPatientsByDoctorName();
                case "2" -> PatientGroup.groupPatientsBySpeciality();
                case "3" -> PatientGroup.groupPatientsByDate();
                default -> System.out.print("You entered an invalid choice. Try again:");
            }
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3"));
    }

    protected static void loadLists() throws IOException {
        doctorList = DoctorFileManager.loadDoctors();
        appointmentList = AppointmentsFileManager.loadAppointments("Appointments.csv");
        patientList = PatientFileManager.loadPatients("Patients.csv");
    }

    protected static void groupPatientsByDoctorName() {
        System.out.println("\nShowing grouped patients list by doctor name:");
        doctorList.forEach(doctor -> {
            System.out.print("\nDr." + doctor.getFirstName() + " " + doctor.getLastName() + " (" + doctor.getSpeciality() + ") :\n");
            appointmentList.stream()
                    .filter(appointment -> doctor.getId() == appointment.getDoctorId())
                    .forEach(appointment -> {
                        patientList.stream()
                                .filter(patient -> patient.getId() == appointment.getPatientId())
                                .forEach(patient -> System.out.print(patient + "\n"));
                    });
            System.out.println("----------------------------");
        });
    }

    protected static void groupPatientsBySpeciality() {
        System.out.println("\nShowing grouped patients by speciality:");
        doctorList.forEach(doctor -> {
            System.out.println(doctor.getSpeciality() + ":");
            appointmentList.stream()
                    .filter(appointment -> doctor.getId() == appointment.getDoctorId())
                    .forEach(appointment -> {
                        patientList.stream()
                                .filter(patient -> patient.getId() == appointment.getPatientId())
                                .forEach(patient -> System.out.print(patient + "\n"));

                    });
            System.out.println("----------------------------");
        });
    }

    protected static void groupPatientsByDate() {
        System.out.println("Showing grouped patients by date of appointment:");
        for (Doctor doctor : doctorList) {
            boolean datePrinted = false;
            for (Appointment appointment : appointmentList) {
                if (doctor.getId() == appointment.getDoctorId()) {
                    if (!datePrinted) {
                        System.out.println("\n" + appointment.getDate() + ": ");
                    }
                    datePrinted = true;
                    for (Patient patient : patientList) {
                        if (appointment.getPatientId() == patient.getId()) {
                            System.out.println(patient.getFirstName() + " " + patient.getLastName() + " " + appointment.getDate() + " " + appointment.getTime());
                        }
                    }
                }
            }
        }
        System.out.println();
    }
}
