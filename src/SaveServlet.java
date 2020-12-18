import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SaveServlet")
public class SaveServlet  extends HttpServlet{
	
	private static final long serialVersionUId=1L;
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	response.setContentType("text/html");
	PrintWriter ot=response.getWriter();
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	EmployeeDetails employee=new EmployeeDetails();
	employee.setName(name);
	employee.setEmail(email);
	int status=EmployeeDetailsDao.save(employee);
	if(status>0) {
	ot.print("Success");
	}
	ot.close();
	}

}
