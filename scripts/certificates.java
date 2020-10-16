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


public class certificates {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student_profile", "root", "Arjun890");
		Statement stmt = con.createStatement();
		DocumentBuilderFactory docBuilderFactory =
		DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(new File("src/certificates.xml"));
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
				
				NodeList cert1List =
						firstVGElement.getElementsByTagName("cert1");
				Element cert1Element = (Element) cert1List.item(0);
				NodeList textBNList = cert1Element.getChildNodes();
				String cert1 = ((Node) textBNList.item(0)).getNodeValue().trim();
				
				NodeList proof1List =
						firstVGElement.getElementsByTagName("proof1");
				Element proof1Element = (Element) proof1List.item(0);
				NodeList textproof1List = proof1Element.getChildNodes();
				String proof1 = ((Node) textproof1List.item(0)).getNodeValue().trim();
				
				NodeList cert2List =
						firstVGElement.getElementsByTagName("cert2");
				Element cert2Element = (Element) cert2List.item(0);
				NodeList textcert2List = cert2Element.getChildNodes();
				String cert2 = ((Node) textcert2List.item(0)).getNodeValue().trim();
				
				NodeList proof2List =
						firstVGElement.getElementsByTagName("proof2");
				Element proof2Element = (Element) proof2List.item(0);
				NodeList textproof2List = proof2Element.getChildNodes();
				String proof2 = ((Node) textproof2List.item(0)).getNodeValue().trim();
				
				NodeList cert3List =
						firstVGElement.getElementsByTagName("cert3");
				Element cert3Element = (Element) cert3List.item(0);
				NodeList textcert3List = cert3Element.getChildNodes();
				String cert3 = ((Node) textcert3List.item(0)).getNodeValue().trim();
				
				NodeList proof3List =
						firstVGElement.getElementsByTagName("proof3");
				Element proof3Element = (Element) cert3List.item(0);
				NodeList textproof3List = cert3Element.getChildNodes();
				String proof3 = ((Node) textproof3List.item(0)).getNodeValue().trim();
				
				NodeList cert4List =
						firstVGElement.getElementsByTagName("cert4");
				Element cert4Element = (Element) cert4List.item(0);
				NodeList textcert4List = cert3Element.getChildNodes();
				String cert4 = ((Node) textcert4List.item(0)).getNodeValue().trim();
				
				NodeList proof4List =
						firstVGElement.getElementsByTagName("proof4");
				Element proof4Element = (Element) cert4List.item(0);
				NodeList textproof4List = cert4Element.getChildNodes();
				String proof4 = ((Node) textproof4List.item(0)).getNodeValue().trim();
				
				NodeList cert5List =
						firstVGElement.getElementsByTagName("cert5");
				Element cert5Element = (Element) cert5List.item(0);
				NodeList textcert5List = cert5Element.getChildNodes();
				String cert5 = ((Node) textcert5List.item(0)).getNodeValue().trim();
				
				NodeList proof5List =
						firstVGElement.getElementsByTagName("proof5");
				Element proof5Element = (Element) cert5List.item(0);
				NodeList textproof5List = cert5Element.getChildNodes();
				String proof5 = ((Node) textproof5List.item(0)).getNodeValue().trim();
				
				//float float_cgpa=(Float.parseFloat(cert1)+Float.parseFloat(proof1)+Float.parseFloat(cert2)+Float.parseFloat(proof2)+Float.parseFloat(cert3)+Float.parseFloat(proof3)+Float.parseFloat(cert4)+Float.parseFloat(proof4))/8;
				//String cgpa=Float.toString(float_cgpa);
				String query = "insert into certificates values('" + roll_no + "','" + cert1 + "','" + proof1 + "','" + cert2 + "','" + proof2 + "','" + cert3 +  "','" + proof3 +  "','" + cert4 + "','" + proof4 + "','" + cert5 + "','" + proof5 +  "')";
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