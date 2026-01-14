package Assignment4;
import java.sql.*;

public class DisplayECSemester7 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/student";
        String user = "root";
        String password = "05052005";

        try {
            Connection con = DriverManager.getConnection(url, user, password);

            String query = """
                SELECT * FROM Students
                WHERE semester = 7 AND branch = 'EC'
            """;

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                        rs.getString("name") + " " +
                        rs.getString("branch") + " " +
                        rs.getInt("semester") + " " +
                        rs.getDouble("percentage") + " " +
                        rs.getInt("year_of_passing")
                );
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
