import java.io.IOException;
import java.util.Scanner;

public class LoginAdmin {

    protected static void verify() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter administrator password:");
        String password = sc.nextLine();

        if (password.equals("ADMIN")) {
            System.out.println("Logged in as Administrator!");
            AdminMenu.showMenu();
        } else {
            System.out.println("Incorrect Administrator password! Please try again!");
            verify();
        }
    }
}
