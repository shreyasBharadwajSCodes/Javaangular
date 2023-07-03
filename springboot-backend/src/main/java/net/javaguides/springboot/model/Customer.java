package net.javaguides.springboot.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cid;
	
	@Column(name="mobno",unique=true)
	private String mobno;
	
	@Column(name="customer_name")
	private String customer_name;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "bunitid") //mappedBy = "Customer"
	List<Bill> bills = new ArrayList<>();
	
	public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	
	public Customer(long cid, String mobno, String customer_name) {
		this.cid = cid;
		this.mobno = mobno;
		this.customer_name = customer_name;
	}
	
	public Customer() {
		super();
	}

	
	
}
