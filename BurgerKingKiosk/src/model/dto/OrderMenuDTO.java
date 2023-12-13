package model.dto;

import java.util.ArrayList;

public class OrderMenuDTO {
	private int quantity;	// 주문 메뉴 수량
	private int side;
	private int drink;
	private long price;
	private int menuId;		// 메뉴 번호(FK)
	private ArrayList<Integer> ingredientList;
	
	// constructor
	public OrderMenuDTO() {}
	
	public OrderMenuDTO(int quantity, int side, int drink, long price, int menuId) {
		this.quantity = quantity;
		this.side = side;
		this.drink = drink;
		this.price = price;
		this.menuId = menuId;
	}

	public OrderMenuDTO(int quantity, int side, int drink, long price, int menuId, ArrayList<Integer> ingredientList) {
		this.quantity = quantity;
		this.side = side;
		this.drink = drink;
		this.price = price;
		this.menuId = menuId;
		this.ingredientList = ingredientList;
	}
	
	// getter
	public int getQuantity() {
		return quantity;
	}
	
	public int getSide() {
		return side;
	}
	
	public int getDrink() {
		return drink;
	}
	
	public long getPrice() {
		return price;
	}
	
	public int getMenuId() {
		return menuId;
	}
	
	public ArrayList<Integer> getIngredientList() {
		return ingredientList;
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
	
	public void setPrice(long price) {
		this.price = price;
	}
	
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	
	public void setIngredientList(ArrayList<Integer> ingredientList) {
		this.ingredientList = ingredientList;
	}
}
