package com.doan2.spring.service;

import java.util.List;

import com.doan2.spring.dao.cart.CartDAO;
import com.doan2.spring.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CartServiceImpl implements CartService {

	// need to inject customer dao
	@Autowired
	private CartDAO cartDAO;
	
	@Override
	@Transactional
	public List<Cart> getCarts() {
		return cartDAO.getCarts();
	}

	@Override
	@Transactional
	public void saveCart(Cart theCustomer) {

		cartDAO.saveCart(theCustomer);
	}

	@Override
	@Transactional
	public Cart getCart(int theId) {
		
		return cartDAO.getCart(theId);
	}

	@Override
	@Transactional
	public void deleteCart(int theId) {

		cartDAO.deleteCart(theId);
	}
}





