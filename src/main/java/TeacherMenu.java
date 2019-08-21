import java.sql.Connection;
import java.util.Scanner;

public class TeacherMenu {


    public static void displayOption() {
        System.out.println("\n1.Add teacher from keyBoard.");
        System.out.println("2.Update teacher.");
        System.out.println("3.Delete teacher.");
        System.out.println("4.Search for a teacher.");
        System.out.println("5.Print data.");
        System.out.println("0. Exit!\n");
    }


    public static void options(Connection connection) {

        int option;
        displayOption();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Choose one option....");

            option = scanner.nextInt();

            switch (option) {
                case 0:
                    System.out.println("Exiting...");
                    break;
                case 1:
                    //insert
                    System.out.println("first_name: ");
                    String first_name = scanner.nextLine() + scanner.nextLine();
                    System.out.println("last_name: ");
                    String last_name = scanner.nextLine();
                    System.out.println("age: ");
                    int age = scanner.nextInt();
                    System.out.println("type: ");
                    String type = scanner.nextLine();
                    TeaherMenuHandler.insertNewTeacher(connection, first_name, last_name, age, type);
                    break;
                case 2:
                    //update
                    System.out.println("Insert new teacher name:");
                    String newTeacherName = scanner.nextLine()+scanner.nextLine();
                    System.out.println("Insert name of that teacher you want to update: ");
                    String oldTeacherName = scanner.nextLine();
                    TeaherMenuHandler.updateTeacher(connection,newTeacherName, oldTeacherName);
                    break;
                case 3:
                    //delete
                    System.out.println("Insert first name of teacher that you want to delete:");
                    String firstNameOfTeacher = scanner.nextLine()+scanner.nextLine();
                    TeaherMenuHandler.deleteTeacher(connection,firstNameOfTeacher);
                    break;
                case 4:
                    //search
                    System.out.println("Teacher name: ");
                    String name = scanner.nextLine() + scanner.nextLine();
                    TeaherMenuHandler.searchForTeacher(connection, name);
                    break;
                case 5:
                    //display data
                    TeaherMenuHandler.displayTable(connection);
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
            TeacherMenu.displayOption();

        } while (option != 0);
    }
}
