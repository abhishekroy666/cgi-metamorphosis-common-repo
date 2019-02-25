package com;

import java.util.ArrayList;
import java.util.List;

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
		Session ss = sf.openSession();
		Transaction tran = ss.getTransaction();
		tran.begin();
		
			Trainer t1 = new Trainer();
			t1.setTid(1); t1.setTname("Raj"); t1.setTech("java");
			
			Student s1 = new Student();
			Student s2 = new Student();
			s1.setSid(101); s1.setSname("Seeta"); s1.setStid(1);
			s2.setSid(102); s2.setSname("Geeta"); s2.setStid(1);
			List<Student> ll = new ArrayList<Student>();
			ll.add(s1); ll.add(s2);
			
			t1.setListOfStudents(ll);
			
			ss.save(t1);
			ss.save(s1);
			ss.save(s2);
			
		tran.commit();
		System.out.println("Records inserted successfully");
		ss.close();
		sf.close();
	}

}
