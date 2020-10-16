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


public class skills {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student_profile", "root", "Arjun890");
		Statement stmt = con.createStatement();
		DocumentBuilderFactory docBuilderFactory =
		DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(new File("src/skills.xml"));
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
				
				NodeList skill1List =
						firstVGElement.getElementsByTagName("skill1");
				Element skill1Element = (Element) skill1List.item(0);
				NodeList textBNList = skill1Element.getChildNodes();
				String skill1 = ((Node) textBNList.item(0)).getNodeValue().trim();
				
				NodeList proof1List =
						firstVGElement.getElementsByTagName("proof1");
				Element proof1Element = (Element) proof1List.item(0);
				NodeList textproof1List = proof1Element.getChildNodes();
				String proof1 = ((Node) textproof1List.item(0)).getNodeValue().trim();
				
				NodeList skill2List =
						firstVGElement.getElementsByTagName("skill2");
				Element skill2Element = (Element) skill2List.item(0);
				NodeList textskill2List = skill2Element.getChildNodes();
				String skill2 = ((Node) textskill2List.item(0)).getNodeValue().trim();
				
				NodeList proof2List =
						firstVGElement.getElementsByTagName("proof2");
				Element proof2Element = (Element) proof2List.item(0);
				NodeList textproof2List = proof2Element.getChildNodes();
				String proof2 = ((Node) textproof2List.item(0)).getNodeValue().trim();
				
				NodeList skill3List =
						firstVGElement.getElementsByTagName("skill3");
				Element skill3Element = (Element) skill3List.item(0);
				NodeList textskill3List = skill3Element.getChildNodes();
				String skill3 = ((Node) textskill3List.item(0)).getNodeValue().trim();
				
				NodeList proof3List =
						firstVGElement.getElementsByTagName("proof3");
				Element proof3Element = (Element) proof3List.item(0);
				NodeList textproof3List = proof3Element.getChildNodes();
				String proof3 = ((Node) textproof3List.item(0)).getNodeValue().trim();
				
				NodeList skill4List =
						firstVGElement.getElementsByTagName("skill4");
				Element skill4Element = (Element) skill4List.item(0);
				NodeList textskill4List = skill4Element.getChildNodes();
				String skill4 = ((Node) textskill4List.item(0)).getNodeValue().trim();
				
				NodeList proof4List =
						firstVGElement.getElementsByTagName("proof4");
				Element proof4Element = (Element) proof4List.item(0);
				NodeList textproof4List = proof4Element.getChildNodes();
				String proof4 = ((Node) textproof4List.item(0)).getNodeValue().trim();
				
				NodeList skill5List =
						firstVGElement.getElementsByTagName("skill5");
				Element skill5Element = (Element) skill5List.item(0);
				NodeList textskill5List = skill5Element.getChildNodes();
				String skill5 = ((Node) textskill5List.item(0)).getNodeValue().trim();
				
				NodeList proof5List =
						firstVGElement.getElementsByTagName("proof5");
				Element proof5Element = (Element) proof5List.item(0);
				NodeList textproof5List = proof5Element.getChildNodes();
				String proof5 = ((Node) textproof5List.item(0)).getNodeValue().trim();
				
				//float float_cgpa=(Float.parseFloat(skill1)+Float.parseFloat(proof1)+Float.parseFloat(skill2)+Float.parseFloat(proof2)+Float.parseFloat(skill3)+Float.parseFloat(proof3)+Float.parseFloat(skill4)+Float.parseFloat(proof4))/8;
				//String cgpa=Float.toString(float_cgpa);
				String query = "insert into skills values('" + roll_no + "','" + skill1 + "','" + proof1 + "','" + skill2 + "','" + proof2 + "','" + skill3 +  "','" + proof3 +  "','" + skill4 + "','" + proof4 + "','" + skill5 + "','" + proof5 +  "')";
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