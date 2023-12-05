package model.vo;

public class AdminVO {
	private int id;
	private String password;
	
	public AdminVO(String password) {
		this.password = password;
	}
	
	// getter
    public int getId() {
        return id;
    }
    
    public String getPassword() {
        return password;
    }
    
    // setter
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String password) {
        this.password = password;
    }
}
