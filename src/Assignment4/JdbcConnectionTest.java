package Assignment4;

import java.sql.Connection;
import java.sql.DriverManager;


public class JdbcConnectionTest {
	  public static void main(String[] args)  {

	        String url = "jdbc:mysql://localhost:3306/student";
	        String user = "root";
	        String password = "05052005";

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection(url, user, password);

	            if (con != null) {
	                System.out.println("Connection Successful");
	            }

	            con.close();
	        } catch (Exception e) {
	            System.out.println("Unable to connect");
	            e.printStackTrace();
	        }
	        
	    }
}
