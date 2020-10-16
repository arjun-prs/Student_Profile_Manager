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


public class sports {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student_profile", "root", "Arjun890");
		Statement stmt = con.createStatement();
		DocumentBuilderFactory docBuilderFactory =
		DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(new File("src/sports.xml"));
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
				
				NodeList sport1List =
						firstVGElement.getElementsByTagName("sport1");
				Element sport1Element = (Element) sport1List.item(0);
				NodeList textBNList = sport1Element.getChildNodes();
				String sport1 = ((Node) textBNList.item(0)).getNodeValue().trim();
				
				NodeList sport2List =
						firstVGElement.getElementsByTagName("sport2");
				Element sport2Element = (Element) sport2List.item(0);
				NodeList textsport2List = sport2Element.getChildNodes();
				String sport2 = ((Node) textsport2List.item(0)).getNodeValue().trim();
				
				NodeList sport3List =
						firstVGElement.getElementsByTagName("sport3");
				Element sport3Element = (Element) sport3List.item(0);
				NodeList textsport3List = sport3Element.getChildNodes();
				String sport3 = ((Node) textsport3List.item(0)).getNodeValue().trim();
				
				NodeList sport4List =
						firstVGElement.getElementsByTagName("sport4");
				Element sport4Element = (Element) sport4List.item(0);
				NodeList textsport4List = sport4Element.getChildNodes();
				String sport4 = ((Node) textsport4List.item(0)).getNodeValue().trim();
				
				NodeList sport5List =
						firstVGElement.getElementsByTagName("sport5");
				Element sport5Element = (Element) sport5List.item(0);
				NodeList textsport5List = sport5Element.getChildNodes();
				String sport5 = ((Node) textsport5List.item(0)).getNodeValue().trim();
					
				String query = "insert into sports values('" + roll_no + "','" + sport1 + "','" + sport2 + "','" + sport3 + "','" + sport4 + "','" + sport5 + "')";
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