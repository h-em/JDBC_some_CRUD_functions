import java.sql.*;
import java.util.Scanner;

public class Menu {

    public static void displayOption() {
        System.out.println("\n1.CRUD Students.");
        System.out.println("2.CRUD Teachers.");
        System.out.println("3.CRUD Groups.");
        System.out.println("0. Exit!\n");
    }

    public static void options(Connection connection){

        int option;
        Menu.displayOption();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Choose one option....");

            option = scanner.nextInt();

            switch (option) {
                case 0:
                    System.out.println("Exiting...");
                    break;
                case 1:
                    StudentMenu.options(connection);
                    break;
                case 2:
                    TeacherMenu.options(connection);
                    break;
                case 3:
                    GroupMenu.options(connection);
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
            Menu.displayOption();

        }while(option>0);
    }
}
