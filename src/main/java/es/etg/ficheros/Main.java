package es.etg.ficheros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import es.etg.ficheros.fileutils.ConvertirXSL;
import es.etg.ficheros.fileutils.CrearFicheroXML_EDLC;
import es.etg.ficheros.fileutils.CrearFichero_EDLC;
import es.etg.ficheros.fileutils.LeerFicheroXML_EDLC;
import es.etg.ficheros.fileutils.LeerFichero_EDLC;
import es.etg.ficheros.fileutils.serializable.BarraPan;

public class Main {

    final static String carpeta = "files/panes.dat";
    final static String XML = "files/EDLC.xml";

    public static void main(String[] args) throws IOException{

        BarraPan pan1 = new BarraPan(1, "Chapata", "Poolish", 0.40f, 85);
        BarraPan pan2 = new BarraPan(2, "Candeal", "Directo", 0.90f, 52);
        BarraPan pan3 = new BarraPan(3, "Hogaza", "Masa Madre", 0.65f, 72);
        BarraPan pan4 = new BarraPan(4, "Baguette", "Poolish", 0.60f, 70);

        CrearFichero_EDLC.write(pan1);
        CrearFichero_EDLC.write(pan2);
        CrearFichero_EDLC.write(pan3);
        CrearFichero_EDLC.write(pan4);

        List<BarraPan> panes = new ArrayList<>();

        panes = LeerFichero_EDLC.read(carpeta);

        System.out.println(panes.get(1).getId());

        CrearFicheroXML_EDLC.crear(carpeta);

        System.out.println( LeerFicheroXML_EDLC.mostrarDOM(XML));

        ConvertirXSL.convertir();


    }
}