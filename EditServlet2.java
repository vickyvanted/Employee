import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet2")

public class EditServlet2 extends HttpServlet{

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html");
		PrintWriter ot=response.getWriter();
		String id=request.getParameter("id");
		int  empId=Integer.parseInt(id);
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		EmployeeDetails employee= new EmployeeDetails();
		employee.setId(empId);
		employee.setName(name);
		employee.setEmail(email);
		int status=EmployeeDetailsDao.update(employee);
		if(status>0) {
			response.sendRedirect("ViewServlet");
		}
		ot.close();
		
	}
	
}
