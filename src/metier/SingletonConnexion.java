package metier;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnexion {
	
	private static Connection connection;
	
	static {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_jee","root","s07874501");
		} catch (Exception e) {
			// TODO Auto-generated catch block  
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}
	

}
