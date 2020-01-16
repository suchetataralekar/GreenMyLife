package com.app.pojos;

import javax.persistence.Column;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Services {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer serviceId;

@Column(length = 30)
private String name;

private double servicePrice;

@Enumerated(EnumType.STRING)
@Column(length = 30)
private ServiceType servType;

@ManyToOne
@JoinColumn(name = "vendor_id")
private Vendor vendorInService;

public Services() {
// TODO Auto-generated constructor stub
}



public Services( String name, double servicePrice, ServiceType servType) {
	super();
	
	this.name = name;
	this.servicePrice = servicePrice;
	this.servType = servType;
}



public Vendor getVendorInService() {
	return vendorInService;
}



public void setVendorInService(Vendor vendorInService) {
	this.vendorInService = vendorInService;
}



public void setServiceId(Integer serviceId) {
	this.serviceId = serviceId;
}




public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public double getServicePrice() {
	return servicePrice;
}



public void setServicePrice(double servicePrice) {
	this.servicePrice = servicePrice;
}



public ServiceType getServType() {
	return servType;
}


public void setServType(ServiceType servType) {
	this.servType = servType;
}







@Override
public String toString() {
	return "Services [serviceId=" + serviceId + ", name=" + name + ", servicePrice=" + servicePrice + ", servType="
			+ servType + "]";
}





}