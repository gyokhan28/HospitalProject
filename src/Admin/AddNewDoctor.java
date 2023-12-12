package Admin;

import Doctor.Doctor;
import Main.Setup;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import Doctor.Specialities;
import FileManagement.DoctorFileManager;

public class AddNewDoctor {

    public static void addNewDoctor() throws IOException {
        List<Doctor> newDoctorsList = Setup.getDoctorList();
        Scanner sc = new Scanner(System.in);
        Doctor newDoctor = new Doctor();
        newDoctor.setId(returnLastID() + 1);
        System.out.print("Enter First name of the doctor:");
        String firstName = sc.next();
        newDoctor.setFirstName(firstName);
        System.out.print("Enter Last name of the doctor:");
        String lastName = sc.next();
        newDoctor.setLastName(lastName);
        System.out.print("Enter speciality:");
        String speciality = sc.next();
        while (true) {
            try {
                speciality = speciality.toUpperCase();
                Specialities.valueOf(speciality);
                break;
            } catch (IllegalArgumentException ignored) {
                System.out.print("There is no such speciality, try again:");
            }
            speciality = sc.next();
        }
        newDoctor.setSpeciality(Specialities.valueOf(speciality.toUpperCase()));
        newDoctorsList.add(newDoctor);
        writeDoctorInFile(newDoctorsList);
        System.out.println("Тhe new doctor (" + newDoctor.getFirstName() + " " + newDoctor.getLastName() + ") was added successfully!");
        System.out.println();
    }

    public static int returnLastID() {
        return Setup.getDoctorList().get(Setup.getDoctorList().size() - 1).getId();
    }

    private static void writeDoctorInFile(List<Doctor> doctors) throws IOException {
        DoctorFileManager.writeDoctors(doctors, "Doctors.csv");
    }
}
