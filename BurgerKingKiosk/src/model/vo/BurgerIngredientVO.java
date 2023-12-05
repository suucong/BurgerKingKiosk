package model.vo;

public class BurgerIngredientVO {
	private int id;
	private String name;
	private int price;
	
	// constructor
	public BurgerIngredientVO(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	// getter
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	// setter
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
}
