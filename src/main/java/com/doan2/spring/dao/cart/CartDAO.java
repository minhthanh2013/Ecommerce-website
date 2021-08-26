package com.doan2.spring.dao.cart;

import java.util.List;

import com.doan2.spring.entity.Cart;

public interface CartDAO {

	 List<Cart> getCarts();

	 void saveCart(Cart theCustomer);

	 Cart getCart(int theId);

	 void deleteCart(int theId);

    List<Cart> getCartsByCustomerOrderId(int cusId, int orderId);

    List<Cart> getListCartNotCheckOut(int idCus);

	void deleteAll(List<Cart> cartList);
	void updateListCart(List<Cart> cartList);
	Cart getListCartByIdProduct(int idProduct);

    List<Integer> getLatestIdCart();

    List<Cart> getLastTwoCarts();
}
