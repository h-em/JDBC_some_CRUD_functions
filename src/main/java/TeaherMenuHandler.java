import java.sql.*;

public class TeaherMenuHandler {


    public static void displayTable(Connection conn) {
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from teachers");
            while (rs.next()) {
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                int age = rs.getInt("age");
                String type = rs.getString("type");
                System.out.println(first_name + " " + last_name + " " + age + " " + type);
                System.out.println(first_name + " " + last_name + " " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertNewTeacher(Connection conn) {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("insert into teachers (first_name, last_name,age, type)" +
                    " values ('anaa','maria',21,'roama')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void deleteTeacher(Connection conn, String firstNameOfTeacher) {
        String sql = "delete from teachers where first_name = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, firstNameOfTeacher);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateTeacher(Connection conn, String newTeacherName, String oldTeacherName) {
        String sql = "update teachers set first_name = ? where first_name = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newTeacherName);
            stmt.setString(2, oldTeacherName);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertNewTeacher(Connection conn,
                                        String first_name, String last_name, int age, String type) {
        String sql = "insert into teachers (first_name, last_name,age,type) values (?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, first_name);
            stmt.setString(2, last_name);
            stmt.setInt(3, age);
            stmt.setString(4, type);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void searchForTeacher(Connection conn, String teacherName) {
        String sql = "select * from teachers where first_name = ?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, teacherName);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("first_name") + " " +
                        rs.getString("last_name") + " " +
                        rs.getInt("age") + " " +
                        rs.getString("type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
