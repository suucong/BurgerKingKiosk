package model.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class OrderDTO {
	private int totalPrice;
	private LocalDateTime orderTime;
	private ArrayList<OrderMenuDTO> orderMenuDTOs;
	
	// constructor
	public OrderDTO(int totalPrice, LocalDateTime orderTime, ArrayList<OrderMenuDTO> orderMenuDTOs) {
		this.totalPrice = totalPrice;
		this.orderTime = orderTime;
		this.orderMenuDTOs = orderMenuDTOs;
	}
	
	// getter
	public int getTotalPrice() {
		return totalPrice;
	}
	
	public LocalDateTime getOrderTime() {
		return orderTime;
	}
	
	public ArrayList<OrderMenuDTO> getOrderMenuDTOs() {
		return orderMenuDTOs;
	}
	
	// setter
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}
	
	public void setOrderMenuDTOs(ArrayList<OrderMenuDTO> orderMenuDTOs) {
		this.orderMenuDTOs = orderMenuDTOs;
	}
}
