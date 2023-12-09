import java.io.IOException;
import java.util.Scanner;

public class UserLoginSelector {

    public static void showSelector() throws IOException {
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        switch (choice) {
            case "1" -> LoginDoctor.verify();
            case "2" -> LoginPatient.verify();
            case "ADMIN" -> LoginAdmin.verify();
            default -> {
                System.out.print("Wrong input! Try again: ");
                UserLoginSelector.showSelector();
            }
        }
    }
}