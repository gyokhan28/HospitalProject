import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppointmentAdder {

    public void addNewHour(int iDPatient) throws IOException {
        Patient patient = LoginPatient.returnPatient(iDPatient);
        Scanner sc = new Scanner(System.in);
        String regex = "\\d{2}-\\d{2}-\\d{4}";
        Pattern pattern = Pattern.compile(regex);

        int lastID = returnLastID();
        String examinationType = returnTypeOfExamination();

        String date = "";
        boolean flagForData = false;
        do {
            System.out.print("Enter date of examination in the format DD-MM-YYYY: ");
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

        boolean flagForTime = false;
        int time =0;
        do {
            System.out.print("Enter time of examination:");
            int enteredTime = sc.nextInt();
            if(enteredTime>=900 &&enteredTime<=1700){
                time=enteredTime;
                flagForTime = true;
            }else {
                System.out.println("Invalid time. Please try again.");
            }
        } while (!flagForTime);
            int doctorID = returnDoctorID();
            System.out.println("Last ID" + lastID + " Examination type " + examinationType + " Date " + date + " time " + time + " doctor ID" + doctorID);

            Setup.getAppointmentList().add(new Appointment(returnLastID()+1,patient,examinationType,date,time,LoginDoctor.returnDoctor(doctorID)));
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("Appointments copy.csv", true))) {

                bw.write(returnLastID() + 1 + "," + iDPatient + "," + examinationType + "," + date + "," + time + "," + doctorID);
                bw.newLine();

                System.out.println("File is updated!");
                System.out.println();
            } catch (IOException e) {
                System.err.println("Error writing in file: " + e.getMessage());
            }

        }

        public String returnTypeOfExamination () {
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

        public int returnDoctorID () {
            Scanner sc = new Scanner(System.in);
            System.out.print("Please enter the name of the doctor you wish to see: ");
            String doctorName = sc.next();
            for (Doctor doctor : Setup.getDoctorList()) {
                if (doctorName.equalsIgnoreCase(doctor.getFirstName())) {
                    return doctor.getId();
                }
            }
            System.out.println("There is no doctor with that name. Please, try again");
            return returnDoctorID();
        }

        public static int returnLastID () throws IOException {
            return Setup.getAppointmentList().get(Setup.getAppointmentList().size()-1).getAppointmentId();
        }
    }