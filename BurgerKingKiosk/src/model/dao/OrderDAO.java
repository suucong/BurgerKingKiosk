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
            String selectQuery = "SELECT * FROM `burgerkingdb`.`Orders` WHERE `order_id` = ?";

            try (PreparedStatement pstmt = connection.prepareStatement(selectQuery)) {
                pstmt.setInt(1, orderId);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                    	long id = rs.getInt("order_id");
                    	LocalDate orderDate = rs.getDate("order_date").toLocalDate();
                    	int orderdateId = rs.getInt("orderdate_id");
                        int totalPrice = rs.getInt("totalPrice");
                        int isTakeout = rs.getInt("isTakeout");
                        Timestamp orderTime = rs.getTimestamp("order_time");

                        orderVO = new OrderVO(id, orderDate, orderdateId, totalPrice, isTakeout, orderTime.toLocalDateTime());
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
            String insertQuery = "INSERT INTO `burgerkingdb`.`Orders` (`order_id`, `order_date`, `orderdate_id`, `totalPrice`, `isTakeout`, `order_time`) VALUES (?, ?)";

            try (PreparedStatement pstmt = connection.prepareStatement(insertQuery)) {
            	pstmt.setLong(1, vo.getId());
            	pstmt.setObject(2, java.sql.Date.valueOf(vo.getDate())); // Assuming vo.getDate() returns a LocalDate
            	pstmt.setInt(3, vo.getOrderdateId());
                pstmt.setInt(4, vo.getTotalPrice());
                pstmt.setInt(5, vo.getIsTakeout());
                pstmt.setTimestamp(6, Timestamp.valueOf(vo.getOrderTime()));

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
