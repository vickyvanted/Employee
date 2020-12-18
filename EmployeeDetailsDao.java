import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;

public class EmployeeDetailsDao {
//Db connection
	public static Connection getConnection() {
		Connection cn =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn=  DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","");
	
	    }
		catch(Exception e) {
			System.out.println(e);	
   }
		return cn; 
		
	} 
//	Create Employee
	public static int save(EmployeeDetails employee) {
		int status=0;
	try {
			Connection cn=EmployeeDetailsDao.getConnection();
			PreparedStatement psts=cn.prepareStatement("insert into Employee(name,email) values(?,?)");
			psts.setString(1, employee.getName());
			psts.setString(2, employee.getEmail());
			status=psts.executeUpdate();
			cn.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return  status;
	}
//Update Employee		
	public static int update(EmployeeDetails employee) {
		int status=0;
	try {
			Connection cn=EmployeeDetailsDao.getConnection();
			PreparedStatement psts=cn.prepareStatement("update Employee set name=?,email=? where id=? ");
			psts.setString(1, employee.getName());
			psts.setString(2, employee.getEmail());
			psts.setInt(3, employee.getId());
			status=psts.executeUpdate();
			cn.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return  status;
	}
	
	
//Delete employee	
	public static int delete(int  employeeId) {
		int status=0;
	try {
			
		Connection cn=EmployeeDetailsDao.getConnection();
		PreparedStatement psts=cn.prepareStatement("delete from Employee  where id=? ");
		psts.setInt(1, employeeId);
		status=psts.executeUpdate();
		cn.close();
	}catch(Exception ex){
			ex.printStackTrace();
		}
		return  status;
	}
//List Employee	
	public static List getEmployeeDetails() {
	List <EmployeeDetails> emplyeeList =  new ArrayList<EmployeeDetails>();
		
		try {
		Connection cn=EmployeeDetailsDao.getConnection();
		PreparedStatement psts=cn.prepareStatement("select * from Employee");
        ResultSet resultset=psts.executeQuery();	
			while (resultset.next()) {
				EmployeeDetails employee=new EmployeeDetails();
				employee.setId(resultset.getInt(1));
				employee.setName(resultset.getString(2));
				employee.setEmail(resultset.getString(3));
				emplyeeList.add(employee);
			}
			cn.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return  emplyeeList;
	}
	
	
	
}
