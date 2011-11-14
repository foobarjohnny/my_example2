package org.daragon.jpa.itcast.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

public class TeacherTest {
	EntityManagerFactory emf;

	@Before
	public void init() {
		emf = Persistence.createEntityManagerFactory("ProfessorService");
	}

	@Test
	public void save() {
		EntityManager em = emf.createEntityManager();
		em.close();
		emf.close();
	}

}
