import java.io.IOException;
import java.util.Scanner;

public class Login {
    public void showMainLogin() throws IOException {
        WelcomeLogo.printWelcomeLogo();
        System.out.print("How would you like to sign up as? (1-Doctor/2-Patient):");
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    LoginDoctor loginDoctor = new LoginDoctor();
                    break;
                case "2":
                    LoginPatient loginPatient = new LoginPatient();
                    break;
                default:
                    System.out.print("Wrong input! Try again: ");
                    break;
            }
        } while (!choice.equals("1") && !choice.equals("2"));
    }
}