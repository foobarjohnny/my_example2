package org.daragon.jpa.itcast.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {
	EntityManagerFactory emf;

	@Before
	public void init() {
		emf = Persistence.createEntityManagerFactory("ProfessorService");
	}

	@Test
	public void save() {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Order o = new Order();
		o.setAmount(33);
		OrderItem oi1 = new OrderItem();
		oi1.setPrice(20);
		oi1.setProdName("水果");
		o.addOrderItem(oi1);
		em.persist(o);
		em.getTransaction().commit()
		;
		
		
		em.close();
		emf.close();
	}
}
