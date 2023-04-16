# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso 2021/22)
Autor/a: Cristina Rubio   uvus:junyao
Proyecto de java , El dataset es sobre el numero de positivo de covid ha tenido dependiendo de año en el marzo de 2022 . 
## Estructura de las carpetas del proyecto

* **/src**: Directorio con el codigo fuente.
  * **fp.covid**: Paquete que contiene los tipos del proyecto.
  * **fp.covid.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.common**:Paquete que contiene los tipos auxiliares.
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
- getYear_date(), de tipo _Integer_,consultable.indica el año que realiza el test.

-String getTemperatura(), de tipo _String_,consultable.indica si las perosonas esta en peligro en totales.

**Constructores**: 

- C1: Tiene un parametro por cada propiedad basica del tipo.
- C2: Crea un objeto de tipo ```Covid``` a partir de los siguientes parametros: ```Integer Age_start,Integer Age_end,Integer Positive,String Country```.

**Restricciones**:
 
- R1: Edad inicial tiene que ser mayor que 0
- R2: Edad final tiene quer ser mayor que 0
- R3: El numero de positivo tiene que ser mayor que 0


***Criterio de igualdad**: Dos Covid son iguales si todas sus propiedades basicas son iguales.

**Criterio de ordenación**: por edad inicial, edad final y pais.

**Otras operaciones**:



#### Tipos auxiliares

- TipoSymptom, enumerado. Puede tomar los valores Fever,Cough,Strengless.
- CovidDatos, para saber los años que hemos investigado sobre el covid.

**Factoría - FactoriaCovids**: 
- Clase de factoría para construir objetos de tipo Covids.

- Covids leerCovids(fichero):Crea un objeto de tipo Covids a partir de la información recogida en el archivo csv, cuya ruta se da como parámetro.
**Tipo Contenedor - Covids**: 
Clase contenedora de los objetos de tipo Covid.

Propiedades:
- covids, de tipo List<Covid>, consultable. Lista de los datos de Covid.

- numeros covids, de tipo Integer devuelve el size de contenedor.

Constructores:
- C1: Constructor para crear un objeto de tipo Covids
- C2: Constructor para eliminar un objeto de tipo Covids.


Criterio de igualdad: Dos covids son iguales si lo son sus propiedades son iguales.

Otras operaciones:
- existeCountry(String country):De tipo booleano,comprueba si hay este pais en el contenedor.

- calcularNumeroDeFiebre(TipoSymptom	symptom):Devuelve un contador para contar el numero de fiebre hay en el database.

- List<Covid> obtenerCovidsPorPais(String country): Un filtro , devuelve el contenedor cual cumple el parametro pais.

-  Map<String,List<Covid>> calcularConsolaPorPais():Devuelve un Map cuyo key es el pais y su valor es una lista que tiene este pais.

-  Map<String,Integer> totalPositivosPorPais():Devuelve un Map cuyo key es pais y su valor es numero de positivo acumulado de este pais.

