package model.vo;

import java.time.LocalDate;

public class OrderMenuVO {
	private int id;
	private int quantity;	// 주문 메뉴 수량
	private String side;
	private String drink;
	private int menuId;		// 메뉴 번호(FK)
	private LocalDate date; // 주문 날짜(FK)
	private int orderId;	// 주문 번호(FK)
	
	// constructor
	public OrderMenuVO(int id, int quantity, String side, String drink, int menuId, LocalDate date, int orderId) {
		this.id = id;
		this.quantity = quantity;
		this.side = side;
		this.drink = drink;
		this.menuId = menuId;
		this.date = date;
		this.orderId = orderId;
	}
	
	// getter
	public int getId() {
		return id;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public String getSide() {
		return side;
	}
	
	public String getDrink() {
		return drink;
	}
	
	public int getMenuId() {
		return menuId;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public int getOrderId() {
		return orderId;
	}
	
	// setter
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setSide(String side) {
		this.side = side;
	}
	
	public void setDrink(String drink) {
		this.drink = drink;
	}
	
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
}
