package org.daragon.jpa.annotationoverride.model;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class CompanyProfessor extends Professor {
	private int vacation;
	@ManyToOne
	private Professor manager;
	public int getVacation() {
		return vacation;
	}
	public void setVacation(int vacation) {
		this.vacation = vacation;
	}
	public Professor getManager() {
		return manager;
	}
	public void setManager(Professor manager) {
		this.manager = manager;
	}
}
