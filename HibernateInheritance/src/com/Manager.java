package com;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@Table(name="Managerr1")
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name="Manager2")
@Inheritance(strategy=InheritanceType.JOINED)
public class Manager extends Employee{
	private int numberOfEmployees;

	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}
	
}
