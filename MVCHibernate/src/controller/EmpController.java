package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.EmpService;
import bean.Emp;

/**
 * Servlet implementation class EmpController
 */
@WebServlet(value="/EmpController")
public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("emp.jsp");
		
		Emp emp = new Emp();
		emp.setEmpid(Integer.parseInt(request.getParameter("empid")));
		emp.setEmpname(request.getParameter("empname"));
		emp.setSalary(Float.parseFloat(request.getParameter("salary")));
		
		EmpService es = new EmpService();
		es.createEmpService(emp);
		
		List<?> listOfRecords = es.retrieveEmpService();
		HttpSession hs = request.getSession();
		hs.setAttribute("records",listOfRecords);
		rd.include(request, response);
	
	}

}
