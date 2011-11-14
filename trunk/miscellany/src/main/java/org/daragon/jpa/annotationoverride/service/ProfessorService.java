package org.daragon.jpa.annotationoverride.service;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.daragon.jpa.annotationoverride.model.Professor;

public class ProfessorService {

	protected EntityManager em;

	public ProfessorService(EntityManager em) {
		super();
		this.em = em;
	}

	public void createProfessor(Professor emp) {
		em.persist(emp);
	}

	public Collection<Professor> findAllProfessors() {
		Query query = em.createQuery("SELECT e from Professor e");
		return query.getResultList();
	}
	
}
