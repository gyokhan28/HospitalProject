import java.io.IOException;
import java.util.Scanner;

public class UserLoginSelector {

    public static void showSelector() throws IOException {
        System.out.print("How would you like to sign up as? (1-Doctor/2-Patient):");
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            choice = sc.nextLine();
            switch (choice) {
                case "1" -> {
                    LoginDoctor loginDoctor = new LoginDoctor();
                    loginDoctor.verifyUserIdentity();
                }
                case "2" -> {
                    LoginPatient loginPatient = new LoginPatient();
                }
                case "ADMIN" -> {
                    LoginAdmin loginAdmin = new LoginAdmin();
                }
                default -> System.out.print("Wrong input! Try again: ");
            }
        } while (!choice.equals("1") && !choice.equals("2")&&!choice.equals("ADMIN"));
    }
}