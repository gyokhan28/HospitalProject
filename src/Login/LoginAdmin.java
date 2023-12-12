package Login;

import Admin.AdminMenu;

import java.io.IOException;
import java.util.Scanner;

public class LoginAdmin {

    public static void verify() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter administrator password:");
        String password = sc.nextLine();
        while (!password.equals("ADMIN")) {
            System.out.print("Incorrect Administrator password! Please try again:");
            password = sc.nextLine();
        }
        AdminMenu.showMenu();
        AdminMenu.chooseAnOption();
    }
}
