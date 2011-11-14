package org.daragon.jpa.itcast.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	private int id;

	private double amount = 0;

	private Set<OrderItem> items = new HashSet<OrderItem>();

	@Id
	@Column(length = 12)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(nullable = false)
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {

		this.amount = amount;
	}

	@OneToMany(cascade = { CascadeType.REMOVE, CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "order")
	public Set<OrderItem> getItems() {
		return items;
	}

	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}

	public void addOrderItem(OrderItem e) {
		e.setOrder(this);
		items.add(e);
	}

}
