package es.etg.ficheros.fileutils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import es.etg.ficheros.fileutils.serializable.BarraPan;

public class CrearFicheroXML_EDLC {
    
    //Haz otra clase que lea el archivo aleatorio y regrese un array de BarraPan, con esto aqui puedes hacer un foreach
    //e ir colgando cada dato en el XML

    public static void crear(String xml){

        final String NOMBRE_ARCHIVO_XML = "files/panes.xml";

        List<BarraPan> panes = new ArrayList<>();

        panes = LeerFichero_EDLC.read(xml);

        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            Document document = builder.newDocument();
            Element raiz = document.createElement("PANES");
            document.appendChild(raiz);

            for (BarraPan pan : panes) {
                
                addBarraPanToDOM(document, raiz, pan);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(NOMBRE_ARCHIVO_XML));

            transformer.transform(source, result);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private static void addBarraPanToDOM(Document document, Element raiz, BarraPan pan) {
        
        Element panElement = document.createElement("PAN");
        
        panElement.setAttribute("id", String.valueOf(pan.getId()));
        
        raiz.appendChild(panElement); 

        Element nombre = document.createElement("NOMBRE");
        nombre.setTextContent(pan.getNombre());
        panElement.appendChild(nombre);

        Element fermentacion = document.createElement("FERMENTACION");
        fermentacion.setTextContent(pan.getaDeFerment());
        panElement.appendChild(fermentacion);

        Element alveografia = document.createElement("ALVEOGRAFIA");
        alveografia.setTextContent(String.valueOf(pan.getAlveografia()));
        panElement.appendChild(alveografia);

        Element hidratacion = document.createElement("HIDRATACION");
        hidratacion.setTextContent(String.valueOf(pan.getHidratacion()));
        panElement.appendChild(hidratacion);
    }
}
