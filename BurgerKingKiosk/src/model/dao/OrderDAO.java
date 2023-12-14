package model.dao;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jdbc.MysqlJdbc;
import model.dto.OrderDTO;
import model.vo.OrderVO;

public class OrderDAO {
	private static Connection connection = null;
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
    public static void deleteOrderAndOrderMenuByOrderId(long orderId) {
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
    private static void deleteOrderMenuByOrderId(Connection connection, long orderId) throws SQLException {
        String deleteOrderMenuQuery = "DELETE FROM `burgerkingdb`.`OrderMenu` WHERE `order_id` = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(deleteOrderMenuQuery)) {
            pstmt.setLong(1, orderId);
            pstmt.executeUpdate();
        }
    }

    // Delete Order
    private static void deleteOrderById(Connection connection, long orderId) throws SQLException {
        String deleteOrderQuery = "DELETE FROM `burgerkingdb`.`Orders` WHERE `order_id` = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(deleteOrderQuery)) {
            pstmt.setLong(1, orderId);
            pstmt.executeUpdate();
        }
    }

    // 주문 정보 조회
    public static List<OrderVO> getAllOrders() throws SQLException {
    	connection = DriverManager.getConnection(MysqlJdbc.URL, MysqlJdbc.USER, MysqlJdbc.PASSWORD);
        List<OrderVO> orders = new ArrayList<>();
        String query = "SELECT * FROM Orders";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                long orderId = resultSet.getInt("order_id");
                int totalPrice = resultSet.getInt("totalPrice");
                Timestamp timestamp = resultSet.getTimestamp("order_time");
                LocalDateTime orderTime = timestamp.toLocalDateTime();
                OrderVO order = new OrderVO(orderId, totalPrice, orderTime);
                orders.add(order);
            }
        }
        return orders;
    }
    
    //OrderID에 따라서 orderID, totalPrice, orderTime 리턴해주는 메서드
    public static Optional<OrderVO> getOrderByOrderID(long orderId) throws SQLException {
        String query = "SELECT * FROM Orders WHERE order_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, orderId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int totalPrice = resultSet.getInt("totalPrice");
                    // Timestamp를 LocalDateTime으로 변환
                    java.sql.Timestamp timestamp = resultSet.getTimestamp("order_time");
                    java.time.LocalDateTime orderTime = timestamp.toLocalDateTime();

                    OrderVO order = new OrderVO(orderId, totalPrice, orderTime);
                    return Optional.of(order);
                }
            }
        }
        return Optional.empty();
    }
}
