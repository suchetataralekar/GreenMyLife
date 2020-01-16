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
public class Plant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPlant;
	@Column(length = 30)
	private String name;
	private double pricePlant;
	
	@ManyToOne
	@JoinColumn(name = "vendor_id")
	private Vendor vendorInPlant;

	
	public Plant() {
		System.err.println("inside the Plant");
	}

	public Plant(String name, double pricePlant) {
		super();
		this.name = name;
		this.pricePlant = pricePlant;
	}

	
	
	public Integer getIdPlant() {
		return idPlant;
	}

	public void setIdPlant(Integer idPlant) {
		this.idPlant = idPlant;
	}

	public Vendor getVendorInPlant() {
		return vendorInPlant;
	}

	public void setVendorInPlant(Vendor vendorInPlant) {
		this.vendorInPlant = vendorInPlant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPricePlant() {
		return pricePlant;
	}

	public void setPricePlant(double pricePlant) {
		this.pricePlant = pricePlant;
	}

	
	
	@Override
	public String toString() {
		return "Plant [idPlant=" + idPlant + ", name=" + name + ", pricePlant=" + pricePlant + "]";
	}
	
	
}
