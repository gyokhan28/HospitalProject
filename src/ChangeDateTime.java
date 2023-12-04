import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangeDateTime {
    List<Appointment> appointmentsList;
    PreviewOfRecordedHours previewOfRecordedHours = new PreviewOfRecordedHours();
    //AppointmentsFileManager appointmentsFileManager;

    public ChangeDateTime() throws IOException {
        this.appointmentsList = AppointmentsFileManager.loadAppointments("Appointments.csv");
    }

    public void changeDateAnaTimeForAppointment(int patientID) throws IOException {
        Scanner sc = new Scanner(System.in);

        String regex = "\\d{2}-\\d{2}-\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        String date = "";
        boolean flagForData = false;

        previewOfRecordedHours.showRecordedHours(patientID);

        System.out.print("Enter AppointmentID you want to change the date of: ");
        int appointmentId = Integer.parseInt(sc.next());
        sc.nextLine();
        boolean isFoundIDIsCorrect = checkIfTheIDIsCorrect(appointmentId, patientID);
        if (isFoundIDIsCorrect) {
            for (Appointment appointment : appointmentsList) {
                if (appointmentId == appointment.getAppointmentId()) {
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
                                System.out.println("Invalid Data. Please try again.");
                            }

                        } else {
                            System.out.println("Invalid date format. Please try again.");
                        }
                    } while (!flagForData);
                    appointment.setDate(date);
                    AppointmentsFileManager.writeAppointments(appointmentsList, "Appointments.csv");
                    System.out.println("Yor new date is updated!");
                }
            }
                } else {
                    System.out.println("Wrong Input!");
                    System.out.println("Your reserved appointment times are:");
                    System.out.println();
                    changeDateAnaTimeForAppointment(patientID);
                }
            }
            public boolean checkIfTheIDIsCorrect ( int appointmentID, int patientID) throws IOException {
                boolean isFound = false;
                List<Appointment> appointmentsByPatient = previewOfRecordedHours.returnAppointmentListByPatientID(patientID);
                if (!appointmentsByPatient.isEmpty()) {
                    for (Appointment appointment : appointmentsByPatient) {
                        if (appointmentID == appointment.getAppointmentId()) {
                            isFound = true;
                        }
                    }
                }
                return isFound;
            }
        }

