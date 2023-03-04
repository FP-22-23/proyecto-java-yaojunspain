# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso 2021/22)
Autor/a: Cristina Rubio   uvus:junyao
Proyecto de java
## Estructura de las carpetas del proyecto

* **/src**: Directorio con el codigo fuente.
  * **fp.covid**: Paquete que contiene los tipos del proyecto.
  * **fp.covid.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset del proyecto.
    * **datasetcovid.csv**: Archivo csv que contiene datos de diferentes partidas de ajedrez.
    
## Estructura del *dataset*

El dataset original Covid Dataset se puede obtener de la URL [https://www.kaggle.com/datasets/resheto/covid19-confirmed-cases-by-country-and-age]. Originalmente tiene 5 columnas y cada fila contiene datos sobre los numeros de positivos de diferentes paises y diferentes años. El dataset usado en este proyecto tiene 8 columna, 5 se han tomado del dataset original, y tres, el boolean enum y float se han generado de forma aleatoria. A continuaciónse describen las 8 columnas de dataset:

* **Age_start**: de tipo Integer, indica los años inicios de las personas.
* **Age_end**: de tipo Integer, indica los años finales de las personas.
* **Positive**: de tipo Integer, indica el numeros de las personas que tiene covid.
* **Country**: de tipo String, indica el pais que ha experimentado.
* **Date**: de tipo LocalDate, indica la fecha que realiza el test para covid.
* **Average_temperature**: de tipo Double, indica la temperatura media que tiene las personas.
* **Death_case**: de tipo Boolean, indica si hay persona fallecita. 
* **Symptom**: de tipo String,indica las síntomas que tiene las personas,hay tres que son fiebre,tos y no tiene fuerza.

## Tipos implementados

Los tipos que se han implementado en el proyecto son los siguientes:

### Tipo Base - Covid
Representa los datos de test de covid.
**Propiedades**:

- _Age_start_, de tipo _Integer_, consultable y modificable. indica los años inicios de las personas. 
- _Age_end_, de tipo _Integer_, consultable y modificable. indica los años finales de las personas.
- _Positive_, de tipo _Integer_, consultable y modificable. indica el numeros de las personas que tiene covid.
- _Country_, de tipo _String_, consultable y modificable. indica el pais que ha experimentado.
- _Date_, de tipo _LocalDate_, consultable y modificable. indica la fecha que realiza el test para covid.
- _Average_temperature_, de tipo _Double_, consultable y modificable. de tipo Double, indica la temperatura media que tiene las personas.
- _Death_case_, de tipo _Boolean_, consultable y modificable. indica si hay persona fallecita
- _Symptom_, de tipo _TipoSymptom_, consultable . indica el síntoma que tienes las personas.Puede tomar los valores Fever,Cough,Strengless.
- Total_Positivo, de tipo Integer, consultable. Numeros totales de las persoans que tiene covid en todo los paises.


**Constructores**: 

- C1: Tiene un parametro por cada propiedad basica del tipo.
- C2: Crea un objeto de tipo ```Covid``` a partir de los siguientes parametros: ```Integer Age_start,Integer Age_end,Integer Positive,String Country```.

**Restricciones**:
 
- R1: La duraciÃ³n debe estar entre 1 y 60.
- R2: El movimiento inicial debe ser uno de los movimientos siguientes: h3, h4, g3, g4, f3, f4, e3, e4, d3, d4, c3, c4, b3, b4, a3, a4, Nh3, Nf3, Nc3, Na3.
- R3: El rating de las blancas debe ser mayor que cero.
- R4: El rating de las negras debe ser mayor que cero.
***Criterio de igualdad**: Dos partidas son iguales si todas sus propiedades bÃ¡sicas son iguales.

**Criterio de ordenaciÃ³n**: Por fecha, duraciÃ³n y nÃºmero de movimientos.

**Otras operaciones**:

- _String getMovimiento(Integer numMovimiento)_: Devuelve el movimiento dado por el nÃºmero numMovimiento. Eleva ```IllegalArgumentException``` si ```numMovimiento``` no estÃ¡ en el intervalo [1, getNumMovimientos()]

#### Tipos auxiliares

- TipoSymptom, enumerado. Puede tomar los valores Fever,Cough,Strengless.







