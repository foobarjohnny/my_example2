package org.daragon.jpa.annotationoverride.model;

import javax.persistence.AssociationOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "BAD_EMP")
@AssociationOverride(name = "manager", joinColumns = @JoinColumn(name = "MGR"))
public class BadProfessor extends CompanyProfessor {

	@Column(name = "H_RATE")
	private float hourlyRate;

	public float getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(float hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	@Override
	public String toString() {
		return "PartTimeProfessor id: " + getId() + " name:" + getName();
	}
}
