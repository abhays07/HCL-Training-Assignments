package Assignment4;

import java.sql.*;

public class IncreasePercentageCSE {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/student";
        String user = "root";
        String password = "05052005";

        try {
            Connection con = DriverManager.getConnection(url, user, password);

            String query = """
                UPDATE Students
                SET percentage = percentage + (percentage * 0.05)
                WHERE branch = 'CSE'
            """;

            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate(query);

            System.out.println(rows + " CSE student(s) updated");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
