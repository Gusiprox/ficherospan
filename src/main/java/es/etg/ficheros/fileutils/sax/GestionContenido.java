package es.etg.ficheros.fileutils.sax;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class GestionContenido extends DefaultHandler {

        public GestionContenido() {
            super();
        }

        public void startDocument() {
            System.out.println("Comienzo del documento XML");
        }

        public void endDocument() {
            System.out.println("Fin del documento XML");
        }

        public void startElement(String uri, String nombre, String nombreC, Attributes atrbs){

            System.out.println("\t Principio elemento:"+nombreC);
        }

        public void endElement(String uri, String nombre, String nombreC) {
            System.out.println("\t Fin elemento:" + nombreC);
        }

        public void characters(char[] ch, int inicio, int longitud) {

            String car = new String(ch, inicio, longitud);
            car = car.replaceAll("[\t\n]", "");
            System.out.println("\t\t" + car);
        }
}
