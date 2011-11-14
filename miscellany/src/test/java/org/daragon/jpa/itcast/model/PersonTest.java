package org.daragon.jpa.itcast.model;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {
	EntityManagerFactory emf;

	@Before
	public void init() {
		emf = Persistence.createEntityManagerFactory("ProfessorService");
	}

	@Test
	public void save() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Person person = new Person();
		person.setBirthday(new Date());
		person.setDescription("long description");
		person.setGendar(Gendar.MAIL);
		IDCard card = new IDCard();
		card.setCardNo("371312198501126019");
		person.setName("Jijun");
		person.setIdCard(card);
		em.persist(person);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	@Test
	public void getPerson() {
		EntityManager em = emf.createEntityManager();
		Person p = em.find(Person.class, 1);
		// 返回代理对象
		Person p2 = em.getReference(Person.class, 2);
		System.out.println(p2.getClass());
		System.out.println(p);
	}

	@Test
	public void updatePerson() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Person p = em.find(Person.class, 2);

		p.setName("Hello world");

		em.getTransaction().commit();
		em.close();
	}

	@Test
	public void updatePerson2() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Person p = em.find(Person.class, 1);
		em.clear();
		p.setName("Hello world");
		// 将游离对象持久化
		em.merge(p);
		em.getTransaction().commit();
		em.close();
	}

	@Test
	public void selectQuery() {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select o from Person o where o.id=?1");
		q.setParameter(1, 2);
		Person p = (Person) q.getSingleResult();
		System.out.println(p);
	}
	@Test public void updateQuery(){
		EntityManager em = emf.createEntityManager();
		
		
		Query query = em.createQuery("update Person o set o.name=:name");
		
		query.setParameter("name", "Java");
		em.getTransaction().begin();
		query.executeUpdate();
		em.getTransaction().commit();
		
		em.close();
		
	}
	
	@Test public void deleteQuery(){
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("delete from Person o where o.id=?2");
		query.setParameter(2,2	);
		
		em.getTransaction().begin();
		query.executeUpdate();
		em.getTransaction().commit();
		em.close();
	
	}
	
	
	
	
	
	

}
