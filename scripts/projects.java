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


public class projects {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student_profile", "root", "Arjun890");
		Statement stmt = con.createStatement();
		DocumentBuilderFactory docBuilderFactory =
		DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(new File("src/projects.xml"));
		doc.getDocumentElement().normalize();
		NodeList listOfVGs = doc.getElementsByTagName("row");
		for (int s = 0; s < listOfVGs.getLength(); s++) {
			Node firstVGNode = listOfVGs.item(s);
			if (firstVGNode.getNodeType() == Node.ELEMENT_NODE) {
				
				Element firstVGElement = (Element) firstVGNode;
				
				NodeList roll_noList =
						firstVGElement.getElementsByTagName("roll_no");
				Element roll_noElement = (Element) roll_noList.item(0);
				NodeList textANList = roll_noElement.getChildNodes();
				String roll_no = ((Node) textANList.item(0)).getNodeValue().trim();
				
				NodeList project1List =
						firstVGElement.getElementsByTagName("project1");
				Element project1Element = (Element) project1List.item(0);
				NodeList textBNList = project1Element.getChildNodes();
				String project1 = ((Node) textBNList.item(0)).getNodeValue().trim();
				
				NodeList proof1List =
						firstVGElement.getElementsByTagName("proof1");
				Element proof1Element = (Element) proof1List.item(0);
				NodeList textproof1List = proof1Element.getChildNodes();
				String proof1 = ((Node) textproof1List.item(0)).getNodeValue().trim();
				
				NodeList project2List =
						firstVGElement.getElementsByTagName("project2");
				Element project2Element = (Element) project2List.item(0);
				NodeList textproject2List = project2Element.getChildNodes();
				String project2 = ((Node) textproject2List.item(0)).getNodeValue().trim();
				
				NodeList proof2List =
						firstVGElement.getElementsByTagName("proof2");
				Element proof2Element = (Element) proof2List.item(0);
				NodeList textproof2List = proof2Element.getChildNodes();
				String proof2 = ((Node) textproof2List.item(0)).getNodeValue().trim();
				
				NodeList project3List =
						firstVGElement.getElementsByTagName("project3");
				Element project3Element = (Element) project3List.item(0);
				NodeList textproject3List = project3Element.getChildNodes();
				String project3 = ((Node) textproject3List.item(0)).getNodeValue().trim();
				
				NodeList proof3List =
						firstVGElement.getElementsByTagName("proof3");
				Element proof3Element = (Element) proof3List.item(0);
				NodeList textproof3List = proof3Element.getChildNodes();
				String proof3 = ((Node) textproof3List.item(0)).getNodeValue().trim();
				
				NodeList project4List =
						firstVGElement.getElementsByTagName("project4");
				Element project4Element = (Element) project4List.item(0);
				NodeList textproject4List = project4Element.getChildNodes();
				String project4 = ((Node) textproject4List.item(0)).getNodeValue().trim();
				
				NodeList proof4List =
						firstVGElement.getElementsByTagName("proof4");
				Element proof4Element = (Element) proof4List.item(0);
				NodeList textproof4List = proof4Element.getChildNodes();
				String proof4 = ((Node) textproof4List.item(0)).getNodeValue().trim();
				
				NodeList project5List =
						firstVGElement.getElementsByTagName("project5");
				Element project5Element = (Element) project5List.item(0);
				NodeList textproject5List = project5Element.getChildNodes();
				String project5 = ((Node) textproject5List.item(0)).getNodeValue().trim();
				
				NodeList proof5List =
						firstVGElement.getElementsByTagName("proof5");
				Element proof5Element = (Element) proof5List.item(0);
				NodeList textproof5List = proof5Element.getChildNodes();
				String proof5 = ((Node) textproof5List.item(0)).getNodeValue().trim();
				
				//float float_cgpa=(Float.parseFloat(project1)+Float.parseFloat(proof1)+Float.parseFloat(project2)+Float.parseFloat(proof2)+Float.parseFloat(project3)+Float.parseFloat(proof3)+Float.parseFloat(project4)+Float.parseFloat(proof4))/8;
				//String cgpa=Float.toString(float_cgpa);
				String query = "insert into projects values('" + roll_no + "','" + project1 + "','" + proof1 + "','" + project2 + "','" + proof2 + "','" + project3 +  "','" + proof3 +  "','" + project4 + "','" + proof4 + "','" + project5 + "','" + proof5 +  "')";
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