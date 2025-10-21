package es.etg.ficheros.fileutils.serializable;

public class BarraPan{
    
    final static int NUMBER_OF_NOMBRE = 20;
    final static int NUMBER_OF_FERMENT = 40;

    private int id;
    private String nombre;
    private String aDeFerment;
    private float alveografia;
    private int hidratacion;

    public BarraPan(int id, String nombre, String aDeFerment, float alveografia, int hidratacion){
        this.id = id;
        this.nombre = nombre;
        this.aDeFerment = aDeFerment;
        this.alveografia = alveografia;
        this.hidratacion = hidratacion;
    }

    private String parseToExactNumber(String toParse, int numChars){

        final String FILL_VALUE = " ";

        if (toParse.length() == numChars) {
            return toParse;
        }
        
        if (toParse.length() < numChars) {

            while (toParse.length() < numChars) {
                toParse = toParse + FILL_VALUE;
            }
            return toParse;
        } else{

            return toParse.substring(0, numChars);
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return parseToExactNumber(nombre, NUMBER_OF_NOMBRE);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getaDeFerment() {
        return parseToExactNumber(aDeFerment, NUMBER_OF_FERMENT);
    }

    public void setaDeFerment(String aDeFerment) {
        this.aDeFerment = aDeFerment;
    }

    public float getAlveografia() {
        return alveografia;
    }

    public void setAlveografia(float alveografia) {
        this.alveografia = alveografia;
    }

    public int getHidratacion() {
        return hidratacion;
    }

    public void setHidratacion(int hidratacion) {
        this.hidratacion = hidratacion;
    }

    public int getBytesUsados(){
        return 132;
    }

}
