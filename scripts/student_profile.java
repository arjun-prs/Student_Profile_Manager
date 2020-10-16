
import java.sql.*;  
import java.io.*;
import java.util.*;
public class student_profile {

public static void main(String[] args) throws Exception {
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student_profile", "root", "Arjun890");
	System.out.println("success");
	Statement stmt=con.createStatement();  
	Scanner sc=new Scanner(System.in);
	String user_id, user_name, mob, email, resume_link, dob, isAdmin, gender, pwd, query;
	System.out.println("Enter your User ID: ");
	user_id=sc.nextLine();
	System.out.println("Enter your Username: ");
	user_name=sc.nextLine();
	System.out.println("Enter your mobile number: ");
	mob=sc.nextLine();
	System.out.println("Enter your email ID: ");
	email=sc.nextLine();
	System.out.println("Enter your resume link: ");
	resume_link=sc.nextLine();
	System.out.println("Enter your date of birth: ");
	dob=sc.nextLine();
	System.out.println("Are you an admin (0/1): ");
	isAdmin=sc.nextLine();
	System.out.println("Enter your Gender (M/F): ");
	gender=sc.nextLine();
	System.out.println("Enter your password: ");
	pwd=sc.nextLine();
	query="insert into users values('"+user_id+"','"+user_name+"','"+mob+"','"+email+"','"+resume_link+"','"+dob+"','"+isAdmin+"','"+gender+"','"+pwd+"')";
	if(stmt.executeUpdate(query)==1)
	{
		System.out.println("Successful Execution");
		ResultSet rs=stmt.executeQuery("select * from users");  
		while(rs.next())  
		System.out.println(rs.getString(1)+"  "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+"  "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+"  "+rs.getString(8)+" "+rs.getString(9));  
	}
	else
	{
		System.out.println("Execution Failed");
	}
	con.close();  
	}
	catch(Exception e){ System.out.println(e);} 
	
	}

}
