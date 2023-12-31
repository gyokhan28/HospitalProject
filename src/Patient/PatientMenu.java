package Patient;

import Appointment.Appointment;
import Appointment.AppointmentAdder;
import Main.Effects;
import Main.Setup;

import java.io.IOException;
import java.util.Scanner;

public class PatientMenu {
    protected int id;
    private static boolean noAppointmentPatient = false;

    public static void setNoAppointmentPatient(boolean noAppointmentPatient) {
        PatientMenu.noAppointmentPatient = noAppointmentPatient;
    }

    public PatientMenu(int id) {
        this.id = id;
    }

    public static void showMenu(Patient patient) throws IOException {
        System.out.println("1. Book a new doctor's appointment.");
        boolean flag = false;
        for (Appointment a : Setup.getAppointmentList()) {
            if (a.getPatient().getId() == patient.getId()) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("2. View of recorded hours for a patient.");
            System.out.println("3. Change the date/time of a recorded appointment.");
            System.out.println("4. Canceling an appointment.");
        } else {
            setNoAppointmentPatient(true);
        }
        System.out.println("0. Exit.");
        chooseAnOption(patient);
    }

    public static void chooseAnOption(Patient patient) throws IOException {
        Scanner sc = new Scanner(System.in);
        String choice;
        System.out.print("Enter your choice: ");
        if (noAppointmentPatient) {
            do {
                choice = sc.nextLine();
                switch (choice) {
                    case "1" -> {
                        System.out.println("***  Book a new doctor's appointment *** ");
                        AppointmentAdder.addNewHour(patient.getId());
                        setNoAppointmentPatient(false);
                        showMenu(patient);
                    }
                    case "0" -> {
                        System.out.println("Closing the R & G Hospital Program...");
                        Effects.wait(2500);
                        System.out.println("Clearing data...");
                        Effects.wait(1500);
                        System.out.println("Exiting...");
                    }
                    default -> System.out.print("Wrong input! Try again: ");
                }
            } while (!choice.equals("0") && !choice.equals("1"));
        } else {
            do {
                choice = sc.nextLine();
                switch (choice) {
                    case "1" -> {
                        System.out.println("***  Book a new doctor's appointment *** ");
                        AppointmentAdder.addNewHour(patient.getId());
                        showMenu(patient);
                    }
                    case "2" -> {
                        System.out.println("*** Showing recorded hours: ***");
                        System.out.println();
                        PreviewOfRecordedHours.showRecordedHours(patient.getId());
                        showMenu(patient);
                    }
                    case "3" -> {
                        System.out.println("***  Change the date/time of a recorded appointment *** ");
                        System.out.println();
                        ChangeDateTime changeDateTime = new ChangeDateTime();
                        changeDateTime.changeDateAndTimeForAppointment(patient.getId());
                        showMenu(patient);
                    }
                    case "4" -> {
                        System.out.println("*** Canceling an appointment ***");
                        CancelingByAppointmentId.cancelAppointment(patient.getId());
                        showMenu(patient);

                    }
                    case "0" -> {
                        System.out.println("Closing the R & G Hospital Program...");
                        Effects.wait(2500);
                        System.out.println("Clearing data...");
                        Effects.wait(1500);
                        System.out.println("Exiting...");
                    }
                    default -> System.out.print("Wrong input! Try again: ");
                }
            } while (!choice.equals("0") && !choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4"));
        }
    }
}
