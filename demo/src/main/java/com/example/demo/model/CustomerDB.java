package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerDB {



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private long customerId;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "customer_email")
	private String customerEmail;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "updated_date")
	private Date updatedDate;
	
	@Column(name = "is_prime_user")
	private Boolean isPrimeUser;
	
	@Column(name = "prime_start_date")
	private Date primeStartDate;
	
	@Column(name = "prime_end_date")
	private Date primeEndDate;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Boolean getIsPrimeUser() {
		return isPrimeUser;
	}

	public void setIsPrimeUser(Boolean isPrimeUser) {
		this.isPrimeUser = isPrimeUser;
	}

	public Date getPrimeStartDate() {
		return primeStartDate;
	}

	public void setPrimeStartDate(Date primeStartDate) {
		this.primeStartDate = primeStartDate;
	}

	public Date getPrimeEndDate() {
		return primeEndDate;
	}

	public void setPrimeEndDate(Date primeEndDate) {
		this.primeEndDate = primeEndDate;
	}

	
	
}
