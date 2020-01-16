package com.app.pojos;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;



@Entity
public class BankAccount {
//	acctNo(Integer @Id), type (enum-AcType -SAVING,CURRENT,FD,LOAN), balance.
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bkId;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private AcType type;
	private double balance;
	
	@OneToOne
	@JoinColumn(name = "vendorId")
	private Vendor vendorInBank;
	
	@OneToOne
	@JoinColumn(name = "adminId")
	private Admin adminInBank;
	
	@OneToOne
	@JoinColumn(name = "customerId")
	private Customer customerInBank;
	
	public BankAccount() {
		System.out.println("inside BankAccount");
	}
	
	public BankAccount(AcType type, double balance) {
		super();
		this.type = type;
		this.balance = balance;
	}

	public Integer getBkId() {
		return bkId;
	}

	public void setBkId(Integer bkId) {
		this.bkId = bkId;
	}

	public AcType getType() {
		return type;
	}

	public void setType(AcType type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Vendor getVendorInBank() {
		return vendorInBank;
	}

	public void setVendorInBank(Vendor vendorInBank) {
		this.vendorInBank = vendorInBank;
	}

	public Admin getAdminInBank() {
		return adminInBank;
	}

	public void setAdminInBank(Admin adminInBank) {
		this.adminInBank = adminInBank;
	}

	public Customer getCustomerInBank() {
		return customerInBank;
	}

	public void setCustomerInBank(Customer customerInBank) {
		this.customerInBank = customerInBank;
	}

	@Override
	public String toString() {
		return "BankAccount [bkId=" + bkId + ", type=" + type + ", balance=" + balance + ", vendorInBank="
				+ vendorInBank + ", adminInBank=" + adminInBank + ", customerInBank=" + customerInBank + "]";
	}
	
	
		
}
