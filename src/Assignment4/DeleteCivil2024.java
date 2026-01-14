package Assignment4;

import java.sql.*;

public class DeleteCivil2024 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/student";
        String user = "root";
        String password = "05052005";

        try {
            Connection con = DriverManager.getConnection(url, user, password);

            String query = """
                DELETE FROM Students
                WHERE year_of_passing = 2024 AND branch = 'Civil'
            """;

            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate(query);

            System.out.println(rows + " record(s) deleted");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
