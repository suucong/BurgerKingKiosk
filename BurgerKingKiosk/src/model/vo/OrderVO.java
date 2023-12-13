package model.vo;

import java.time.LocalDateTime;

public class OrderVO {
	private long id;	// PK
	private int totalPrice;
	private LocalDateTime orderTime;
	
	// constructor	
	public OrderVO() {}
	
	public OrderVO(int totalPrice, LocalDateTime orderTime) {
		this.totalPrice = totalPrice;
		this.orderTime = orderTime;
	}
	
	public OrderVO(long id, int totalPrice, LocalDateTime orderTime) {
		this.id = id;
		this.totalPrice = totalPrice;
		this.orderTime = orderTime;
	}
	
	// getter
	public long getId() {
		return id;
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}
	
	public LocalDateTime getOrderTime() {
		return orderTime;
	}
	
	// setter
	public void setId(long id) {
		this.id = id;
	}
	
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}
}
