package es.etg.ficheros.fileutils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import es.etg.ficheros.fileutils.serializable.FileData;

public class FileUtil {
    
    private FileUtil(){}

    public static boolean escribirRandomFichero(FileData data)  {

        try (DataOutputStream writer = new DataOutputStream(new FileOutputStream(data.getFichero()))) {
            
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

    public static String leerRandomFichero(String fichero, int puntero, int cantidad, String tipo){

        final String ERROR_VALUE = "";
        final String SALTO_LINEA = "\n";

        try (DataInputStream reader = new DataInputStream(new FileInputStream(fichero))) {
            
            StringBuilder content = new StringBuilder();

            switch (tipo) {

                case "string":
                    


                    break;
            
                default:
                    break;
            }
            
            return content.toString();

        } catch (Exception e) {
            return ERROR_VALUE;
        }
    }
}
