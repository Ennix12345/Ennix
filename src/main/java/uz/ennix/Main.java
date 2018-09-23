package uz.ennix;

import org.w3c.dom.*;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import javax.xml.stream.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException,
            XPathExpressionException, XMLStreamException, TransformerException {
        /*DefaultHandler handler = new DefaultHandler(){
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes){
                String name = attributes.getValue("name");
                if(name!=null && !name.isEmpty()){
                    System.out.println(name);
                }
                }
            @Override
            public void characters(char[] ch, int start, int length){
                String str = "";
                for (int i = 0; i < length; i++) {
                    str+=ch[start + i]; }
                System.out.println(str);
            }
        };
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser parser = spf.newSAXParser();
        parser.parse(new File("pom.xml"), handler);

        XMLInputFactory xif = XMLInputFactory.newInstance();
        XMLStreamReader reader = xif.createXMLStreamReader(new FileInputStream("pom.xml"));
        while (reader.hasNext()){
            int event = reader.next();
            if(event==XMLStreamConstants.START_ELEMENT){
                System.out.println(reader.getLocalName());
            }*/
        XMLOutputFactory xof = XMLOutputFactory.newFactory();
        XMLStreamWriter xsw = xof.createXMLStreamWriter(new FileOutputStream(""));
        xsw.writeStartDocument();
        xsw.writeStartElement("root");
        xsw.writeStartElement("font");
        xsw.writeAttribute("size", "18");
        xsw.writeCharacters("TimesNewRoman");
        xsw.writeEndElement();
        xsw.writeEndDocument();

        }
        /*DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element element1 = document.createElement("root");
        Element element2 = document.createElement("font");
        Text text = document.createTextNode("TimesNewRoman");
        document.appendChild(element1);
        element1.appendChild(element2);
        element2.appendChild(text);
        element2.setAttribute("size", "20");

        //Transformer t = TransformerFactory.newInstance().newTransformer();
        //t.setOutputProperty(OutputKeys.INDENT, "yes");
        //t.transform(new DOMSource(document), new StreamResult(new FileOutputStream("templ.xml")));

        DOMImplementation impl = document.getImplementation();
        DOMImplementationLS imLS = (DOMImplementationLS)impl.getFeature("LS", "3.0");
        LSSerializer ser = imLS.createLSSerializer();
        ser.getDomConfig().setParameter("format-pretty-print", true);
        String s = ser.writeToString(document);
        System.out.println(s);

        LSOutput los = imLS.createLSOutput();
        los.setEncoding("UTF-8");
        los.setByteStream(Files.newOutputStream(Paths.get("templ.xml")));
        ser.write(document, los);
        XPathFactory xPath = XPathFactory.newInstance();
        XPath xP = xPath.newXPath();
        System.out.println(xP.evaluate("count(/preferences/root/node/node/node)", document));
        printElements(element.getChildNodes(), 0);
    }
        static void printElements(NodeList nodeList, int tabs){
        for (int i = 0; i < nodeList.getLength(); i++) {
            if(nodeList.item(i) instanceof Element) {
                String value = "";
                if(!nodeList.item(i).getTextContent().trim().isEmpty()
                        &&!((Text)nodeList.item(i).getFirstChild()).getData().trim().isEmpty()
                        &&!((Text)nodeList.item(i).getFirstChild()).getData().trim().equals("\n")){
                    Text text = (Text)nodeList.item(i).getFirstChild();
                    value+=" = " + text.getData().trim();
                }
                System.out.println(getTab(tabs) + nodeList.item(i).getNodeName() + value);

                NamedNodeMap attri = nodeList.item(i).getAttributes();
                for (int j = 0; j < attri.getLength(); j++) {
                    Node attribute = attri.item(j);
                    String name = attribute.getNodeName();
                    String val = attribute.getNodeValue();
                    System.out.println("Attri " + name + " = " + val);
                }
                System.out.println(getTab(tabs) + ((Element) nodeList.item(i)).getTagName());
                if(((Element) nodeList.item(i)).hasAttribute("name")){
                    System.out.println(((Element) nodeList.item(i)).getAttribute("name"));
                }
                if(nodeList.item(i).hasChildNodes()){
                    printElements(nodeList.item(i).getChildNodes(), ++tabs);
                }
            }
            }
        }
        static String getTab(int tabs){
        String str = "";
            for (int i = 0; i < tabs; i++) {
                str+="\t";
                }
           return str;*/
        }


