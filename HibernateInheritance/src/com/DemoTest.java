package com;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class DemoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		tran.begin();
			Employee e = new Employee();
			Manager m = new Manager();
			Developer d = new Developer();
			
			e.setEmpid(1); e.setEmpname("Raj"); e.setSalary(5000);
			m.setEmpid(2); m.setEmpname("Raju"); m.setSalary(8000); m.setNumberOfEmployees(10); 
			d.setEmpid(3); d.setEmpname("Ram"); d.setSalary(10000); d.setProjectName("java");
			
			session.save(e);
			session.save(m);
			session.save(d);
		tran.commit();
		session.close();
		sf.close();
	}

}
