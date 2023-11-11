import java.util.Scanner;

public class Verifier {
    Scanner sc = new Scanner(System.in);

    public int getIdFromUser() {
        System.out.print("Enter ID: ");
        Scanner sc = new Scanner(System.in);
        int id = 0;
        while (true) {
            if (sc.hasNextInt()) {
                id = sc.nextInt();
                break;
            } else {
                System.out.print("You must enter an integer! Try again:");
                sc.next();
            }
        }
        return id;
    }
    public String getNameFromUser() {
        System.out.print("Enter name: ");
        return sc.nextLine();
    }
}
