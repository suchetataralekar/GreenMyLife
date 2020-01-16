package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IVendorDao;
import com.app.pojos.Plant;
import com.app.pojos.Product;
import com.app.pojos.Services;
import com.app.pojos.Vendor;

@RestController
@RequestMapping("/vendor")
public class VendorController {
	
	@Autowired
	private IVendorDao dao;
	
	@PostConstruct
	public void myInit()
	{
		System.out.println("inside myInit..");
	}
	
	@PostMapping("/add")
	public void addVendor(@RequestBody Vendor v)
	{
		dao.addVendor(v);
	}
	
	@GetMapping("/{id}")
	public Vendor getVendor(@PathVariable int id)
	{
	  return	dao.getDetails(id);
	}
	

	@GetMapping("/product")
	public List<Product> getProduct()
	{
	  return dao.getProduct();
	}
	
}



