package es.etg.ficheros.fileutils;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

import es.etg.ficheros.fileutils.serializable.FileData;

public class FileUtil {
    
    private FileUtil(){}

    public static boolean escribirRandomFichero(FileData data)  {

        try (DataOutputStream writer = new DataOutputStream(new FileOutputStream(data.getFichero(), true))) {
            
            switch (data.getTipoDato()) {

                case STRING:
                    writer.writeChars((String) data.getContenido());
                    break;

                case FLOAT:
                    writer.writeFloat((Float) data.getContenido());
                    break;

                case INT:
                    writer.writeInt((int) data.getContenido());
                    break;

                default: return false;
            }

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public static String leerRandomFichero(FileData data){
    
        final String ERROR_VALUE = "";
        final String SALTO_LINEA = "\n";

        File file = new File(data.getFichero());
        if (!file.exists()) return ERROR_VALUE;

        try (RandomAccessFile reader = new RandomAccessFile(file, "r")) {
            
            StringBuilder content = new StringBuilder();

            reader.seek(data.getPuntero());

            switch (data.getTipoDato()) {

                case STRING:

                    for (int i = 0; i < data.getCantidadARecorrer(); i++) {
                        content.append(reader.readChar());
                    }

                    break;
                case INT:

                    for (int i = 0; i < data.getCantidadARecorrer(); i++) {
                        content.append(reader.readInt());
                    }

                    break;

                case FLOAT:

                    for (int i = 0; i < data.getCantidadARecorrer(); i++) {
                        content.append(reader.readFloat());
                    }

                    break;
                default:
                    return ERROR_VALUE;
                    
            }
            
            return content.toString();

        } catch (Exception e) {
            return ERROR_VALUE;
        }
    }
}
