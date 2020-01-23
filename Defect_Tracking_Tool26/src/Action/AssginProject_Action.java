package Action;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.AddProjectBean;
import Bean.AddUserBean;
import Bean.AssginProjectBean;
import DAO.AddProjectDao;
import DAO.AddUserDao;
import DAO.AssginProjectDao;

/**
 * Servlet implementation class AssginProject_Action
 */
@WebServlet("/AssginProject_Action")
public class AssginProject_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssginProject_Action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int status=0;	
		System.out.println("hi**************");
		
		String name=request.getParameter("projectname");
		int i = Integer.parseInt(name);
		System.out.println("project id in servlet*****:"+i);
		
		String n=request.getParameter("username");
		int j = Integer.parseInt(n);
		System.out.println("user id in sevlet*****:"+j);
		/*
		 * AddProjectBean pb = new AddProjectBean(); pb.setProject_Name(name); int s =
		 * AddProjectDao.selectId(name);
		 * 
		 * AssginProjectBean ap = new AssginProjectBean();
		 * 
		 * String username[] = request.getParameterValues("username"); AddUserBean ub =
		 * new AddUserBean(); for(String ustr : username) { ap.setPM_Id(s);
		 * ub.setName(ustr); int m=AddUserDao.selectUserId(ub); ap.setUD_Id(m);
		 * 
		 * status=AssginProjectDao.insert(ap, ub);
		 * 
		 * HttpSession session = request.getSession(); session.setAttribute("uid",m);
		 * 
		 * System.out.println("username*****:"+username);
		 * 
		 * 
		 * 
		 * }
		 * 
		 * if(status>0) { System.out.println("hi assgin project servlet");
		 * response.sendRedirect("views/AssignProject.jsp"); } else {
		 * System.out.println("data is not inserted"); }
		 */
}
}
