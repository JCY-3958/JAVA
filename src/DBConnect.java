import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private Connection conn;
	
	public DBConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://222.119.100.89:3382/shopping",
					"minishop",
					"2m2w"
					);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void startDB() {
		
	}
}
