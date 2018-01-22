package com.egiants.model;
import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT p FROM Item p"),
    @NamedQuery(name = "Item.findByitemId", query = "SELECT p FROM Product p WHERE p.productId = :productId"),
    @NamedQuery(name = "Item.findByitemName", query = "SELECT p FROM Product p WHERE p.companyId = :companyId"),
    @NamedQuery(name = "Item.findByprice", query = "SELECT p FROM Product p WHERE p.name = :name")})
public class Item implements Serializable {

	@Id
	@Column(name = "item_id")
	private Long itemId;
	
	@Column(name = "item_name")
	private String itemName;

	@Column(name = "initial_price")
	private BigDecimal price;

	

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(Long itemId, String itemName, BigDecimal price) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.price=price;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
/*
//@XmlRootElement
public class Item {
	String id;
	String firstName;
	String lastName;
	int age;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
*/