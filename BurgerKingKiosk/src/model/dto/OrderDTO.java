package model.dto;

import java.util.ArrayList;

public class OrderDTO {
	private int totalPrice;
	private int isTakeout;
	private ArrayList<OrderMenuDTO> orderMenuDTOs;
	
	// constructor
	public OrderDTO(int totalPrice, int isTakeout, ArrayList<OrderMenuDTO> orderMenuDTOs) {
		this.totalPrice = totalPrice;
		this.isTakeout = isTakeout;
		this.orderMenuDTOs = orderMenuDTOs;
	}
	
	// getter
	public int getTotalPrice() {
		return totalPrice;
	}
	
	public int getIsTakeout() {
		return isTakeout;
	}
	
	public ArrayList<OrderMenuDTO> getOrderMenuDTOs() {
		return orderMenuDTOs;
	}
	
	// setter
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public void setIsTakeout(int isTakeout) {
		this.isTakeout = isTakeout;
	}
	
	public void setOrderMenuDTOs(ArrayList<OrderMenuDTO> orderMenuDTOs) {
		this.orderMenuDTOs = orderMenuDTOs;
	}
}
