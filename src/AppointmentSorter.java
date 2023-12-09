import java.io.IOException;
import java.util.*;

public class AppointmentSorter {
    private final int personalDoctorId;
    private Scanner sc;
    private String sortingType;

    private DoctorMenu doctorMenu;

    public DoctorMenu getDoctorMenu() {
        return doctorMenu;
    }

    public void setDoctorMenu(DoctorMenu doctorMenu) {
        this.doctorMenu = doctorMenu;
    }

    public void setOrderType(String orderType) {
        this.sortingType = orderType;
    }

    public AppointmentSorter(int id, DoctorMenu doctorMenu) {
        this.personalDoctorId = id;
        setDoctorMenu(doctorMenu);
    }

    public void sortChoice() throws IOException {
        System.out.println("\nChoose sorting order:");
        System.out.print("1.Ascending / 2.Descending order (or 0 to go to the Main menu):");
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            choice = sc.next();
            switch (choice) {
                case "0" -> {
                    DoctorMenu doctorMenu = new DoctorMenu(personalDoctorId);
                    doctorMenu.showMenu();
                }
                case "1" -> {
                    setOrderType("Ascending");
                    handleMenuChoice();
                }

                case "2" -> {
                    setOrderType("Descending");
                    handleMenuChoice();
                }
                default -> System.out.print("Wrong input! Try again: ");
            }
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("0"));
    }

    public String takeId() {
        sc = new Scanner(System.in);
        System.out.print("Enter Doctor ID (or press Enter to see yours):");
        String id = sc.nextLine();
        if (id.isEmpty()) {
            return "";
        } else {
            try {
                Integer.parseInt(id);
                return id;
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID!");
                return takeId();
            }
        }
    }

    public void handleMenuChoice() throws IOException {
        String redColor = "\u001B[31m", resetColor = "\u001B[0m";
        System.out.println("\n" + redColor + sortingType + resetColor + " sorting is selected.");
        System.out.print("\n1.Sort by patient name\n2.Sort by appointment hour\n3.Sort by patient ID\nEnter your choice:");
        sc = new Scanner(System.in);
        String id;
        String sortChoice;
        do {
            sortChoice = sc.nextLine();

            switch (sortChoice) {
                case "1":
                    id = takeId();
                    if (!id.isEmpty()) {
                        printSortedByNameAppointments(Integer.parseInt(id), sortingType);
                    } else {
                        System.out.println("\nShowing your appointments sorted by patient name:");
                        printSortedByNameAppointments(personalDoctorId, sortingType);
                    }
                    sortChoice();
                    break;
                case "2":
                    id = takeId();
                    if (!id.isEmpty()) {
                        printSortedByHourAppointments(Integer.parseInt(id), sortingType);
                    } else {
                        System.out.println("\nShowing your appointment sorted by hour:");
                        printSortedByHourAppointments(personalDoctorId, sortingType);
                    }
                    sortChoice();
                    break;
                case "3":
                    id = takeId();
                    if (!id.isEmpty()) {
                        printSortedByPatientID(Integer.parseInt(id), sortingType);
                    } else {
                        System.out.println("\nShowing your appointment sorted by patient ID:");
                        printSortedByPatientID(personalDoctorId, sortingType);
                    }
                    sortChoice();
                    break;
                default:
                    System.out.print("Wrong input! Try again: ");
            }
        } while (!sortChoice.equals("1") && !sortChoice.equals("2") && !sortChoice.equals("3"));
    }

    public static String formatHour(int intHour) {
        String hour = String.valueOf(intHour);
        String minutes = hour.substring(hour.length() - 2);
        String hours = hour.substring(0, hour.length() - 2);
        return hours + ":" + minutes;
    }

    public List<Appointment> getDoctorAppointments(int docId) {
        List<Appointment> currentDocAppointments = new ArrayList<>();
        for (Appointment a : Setup.getAppointmentList()) {
            if (a.getDoctor().getId() == docId) {
                currentDocAppointments.add(a);
            }
        }
        return currentDocAppointments;
    }

    public void printSortedByNameAppointments(int docId, String orderType) {
        Collections.sort(Setup.getPatientList());
        if (orderType.equals("Descending")) {
            Collections.reverse(Setup.getPatientList());
        }
        boolean isFound = false;
        for (Patient patient : Setup.getPatientList()) {
            for (Appointment appointment : Setup.getAppointmentList()) {
                if (patient.getId() == appointment.getPatient().getId() && appointment.getDoctor().getId() == docId) {
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