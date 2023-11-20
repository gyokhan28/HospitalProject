import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AppointmentAdder {
    // private final int personalPatientId;
    private final List<Doctor> doctorsList;

    public AppointmentAdder() throws IOException {
        doctorsList = DoctorFileManager.loadDoctors("Doctors.csv");
    }


    public void addNewHour(int iDPatient) throws IOException {
        Scanner sc = new Scanner(System.in);

        int lastID = returnLastID();
        String examinationType = returnTypeOfExamination();
        System.out.print("Enter date of examination: ");
        String date = sc.nextLine();
        System.out.print("Enter time of examination:");
        int time = sc.nextInt();
        int doctorID = returnDoctorID();
        System.out.println("Last ID" + lastID + " Examination type " + examinationType + " Date " + date + " time " + time + " doctor ID" + doctorID);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Appointments copy.csv", true))) {

            bw.write(returnLastID() + 1 + "," + iDPatient + "," + examinationType + "," + date + "," + time + "," + doctorID);
            bw.newLine();

            System.out.println("File is updated!");
            System.out.println();
        } catch (IOException e) {
            System.err.println("Error writing in file: " + e.getMessage());
        }

    }

    public String returnTypeOfExamination() {
        System.out.println("Please select the type of doctor's examination: ");
        System.out.println("1. Initial.");
        System.out.println("2. Secondary");
        System.out.println("3. Consultation");
        System.out.println("4. Procedure");
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        boolean formatFlag = false;
        while (!formatFlag) {
            try {
                choice = sc.nextInt();
                formatFlag = true;
            } catch (InputMismatchException e) {
                System.out.println("You must enter an integer!");
                sc.next();
            }
        }
        do {
            switch (choice) {
                case 1 -> {
                    return "Initial";
                }
                case 2 -> {

                    return "Secondary";
                }
                case 3 -> {
                    return "Consultation";
                }
                case 4 -> {
                    return "Procedure";
                }
                default -> System.out.print("Wrong input! Try again: ");
            }
        } while (true);
    }

    public int returnDoctorID() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the name of the doctor you wish to see: ");
        String doctorName = sc.next();
        for (Doctor doctor : doctorsList) {
            if (doctorName.equalsIgnoreCase(doctor.getFirstName())) {
                return doctor.getId();
            }
        }
        System.out.println("There is no doctor with that name. Please, try again");
        return returnDoctorID();
    }

    public int returnLastID() throws IOException {
        List<Appointment> appointmentList = AppointmentsFileManager.loadAppointments("Appointments copy.csv");
        return appointmentList.get(appointmentList.size() - 1).getAppointmentId();
    }
}
