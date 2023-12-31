package Login;

import Doctor.Doctor;
import Main.Setup;
import Doctor.DoctorMenu;

import java.io.IOException;
import java.util.Scanner;

public class LoginDoctor {
    protected static Scanner sc;

    public static void verify() throws IOException {
        sc = new Scanner(System.in);
        int id = getIdFromUser();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        boolean isFound = false;
        for (Doctor doctor : Setup.getDoctorList()) {
            if (id == doctor.getId() && name.equalsIgnoreCase(doctor.getFirstName())) {
                isFound = true;
                System.out.println("\nLogged in as Dr." + doctor.getFirstName() + " " + doctor.getLastName() + "!");
                DoctorMenu doctorMenu = new DoctorMenu(id);
                doctorMenu.showMenu();
            }
        }
        if (!isFound) {
            System.out.println("Incorrect ID/Name! Try again:");
            verify();
        }
    }

    public static int getIdFromUser() {
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

    public static Doctor returnDoctor(int doctorId){
        for(Doctor doctor: Setup.getDoctorList()){
            if(doctor.getId()==doctorId){
                return doctor;
            }
        }
        return null;
    }
}
