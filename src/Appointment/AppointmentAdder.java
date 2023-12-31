package Appointment;

import Doctor.Doctor;
import FileManagement.AppointmentsFileManager;
import Patient.Patient;
import Main.Setup;
import Login.LoginPatient;
import Login.LoginDoctor;
import Patient.ChangeDateTime;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppointmentAdder {

    public static void addNewHour(int iDPatient) throws IOException {
        Patient patient = LoginPatient.returnPatient(iDPatient);
        Scanner sc = new Scanner(System.in);
        String regex = "\\d{2}-\\d{2}-\\d{4}";
        Pattern pattern = Pattern.compile(regex);

        String examinationType = returnTypeOfExamination();

        String date = "";
        boolean flagForData = false;
        do {
            System.out.print("Enter date of examination (in the format DD-MM-YYYY): ");
            String enteredDate = sc.nextLine();
            Matcher matcher = pattern.matcher(enteredDate);
            if (matcher.matches()) {
                String[] parts = enteredDate.split("-");
                int day = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);
                if (day <= 31 && month <= 12 && year >= 2023) {
                    date = enteredDate;
                    flagForData = true;
                } else {
                    System.out.println("An invalid date was entered! Please try again.");
                }

            } else {
                System.out.println("Invalid date format. Please try again.");
            }
        } while (!flagForData);

        boolean flagForTime = false;
        int time = 0;
        System.out.print("Enter time of examination:");
        do {
            int enteredTime = sc.nextInt();
            if (enteredTime >= 900 && enteredTime <= 1700) {
                time = enteredTime;
                flagForTime = true;
            } else {
                System.out.println("Invalid time. Please try again.");
            }
        } while (!flagForTime);
        int doctorID = returnDoctorID();

        Appointment newAppointment = new Appointment(returnLastID() + 1, patient, examinationType, date, time, LoginDoctor.returnDoctor(doctorID));

        boolean appointmentUnavailable = Setup.getAppointmentList().stream().anyMatch(appointment -> Objects.equals(appointment.getDate(), newAppointment.getDate()) &&
                appointment.getTime() == newAppointment.getTime() && appointment.getDoctor().equals(newAppointment.getDoctor()));
        if (appointmentUnavailable) {
            System.out.println("An appointment with the same date, time and doctor already exists. Try again!");
            addNewHour(iDPatient);
        } else {
            Setup.getAppointmentList().add(newAppointment);
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("Appointments.csv", true))) {

                bw.write(newAppointment.getAppointmentId() + "," + newAppointment.getPatient().getId() + "," + newAppointment.getTypeOfExamination() + "," + newAppointment.getDate() + "," + newAppointment.getTime() + "," + newAppointment.getDoctor().getId());
                bw.newLine();

                System.out.println("File is updated!");
                System.out.println();
            } catch (IOException e) {
                System.err.println("Error while trying to write in file: " + e.getMessage());
            }

        }
    }

    public static String returnTypeOfExamination() {
        System.out.println("Please select the type of doctor's examination: ");
        System.out.println("1. Initial.");
        System.out.println("2. Secondary");
        System.out.println("3. Consultation");
        System.out.println("4. Procedure");
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            choice = sc.nextLine();
            switch (choice) {
                case "1" -> {
                    return "Initial";
                }
                case "2" -> {

                    return "Secondary";
                }
                case "3" -> {
                    return "Consultation";
                }
                case "4" -> {
                    return "Procedure";
                }
                default -> System.out.print("Wrong input! Try again: ");
            }
        } while (true);
    }

    public static int returnDoctorID() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the doctor's names:");
        System.out.print("First name: ");
        String docFirstName = sc.next();
        System.out.print("Last name: ");
        String docLastName = sc.next();
        for (Doctor doctor : Setup.getDoctorList()) {
            if (docFirstName.equalsIgnoreCase(doctor.getFirstName()) && docLastName.equalsIgnoreCase(doctor.getLastName())) {
                return doctor.getId();
            }
        }
        System.out.println("There is no doctor with that name. Please, try again!");
        return returnDoctorID();
    }

    public static int returnLastID() throws IOException {
        return Setup.getAppointmentList().get(Setup.getAppointmentList().size() - 1).getAppointmentId();
    }
}