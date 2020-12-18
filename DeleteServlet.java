import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DeleteServlet")

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUId=1L;
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	String id=request.getParameter("id");
	int  empId=Integer.parseInt(id);
	EmployeeDetailsDao.delete(empId);
	response.sendRedirect("ViewServlet");
	
	}
	
	
}
