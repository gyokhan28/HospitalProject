import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        Setup.loadLists();
        System.out.println("\t\t\tWelcome to the R & G Hospital!");
        Effects.wait(500);
        System.out.print("How would you like to sign up as? (1-Doctor/2-Patient):");
        UserLoginSelector.showSelector();
        System.out.println();
    }
}