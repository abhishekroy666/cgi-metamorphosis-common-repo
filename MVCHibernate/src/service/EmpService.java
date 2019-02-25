package service;

import java.util.List;

import dao.EmpDao;
import bean.Emp;

public class EmpService {

	public void createEmpService(Emp emp){
		EmpDao ed = new EmpDao();
		ed.createEmpDao(emp);
	}
	
	public List<?> retrieveEmpService(){
		EmpDao ed = new EmpDao();
		List<?> listOfRecords = ed.retrieveEmpDao();
		return listOfRecords;
	}
}
