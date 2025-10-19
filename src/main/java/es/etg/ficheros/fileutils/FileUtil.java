package es.etg.ficheros.fileutils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileUtil {
    
    private FileUtil(){}

    public boolean escribirFichero(String fichero, String contenido)  {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichero))) {
            
            writer.write(contenido);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public String leerFichero(String fichero){

        final String ERROR_VALUE = "";
        final String SALTO_LINEA = "\n";

        try (BufferedReader reader = new BufferedReader(new FileReader(fichero))) {
            
            StringBuilder content = new StringBuilder();

            while (reader.ready()) {
                content.append(reader.readLine()).append(SALTO_LINEA);
            }
            
            return content.toString();

        } catch (Exception e) {
            return ERROR_VALUE;
        }
    }
}
