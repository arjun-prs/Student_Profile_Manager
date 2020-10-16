import java.io.*;
import java.util.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class users {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student_profile", "root", "Arjun890");
		Statement stmt = con.createStatement();
		DocumentBuilderFactory docBuilderFactory =
		DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(new File("src/users.xml"));
		doc.getDocumentElement().normalize();
		NodeList listOfVGs = doc.getElementsByTagName("row");
		for (int s = 0; s < listOfVGs.getLength(); s++) {
			Node firstVGNode = listOfVGs.item(s);
			if (firstVGNode.getNodeType() == Node.ELEMENT_NODE) {
				
				Element firstVGElement = (Element) firstVGNode;
				
				NodeList user_idList =
						firstVGElement.getElementsByTagName("user_id");
				Element user_idElement = (Element) user_idList.item(0);
				NodeList textANList = user_idElement.getChildNodes();
				String user_id = ((Node) textANList.item(0)).getNodeValue().trim();
				
				NodeList user_nameList =
						firstVGElement.getElementsByTagName("user_name");
				Element user_nameElement = (Element) user_nameList.item(0);
				NodeList textBNList = user_nameElement.getChildNodes();
				String user_name = ((Node) textBNList.item(0)).getNodeValue().trim();
				
				NodeList mobList =
						firstVGElement.getElementsByTagName("mob");
				Element mobElement = (Element) mobList.item(0);
				NodeList textmobList = mobElement.getChildNodes();
				String mob = ((Node) textmobList.item(0)).getNodeValue().trim();
				
				NodeList emailList =
						firstVGElement.getElementsByTagName("email");
				Element emailElement = (Element) emailList.item(0);
				NodeList textemailList = emailElement.getChildNodes();
				String email = ((Node) textemailList.item(0)).getNodeValue().trim();
				
				NodeList resume_linkList =
						firstVGElement.getElementsByTagName("resume_link");
				Element resume_linkElement = (Element) resume_linkList.item(0);
				NodeList textresume_linkList = resume_linkElement.getChildNodes();
				String resume_link = ((Node) textresume_linkList.item(0)).getNodeValue().trim();
				
				NodeList dobList =
						firstVGElement.getElementsByTagName("dob");
				Element dobElement = (Element) dobList.item(0);
				NodeList textdobList = dobElement.getChildNodes();
				String dob = ((Node) textdobList.item(0)).getNodeValue().trim();
				
				NodeList isAdminList =
						firstVGElement.getElementsByTagName("isAdmin");
				Element isAdminElement = (Element) isAdminList.item(0);
				NodeList textisAdminList = isAdminElement.getChildNodes();
				String isAdmin = ((Node) textisAdminList.item(0)).getNodeValue().trim();
				
				NodeList genderList =
						firstVGElement.getElementsByTagName("gender");
				Element genderElement = (Element) genderList.item(0);
				NodeList textgenderList = genderElement.getChildNodes();
				String gender = ((Node) textgenderList.item(0)).getNodeValue().trim();
				
				NodeList pwdList =
						firstVGElement.getElementsByTagName("pwd");
				Element pwdElement = (Element) pwdList.item(0);
				NodeList textpwdList = pwdElement.getChildNodes();
				String pwd = ((Node) textpwdList.item(0)).getNodeValue().trim();
								
				//float float_cgpa=(Float.parseFloat(user_name)+Float.parseFloat(mob)+Float.parseFloat(email)+Float.parseFloat(resume_link)+Float.parseFloat(dob)+Float.parseFloat(isAdmin)+Float.parseFloat(gender)+Float.parseFloat(pwd))/8;
				//String cgpa=Float.toString(float_cgpa);
				String query = "insert into users values('" + user_id + "','" + user_name + "','" + mob + "','" + email + "','" + resume_link + "','" + dob +  "','" + isAdmin +  "','" + gender + "','" + pwd +  "')";
				if (stmt.executeUpdate(query) == 1) {
					System.out.println("Successful Execution");	
				} 
				else {
					System.out.println("Execution Failed");
				}
			}
		}
		con.close();
	}
}