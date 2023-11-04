import java.util.Scanner;

public class Login {
    public void showMainLogin() {
        WelcomeLogo.printWelcomeLogo();
        System.out.print("How would you like to sign up as? (1-Doctor/2-Patient):");
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    LoginDoctor loginDoctor = new LoginDoctor();
                    loginDoctor.verify();
                    break;
                case "2":
                    LoginPatient loginPatient = new LoginPatient();
                    loginPatient.printMessage();
                    break;
                default:
                    System.out.print("Wrong input! Try again: ");
                    break;
            }
        } while (!choice.equals("1") && !choice.equals("2"));
    }
}