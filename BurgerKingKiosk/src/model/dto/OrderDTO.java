package model.dto;

import java.util.ArrayList;

import model.vo.OrderMenuVO;

public class OrderDTO {
	private int totalPrice;
	private ArrayList<OrderMenuVO> orderMenuVOs;
	
	// constructor
	public OrderDTO() {}
	
	public OrderDTO(int totalPrice, ArrayList<OrderMenuVO> orderMenuVOs) {
		this.totalPrice = totalPrice;
		this.orderMenuVOs = orderMenuVOs;
	}
	
	// getter
	public int getTotalPrice() {
		return totalPrice;
	}
	
	public ArrayList<OrderMenuVO> getOrderMenuVOs() {
		return orderMenuVOs;
	}
	
	// setter
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public void setOrderMenuDTOs(ArrayList<OrderMenuVO> orderMenuVOs) {
		this.orderMenuVOs = orderMenuVOs;
	}
}
