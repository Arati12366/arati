package Action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteByIdUser
 */
@WebServlet("/DeleteByIdUser")
public class DeleteByIdUser extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteByIdUser() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
		//doGet(request, response);
		String D_id= request.getParameter("PID");
		System.out.println("inside delete servlet by id " + D_id);
		
		HttpSession session=request.getSession();
		session.setAttribute("pid",D_id);
		
		
		RequestDispatcher rd=request.getRequestDispatcher("views/DeleteUserModal.jsp");
		rd.forward(request, response);
		
		
	}

}
