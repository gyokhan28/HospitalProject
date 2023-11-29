import java.io.IOException;
import java.util.*;

public class AppointmentSorter {
    private final int personalDoctorId;
    private final List<Doctor> doctorList;
    private final List<Appointment> appointmentList;
    private final List<Patient> patientList;
    private Scanner sc;
    private String sortingType;
    private final String docFirstName;
    private final String docLastName;

    public void setOrderType(String orderType) {
        this.sortingType = orderType;
    }

    public AppointmentSorter(int id, List<Doctor> doctorList, String firstName, String lastName) throws IOException {
        appointmentList = AppointmentsFileManager.loadAppointments();
        patientList = PatientFileManager.loadPatients();
        this.doctorList = doctorList;
        this.personalDoctorId = id;
        docFirstName = firstName;
        docLastName = lastName;
    }

    public void sortChoice() throws IOException {
        System.out.println("\nChoose sorting order:");
        System.out.print("1.Ascending / 2.Descending order (or 0 to go to the Main menu):");
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            choice = sc.next();
            switch (choice) {
                case "0":
                    DoctorMenu doctorMenu = new DoctorMenu(personalDoctorId, docFirstName, docLastName, doctorList);
                    doctorMenu.showMenu();
                case "1":
                    setOrderType("Ascending");
                    handleMenuChoice(choice);
                    break;
                case "2":
                    setOrderType("Descending");
                    handleMenuChoice(choice);
                    break;
                default:
                    System.out.print("Wrong input! Try again: ");
            }
        } while (!choice.equals("1") && !choice.equals("2"));
    }

    public String takeId() {
        sc = new Scanner(System.in);
        System.out.print("Enter ID:");
        String id = sc.nextLine();
        boolean flag = false;
        if (id.isEmpty()) {
            return "";
        } else {
            try {
                int testId = Integer.parseInt(id);
                return id;
            } catch (NumberFormatException e){
                System.out.println("Invalid ID!");
                return takeId();
            }
        }
    }

    public void handleMenuChoice(String choice) throws IOException {
        System.out.println("\n1.Sort by patient name");
        System.out.println("2.Sort by appointment hour");
        System.out.println("3.Sort by patient ID");
        System.out.print("\nEnter your choice:");
        sc = new Scanner(System.in);
        String sortChoice = sc.next();
        String id;
        do {
            switch (sortChoice) {
                case "1":
                    id = takeId();
                    if (!id.isEmpty()) {
                        printSortedByNameAppointments(Integer.parseInt(id), sortingType);
                    } else {
                        System.out.println("Showing your appointments sorted by patient name:");
                        printSortedByNameAppointments(personalDoctorId, sortingType);
                    }
                    sortChoice();
                    break;
                case "2":
                    id = takeId();
                    if (!id.isEmpty()) {
                        printSortedByHourAppointments(Integer.parseInt(id), sortingType);
                    } else {
                        System.out.println("Showing your appointment sorted by hour:");
                        printSortedByHourAppointments(personalDoctorId, sortingType);
                    }
                    sortChoice();
                    break;
                case "3":
                    id = takeId();
                    if (!id.isEmpty()) {
                        printSortedByPatientID(Integer.parseInt(id), sortingType);
                    } else {
                        System.out.println("Showing your appointment sorted by patient ID:");
                        printSortedByPatientID(personalDoctorId, sortingType);
                    }
                    sortChoice();
                    break;
                default:
                    System.out.print("Wrong input! Try again: ");
                    choice = sc.next();
            }
        } while (!choice.equals("1") && !choice.equals("2"));
    }

    public static String formatHour(int intHour) {
        String hour = String.valueOf(intHour);
        String minutes = hour.substring(hour.length() - 2);
        String hours = hour.substring(0, hour.length() - 2);
        return hours + ":" + minutes;
    }

    public List<Appointment> getDoctorAppointments(int docId) {
        List<Appointment> currentDocAppointments = new ArrayList<>();
        for (Appointment a : appointmentList) {
            if (a.getDoctorId() == docId) {
                currentDocAppointments.add(a);
            }
        }
        return currentDocAppointments;
    }

    public void printSortedByNameAppointments(int docId, String orderType) {
        Collections.sort(patientList);
        if (orderType.equals("Descending")) {
            Collections.reverse(patientList);
        }
        boolean isFound = false;
        for (Patient patient : patientList) {
            for (Appointment appointment : appointmentList) {
                if (patient.getId() == appointment.getPatientId() && appointment.getDoctorId() == docId) {
                    isFound = true;
                    System.out.print("Patient name:" + patient.getFirstName() + " " + patient.getLastName());
                    System.out.println(" | Appointment on:" + appointment.getDate() + ", at:" + formatHour(appointment.getTime()) + " (Examination:" + appointment.getTypeOfExamination() + ")");
                }
            }
        }
        if (!isFound) {
            System.out.println("Doctor with ID " + docId + " has no appointments!");
        }
    }

    public void printSortedByHourAppointments(int docId, String sortingType) {
        List<Appointment> currentDocAppointments = getDoctorAppointments(docId);
        if (!currentDocAppointments.isEmpty()) {
            Comparator<Appointment> appointmentHourComparator = Comparator.comparing(Appointment::getTime);
            currentDocAppointments.sort(appointmentHourComparator);
            if (sortingType.equals("Ascending")) {
                for (Appointment currentDocAppointment : currentDocAppointments) {
                    System.out.println(currentDocAppointment);
                }
            } else {
                for (int i = currentDocAppointments.size() - 1; i >= 0; i--) {
                    System.out.println(currentDocAppointments.get(i));
                }
            }
        } else {
            System.out.println("The doctor with ID " + docId + " has no appointments!");
        }
    }

    public void printSortedByPatientID(int docId, String sortingType) {
        List<Appointment> currentDocAppointments = getDoctorAppointments(docId);
        if (!currentDocAppointments.isEmpty()) {
            Comparator<Appointment> patientIdComparator = Comparator.comparing(Appointment::getPatientId);
            currentDocAppointments.sort(patientIdComparator);
            if (sortingType.equals("Ascending")) {
                currentDocAppointments.forEach(System.out::println);
            } else {
                for (int i = currentDocAppointments.size() - 1; i >= 0; i--) {
                    System.out.println(currentDocAppointments.get(i));
                }
            }
        } else {
            System.out.println("The doctor with ID " + docId + " has no appointments!");
        }
    }
}