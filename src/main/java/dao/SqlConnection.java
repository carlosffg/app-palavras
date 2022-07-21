package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlConnection {
	
	public Connection getSqlConnection() {
		Connection conn = null;
		
		try {
			Class.forName("org.postgresql.Driver");			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(
					"jdbc:postgresql://ec2-54-152-28-9.compute-1.amazonaws.com:5432/de2eqcffklpr2i", "kwsndnbhgencnj", "9c0219c49efd67accd93746238ba920d780a4f177f79e2fb94b9fa646cca4a1a"
					);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

}
