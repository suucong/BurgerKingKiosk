package model.vo;

public class MenuVO {
	private int id;
	private String name;
	private long price;
	private int isPossible;
	private String menuImagepath;
	private int typeId;
	private int menubytypeId;
	
	// constructor
	public MenuVO(String name, long price, int isPossible, String menuImagepath, int typeId, int menubytypeId) {
		this.name = name;
		this.price = price;
		this.isPossible = isPossible;
		this.menuImagepath = menuImagepath;
		this.typeId = typeId;
		this.menubytypeId = menubytypeId;
	}
	
	public MenuVO(int id, String name, long price, int isPossible, String menuImagepath, int typeId, int menubytypeId) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.isPossible = isPossible;
		this.menuImagepath = menuImagepath;
		this.typeId = typeId;
		this.menubytypeId = menubytypeId;
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
	
	public String getMenuImagepath() {
		return menuImagepath;
	}
	
	public int getTypeId() {
		return typeId;
	}
	
	public int getMenubytypeId() {
		return menubytypeId;
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
	
	public void setMenuImagepath(String menuImagepath) {
		this.menuImagepath = menuImagepath;
	}
	
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	
	public void setMenubytypeId(int menubytypeId) {
		this.menubytypeId = menubytypeId;
	}
}
