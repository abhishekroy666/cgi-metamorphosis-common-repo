package com;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
//@Table(name="EmployeeDetails")
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@Table(name="Employee1")
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name="Employee2")
@Inheritance(strategy=InheritanceType.JOINED)
public class Employee {
	@Id
	private int empid;
	private String empname;
	private float salary;
	
	//setter and getter
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
}
