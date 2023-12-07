import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        Setup.loadLists();
        System.out.print("How would you like to sign up as? (1-Doctor/2-Patient):");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        UserLoginSelector.showSelector(sc, choice);
        System.out.println();
    }
}