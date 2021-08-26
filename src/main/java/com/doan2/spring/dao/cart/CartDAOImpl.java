package com.doan2.spring.dao.cart;

import java.util.List;

import com.doan2.spring.entity.Cart;
import com.doan2.spring.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDAOImpl implements CartDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Cart> getCarts() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Cart> theQuery =
				currentSession.createQuery("from Cart",
						Cart.class);
		
		// execute query and get result list
		List<Cart> carts = theQuery.getResultList();
				
		// return the results		
		return carts;
	}

	@Override
	public void saveCart(Cart theCustomer) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Cart getCart(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Cart theCustomer = currentSession.get(Cart.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCart(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Cart where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();		
	}

	@Override
	public List<Cart> getCartsByCustomerOrderId(int cusId, int orderId) {
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query  ... sort by last name
		Query<Cart> theQuery =
				currentSession.createQuery("from Cart where idCus="+cusId+" and idOrder="+orderId,
						Cart.class);

		// execute query and get result list
		List<Cart> carts = theQuery.getResultList();

		// return the results
		return carts;
	}

	@Override
	public List<Cart> getListCartNotCheckOut(int idCus) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Cart> theQuery =
				currentSession.createQuery("from Cart where idCus ="+idCus+" and idOrder IS NULL",
						Cart.class);

		// execute query and get result list
		List<Cart> carts = theQuery.getResultList();
		return carts;
	}

	@Override
	public void deleteAll(List<Cart> cartList) {
		Session currentSession = sessionFactory.getCurrentSession();
		for (Cart listCarts:
			 cartList) {
			currentSession.delete(listCarts);
		}
	}

	@Override
	public void updateListCart(List<Cart> cartList) {
		Session currentSession = sessionFactory.getCurrentSession();
		for (int i = 0; i < cartList.size(); i++) {
			currentSession.update(cartList.get(i));
		}
	}

	@Override
	public Cart getListCartByIdProduct(int idProduct) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Cart> theQuery =
				currentSession.createQuery("from Cart where idProduct ="+idProduct,
						Cart.class);
		if (theQuery.setMaxResults(1).getResultList().size() != 0){
			return theQuery.setMaxResults(1).getResultList().get(0);
		}
		return new Cart();
	}

	@Override
	public List<Integer> getLatestIdCart() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createSQLQuery("select max(idCart) from Cart");

		return theQuery.setMaxResults(1).getResultList();
	}

	@Override
	public List<Cart> getLastTwoCarts() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Cart> theQuery =
				currentSession.createQuery("from Cart order by idCart DESC",
						Cart.class);
		List<Cart> cartList = theQuery.setMaxResults(2).getResultList();
		return cartList;
	}

}











