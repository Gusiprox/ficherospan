package es.etg.ficheros.fileutils.serializable;

import java.io.IOException;

import es.etg.ficheros.fileutils.enums.TipoDato;

public class FileData {

    private static int DEFAULT_VALUE = 1;

    private boolean isFileReadData;
    
    private String fichero;

    private Object contenido;

    private int puntero;
    private int cantidadARecorrer;

    private TipoDato tipoDato;

    public FileData(String fichero, Object contenido) throws IOException{
        this.fichero = fichero;
        setContenido(contenido);

        this.isFileReadData = false;

    }

    public FileData(String fichero, int puntero, TipoDato tipoDato){
        this.fichero = fichero;
        this.puntero = puntero;
        this.tipoDato = tipoDato;
        cantidadARecorrer = DEFAULT_VALUE;

        this.isFileReadData = true;
    }

    public void setTipoDato(TipoDato dato){
        this.tipoDato = dato;
    }

    private void setTipoDato(Object contenido){

        if (contenido instanceof String) {
            tipoDato = TipoDato.STRING;
        
        } else if (contenido instanceof Integer) {
            tipoDato = TipoDato.INT;
        
        } else if(contenido instanceof Float){
            tipoDato = TipoDato.FLOAT;
        }
    }

    public boolean isReadData(){
        return isFileReadData;
    }

    public String getFichero(){
        return fichero;
    }

    public Object getContenido(){
        return contenido;
    }

    public TipoDato getTipoDato(){
        return tipoDato;
    }
    public int getPuntero(){
        return puntero;
    }
    public int getCantidadARecorrer(){
        return cantidadARecorrer;
    }

    public void setContenido(Object contenido){
        this.contenido = contenido;
        setTipoDato(contenido);
    }

    public void setPuntero(int puntero){
        this.puntero = puntero;
    }
    public void setCantidadARecorrer(int cantidadARecorrer){
        this.cantidadARecorrer = cantidadARecorrer;
    }

}
