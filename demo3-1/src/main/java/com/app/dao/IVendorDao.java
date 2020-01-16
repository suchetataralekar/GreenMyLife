package com.app.dao;

import java.util.List;

import com.app.pojos.Plant;
import com.app.pojos.Product;
import com.app.pojos.Services;
import com.app.pojos.Vendor;

public interface IVendorDao {

	void addVendor(Vendor v );
	Vendor getDetails(int id);
	List<Product> getProduct();
}
