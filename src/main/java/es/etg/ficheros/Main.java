package es.etg.ficheros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import es.etg.ficheros.fileutils.CrearFicheroXML_EDLC;
import es.etg.ficheros.fileutils.CrearFichero_EDLC;
import es.etg.ficheros.fileutils.LeerFichero_EDLC;
import es.etg.ficheros.fileutils.serializable.BarraPan;

public class Main {

    final static String carpeta = "files/panes.dat";
    public static void main(String[] args) throws IOException{

        BarraPan pan = new BarraPan(1, "Baggete", "Artesanal", 5.3f, 15);
        BarraPan pan2 = new BarraPan(2, "Baggete", "Artesanal", 5.3f, 15);

        CrearFichero_EDLC.write(pan);
        CrearFichero_EDLC.write(pan2);

        List<BarraPan> panes = new ArrayList<>();

        panes = LeerFichero_EDLC.read(carpeta);

        System.out.println(panes.get(1).getId());

        CrearFicheroXML_EDLC.crear(carpeta);


    }
}