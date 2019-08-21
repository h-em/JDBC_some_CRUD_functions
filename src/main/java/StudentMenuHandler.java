import java.sql.*;

public class StudentMenuHandler {


    public static void displayTable(Connection conn) {
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from students");
            while (rs.next()) {
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                int age = rs.getInt("age");
                System.out.println(first_name + " " + last_name + " " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertNewStudent(Connection conn){
        try (Statement stmt = conn.createStatement()){
            stmt.executeUpdate("insert into students (first_name, last_name,age) values ('anaa','maria',21)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void deleteStudent(Connection conn, String studentFirstName){
        String sql = "delete from students where first_name = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString( 1,studentFirstName);
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void updateAStrudent(Connection conn, String newStudentName, String oldStudentName){
        String sql = "update students set first_name = ? where first_name = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,newStudentName);
            stmt.setString(2,oldStudentName);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertNewStudent(Connection conn,
                                        String first_name, String last_name, int age){
        String sql = "insert into students (first_name, last_name,age) values (?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,first_name);
            stmt.setString(2,last_name);
            stmt.setInt(3,age);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void searchForStudent(Connection conn, String studentName){
        String sql = "select * from students where first_name = ?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,studentName);
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                System.out.println(rs.getString("first_name") + " "+
                        rs.getString("last_name") + " "+
                        rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
