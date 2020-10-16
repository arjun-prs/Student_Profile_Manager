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


public class socials {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student_profile", "root", "Arjun890");
		Statement stmt = con.createStatement();
		DocumentBuilderFactory docBuilderFactory =
		DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(new File("src/socials.xml"));
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
				
				NodeList social1List =
						firstVGElement.getElementsByTagName("social1");
				Element social1Element = (Element) social1List.item(0);
				NodeList textBNList = social1Element.getChildNodes();
				String social1 = ((Node) textBNList.item(0)).getNodeValue().trim();
				
				NodeList social2List =
						firstVGElement.getElementsByTagName("social2");
				Element social2Element = (Element) social2List.item(0);
				NodeList textsocial2List = social2Element.getChildNodes();
				String social2 = ((Node) textsocial2List.item(0)).getNodeValue().trim();
				
				NodeList social3List =
						firstVGElement.getElementsByTagName("social3");
				Element social3Element = (Element) social3List.item(0);
				NodeList textsocial3List = social3Element.getChildNodes();
				String social3 = ((Node) textsocial3List.item(0)).getNodeValue().trim();
				
				NodeList social4List =
						firstVGElement.getElementsByTagName("social4");
				Element social4Element = (Element) social4List.item(0);
				NodeList textsocial4List = social4Element.getChildNodes();
				String social4 = ((Node) textsocial4List.item(0)).getNodeValue().trim();
				
				NodeList social5List =
						firstVGElement.getElementsByTagName("social5");
				Element social5Element = (Element) social5List.item(0);
				NodeList textsocial5List = social5Element.getChildNodes();
				String social5 = ((Node) textsocial5List.item(0)).getNodeValue().trim();
					
				String query = "insert into socials values('" + roll_no + "','" + social1 + "','" + social2 + "','" + social3 + "','" + social4 + "','" + social5 + "')";
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