package com;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Emp {
	@Id
	private int empid;
	private String empname;
	private float salary;
	
	//Setters and Getters
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
	
	//toString()
	@Override
	public String toString() {
		return "Emp [empid=" + empid + ", empname=" + empname + ", salary="
				+ salary + "]";
	}	
}
