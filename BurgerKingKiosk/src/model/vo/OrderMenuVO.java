package model.vo;

public class OrderMenuVO {
	private long id;	   // PK
	private int menuId;		// 메뉴 번호(FK)
	private int orderId;	// 주문 번호(FK)
	
	// constructor
	public OrderMenuVO() {}
	
	public OrderMenuVO(int menuId, int orderId) {
		this.menuId = menuId;
		this.orderId = orderId;
	}
	
	public OrderMenuVO(long id, int menuId, int orderId) {
		this.id = id;
		this.menuId = menuId;
		this.orderId = orderId;
	}
	
	// getter
	public long getId() {
		return id;
	}
	
	public int getMenuId() {
		return menuId;
	}
	
	public int getOrderId() {
		return orderId;
	}
	
	// setter
	public void setId(long id) {
		this.id = id;
	}
	
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
}
