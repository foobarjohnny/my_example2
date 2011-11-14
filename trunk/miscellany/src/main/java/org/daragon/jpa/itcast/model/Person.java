package org.daragon.jpa.itcast.model;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Person {
	@Id
	@GeneratedValue
	private int id;

	private String name;
	@Temporal(TemporalType.DATE)
	private Date birthday;
	@Enumerated(EnumType.STRING)
	private Gendar gendar;
	@Lob
	private String description;
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private Byte[] file;

	@OneToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name = "idcard_id")
	private IDCard idCard;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Gendar getGendar() {
		return gendar;
	}

	public void setGendar(Gendar gendar) {
		this.gendar = gendar;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Byte[] getFile() {
		return file;
	}

	public void setFile(Byte[] file) {
		this.file = file;
	}

	public IDCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IDCard idCard) {
		this.idCard = idCard;
	}

	@Override
	public String toString() {
		return "Person [id="
				+ id
				+ ", "
				+ (name != null ? "name=" + name + ", " : "")
				+ (birthday != null ? "birthday=" + birthday + ", " : "")
				+ (gendar != null ? "gendar=" + gendar + ", " : "")
				+ (description != null ? "description=" + description + ", "
						: "")
				+ (file != null ? "file=" + Arrays.toString(file) : "") + "]";
	}

}
