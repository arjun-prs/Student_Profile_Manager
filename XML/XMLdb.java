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


public class XMLdb {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/XMLdb", "root", "Ramana@1950");
		Statement stmt = con.createStatement();
		DocumentBuilderFactory docBuilderFactory =
		DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(new File("src/vgsales.xml"));
		doc.getDocumentElement().normalize();
		NodeList listOfVGs = doc.getElementsByTagName("row");
		for (int s = 0; s < listOfVGs.getLength(); s++) {
			Node firstVGNode = listOfVGs.item(s);
			if (firstVGNode.getNodeType() == Node.ELEMENT_NODE) {
				
				Element firstVGElement = (Element) firstVGNode;
				
				NodeList rankList =
						firstVGElement.getElementsByTagName("Rank");
				Element rankElement = (Element) rankList.item(0);
				NodeList textANList = rankElement.getChildNodes();
				String rank = ((Node) textANList.item(0)).getNodeValue().trim();
				
				NodeList nameList =
						firstVGElement.getElementsByTagName("Name");
				Element nameElement = (Element) nameList.item(0);
				NodeList textBNList = nameElement.getChildNodes();
				String name = ((Node) textBNList.item(0)).getNodeValue().trim();
				
				NodeList platformList =
						firstVGElement.getElementsByTagName("Platform");
				Element platformElement = (Element) platformList.item(0);
				NodeList textplatformList = platformElement.getChildNodes();
				String platform = ((Node) textplatformList.item(0)).getNodeValue().trim();
				
				NodeList yearList =
						firstVGElement.getElementsByTagName("Year");
				Element yearElement = (Element) yearList.item(0);
				NodeList textyearList = yearElement.getChildNodes();
				String year = ((Node) textyearList.item(0)).getNodeValue().trim();
				
				NodeList genreList =
						firstVGElement.getElementsByTagName("Genre");
				Element genreElement = (Element) genreList.item(0);
				NodeList textgenreList = genreElement.getChildNodes();
				String genre = ((Node) textgenreList.item(0)).getNodeValue().trim();
				
				NodeList publisherList =
						firstVGElement.getElementsByTagName("Publisher");
				Element publisherElement = (Element) publisherList.item(0);
				NodeList textLNList = publisherElement.getChildNodes();
				String publisher = ((Node) textLNList.item(0)).getNodeValue().trim();
				
				NodeList na_salesList =
						firstVGElement.getElementsByTagName("NA_Sales");
				Element na_salesElement = (Element) na_salesList.item(0);
				NodeList textna_salesList = na_salesElement.getChildNodes();
				String na_sales = ((Node) textna_salesList.item(0)).getNodeValue().trim();
				
				NodeList eu_salesList =
						firstVGElement.getElementsByTagName("EU_Sales");
				Element eu_salesElement = (Element) eu_salesList.item(0);
				NodeList texteu_salesList = eu_salesElement.getChildNodes();
				String eu_sales = ((Node) texteu_salesList.item(0)).getNodeValue().trim();
				
				NodeList jp_salesList =
						firstVGElement.getElementsByTagName("JP_Sales");
				Element jp_salesElement = (Element) jp_salesList.item(0);
				NodeList textjp_salesList = jp_salesElement.getChildNodes();
				String jp_sales = ((Node) textjp_salesList.item(0)).getNodeValue().trim();
				
				NodeList other_salesList =
						firstVGElement.getElementsByTagName("Other_Sales");
				Element other_salesElement = (Element) other_salesList.item(0);
				NodeList textother_salesList = other_salesElement.getChildNodes();
				String other_sales = ((Node) textother_salesList.item(0)).getNodeValue().trim();
				
				NodeList global_salesList =
						firstVGElement.getElementsByTagName("Global_Sales");
				Element global_salesElement = (Element) global_salesList.item(0);
				NodeList textglobal_salesList = global_salesElement.getChildNodes();
				String global_sales = ((Node) textglobal_salesList.item(0)).getNodeValue().trim();
				
				String query = "insert into VGSales values('" + rank + "','" + name + "','" + platform + "','" + year + "','" + genre + "','" + publisher + "','" + na_sales + "','" + eu_sales + "','" + jp_sales + "','" + other_sales + "','" + global_sales + "')";
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