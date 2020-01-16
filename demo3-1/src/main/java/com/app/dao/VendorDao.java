package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.app.pojos.Plant;
import com.app.pojos.Product;
import com.app.pojos.Services;
import com.app.pojos.Vendor;

@Repository
public class VendorDao implements IVendorDao
{
	@PersistenceContext
	private EntityManager mgr;
	@Override
	public void addVendor(Vendor v) {
		
		mgr.unwrap(Session.class).save(v);
		System.out.println(v);
		mgr.unwrap(Session.class).save(v.addUser()); 
	}
	@Override
	public Vendor getDetails(int id) {
		
		return mgr.unwrap(Session.class).get(Vendor.class, id);
	}
	@Override
	public List<Product> getProduct() {
		
		String jpql = "select p from Product p";
		return mgr.unwrap(Session.class).createQuery(jpql,Product.class).getResultList();
	}

	
	
}
