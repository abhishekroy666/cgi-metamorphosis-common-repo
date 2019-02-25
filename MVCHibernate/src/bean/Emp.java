package bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Emp {
	@Id
	public int empid;
	public String empname;
	public float salary;
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
	
	//Setters and Getters
	
}
