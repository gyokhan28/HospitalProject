import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LoginDoctor {
    DoctorFileManager doctorFileManager;
    protected List<Doctor> doctorList;

    public LoginDoctor() throws IOException {
        doctorFileManager = new DoctorFileManager();
        doctorList = doctorFileManager.loadDoctors("Doctors.csv");
        verify();
    }

    protected void verify() {
        System.out.println("Enter doctor ID:");
        Scanner sc = new Scanner(System.in);
        int id = 0;
        boolean formatFlag = false;
        while (!formatFlag) {
            try {
                id = sc.nextInt();
                formatFlag = true;
            } catch (InputMismatchException e) {
                System.out.println("You must enter an integer!");
                sc.next();
            }
        }
        System.out.println("Enter name:");
        sc.nextLine();
        String name = sc.nextLine();
    }
}
