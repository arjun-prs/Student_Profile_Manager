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


public class languages {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student_profile", "root", "Arjun890");
		Statement stmt = con.createStatement();
		DocumentBuilderFactory docBuilderFactory =
		DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(new File("src/languages.xml"));
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
				
				NodeList lang1List =
						firstVGElement.getElementsByTagName("lang1");
				Element lang1Element = (Element) lang1List.item(0);
				NodeList textBNList = lang1Element.getChildNodes();
				String lang1 = ((Node) textBNList.item(0)).getNodeValue().trim();
				
				NodeList lang2List =
						firstVGElement.getElementsByTagName("lang2");
				Element lang2Element = (Element) lang2List.item(0);
				NodeList textlang2List = lang2Element.getChildNodes();
				String lang2 = ((Node) textlang2List.item(0)).getNodeValue().trim();
				
				NodeList lang3List =
						firstVGElement.getElementsByTagName("lang3");
				Element lang3Element = (Element) lang3List.item(0);
				NodeList textlang3List = lang3Element.getChildNodes();
				String lang3 = ((Node) textlang3List.item(0)).getNodeValue().trim();
				
				NodeList lang4List =
						firstVGElement.getElementsByTagName("lang4");
				Element lang4Element = (Element) lang4List.item(0);
				NodeList textlang4List = lang4Element.getChildNodes();
				String lang4 = ((Node) textlang4List.item(0)).getNodeValue().trim();
				
				NodeList lang5List =
						firstVGElement.getElementsByTagName("lang5");
				Element lang5Element = (Element) lang5List.item(0);
				NodeList textlang5List = lang5Element.getChildNodes();
				String lang5 = ((Node) textlang5List.item(0)).getNodeValue().trim();
					
				String query = "insert into languages values('" + roll_no + "','" + lang1 + "','" + lang2 + "','" + lang3 + "','" + lang4 + "','" + lang5 + "')";
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