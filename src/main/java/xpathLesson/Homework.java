package xpathLesson;

import org.htmlcleaner.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class Homework {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {

        System.out.println("Enter the link");
        String link = "https://www.dns-shop.ru/catalog/recipe/784c048a75d2b8e9/8-adernye-processory/";

        System.out.println("Enter xPath");
        String xpath = "//*[@id=\"catalog-items-page\"]/div[6]/div[5]/div[1]/div/div[1]/div";

        if (link == null) {
            throw new NullPointerException("Enter the link");
        }

        if (xpath == null) {
            throw new NullPointerException("Enter xpath");
        }

        if (!xpath.startsWith("/")) {
            throw new IllegalArgumentException("Enter correct xpath");
        }


        URL myUrl = new URL(link);


        HtmlCleaner htmlCleaner = new HtmlCleaner();
        CleanerProperties properties = htmlCleaner.getProperties();
        properties.setOmitComments(true);
        TagNode tagNode = htmlCleaner.clean(myUrl);
        new PrettyXmlSerializer(properties).writeToFile(tagNode, "D:\\Users\\Самат\\Desktop\\ИТИС\\SiteParser\\src\\main\\java\\xpathLesson\\parsing.xml", "utf-8");

        File file = new File("D:\\Users\\Самат\\Desktop\\ИТИС\\SiteParser\\src\\main\\java\\xpathLesson\\parsing.xml");


        FileInputStream fileInputStream = new FileInputStream(file);
        XPath xPath = XPathFactory.newInstance().newXPath();
        DocumentBuilder documentBuilder;
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(fileInputStream);


        XPathExpression xPathExpression = xPath.compile(xpath);
        NodeList result = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);

        for (int i = 0; i < result.getLength(); i++) {
            System.out.println(result.item(i).getNodeValue());

        }
    }
}

