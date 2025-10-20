package es.etg.ficheros;

import java.io.IOException;

import es.etg.ficheros.fileutils.FileUtil;
import es.etg.ficheros.fileutils.serializable.FileData;

public class Main {
    public static void main(String[] args) throws IOException{

        FileData data = new FileData("prueba.txt", 13.5f);

        FileUtil.escribirRandomFichero(data);
    }
}