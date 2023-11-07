import java.util.List;
import java.util.Scanner;

public class DoctorMenu {
    private int id;
    private String firstName, lastName;
    private List<Doctor> doctorList;

    public DoctorMenu(int id, String firstName, String lastName, List<Doctor> doctorList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.doctorList = doctorList;
    }
    public void showMenu() {
        System.out.println("Logged in as " + firstName + " " + lastName + "!");
        System.out.println("1.Show reserved appointments for medical examination");
        System.out.println("2.Sort reserved examinations");
        System.out.println("3.Group patients");
        selectMenuOption();
    }
    public void selectMenuOption() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        System.out.print("Enter your choice: ");
        do {
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("1.ShowReserved");
                    break;
                case 2:
                    System.out.println("2.SortReserved");
                    break;
                case 3:
                    System.out.println("3.Group");
                    break;
                default:
                    System.out.print("Wrong input! Try again: ");
            }
        } while (choice != 1 && choice != 2 && choice != 3);
    }
}
