package es.etg.ficheros.fileutils;

import java.io.IOException;

import es.etg.ficheros.fileutils.serializable.BarraPan;
import es.etg.ficheros.fileutils.serializable.FileData;

public class CrearFichero_EDLC {

    public static void write(BarraPan pan) throws IOException{

        final String FICHERO = "files/panes.dat";

        //DataOutputStream os = new DataOutputStream(new FileOutputStream(FICHERO, true));

        FileData data = new FileData(FICHERO, pan.getId());
        finalWrite(data);

        data.setContenido(pan.getNombre());
        finalWrite(data);

        data.setContenido(pan.getaDeFerment());
        finalWrite(data);

        data.setContenido(pan.getAlveografia());
        finalWrite(data);

        data.setContenido(pan.getHidratacion());
        finalWrite(data);

    }

    private static void finalWrite(FileData data){
        FileUtil.escribirRandomFichero(data);
    }
}