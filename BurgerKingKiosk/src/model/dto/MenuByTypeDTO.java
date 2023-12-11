package model.dto;

import java.util.ArrayList;

import model.vo.MenuTypeVO;
import model.vo.MenuVO;

public class MenuByTypeDTO {
	private MenuTypeVO menuTypeVo;
	private ArrayList<MenuVO> menuVos;
	
	// constructor
	public MenuByTypeDTO(MenuTypeVO menuTypeVo, ArrayList<MenuVO> menuVos) {
		this.menuTypeVo = menuTypeVo;
		this.menuVos = menuVos;
	}
	
	// getter
	public MenuTypeVO getMenuTypeVo() {
		return menuTypeVo;
	}
	
	public ArrayList<MenuVO> getMenuVos() {
		return menuVos;
	}
	
	// setter
	public void setMenuTypeVo(MenuTypeVO menuTypeVo) {
		this.menuTypeVo = menuTypeVo;
	}
	
	public void setMenuVos(ArrayList<MenuVO> menuVos) {
		this.menuVos = menuVos;
	}
}
