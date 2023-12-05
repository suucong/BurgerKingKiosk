package model.vo;

public class AddIngredientVO {
	private int id;	
	private int ingredientId;
	private int orderMenuId;
	
	// constructor
	public AddIngredientVO(int ingredientId, int orderMenuId) {
		this.ingredientId = ingredientId;
		this.orderMenuId = orderMenuId;
	}
	
	// getter
	public int getId() {
		return id;
	}
	
	public int getIngredientId() {
		return ingredientId;
	}
	
	public int getOrderMenuId() {
		return orderMenuId;
	}
	
	// setter
	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}
	
	public void setOrderMenuId(int orderMenuId) {
		this.orderMenuId = orderMenuId;
	}
}
