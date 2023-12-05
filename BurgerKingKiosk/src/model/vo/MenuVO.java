package model.vo;

public class MenuVO {
	private int id;
	private String name;
	private String price;
	private int typeId;
	
	public MenuVO(String name, String price, int typeId) {
		this.name = name;
		this.price = price;
		this.typeId = typeId;
	}
	
	// getter
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPrice() {
		return price;
	}
	
	public int getTypeId() {
		return typeId;
	}
	
	// setter
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
}
