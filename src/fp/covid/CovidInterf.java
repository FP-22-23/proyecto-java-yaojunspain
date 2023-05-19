package fp.covid;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.Map.Entry;

import fp.common.TipoSymptom;

public interface CovidInterf {
	/**
	 * @return El número de casos almacenado en el objeto casoCovid.
	 */
	
		public void añadirCovid(Covid c);
		
		public Integer getNumeroCovids();
		
	/*
	 * @param c Covid
	 * eliminar un casos al obejto*/	
		
		public void eliminarCovids(Covid c);
		
	// obetener covid al objeto	
		
		public List<Covid> getCovids();
	/* entrega 2 tipo 1
	 * @param String country
	 * comprobar si existe el pais dado como parametro
	 * @return si existe el covid de este pais o no
	 * */
		
		public boolean existeCountry(String country);
		
	/* entrega 2 tipo 2
	 * @param TipoSymptom symptom
	 * calcular los numeros de la sintoma
	 * @return el numero de los sintomas de las covids que tiene la symptom dada como parametro
	 * */		
		
		public Integer calcularNumeroDeFiebre(TipoSymptom	symptom);
		
	/* entrega 2 tipo 3
	 * @param String country
	 * contador calcular numero de sintomas
	 * @return la lista de tipo Covid que contiene los covids de los paises que tiene el anyo dado como parametro
	 * */		
		
		public List<Covid> obtenerCovidsPorPais(String country);
		
	/* entrega 2 tipo 4
	 * cada pais tiene su covid
	 * @return el mapa cuyo las claves son el pais  y los valores son listas de covid.
	 * */
		
		public Map<String,List<Covid>> calcularCovidPorPais();
		
	/* entrega 2 tipo 5
	 * obtener una mapa cada pais tiene su numero de positivos
	 * @return el mapa cuyo las claves son el sexo de cada persona y los valores son las personas que tiene cada sexo.
	 * */
		
		public Map<String,Integer> totalPositivosPorPais();
		
	/*entrega 3 tipo 4
	 * @return el covid filtrado por pais que tiene mayor temperatura.
	 * */
		
		public Covid calcularMaxTemperaturaPorPais(String country);
		
	/*entrega 3 tipo 4
	 * @return el covid filtrado por pais que tiene menor temperatura.
	 * */	
		
		public Covid calcularMinTemperaturaPorPais(String country);
		
	/* entrega 2 tipo 5
	 * obtener covids con pais filtrado y pais ordenado
	 * @return una lista de pais con los paises ordenados
	 * */
					
		public List<Covid> obtenerCovidsPorPaisOrdenado(String country);
		
	/* entrega 2 tipo 7
	 * obtener una mapa que calcular cada sintoma con su nuemro de pais que contiene ese sintoma
	 * @return el mapa cuyo las claves son las sintomas y los valores son los numeros de sintomas de tiene .
	 * */
				
		public Map<TipoSymptom,Integer> totalSintomaPorCovid();
		
	/* entrega 2 tipo 8
	 * obtener la temperatura maxima de covid por pais con un map
	 * @return el mapa cuyo las claves son los paises  y los valores es el valor que tiene temperatura maximo de covid.
	 * */
			
		public Map<String,Covid> temMaxPorPais(String country);
		
	/* entrega 2 tipo 9
	 * obtener las listas de covids con n temperatura ordenado por su pais con un map
	 * @return el mapa cuyo las claves son los paises y los valores son las listas ordenadas por temperatura
	 * ademas tiene un parametro n para decir cuando quire .
	 * */
			
		public SortedMap<String,List<Covid>> getNTempPorPaisOrdenado(Integer n,String country);
		
	/* entrega 2 tipo 9 aux
	 * obtener un lista filtrado por pais con temperatura ordenada
	 * */
			
		public List<Covid> ordenadoPorTemp(String country);
		
	/* entrega 2 tipo 10
	 * obtener los numeros de covids que tiene cada pais con un map
	 * @return el mapa cuyo las claves son los paises  y los valores son los nuemros de covids que tiene cada pais.
	 * */
			
		public Entry<String,Long> mayorNumeroCovidPorPais();

		
		
}
