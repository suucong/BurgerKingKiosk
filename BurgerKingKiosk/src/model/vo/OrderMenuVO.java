package model.vo;

public class OrderMenuVO {
	private int id;	   // PK
	private int quantity;	// 주문 메뉴 수량
	private int side;
	private int drink;
	private int menuId;		// 메뉴 번호(FK)
	private int orderId;	// 주문 번호(FK)
	
	// constructor
	public OrderMenuVO(int id, int quantity, int side, int drink, int menuId, int orderId) {
		this.id = id;
		this.quantity = quantity;
		this.side = side;
		this.drink = drink;
		this.menuId = menuId;
		this.orderId = orderId;
	}
	
	// getter
	public int getId() {
		return id;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public int getSide() {
		return side;
	}
	
	public int getDrink() {
		return drink;
	}
	
	public int getMenuId() {
		return menuId;
	}
	
	public int getOrderId() {
		return orderId;
	}
	
	// setter
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setSide(int side) {
		this.side = side;
	}
	
	public void setDrink(int drink) {
		this.drink = drink;
	}
	
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
}
