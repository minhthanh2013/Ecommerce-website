package com.doan2.spring.service.cart;

import java.util.List;

import com.doan2.spring.entity.Cart;

public interface CartService {

	List<Cart> getCarts();

	 void saveCart(Cart cart);

	Cart getCart(int theId);

	 void deleteCart(int theId);
	 void deleteAll(List<Cart>cartList);
	List<Cart> getCartsByCustomerOrderId(int cusId, int orderId);
	List<Cart> getListCartNotCheckOut(int idCus);

    void updateListCart(List<Cart> cartList);
	Cart getListCartByIdProduct(int idProduct);
	List<Integer> getLatestIdCart();
	List<Cart> getLastTwoCarts();
}
