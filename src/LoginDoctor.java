import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class LoginDoctor {
    protected List<Doctor> doctorList;
    protected Scanner sc;

    public LoginDoctor() throws IOException {
        doctorList = DoctorFileManager.loadDoctors("Doctors.csv");
        sc = new Scanner(System.in);
    }

    protected void verifyUserIdentity() throws IOException {
        int id = getIdFromUser();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        boolean isFound = false;
        for (Doctor doctor : doctorList) {
            if (id == doctor.getId() && name.equalsIgnoreCase(doctor.getFirstName())) {
                isFound = true;
                DoctorMenu doctorMenu = new DoctorMenu(doctor.getId(), doctor.getFirstName(), doctor.getLastName(), doctorList);
                doctorMenu.showMenu();
            }
        }
        if (!isFound) {
            System.out.println("Incorrect ID/Name! Try again:");
            verifyUserIdentity();
        }
    }

    public int getIdFromUser() {
        System.out.print("Enter ID: ");
        Scanner sc = new Scanner(System.in);
        int id;
        while (true) {
            if (sc.hasNextInt()) {
                id = sc.nextInt();
                break;
            } else {
                System.out.print("You must enter an integer! Try again:");
                sc.next();
            }
        }
        return id;
    }
}
