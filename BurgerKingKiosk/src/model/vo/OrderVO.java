package model.vo;

import java.time.LocalDateTime;
import java.time.LocalDate;

public class OrderVO {
	private LocalDate date; // PK
	private int id;	// PK
	private int totalPrice;
	private int isTakeout;
	private LocalDateTime orderTime;
	
	// constructor	
	public OrderVO(LocalDate date, int id, int totalPrice, int isTakeout, LocalDateTime orderTime) {
		this.date = date;
		this.id = id;
		this.totalPrice = totalPrice;
		this.isTakeout = isTakeout;
		this.orderTime = orderTime;
	}
	
	// getter
	public LocalDate getDate() {
		return date;
	}
	
	public int getId() {
		return id;
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}
	
	public int getIsTakeout() {
		return isTakeout;
	}
	
	public LocalDateTime getOrderTime() {
		return orderTime;
	}
	
	// setter
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public void isTakeout(int isTakeout) {
		this.isTakeout = isTakeout;
	}
	
	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}
}
