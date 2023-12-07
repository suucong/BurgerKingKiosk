package model.dto;

import java.util.ArrayList;

public class OrderMenuDTO {
	private int quantity;	// 주문 메뉴 수량
	private String side;
	private String drink;
	private int menuId;		// 메뉴 번호(FK)
	private int orderId;	// 주문 번호(FK)
	private ArrayList<String> ingredientList = new ArrayList<>();	// 재료 추가 배열
	
	// constructor
	public OrderMenuDTO(int quantity, String side, String drink, int menuId, int orderId, ArrayList<String> ingredientList) {
		this.quantity = quantity;
		this.side = side;
		this.drink = drink;
		this.menuId = menuId;
		this.orderId = orderId;
		this.ingredientList = ingredientList;
	}
	
	// getter
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
	
	public int getOrderId() {
		return orderId;
	}
	
	public ArrayList<String> getIngredientList() {
		return ingredientList;
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
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public void setIngredientList(ArrayList<String> ingredientList) {
		this.ingredientList = ingredientList;
	}
}
