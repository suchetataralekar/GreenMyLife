package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProduct;
	@Column(length = 30)
	private String name;	
	private double priceProduct;
	
	@ManyToOne
	@JoinColumn(name = "vendor_id")
	private Vendor vendorInProduct;

	
	public Product() {
		System.err.println("inside the Product");
	}

	public Product(String name, double priceProduct) {
		super();
		this.name = name;
		this.priceProduct = priceProduct;
	}



	
	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(double priceProduct) {
		this.priceProduct = priceProduct;
	}


	public Vendor getVendorInProduct() {
		return vendorInProduct;
	}

	public void setVendorInProduct(Vendor vendorInProduct) {
		this.vendorInProduct = vendorInProduct;
	}

	
	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", name=" + name + ", priceProduct=" + priceProduct + "]";
	}
	
	
}
