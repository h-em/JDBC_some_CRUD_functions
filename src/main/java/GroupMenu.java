import java.sql.Connection;
import java.util.Scanner;

public class GroupMenu {

    public static void displayOption() {
        System.out.println("\n1.Add group from keyBoard.");
        System.out.println("2.Update group.");
        System.out.println("3.Delete group.");
        System.out.println("4.Search for a group.");
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
                    System.out.println("name: ");
                    String name = scanner.nextLine() + scanner.nextLine();
                    GroupMenuHandler.insertNewGroup(connection,name);
                    break;
                case 2:
                    //update
                    System.out.println("Insert new group name:");
                    String newGroupName = scanner.nextLine()+scanner.nextLine();
                    System.out.println("Insert name of that group you want to update: ");
                    String oldGroupName= scanner.nextLine();
                    StudentMenuHandler.updateAStrudent(connection,newGroupName, oldGroupName);
                    break;
                case 3:
                    //delete
                    System.out.println("Insert name of group that you want to delete:");
                    String groupName = scanner.nextLine()+scanner.nextLine();
                    GroupMenuHandler.deleteGroup(connection,groupName);
                    break;
                case 4:
                    //search
                    System.out.println("Group name: ");
                    String nameOfGroup = scanner.nextLine() + scanner.nextLine();
                    GroupMenuHandler.searchForGroup(connection,nameOfGroup);
                    break;
                case 5:
                    //display data
                    GroupMenuHandler.displayTable(connection);
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
            GroupMenu.displayOption();

        } while (option != 0);
    }

}
