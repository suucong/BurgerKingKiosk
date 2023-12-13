package model.dao;

import java.sql.*;
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
        String insertQuery = "INSERT INTO `burgerkingdb`.`OrderMenu` (`menu_id`, `order_id`) VALUES (?, ?)";
        int result = 0;

        try (Connection connection = DriverManager.getConnection(MysqlJdbc.URL, MysqlJdbc.USER, MysqlJdbc.PASSWORD)) {
            int orderId = insertOrderVO(orderDto.getTotalPrice());

            for (int i = 0; i < orderDto.getOrderMenuVOs().size(); i++) {
                try (PreparedStatement pstmt = connection.prepareStatement(insertQuery)) {
                    pstmt.setInt(1, orderDto.getOrderMenuVOs().get(i).getMenuId());
                    pstmt.setInt(2, orderId);

                    result = pstmt.executeUpdate();
                }
            }

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    // Insert OrderVO
    public static int insertOrderVO(int totalPrice) {
        int result = 0;

        try (Connection connection = DriverManager.getConnection(MysqlJdbc.URL, MysqlJdbc.USER, MysqlJdbc.PASSWORD)) {
            String insertQuery = "INSERT INTO `burgerkingdb`.`Orders` (`totalPrice`, `order_time`) VALUES (?, ?)";

            try (PreparedStatement pstmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setInt(1, totalPrice);

                // 현재 시간을 가져와서 LocalDateTime으로 설정
                LocalDateTime currentTime = LocalDateTime.now();
                pstmt.setObject(2, currentTime);

                result = pstmt.executeUpdate();

                // 생성된 키(Order ID)를 가져오기
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    
    // Delete Order and Order Menu at once
    public static void deleteOrderAndOrderMenuByOrderId(int orderId) {
        try (Connection connection = DriverManager.getConnection(MysqlJdbc.URL, MysqlJdbc.USER, MysqlJdbc.PASSWORD)) {
            // Delete Order Menu
            deleteOrderMenuByOrderId(connection, orderId);

            // Delete Order
            deleteOrderById(connection, orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete Order Menu
    private static void deleteOrderMenuByOrderId(Connection connection, int orderId) throws SQLException {
        String deleteOrderMenuQuery = "DELETE FROM `burgerkingdb`.`OrderMenu` WHERE `order_id` = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(deleteOrderMenuQuery)) {
            pstmt.setInt(1, orderId);
            pstmt.executeUpdate();
        }
    }

    // Delete Order
    private static void deleteOrderById(Connection connection, int orderId) throws SQLException {
        String deleteOrderQuery = "DELETE FROM `burgerkingdb`.`Orders` WHERE `order_id` = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(deleteOrderQuery)) {
            pstmt.setInt(1, orderId);
            pstmt.executeUpdate();
        }
    }
}
