package es.etg.ficheros.fileutils;

import java.util.ArrayList;
import java.util.List;

import es.etg.ficheros.fileutils.enums.TipoDato;
import es.etg.ficheros.fileutils.serializable.BarraPan;
import es.etg.ficheros.fileutils.serializable.FileData;

public class LeerFichero_EDLC {
    
    //La clase Write esta preparada para escrbir varios tipos de datos, pero esta no lo va a estar porque BarraPan.java debería
    //heredar de otra general, cuando haga eso puedo devolver list<Clase General>, pasar un enum con el tipo de dato y ya
    
    public static List<BarraPan> read(String fichero){

        final int TAMAÑO_BARRA_PAN = 132;
        final int POSICION_INICIAL = 0;

        final int SIZE_INT = 4;
        final int SIZE_FLOAT = 4;
        final int SIZE_CHAR = 2;

        final int CANTIDAD_A_RECORRER = (int) FileUtil.getNumBytes(fichero) / TAMAÑO_BARRA_PAN;
        
        List<BarraPan> panes  = new ArrayList<>();

        FileData data = new FileData(fichero, POSICION_INICIAL, TipoDato.INT);

        for (int i = 0; i < CANTIDAD_A_RECORRER; i++) {
            
            int id;
            String nombre;
            final int SIZE_NOMBRE = SIZE_CHAR * 20;

            String aDeFerment;
            final int SIZE_A_DE_FERMENT = SIZE_CHAR * 40;

            Float alveografia;
            int hidratacion;

            id = Integer.parseInt(fileRead(data));
            data.movePuntero(SIZE_INT);

            data.setTipoDato(TipoDato.STRING);
            data.setCantidadARecorrer(SIZE_NOMBRE);
            nombre = fileRead(data);
            data.movePuntero(SIZE_NOMBRE);

            data.setTipoDato(TipoDato.STRING);
            data.setCantidadARecorrer(SIZE_A_DE_FERMENT);
            aDeFerment = fileRead(data);
            data.movePuntero(SIZE_A_DE_FERMENT);

            data.setTipoDato(TipoDato.FLOAT);
            data.setCantidadARecorrer(1);
            alveografia = Float.parseFloat(fileRead(data));
            data.movePuntero(SIZE_FLOAT);

            data.setTipoDato(TipoDato.INT);
            hidratacion = Integer.parseInt(fileRead(data));
            data.movePuntero(SIZE_INT);

            panes.add(new BarraPan(id, nombre, aDeFerment, alveografia, hidratacion));

        }
        return panes;

    }

    private static String fileRead(FileData data){
        return FileUtil.leerRandomFichero(data);
    }
}
