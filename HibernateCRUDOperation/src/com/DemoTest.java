package com;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DemoTest {

	public static void main(String[] args) {
		
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		System.out.println("File Loaded...");
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		
		/*----------Insert--------------
		Emp e = new Emp();
		e.setEmpid(106);
		e.setEmpname("Amit");
		e.setSalary(13000);
		
		tran.begin();
			session.save(e);
		tran.commit();
		System.out.println("Record inserted successfully");*/
		
		/*----------Delete--------------
		Emp e = (Emp)session.get("com.Emp",106);
		if(e==null){
			System.out.println("Employee not found");
		}else{
			tran.begin();
				session.delete(e);
			tran.commit();
			System.out.println("Employee successfully deleted");
		}*/
		
		/*----------Update--------------
		Emp e = (Emp)session.get("com.Emp",100);
		if(e==null){
			System.out.println("Employee not found");
		}else{
			tran.begin();
				e.setSalary(50000);
				session.update(e);
			tran.commit();
			System.out.println("Employee successfully updated");
		}*/
		
		
		//Retrieve
		//Query qry = session.createQuery("from Emp e where e.salary>?");
		Query qry = session.createQuery("from Emp e where e.salary>:sal");
		qry.setParameter("sal",40000f);
		List<?> ll = qry.list();
		Iterator<?> itr = ll.iterator();
		while(itr.hasNext()){
			Emp e = (Emp)itr.next();
			System.out.println(e);
		}
		
		
		session.close();
		sf.close();
	}

}
