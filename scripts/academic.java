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


public class academic {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student_profile", "root", "Arjun890");
		Statement stmt = con.createStatement();
		DocumentBuilderFactory docBuilderFactory =
		DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(new File("src/academic.xml"));
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
				
				NodeList sgpa1List =
						firstVGElement.getElementsByTagName("sgpa1");
				Element sgpa1Element = (Element) sgpa1List.item(0);
				NodeList textBNList = sgpa1Element.getChildNodes();
				String sgpa1 = ((Node) textBNList.item(0)).getNodeValue().trim();
				
				NodeList sgpa2List =
						firstVGElement.getElementsByTagName("sgpa2");
				Element sgpa2Element = (Element) sgpa2List.item(0);
				NodeList textsgpa2List = sgpa2Element.getChildNodes();
				String sgpa2 = ((Node) textsgpa2List.item(0)).getNodeValue().trim();
				
				NodeList sgpa3List =
						firstVGElement.getElementsByTagName("sgpa3");
				Element sgpa3Element = (Element) sgpa3List.item(0);
				NodeList textsgpa3List = sgpa3Element.getChildNodes();
				String sgpa3 = ((Node) textsgpa3List.item(0)).getNodeValue().trim();
				
				NodeList sgpa4List =
						firstVGElement.getElementsByTagName("sgpa4");
				Element sgpa4Element = (Element) sgpa4List.item(0);
				NodeList textsgpa4List = sgpa4Element.getChildNodes();
				String sgpa4 = ((Node) textsgpa4List.item(0)).getNodeValue().trim();
				
				NodeList sgpa5List =
						firstVGElement.getElementsByTagName("sgpa5");
				Element sgpa5Element = (Element) sgpa5List.item(0);
				NodeList textsgpa5List = sgpa5Element.getChildNodes();
				String sgpa5 = ((Node) textsgpa5List.item(0)).getNodeValue().trim();
				
				NodeList sgpa6List =
						firstVGElement.getElementsByTagName("sgpa6");
				Element sgpa6Element = (Element) sgpa5List.item(0);
				NodeList textsgpa6List = sgpa5Element.getChildNodes();
				String sgpa6 = ((Node) textsgpa6List.item(0)).getNodeValue().trim();
				
				NodeList sgpa7List =
						firstVGElement.getElementsByTagName("sgpa7");
				Element sgpa7Element = (Element) sgpa5List.item(0);
				NodeList textsgpa7List = sgpa5Element.getChildNodes();
				String sgpa7 = ((Node) textsgpa7List.item(0)).getNodeValue().trim();
				
				NodeList sgpa8List =
						firstVGElement.getElementsByTagName("sgpa8");
				Element sgpa8Element = (Element) sgpa5List.item(0);
				NodeList textsgpa8List = sgpa5Element.getChildNodes();
				String sgpa8 = ((Node) textsgpa8List.item(0)).getNodeValue().trim();
				float float_cgpa=(Float.parseFloat(sgpa1)+Float.parseFloat(sgpa2)+Float.parseFloat(sgpa3)+Float.parseFloat(sgpa4)+Float.parseFloat(sgpa5)+Float.parseFloat(sgpa6)+Float.parseFloat(sgpa7)+Float.parseFloat(sgpa8))/8;
				String cgpa=Float.toString(float_cgpa);
				String query = "insert into education values('" + roll_no + "','" + sgpa1 + "','" + sgpa2 + "','" + sgpa3 + "','" + sgpa4 + "','" + sgpa5 +  "','" + sgpa6 +  "','" + sgpa7 + "','" + sgpa8 + "','" + cgpa +  "')";
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