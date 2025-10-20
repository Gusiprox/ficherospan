package es.etg.ficheros.fileutils.enums;

public enum TipoDato {

    STRING( "string"),
    INT ("int"),
    FLOAT("float");

    private final String dato;

    TipoDato(String dato){
        this.dato = dato;
    }

    public String getTipoDato(){
        return dato;
    }

}
