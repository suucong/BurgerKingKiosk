package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import jdbc.MysqlJdbc;

import java.time.LocalDateTime;

import model.vo.OrdersVO;

public class OrdersDAO {
    private static Connection connection = null;
    
    static {
        try {
            Class.forName(MysqlJdbc.DRIVER);
            connection = DriverManager.getConnection(MysqlJdbc.URL, MysqlJdbc.USER, MysqlJdbc.PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    // 주문 정보 조회
    public static List<OrdersVO> getAllOrders() throws SQLException {
    	connection = DriverManager.getConnection(MysqlJdbc.URL, MysqlJdbc.USER, MysqlJdbc.PASSWORD);
        List<OrdersVO> orders = new ArrayList<>();
        String query = "SELECT * FROM Orders";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int orderId = resultSet.getInt("order_id");
                int totalPrice = resultSet.getInt("totalPrice");
                Timestamp timestamp = resultSet.getTimestamp("order_time");
                LocalDateTime orderTime = timestamp.toLocalDateTime();
                OrdersVO order = new OrdersVO(orderId, totalPrice, orderTime);
                orders.add(order);
            }
        }
        return orders;
    }
    //OrderID에 따라서 orderID, totalPrice, orderTime 리턴해주는 메서드
    public static Optional<OrdersVO> getOrderByOrderID(int orderId) throws SQLException {
        String query = "SELECT * FROM Orders WHERE order_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, orderId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int totalPrice = resultSet.getInt("totalPrice");
                    // Timestamp를 LocalDateTime으로 변환
                    java.sql.Timestamp timestamp = resultSet.getTimestamp("order_time");
                    java.time.LocalDateTime orderTime = timestamp.toLocalDateTime();

                    OrdersVO order = new OrdersVO(orderId, totalPrice, orderTime);
                    return Optional.of(order);
                }
            }
        }
        return Optional.empty();
    }

}
