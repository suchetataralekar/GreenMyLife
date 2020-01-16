package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	
	@Column(length = 30)
	private String name;
	
	@Column(length = 30)
	private String email;
	
	@Column(length = 30)
	private String password;
	
	@Column(length = 30)
	private String address;
	private int contactNo;
	
	@OneToOne(mappedBy = "vendorInBank", cascade = CascadeType.ALL, orphanRemoval = true)
	private BankAccount accVendor;
	
	@OneToMany(mappedBy = "vendorInService",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Services> services = new ArrayList<>();
	
	@OneToMany(mappedBy = "idProduct",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Product> products= new ArrayList<>();
	
	@OneToMany(mappedBy = "idPlant",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Plant> plants= new ArrayList<>();	
	
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
	@OneToOne(mappedBy = "vendor", cascade = CascadeType.ALL, orphanRemoval = true)
	private User us;
	
	public Vendor() {
		System.out.println("Vendor ctor");
	}

	public Vendor(String name, String email, String password, String address, int contactNo, UserRole role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.contactNo = contactNo;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	public BankAccount getAccVendor() {
		return accVendor;
	}

	public void setAccVendor(BankAccount accVendor) {
		this.accVendor = accVendor;
	}

	public List<Services> getServices() {
		return services;
	}

	public void setServices(List<Services> services) {
		this.services = services;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Plant> getPlants() {
		return plants;
	}

	public void setPlants(List<Plant> plants) {
		this.plants = plants;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public User getUs() {
		return us;
	}

	public void setUs(User us) {
		this.us = us;
	}
	
	//convenience method
	public void addAccount(BankAccount b)
	{
		accVendor= b;
		b.setVendorInBank(this);
	}
	public void removeAccount(BankAccount b)
	{
		accVendor= null;
		b.setVendorInBank(null);
	}
	
	public User addUser()
	{
		User u =new User() ;
		u.setName(name); u.setEmail(email); u.setPassword(password); u.setRole(role);u.setVendor(this);
		return u;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", address="
				+ address + ", contactNo=" + contactNo + ", accVendor=" + accVendor + ", services=" + services
				+ ", products=" + products + ", plants=" + plants + ", role=" + role + "]";
	}
	
	
	
	
	
}










