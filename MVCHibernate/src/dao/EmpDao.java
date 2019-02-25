package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import resource.DBConnection;
import bean.Emp;

public class EmpDao {
	public void createEmpDao(Emp emp){
		Session session = DBConnection.getConnection().openSession();
		Transaction tran = session.getTransaction();
		tran.begin();
			session.save(emp);
		tran.commit();
		System.out.println("Record inserted successfully");
		session.close();
	}
	
	public List<?> retrieveEmpDao(){
		Session session = DBConnection.getConnection().openSession();
		Query qry = session.createQuery("from Emp e");
		List<?> listOfRecords = qry.list();
		session.close();
		return listOfRecords;		
	}
}
