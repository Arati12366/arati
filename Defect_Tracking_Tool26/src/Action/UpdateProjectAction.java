package Action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import Bean.AddProjectBean;
import DAO.AddProjectDao;


/**
 * Servlet implementation class UpdateProjectAction
 */
@WebServlet("/UpdateProjectAction")
public class UpdateProjectAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProjectAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  //	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

	   
	   int PM_Id=Integer.parseInt(request.getParameter("uid"));
	  //  System.out.println(PM_Id);
	    String pname=request.getParameter("Project_Name");
	   System.out.println(pname);
	    String stool=request.getParameter("Soft_Tools");
	   System.out.println(stool);
	 
	   String strModule[]=request.getParameterValues("Module_Name");
	   String mode=Arrays.toString(strModule);
//			   System.out.println("Module_Name"+mode);
//	for(String module2:strModule) {
//		System.out.println("module name " + module2);
//	}
	  	    
	   AddProjectBean pb=new AddProjectBean();
	   pb.setPM_Id(PM_Id);
	   pb.setProject_Name(pname);
	   pb.setSoft_Tools(stool);
		/*pb.setModule_Name(mode);*/
	/* pb.setModule_Name(module);*/
	  
	 
  

	   int status=AddProjectDao.Update_Project(pb);
	
	   int id = AddProjectDao.returnID();
	   ArrayList<String> l = new ArrayList<String>();
	   l.add(mode);
	   
	 Iterator i = l.iterator();
	 
	 while(i.hasNext())
	 {
		 pb.setPM_Id(id);
	    	pb.setModule_Name((String) i.next());
	    	  int s = AddProjectDao.Update_ProjectMN(pb); 
	    	  if(s>0 )
	    	   	{
	    	   		 System.out.println("update succesfully");
	    				
	    				response.sendRedirect("views/AddProject.jsp");
	    	   	}
	    	   	else {
	    	   		 System.out.println("update not succesfully");
	    				
	    				response.sendRedirect("views/AddProject.jsp");
	    	   	}
	    	  
	 }
	 
//		 
//if(mode!=null) {
//	   for(String module1:strModule)
//	    {
//	    	System.out.println("inside Updatemodulenames            "+module1);		
//	    	pb.setPM_Id(id);
//	    	pb.setModule_Name(mode);
//	    }
//}

	 
	
	   System.out.println("***********UPDATE PROJECT STATUS*********"+status);
	   if( status>0)
   	{
   		 System.out.println("update succesfully");
			
			response.sendRedirect("views/AddProject.jsp");
   	}
   	else {
   		 System.out.println("update not succesfully");
			
			response.sendRedirect("views/AddProject.jsp");
   	}
//	 
//		 if(status>0)
//	   {
//		   System.out.println("update succesfully");
//			
//			response.sendRedirect("views/AddProject.jsp");
//		   
//	   }
//	  else
//	   {
//		   System.out.println("update not successfully");
//		   response.sendRedirect("views/AddProject.jsp");
//		   
//	   }
//	
	}

}
