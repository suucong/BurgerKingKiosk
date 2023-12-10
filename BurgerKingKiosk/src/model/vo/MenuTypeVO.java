package model.vo;

public class MenuTypeVO {
	private int id;
	private String name;
	
	// constructor
    public MenuTypeVO(String name) {
        this.name = name;
    }
    
    public MenuTypeVO(int id, String name) {
    	this.id = id;
        this.name = name;
    }
    
    // getter
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    // setter
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
