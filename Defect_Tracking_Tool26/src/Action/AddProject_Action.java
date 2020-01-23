package Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.AddProjectBean;
import DAO.AddProjectDao;



/**
 * Servlet implementation class AddProject_Action
 */
@WebServlet("/AddProject_Action")
public class AddProject_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProject_Action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Project_Name=request.getParameter("Project_Name");
		System.out.println(Project_Name);
		String Soft_Tools=request.getParameter("Soft_Tools");
		System.out.println(Soft_Tools);
      	String date1 = request.getParameter("Start_Date");
		System.out.println("Date In The Servlet"+date1);
		String year = date1.substring(6);
		String month = date1.substring(0,2);
		String date = date1.substring(3,5);
		String newDate = String.join("-", year,month,date);
		Date start_Date = Date.valueOf(newDate);	
		System.out.println("Date In The Servlet"+start_Date);
      
		/*
		 * String module=request.getParameter("Module_Name");
		 * System.out.println(module);
		 */
		
	  AddProjectBean beanObj=new AddProjectBean();
	 beanObj.setProject_Name(Project_Name);
	 beanObj.setSoft_Tools(Soft_Tools);
	 beanObj.setStart_Date(start_Date);
		
	  PrintWriter out = response.getWriter();
	  out.print("All product bean"+beanObj.toString());
	  System.out.println("All product bean"+beanObj);
		
	  int status=AddProjectDao.save(beanObj);
	  int id = AddProjectDao.returnMaxID();
	  
	  String strModule[]=request.getParameterValues("Module_Name");
		for(String module:strModule) {
			       beanObj.setPM_Id(id);
			       beanObj.setModule_Name(module);
			       AddProjectDao.saveModuleNames(beanObj);
				System.out.println("module names " + module + " id " + id);
		}
	  
	  System.out.println(status);
	
	  if(status>0) {
		response.sendRedirect("views/AddProject.jsp");
	  }else {
			response.sendRedirect("views/AddProject.jsp");

	  }
	}

}
