import java.sql.*;

public class GroupMenuHandler {

    public static void displayTable(Connection conn) {
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from `groups`");
            while (rs.next()) {
                String first_name = rs.getString("name");
                System.out.println(first_name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteGroup(Connection conn, String groupName){
        String sql = "delete from `groups` where name = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString( 1,groupName);
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void updateGroup(Connection conn, String newName, String oldName){
        String sql = "update `groups` set name = ? where name = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,newName);
            stmt.setString(2,oldName);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertNewGroup(Connection conn,String name){
        String sql = "insert into `groups` (name) values (?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,name);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void searchForGroup(Connection conn, String groupName){
        String sql = "select * from `groups` where name = ?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,groupName);
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
