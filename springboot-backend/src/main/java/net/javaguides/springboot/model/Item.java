package net.javaguides.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Item")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long itemid;
	
	@Column(name="itemname",unique = true)
	private String itemname;
	
	@Column(name = "itemprice")
	private long itemprice;

	public long getItemid() {
		return itemid;
	}

	public void setItemid(long itemid) {
		this.itemid = itemid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public long getItemprice() {
		return itemprice;
	}

	public void setItemprice(long itemprice) {
		this.itemprice = itemprice;
	}

	public Item(long itemid, String itemname, long itemprice) {
		super();
		this.itemid = itemid;
		this.itemname = itemname;
		this.itemprice = itemprice;
	}

	public Item() {
		super();
	}
	
}
