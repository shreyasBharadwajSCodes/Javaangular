package net.javaguides.springboot.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

//While Searching Search as per customer id
@Entity
@Table(name = "Bill")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bunitid; //Bill Element
	

	@Column(name="itemid")
	private long iid;
	
	@Column(name="itemprice")
	private long itemprice;
	
	@Column(name="quantity")
	private long quantity;
	
	@Column(name="Date")
	Date billdate;
	
	@Column(name="orderid")
	private long orderid;
	
	@ManyToOne
	private Customer customer;
	
	
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public long getIid() {
		return iid;
	}
	public void setIid(long iid) {
		this.iid = iid;
	}
	public long getItemprice() {
		return itemprice;
	}
	public void setItemprice(long itemprice) {
		this.itemprice = itemprice;
	}
	
	public Bill(long bunitid, long iid, long itemprice, long quantity, Date billdate, long orderid) {
		super();
		this.bunitid = bunitid;
		this.iid = iid;
		this.itemprice = itemprice;
		this.quantity = quantity;
		this.billdate = billdate;
		this.orderid = orderid;
	}
	
	public Bill() {
		super();
	}
	public long getBunitid() {
		return bunitid;
	}
	public void setBunitid(long bunitid) {
		this.bunitid = bunitid;
	}
	public Date getBilldate() {
		return billdate;
	}
	public void setBilldate(Date billdate) {
		this.billdate = billdate;
	}
	public long getOrderid() {
		return orderid;
	}
	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}
	
	
	
}
