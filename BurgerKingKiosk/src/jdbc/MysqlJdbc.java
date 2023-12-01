package jdbc;

import java.sql.*;

public class MysqlJdbc {
	static String DRIVER = "com.mysql.cj.jdbc.Driver";
	static String URL = "jdbc:mysql://localhost:3306/burgerkingdb?serverTimezZone=UTC";
	static String USER = "admin";
	static String PASSWORD = "1210";
	Connection con = null;
	Statement stmt = null;
	
	public MysqlJdbc() {
		try {
			Class.forName(DRIVER);
			System.out.println("driver loading success!");
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.createStatement();
			
			System.out.println("database connection success");
		} catch(Exception e) {
			System.out.println("cannot find driver!");
			System.out.println(e);
		}
	}
	
	public static void main(String args[]) {
		new MysqlJdbc();
	}
}
