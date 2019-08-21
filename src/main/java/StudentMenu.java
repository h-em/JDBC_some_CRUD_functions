import java.sql.Connection;
import java.util.Scanner;

public class StudentMenu {


    public static void displayOption() {
        System.out.println("\n1.Add student from keyBoard.");
        System.out.println("2.Update student.");
        System.out.println("3.Delete student.");
        System.out.println("4.Search for a student.");
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
                    String f_name = scanner.nextLine() + scanner.nextLine();
                    System.out.println("last_name: ");
                    String l_name = scanner.nextLine();
                    System.out.println("age: ");
                    int age = scanner.nextInt();
                    StudentMenuHandler.insertNewStudent(connection, f_name, l_name, age);
                    break;
                case 2:
                    //update
                    System.out.println("Insert new student name:");
                    String newStudentName = scanner.nextLine()+scanner.nextLine();
                    System.out.println("Insert name of that student you want to update: ");
                    String oldStudentName = scanner.nextLine();
                    StudentMenuHandler.updateAStrudent(connection,newStudentName, oldStudentName);
                    break;
                case 3:
                    //delete
                    System.out.println("Insert first name of student that you want to delete:");
                    String studentFirstName = scanner.nextLine()+scanner.nextLine();
                    StudentMenuHandler.deleteStudent(connection,studentFirstName);
                    break;
                case 4:
                    //search
                    System.out.println("Student name: ");
                    String name = scanner.nextLine() + scanner.nextLine();
                    StudentMenuHandler.searchForStudent(connection, name);
                    break;
                case 5:
                    //display data
                    StudentMenuHandler.displayTable(connection);
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
            StudentMenu.displayOption();

        } while (option != 0);


    }
}
