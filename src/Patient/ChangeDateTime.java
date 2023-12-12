package Patient;

import Appointment.Appointment;
import Main.Setup;
import FileManagement.AppointmentsFileManager;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangeDateTime {

    public void changeDateAndTimeForAppointment(int patientID) throws IOException {
        Scanner sc = new Scanner(System.in);

        String regex = "\\d{2}-\\d{2}-\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        String date = "";
        boolean flagForData = false;

        PreviewOfRecordedHours.showRecordedHours(patientID);

        System.out.print("Enter AppointmentID you want to change the date of: ");
        int appointmentId;
        for (; ; ) {
            if (sc.hasNextInt()) {
                appointmentId = Integer.parseInt(sc.next());
                break;
            } else {
                System.out.print("Incorrect Appointment ID. Try again:");
                sc.nextLine();
            }
        }
        sc.nextLine();
        boolean isFoundIDIsCorrect = checkIfTheIDIsCorrect(appointmentId, patientID);
        if (isFoundIDIsCorrect) {
            for (Appointment appointment : Setup.getAppointmentList()) {
                if (appointmentId == appointment.getAppointmentId()) {
                    Appointment changedAppointment = new Appointment(appointment.getAppointmentId(), appointment.getPatient(), appointment.getTypeOfExamination(), appointment.getDate(), appointment.getTime(), appointment.getDoctor());

                    do {
                        System.out.print("Enter new date for appointment in the format DD-MM-YYYY: ");
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
                                System.out.println("Invalid Date. Please try again.");
                            }

                        } else {
                            System.out.println("Invalid date format. Please try again.");
                        }
                    } while (!flagForData);
                    changedAppointment.setDate(date);

                    System.out.print("Enter new time of examination in format HHMM:");
                    int enteredTime = 0;
                    boolean flagForTime = false;

                    do {
                        if (sc.hasNextInt()) {
                            enteredTime = sc.nextInt();
                            if (enteredTime >= 900 && enteredTime <= 1700) {
                                flagForTime = true;
                            } else {
                                System.out.print("You must enter a time between 9:00 - 17:00! Try again:");
                            }
                        } else {
                            System.out.print("You must enter a valid time! Try again:");
                            sc.next();
                        }
                    } while (!flagForTime);
                    changedAppointment.setTime(enteredTime);
                    if (!appointmentAlreadyExists(changedAppointment)) {
                        int index = Setup.getAppointmentList().indexOf(appointment);
                        Setup.getAppointmentList().set(index, changedAppointment);
                        AppointmentsFileManager.writeAppointments(Setup.getAppointmentList(), "Appointments.csv");
                        System.out.println("Your new date is updated!\n");
                    } else {
                        System.out.println("Appointment already exists. Try again.");
                        changeDateAndTimeForAppointment(appointment.getPatient().getId());
                    }
                }
            }
        } else {
            System.out.println("Wrong Input!");
            System.out.println("Your reserved appointment times are:");
            System.out.println();
            changeDateAndTimeForAppointment(patientID);
        }
    }

    public static boolean appointmentAlreadyExists(Appointment appointment) {
        return Setup.getAppointmentList().stream().anyMatch(appointment1 -> appointment1.getTime() == appointment.getTime() &&
                appointment1.getDate().equals(appointment.getDate()) &&
                appointment1.getDoctor().getFirstName().equals(appointment.getDoctor().getFirstName()) &&
                appointment1.getDoctor().getLastName().equals(appointment.getDoctor().getLastName()));
    }

    public boolean checkIfTheIDIsCorrect(int appointmentID, int patientID) {
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