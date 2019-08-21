
public class Main {

    public static void main(String[] args) {

        // create connection
        DataBaseConnection dataBaseConnection = DataBaseConnection.getInstance();
        Menu.options(dataBaseConnection.getConnection());
    }
}

