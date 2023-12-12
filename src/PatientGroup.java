import java.util.Scanner;
import java.util.stream.Collectors;

public class PatientGroup {

    protected static void showGroupingMenu(){
        System.out.print("\n1.Group by doctor name\n2.Group by speciality\n3.Group by date of appointment:\nEnter your choice:");
        Scanner sc = new Scanner(System.in);
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

    protected static void groupPatientsByDoctorName() {
        System.out.println("\nShowing grouped patients list by doctor name:");
        Setup.getDoctorList().forEach(doctor -> {
            System.out.print("\nDr." + doctor.getFirstName() + " " + doctor.getLastName() + " (" + doctor.getSpeciality() + ") :\n");
            Setup.getAppointmentList().stream()
                    .filter(appointment -> doctor.getId() == appointment.getDoctor().getId())
                    .forEach(appointment -> Setup.getPatientList().stream()
                            .filter(patient -> patient.getId() == appointment.getPatient().getId())
                            .forEach(patient -> System.out.print(patient + "\n")));
            System.out.println("----------------------------");
        });
    }

    protected static void groupPatientsBySpeciality() {
        System.out.println("\nShowing grouped patients by speciality:");
        Setup.getDoctorList().forEach(doctor -> {
            System.out.println(doctor.getSpeciality() + ":");
            Setup.getAppointmentList().stream()
                    .filter(appointment -> doctor.getId() == appointment.getDoctor().getId())
                    .forEach(appointment -> Setup.getPatientList().stream()
                            .filter(patient -> patient.getId() == appointment.getPatient().getId())
                            .forEach(patient -> System.out.print(patient + "\n")));
            System.out.println("----------------------------");
        });
    }

    protected static void groupPatientsByDate() {
        System.out.println("\nShowing grouped patients by date of appointment:\n");
        Setup.getAppointmentList().stream().collect(Collectors.groupingBy(Appointment::getDate))
                .forEach((date, appointments) -> {
                    System.out.println(date + ":");
                    appointments.forEach(appointment -> Setup.getPatientList().stream()
                            .filter(patient -> patient.getId() == appointment.getPatient().getId())
                            .forEach(patient -> System.out.print(patient + "\n")));
                    System.out.println("----------------------------");
                });
    }
}

