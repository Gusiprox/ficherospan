# DOCUMENTACION FICHEROS

***Tipo de dato a guardar: `Barra de pan`***

## Datos a guardar

- id: (int)
- nombre: (String)
- agenteDeFermentacion "aDeFerment": (String)
- alveografia: (float)
- hidratacion: (int)

**Explicacion de los campos:**

- El `id` es el identificador principal por eso es int.

- `Nombre` es el nombre de la barra por eso String de 20.

- `AgenteDeFermentación` es en pocas palabras la levadura o masa madre utilizada, hay varias asique se guarda en String de 40.

- `alveografia` un valor decimal que se saca de la comparación entre la **extensibilidad** del pan y su **tenacidad**, se saca un valor entre 0.55 para arriba (mas tenaz) o hacia abajo (mas extensible), en general lo mejor es entre 0.4 y 0.7 por esto es float

- `hidratacion` es el pocentaje de liquido comparado a lo solido que le pones a la hora de hacer el pan, es un numerico int.

>El agente de fermentacion tiene su propio porcentaje de hidratacion, esto es importante porque no es informacion repetida

**Tamaño**

El tamaño de cada Barra De Pan sera de 4 + 40 + 80 + 4 + 4 = 132

## Uso 

### CrearFichero_EDLC.java

Para usarlo he decido hacerlo en la propia clase main ya que solo se pide la funcionalidad y no una interfaz

Para escribir un fichero de acceso aleatorio en este caso guardamos barras de pan : pan, `CrearFichero_EDLC` recibe una clase `BarraPan` y la escribe con el metodo `.write`. Y escribe los datos ordenados 

ejemplo: `BarraPan pan1 = new BarraPan(1, "Chapata", "Poolish", 0.40f, 85);`

### ModificarFichero_EDLC.java

>No implementado por falta de tiempo


### CrearFicheroXML_EDLC.java

Para usarlo le pasas el fichero.dat y este lo transforma en un .XML, si quieres cambiar el nombre del fichero de salida vas a `CrearFicheroXML.java` y le cambias la constante `NOMBRE_ARCHIVO_XML`

ejemplo: `CrearFicheroXML_EDLC.crear(carpeta);`

### LeerFicheroXML_EDLC.java

Para usarlo le tienes que mandar el archivo XML en String con esto devuelve un String con los valores

Usando el DOM
ejemplo: `LeerFicheroXML_EDLC.mostrarDOM(XML)`

Usando el SAX
> No hubo tiempo

### XSLT a HTML

Para ello uso la clase `ConvertirXSL.java` esta clase tiene una funcion a la que no le pasas nada, y convierte el .xml a HTML mediante un XSL de estilo

ejemplo: `ConvertirXSL.convertir();`

### Otros detalles

- Todos los archivos se guardan en files

- Esta hecho para escribir sobre el fichero varias veces, por lo que si quieres ejecutar el codigo otra vez para que funcione bien tendrás que borrar el panes.dat

- La clase `FileData.java` es clave para el uso de mi codigo, ya que para manejar los punteros, tipos de datos entre otras cosas usas esta clase
 este es un jemplo: 
```java
public static String leerRandomFichero(FileData data){
    
        final String ERROR_VALUE = "";

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
```

## Problemas

Hay un fallo en el xml que la ultima de Agente de fermentacion, no se escribe bien, aunque si lo pruebas varias veces si sale, solo es con ese dato y la ultima asique no se cual es el fallo exactamente

Falta la parte de SAX y no tengo tiempo 

>El trabajo se complicó porque me estaba devolviendo un bucle infinito, el cual pensé que iba por el XML pero alfinal era una Constante mal puesta, esto tomó todo mi tiempo y no me dio tiempo a acabar, si lo corriges es posible que este subido a mi repositorio de github una version con esto implementado https://github.com/Gusiprox/ficherospan.git por si quieres mirarlo.