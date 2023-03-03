package parsingStudy;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
public class xmlParsingStudy {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse("http://apis.data.go.kr/6260000/AttractionService/getAttractionKr?serviceKey=a6DHJSFwjzde7HSoTLVracSshY2bpB%2FbZP6bKJR7sdNUfm%2BhIyZrIV5ZoZoZnAJGphwLU%2FcZHJc9URbw9yP0DA%3D%3D&numOfRows=10&pageNo=1");
        
        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());
        Node firstNode = root.getFirstChild(); //CSS로 들어가서
        Node customer = firstNode.getNextSibling();
        System.out.println(customer.getNodeName());
        Node body = customer.getNextSibling().getNextSibling(); //body
        NodeList childList = body.getChildNodes();
        Node items = childList.item(1);
        NodeList title = items.getChildNodes();
        for(int i=0;i<title.getLength();i++){
            Node item = title.item(i);
            if(item.getNodeType() == Node.ELEMENT_NODE){ //노드 타입이 공백이 아닐 경우
                // System.out.println(item.getNodeName());
		        // System.out.println(item.getTextContent());
                System.out.println(item.getFirstChild().getNextSibling().getTextContent());
                System.out.println(item.getFirstChild().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getTextContent());
                System.out.println();
            }
            else{
                // System.out.println("공백 입니다.");
            }
        }
    }
}
