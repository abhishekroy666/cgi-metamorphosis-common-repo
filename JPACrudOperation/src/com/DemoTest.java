package com;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.Iterator;
import java.util.List;

public class DemoTest {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPACrudOperation");
		EntityManager manager = factory.createEntityManager();
		
		/*-------Insert------------
		Emp e1 = new Emp();
		e1.setEmpid(102);
		e1.setEmpname("Geeta");
		e1.setSalary(12000);
		EntityTransaction tran = manager.getTransaction();
		tran.begin();
		manager.persist(e1);
		tran.commit();
		System.out.println("Record inserted successfully");*/
		
		/*-------Delete-----------
		Emp emp = manager.find(Emp.class, 101);
		if(emp==null){
			System.out.println("Record not present");
		}else{
			EntityTransaction tran = manager.getTransaction();
			tran.begin();
			manager.remove(emp);
			tran.commit();
			System.out.println("Record successfully deleted");
		}*/
		
		
		/*------------Update--------
		Emp emp = manager.find(Emp.class, 102);
		if(emp==null){
			System.out.println("Record not present");
		}else{
			EntityTransaction tran = manager.getTransaction();
			tran.begin();
			emp.setSalary(30000);
			manager.merge(emp);
			tran.commit();
			System.out.println("Record successfully updated");
		}*/
		
		
		//Retrieve more than one record
		Query qry = manager.createQuery("select e from Emp e where e.salary>?1");
		qry.setParameter(1,14000);
		List<?> ll = qry.getResultList();
		System.out.println("Number of Records : "+ll.size());
		Iterator<?> itr = ll.iterator();
		while(itr.hasNext()){
			Emp e = (Emp)itr.next();
			System.out.println(e);
		}
		
		//Retrieve only one column
		qry = manager.createQuery("select e.empname from Emp e");
		ll = qry.getResultList();
		System.out.println("Number of Records : "+ll.size());
		itr = ll.iterator();
		while(itr.hasNext()){
			String name = (String)itr.next();
			System.out.println(name);
		}
		
		//Retrieve more than one columns
		qry = manager.createQuery("select e.empid,e.empname from Emp e");
		ll = qry.getResultList();
		System.out.println("Number of Records : "+ll.size());
		itr = ll.iterator();
		while(itr.hasNext()){
			Object[] obj = (Object[])itr.next();
			System.out.println(obj[0]+" "+obj[1]);
		}
		
		/*Emp emp = manager.find(Emp.class, 102);
		if(emp==null){
			System.out.println("Record not present");
		}else{
			System.out.println(emp);
		}*/
		manager.close();
		factory.close();
	}
}
