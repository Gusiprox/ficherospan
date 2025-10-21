package es.etg.ficheros.fileutils;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class LeerFicheroXML_EDLC {
    
    //Falta parte SAX
    public static String mostrarDOM(String file){

        final String ERROR_VALUE = "";
        final String SALTO_LINEA = "\n";
        final String ESPACIO_LINEA = " ";
        StringBuilder result = new StringBuilder();

        try {

            File xmlFile = new File(file);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            Document document = builder.parse(xmlFile);
            
            document.getDocumentElement().normalize();

            NodeList panNodes = document.getElementsByTagName("PAN");

            for (int i = 0; i < panNodes.getLength(); i++) {
                Node panNode = panNodes.item(i);

                if (panNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element panElement = (Element) panNode;

                    String id = getTagValue("ID", panElement);
                    String nombre = getTagValue("NOMBRE", panElement);
                    String fermentacion = getTagValue("FERMENTACION", panElement);
                    String alveografia = getTagValue("ALVEOGRAFIA", panElement);
                    String hidratacion = getTagValue("HIDRATACION", panElement);

                    result.append(id).append(ESPACIO_LINEA).
                    append(nombre).append(ESPACIO_LINEA).
                    append(fermentacion).append(ESPACIO_LINEA).
                    append(alveografia).append(ESPACIO_LINEA).
                    append(hidratacion).append(SALTO_LINEA);
                }
            }

            return result.toString();

        } catch (Exception e) {

            System.out.println(e);
            return ERROR_VALUE;
        }


    }

    private static String getTagValue(String tag, Element element) {

        NodeList nodeList = element.getElementsByTagName(tag);
        
        if (nodeList != null && nodeList.getLength() > 0) {

            Element tagElement = (Element) nodeList.item(0);
            
            NodeList textNodeList = tagElement.getChildNodes();
            
            if (textNodeList != null && textNodeList.getLength() > 0) {

                return textNodeList.item(0).getNodeValue();
            }
        }
        return ""; // Devuelve cadena vacía si no se encuentra
    }

}
