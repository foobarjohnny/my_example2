package org.daragon.jpa.itcast.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Teacher {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="teacher_student",inverseJoinColumns=@JoinColumn(name="student_id"),
	joinColumns=@JoinColumn(name="teacher_id")
			)
	private Set<Student> students = new HashSet<Student>();

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

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public void addStudent(Student s){
		s.addTeacher(this);
		students.add(s);
	}
}
