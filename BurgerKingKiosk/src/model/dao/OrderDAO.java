package model.dao;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jdbc.MysqlJdbc;
import model.dto.OrderDTO;
import model.vo.OrderVO;

public class OrderDAO {
	// Select OrderVO
    public static OrderVO select(int orderId) {	// 존재하지 않을 시 null 반환
        OrderVO orderVO = null;

        try (Connection connection = DriverManager.getConnection(MysqlJdbc.URL, MysqlJdbc.USER, MysqlJdbc.PASSWORD)) {
            String selectQuery = "SELECT * FROM `burgerkingdb`.`Orders` WHERE `order_id` = ?";

            try (PreparedStatement pstmt = connection.prepareStatement(selectQuery)) {
                pstmt.setInt(1, orderId);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                    	long id = rs.getInt("order_id");
                        int totalPrice = rs.getInt("totalPrice");
                        Timestamp orderTime = rs.getTimestamp("order_time");

                        orderVO = new OrderVO(id, totalPrice, orderTime.toLocalDateTime());
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderVO;
    }
    
    // Insert Order
    public static int insertOrder(OrderDTO orderDto) {
    	return 1;
    }
    
    // Insert OrderVO
    public static int insertOrderVO(OrderVO vo) {
        int result = 0;

        try (Connection connection = DriverManager.getConnection(MysqlJdbc.URL, MysqlJdbc.USER, MysqlJdbc.PASSWORD)) {
            String insertQuery = "INSERT INTO `burgerkingdb`.`Orders` (`totalPrice`, `order_time`) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement pstmt = connection.prepareStatement(insertQuery)) {
                pstmt.setInt(1, vo.getTotalPrice());
                
                // 현재 시간을 가져와서 LocalDateTime으로 설정
                LocalDateTime currentTime = LocalDateTime.now();
                pstmt.setObject(2, currentTime);

                result = pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

	// Delete OrderVO
	public static int delete(int orderId) {
	    try (Connection connection = DriverManager.getConnection(MysqlJdbc.URL, MysqlJdbc.USER, MysqlJdbc.PASSWORD);
	         Statement stmt = connection.createStatement()) {

	        String deleteQuery = "DELETE FROM `Orders` WHERE `order_id` = " + orderId;

	        int rowsAffected = stmt.executeUpdate(deleteQuery);

	        return rowsAffected;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return 0; // 실패 시 0 반환
	    }
	}
}
