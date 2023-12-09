package model.dao;

import java.sql.*;
import java.time.LocalDate;

import jdbc.MysqlJdbc;
import model.vo.OrderVO;

public class OrderDAO {
	// Select OrderVO
    public static OrderVO select(int orderId) {	// 존재하지 않을 시 null 반환
        OrderVO orderVO = null;

        try (Connection connection = DriverManager.getConnection(MysqlJdbc.URL, MysqlJdbc.USER, MysqlJdbc.PASSWORD)) {
            String selectQuery = "SELECT * FROM `burgerkingdb`.`Order` WHERE `order_id` = ?";

            try (PreparedStatement pstmt = connection.prepareStatement(selectQuery)) {
                pstmt.setInt(1, orderId);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                    	LocalDate orderDate = rs.getDate("order_date").toLocalDate();
                        int totalPrice = rs.getInt("totalPrice");
                        Timestamp orderTime = rs.getTimestamp("order_time");

                        orderVO = new OrderVO(orderDate, orderId, totalPrice, orderTime.toLocalDateTime());
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderVO;
    }
    
	// Insert OrderVO
	public static int insert(OrderVO vo) {
		int result = 0;
		
		try (Connection connection = DriverManager.getConnection(MysqlJdbc.URL, MysqlJdbc.USER, MysqlJdbc.PASSWORD)) {
            String insertQuery = "INSERT INTO `burgerkingdb`.`Order` (`order_date`, `order_id`, `totalPrice`, `order_time`) VALUES (?, ?)";

            try (PreparedStatement pstmt = connection.prepareStatement(insertQuery)) {
            	pstmt.setObject(1, java.sql.Date.valueOf(vo.getDate())); // Assuming vo.getDate() returns a LocalDate
                pstmt.setInt(2, vo.getId());
                pstmt.setInt(3, vo.getTotalPrice());
                pstmt.setTimestamp(4, Timestamp.valueOf(vo.getOrderTime()));

                result = pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
	}
	
	// Update OrderVO
	public static int update(int orderId, OrderVO updatedOrder) {
	    try (Connection connection = DriverManager.getConnection(MysqlJdbc.URL, MysqlJdbc.USER, MysqlJdbc.PASSWORD)) {
	        String updateQuery = "UPDATE `burgerkingdb`.`Order` SET `totalPrice` = ?, `order_time` = ? WHERE `order_id` = ?";

	        try (PreparedStatement pstmt = connection.prepareStatement(updateQuery)) {
	            pstmt.setInt(1, updatedOrder.getTotalPrice());
	            pstmt.setTimestamp(2, Timestamp.valueOf(updatedOrder.getOrderTime()));
	            pstmt.setInt(3, orderId);

	            return pstmt.executeUpdate();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return 0; // 실패 시 0 반환
	    }
	}
	
	// Delete OrderVO
	public static int delete(int orderId) {
	    try (Connection connection = DriverManager.getConnection(MysqlJdbc.URL, MysqlJdbc.USER, MysqlJdbc.PASSWORD);
	         Statement stmt = connection.createStatement()) {

	        String deleteQuery = "DELETE FROM `Order` WHERE `order_id` = " + orderId;

	        int rowsAffected = stmt.executeUpdate(deleteQuery);

	        return rowsAffected;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return 0; // 실패 시 0 반환
	    }
	}
}
