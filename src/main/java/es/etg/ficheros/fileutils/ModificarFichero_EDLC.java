package es.etg.ficheros.fileutils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import es.etg.ficheros.fileutils.serializable.BarraPan;

public class ModificarFichero_EDLC {
    
    public static String modify(String filePath, int id, BarraPan datoNuevo) throws IOException{
        
        final String ERROR_NO_EXISTE = "El fichero no existe";
        final String ERROR_ID_NO_ENCONTRADA = "El id que pasas no se encuentra";

        final String SUSCESFULL_VALUE = "Se ha cambiado correctamente";
        final int INDEX_DEFAULT_VALUE = -1;

        final long NUM_BYTES = FileUtil.getNumBytes(filePath);

        File file = new File(filePath);
        if (!file.exists()) return ERROR_NO_EXISTE;
        if (NUM_BYTES / datoNuevo.getBytesUsados() < id) return ERROR_ID_NO_ENCONTRADA;
    
        List<BarraPan> panes = new ArrayList<>();

        panes = LeerFichero_EDLC.read(filePath);

        int index = INDEX_DEFAULT_VALUE;

        for (BarraPan barraPan : panes) {
            if (barraPan.getId() == id) {
                index = panes.indexOf(barraPan);
                break;
            }
        }

        if (index == INDEX_DEFAULT_VALUE) return ERROR_ID_NO_ENCONTRADA;

        panes.set(index, datoNuevo);

        file.delete();
        file.createNewFile();

        for (BarraPan barraPan : panes) {
            CrearFichero_EDLC.write(barraPan);
        }
        return SUSCESFULL_VALUE;

    }
}
