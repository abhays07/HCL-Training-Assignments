package Assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreateAndInsertStudents {
	public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student";
		String user = "root";
		String password = "05052005";
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			Statement statement = connection.createStatement();

			String createtable = """
					        CREATE TABLE IF NOT EXISTS Students (
					        id INT PRIMARY KEY,
					        name VARCHAR(50),
					        branch VARCHAR(20),
					        semester INT,
					        percentage DOUBLE,
					        year_of_passing INT
					    )
					""";
			statement.execute(createtable);

			String insertData = """
					    INSERT INTO Students VALUES
					    (1, 'Aman', 'CSE', 7, 78.5, 2024),
					    (2, 'Riya', 'EC', 7, 82.0, 2025),
					    (3, 'Rahul', 'Civil', 8, 70.0, 2024),
					    (4, 'Neha', 'CSE', 6, 75.0, 2025)
					""";
			statement.execute(insertData);

			System.out.println("Table created successfully");
			
			String query = """
	                SELECT * FROM Students
	            """;
			ResultSet rs=statement.executeQuery(query);
			 System.out.println("ID  Name   Branch  Sem  %age  Year");
	            System.out.println("----------------------------------");

	            while (rs.next()) {
	                System.out.println(
	                        rs.getInt("id") + "   " +
	                        rs.getString("name") + "   " +
	                        rs.getString("branch") + "   " +
	                        rs.getInt("semester") + "   " +
	                        rs.getDouble("percentage") + "   " +
	                        rs.getInt("year_of_passing")
	                );
	            }
			
			
			//while(r)
			
			connection.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
