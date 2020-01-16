package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 30)
	private String name;
	
	@Column(length = 30)
	private String email;
	
	@Column(length = 30)
	private String password;
	private int contactNo;
	
	@OneToOne(mappedBy = "customerInBank", cascade = CascadeType.ALL, orphanRemoval = true)
	private BankAccount accCustomer;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private UserRole role;
	
	@OneToOne(mappedBy = "cust", cascade = CascadeType.ALL, orphanRemoval = true)
	private User us;
	
	
	public Customer() {
		System.out.println("inside Customer ctor");
	}
	
	public Customer(String name, String email, String password, int contactNo, UserRole role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
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

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	
	public BankAccount getAccCustomer() {
		return accCustomer;
	}

	public void setAccCustomer(BankAccount accCustomer) {
		this.accCustomer = accCustomer;
	}

	
	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
	
	public User getUs() 
	{
		return us;
	}

	public void setUs(User us)
	{
		this.us = us;
	}
	
	//convenience method
		public void addAccount(BankAccount b)
		{
			accCustomer= b;
			b.setCustomerInBank(this);
		}
		public void removeAccount(BankAccount b)
		{
			accCustomer= null;
			b.setCustomerInBank(null);	
		}
		public User addUser()
		{
			User u =new User() ;
			u.setName(name); u.setEmail(email); u.setPassword(password); u.setRole(role);u.setCust(this);
			return u;
		}
		
		
		
		@Override
		public String toString() {
			return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
					+ ", contactNo=" + contactNo + ", accCustomer=" + accCustomer + ", role=" + role + "]";
		}
		
		
		
	
}
