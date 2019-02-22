package ru.kpfu.itis;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = builder.parse(new File("D:/Test.xml"));

    Element element = document.getDocumentElement();
//    System.out.println(element.getTagName());
    NodeList nodeList = element.getChildNodes();
    for (int i = 0; i < 9; i++) {
      System.out.println(nodeList.item(i));
    }
  }
}
