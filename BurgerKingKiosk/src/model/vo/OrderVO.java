package model.vo;

import java.time.LocalDateTime;

public class OrderVO {
	private int id;
	private int totalPrice;
	private LocalDateTime orderTime;
	
	// constructor
	public OrderVO(int totalPrice, LocalDateTime orderTime) {
		this.totalPrice = totalPrice;
		this.orderTime = orderTime;
	}
	
	// getter
	public int getId() {
		return id;
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}
	
	public LocalDateTime getOrderTime() {
		return orderTime;
	}
	
	// setter
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}
}
