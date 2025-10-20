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