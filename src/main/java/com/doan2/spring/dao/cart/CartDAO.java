package com.doan2.spring.dao.cart;

import java.util.List;

import com.doan2.spring.entity.Cart;

public interface CartDAO {

	public List<Cart> getCarts();

	public void saveCart(Cart theCustomer);

	public Cart getCart(int theId);

	public void deleteCart(int theId);
	
}
