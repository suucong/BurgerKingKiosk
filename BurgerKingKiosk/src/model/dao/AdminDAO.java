package model.dao;

import java.sql.*;
import jdbc.MysqlJdbc;
import jdbc.MysqlJdbc.*;

public class AdminDAO {
	public static boolean isAdminTableNotEmpty() {	// Admin 테이블에 데이터가 있는지 없는지를 반환하는 메서드
        try (Connection connection = DriverManager.getConnection(MysqlJdbc.URL, MysqlJdbc.USER, MysqlJdbc.PASSWORD);
             Statement statement = connection.createStatement()) {

            String query = "SELECT COUNT(*) FROM Admin";
            ResultSet resultSet = statement.executeQuery(query);

            // Move to the first row of the result set
            resultSet.next();

            // Get the count of rows
            int rowCount = resultSet.getInt(1);

            // Check if the count is greater than 0
            return rowCount > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Handle the exception or log it accordingly
        }
    }
	
	public static String getAdminPassword(int adminId) {	// Admin의 기본키를 기준으로 password를 반환하는 메서드
        try {
            Connection connection = DriverManager.getConnection(MysqlJdbc.URL, MysqlJdbc.USER, MysqlJdbc.PASSWORD);
            Statement stmt = connection.createStatement();

            String query = "SELECT admin_password FROM Admin WHERE admin_id = " + adminId;
            ResultSet rs = stmt.executeQuery(query);

            // Check if a result was found
            if (rs.next()) {
                String adminPassword = rs.getString("admin_password");
                
                return adminPassword;
            } else {
                System.out.println("Admin not found");
            }

            // Close resources
            rs.close();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
	
	public static void insertAdmin(String password) {
        try {
        	Connection connection = DriverManager.getConnection(MysqlJdbc.URL, MysqlJdbc.USER, MysqlJdbc.PASSWORD);
            Statement stmt = connection.createStatement();

            // Query to insert data into Admin table
            String query = "INSERT INTO Admin (admin_password) VALUES ('" + password + "')";
            int rowsAffected = stmt.executeUpdate(query);

            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Failed to insert data.");
            }

            // Close resources
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
	}
}
	
