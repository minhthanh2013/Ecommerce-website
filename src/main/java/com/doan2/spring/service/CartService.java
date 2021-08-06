package com.doan2.spring.service;

import java.util.List;

import com.doan2.spring.entity.Cart;

public interface CartService {

	List<Cart> getCarts();

	 void saveCart(Cart cart);

	Cart getCart(int theId);

	 void deleteCart(int theId);
	
}
