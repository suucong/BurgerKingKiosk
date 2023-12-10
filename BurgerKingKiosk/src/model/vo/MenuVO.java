package model.vo;

public class MenuVO {
	private int id;
	private String name;
	private long price;
	private int isPossible;
	private int typeId;
	
	// constructor
	public MenuVO(String name, long price, int isPossible, int typeId) {
		this.name = name;
		this.price = price;
		this.isPossible = isPossible;
		this.typeId = typeId;
	}
	
	public MenuVO(int id, String name, long price, int isPossible, int typeId) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.isPossible = isPossible;
		this.typeId = typeId;
	}
	
	// getter
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public long getPrice() {
		return price;
	}
	
	public int getIsPossible() {
		return isPossible;
	}
	
	public int getTypeId() {
		return typeId;
	}
	
	// setter
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(long price) {
		this.price = price;
	}
	
	public void setIsPossible(int isPossible) {
		this.isPossible = isPossible;
	}
	
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
}
