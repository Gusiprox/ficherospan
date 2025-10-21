package es.etg.ficheros.fileutils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class ConvertirXSL {
    
    public static void convertir() throws IOException{

        final String HOJA_ESTILOS = "files/estilos.xsl";
        final String DATOS = "files/EDLC.xml";

        File fileHTML = new File("files/EDLC.html");

        FileOutputStream os = new FileOutputStream(fileHTML);

        Source estilos = new StreamSource(HOJA_ESTILOS);
        Source datos = new StreamSource(DATOS);
        Result result = new StreamResult(os);

        try {

            Transformer transformer = TransformerFactory.newInstance().newTransformer(estilos);
            
            transformer.transform(datos, result);

        } catch (TransformerException e1) {
            System.out.println("Fallo " + e1);
        } catch (Exception e2){
            System.out.println("Fallo 2" + e2);
        }

        os.close();

    }
}
