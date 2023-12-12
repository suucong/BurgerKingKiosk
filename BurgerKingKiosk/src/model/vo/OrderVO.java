package model.vo;

import java.time.LocalDateTime;
import java.time.LocalDate;

public class OrderVO {
	private long id;	
	private LocalDate date; 
	private int orderdateId;
	private int totalPrice;
	private int isTakeout;
	private LocalDateTime orderTime;
	
	// constructor	
	public OrderVO() {}
	
	public OrderVO(LocalDate date, int orderdateId, int totalPrice, int isTakeout, LocalDateTime orderTime) {
		this.date = date;
		this.orderdateId = orderdateId;
		this.totalPrice = totalPrice;
		this.isTakeout = isTakeout;
		this.orderTime = orderTime;
	}
	
	public OrderVO(long id, LocalDate date, int orderdateId, int totalPrice, int isTakeout, LocalDateTime orderTime) {
		this.id = id;
		this.date = date;
		this.orderdateId = orderdateId;
		this.totalPrice = totalPrice;
		this.isTakeout = isTakeout;
		this.orderTime = orderTime;
	}
	
	// getter
	public long getId() {
		return id;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public int getOrderdateId() {
		return orderdateId;
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
	public void setId(long id) {
		this.id = id;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public void setOrderdateId(int orderdateId) {
		this.orderdateId = orderdateId;
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
