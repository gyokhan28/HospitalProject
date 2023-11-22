import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginAdmin {
    public LoginAdmin() throws IOException {
        verify();
    }

    protected void verify() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter administrator password:");
        String password = sc.nextLine();

        if (password.equals("ADMIN")){
            AdminMenu adminMenu = new AdminMenu();
            return;
        }
        System.out.println("Incorrect Administrator password! Please try again!");
        verify();
    }
}
