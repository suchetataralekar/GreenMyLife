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
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAdmin;
	
	@Column(length = 30)
	private String name;
	
	@Column(length = 30)
	private String email;
	
	@Column(length = 30)
	private String password;
	
	private int contactNo;
	
	@OneToOne(mappedBy = "adminInBank", cascade = CascadeType.ALL, optional = true)
	private BankAccount accAdmin;
	

	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private UserRole role;
	
	@OneToOne(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
	private User us;
	
	public Admin() {
		System.out.println("inside Admin ctor");
	}
	
	
	public Admin(String name, String email, String password, int contactNo, BankAccount accAdmin, UserRole role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.contactNo = contactNo;
		this.accAdmin = accAdmin;
		this.role = role;
	}


	
	public Integer getIdAdmin() {
		return idAdmin;
	}


	public void setIdAdmin(Integer idAdmin) {
		this.idAdmin = idAdmin;
	}


	public int getContactNo() {
		return contactNo;
	}


	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	
	public BankAccount getAccAdmin() {
		return accAdmin;
	}


	public void setAccAdmin(BankAccount accAdmin) {
		this.accAdmin = accAdmin;
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
			accAdmin= b;
			b.setAdminInBank(this);
		}
		public void removeAccount(BankAccount b)
		{
			accAdmin= null;
			b.setAdminInBank(null);
		}
		public User addUser()
		{
			User u =new User() ;
			u.setName(name); u.setEmail(email); u.setPassword(password); u.setRole(role);u.setAdmin(this);
			return u;
		}
		
		
	
	
	@Override
	public String toString() {
		return "Admin [idAdmin=" + idAdmin + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", contactNo=" + contactNo + ", accAdmin=" + accAdmin + ", role=" + role + "]";
	}

	
	
	
	
	
}
