package model.vo;

import java.time.LocalDateTime;
import java.util.Date;

public class OrdersVO {
    private int orderId;
    private int totalPrice;
    private LocalDateTime orderTime;

    // 생성자
    public OrdersVO(int orderId, int totalPrice, LocalDateTime orderTime) {
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.orderTime = orderTime;
    }

    // 게터와 세터
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }
}
