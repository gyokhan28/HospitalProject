import java.util.Scanner;

public class LoginDoctor {
    private int id;
    private String name;
    Menu m1 = new Menu();
    protected void verify() {
        System.out.println("Enter ID:");
        Scanner sc = new Scanner(System.in);
        id = sc.nextInt();
        System.out.println("Enter name:");
        sc.nextLine();
        name = sc.nextLine();
        showMenu();
    }
    public void showMenu(){
        m1.showMenu();
    }
}
