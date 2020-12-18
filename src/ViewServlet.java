import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet  extends HttpServlet{

	private static final long serialVersionUId=1L;
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html");
		PrintWriter ot=response.getWriter();
		ot.println("<h1>Employees</h1>");
		List <EmployeeDetails> empllist=(List<EmployeeDetails>) EmployeeDetailsDao.getEmployeeDetails();
		ot.print("<table border ='1' width='100%'");
		ot.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Delete</th></tr>");
		for(EmployeeDetails empl:empllist) {
			ot.print("<tr><td>"+empl.getId()+"</td><td>"+empl.getName()+"</td><td>"+empl.getEmail()+"</td><td><a href='DeleteServlet?id="+empl.getId()+"'>delete</a></tr");
		}
		ot.print("</table>");
		ot.close();
	}
	
}
