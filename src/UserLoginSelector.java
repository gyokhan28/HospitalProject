import java.io.IOException;
import java.util.Scanner;

public class UserLoginSelector {

    public static void showSelector(Scanner sc, String choice) throws IOException {

            switch (choice) {
                case "1" -> {
                    LoginDoctor.verifyUserIdentity();

                }
                case "2" -> {
                    LoginPatient.verify();

                }
                case "ADMIN" -> {
                    LoginAdmin.verify();

                }
                default -> {
                    System.out.print("Wrong input! Try again: ");
                    String newChoice = sc.nextLine();
                    UserLoginSelector.showSelector(sc,newChoice);

                }
            }
    }
}