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

        BarraPan pan = new BarraPan(1, "Baggete", "Artesanal", 5.3f, 15);
        BarraPan pan2 = new BarraPan(2, "Algo", "Pollada", 1.3f, 85);
        BarraPan pan3 = new BarraPan(3, "Algo2", "Pollada2", 6.3f, 105);

        CrearFichero_EDLC.write(pan);
        CrearFichero_EDLC.write(pan2);
        CrearFichero_EDLC.write(pan3);

        List<BarraPan> panes = new ArrayList<>();

        panes = LeerFichero_EDLC.read(carpeta);

        System.out.println(panes.get(1).getId());

        CrearFicheroXML_EDLC.crear(carpeta);

        System.out.println( LeerFicheroXML_EDLC.mostrarDOM(XML));

        ConvertirXSL.convertir();


    }
}