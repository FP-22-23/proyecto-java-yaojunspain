package fp.covid;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.common.TipoSymptom;

public class CovidsStream implements CovidInterf{
	//Atributo
	private List<Covid>	covids;
	//Constructores -vacio
	public CovidsStream() {
		this.covids = new ArrayList<>();
	}
	//Constructor Stream de Consola
	public CovidsStream(Stream<Covid> covids) {
		this.covids = covids.collect(Collectors.toList());
	}
	@Override
	public int hashCode() {
		return Objects.hash(covids);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CovidsStream other = (CovidsStream) obj;
		return Objects.equals(covids, other.covids);
	}
	@Override
	public String toString() {
		return "CovidsStream [covids=" + covids + "]";
	}
	public void añadirCovid(Covid covid) {
		this.covids.add(covid);
	}
	public void añadirCovidAll(List<Covid> covid) {
		this.covids.addAll(covid);
	}
	public List<Covid> getCovids(){
		return covids;
	}
	public void eliminarCovid(Covid covid) {
		this.covids.remove(covid);
	}
	
	//Bloque 1 tipo 1
	//@return si existe el covid de este pais o no
	public boolean existeCountry(String country) {
		return this.covids.stream()
				.anyMatch(c -> c.getCountry().equals(country));
	}
	
	//Bloque 1 tipo 2
	//@return el numero de los sintomas de las covids que tiene la symptom dada como parametro
	public Integer calcularNumeroDeFiebre(TipoSymptom	symptom) {
		Long res = this.covids.stream()
				.filter(c ->c.getSymptom().equals(symptom))
				.count();
		return res.intValue();
	}
	
	//Bloque 1 tipo 3
	//@return la lista de tipo Covid que contiene los covids de los paises que tiene el anyo dado como parametro
	public List<Covid> obtenerCovidsPorPais(String country){
		return this.covids.stream()
				.filter(c -> c.getCountry().equals(country))
				.collect(Collectors.toList());		
	}
	
	//Bloque 1 tipo 4
	//@return el covid filtrado por pais que tiene mayor temperatura.
	//@return el covid filtrado por pais que tiene menor temperatura.
	public Covid calcularMaxTemperaturaPorPais(String country) {
		return this.covids.stream()
				.filter(c ->c.getCountry().equals(country))
				.max(Comparator.comparing(Covid::getAverage_temperature))
				.get();				
	}
	public Covid calcularMinTemperaturaPorPais(String country) {
		return this.covids.stream()
				.filter(c ->c.getCountry().equals(country))
				.min(Comparator.comparing(Covid::getAverage_temperature))
				.get();
	}
	
	//Bloque 1 tipo 5
	//@return una lista de pais con los paises ordenados
	public List<Covid> obtenerCovidsPorPaisOrdenado(String country){
		return this.covids.stream()
				.sorted(Comparator.comparing(Covid::getCountry))
				.filter(c -> c.getCountry().equals(country))
				.collect(Collectors.toList());	
	}
	
	//Bloque 2 tipo 6 metodo 5 de la entrega 2
	public Map<String,List<Covid>> calcularCovidPorPais(){
		return this.covids.stream()
				.collect(Collectors.groupingBy(
						Covid::getCountry,
						Collectors.toList()
						));			
	}
	
	// Bloque 2 tipo 7 colletingAndThen
	//@return el mapa cuyo las claves son las sintomas y los valores son los numeros de sintomas de tiene .
	public Map<TipoSymptom,Integer> totalSintomaPorCovid(){
		return this.covids.stream()
				.collect(Collectors.groupingBy(
						Covid::getSymptom,
						Collectors.collectingAndThen(Collectors.counting(),Long::intValue)
						));
	}
	
	//Bloque 2 tipo 8
	// @return el mapa cuyo las claves son los paises  y los valores es el valor que tiene temperatura maximo de covid.
	public Map<String,Covid> temMaxPorPais(String country){
		return this.covids.stream().filter(c->c.getCountry().equals(country))
				.collect(Collectors.groupingBy(Covid::getCountry,
						Collectors.collectingAndThen(Collectors.toList(), lista->ordenadoPorTemp(country).get(ordenadoPorTemp(country).size()-1))));
	}
	//Bloque 2 tipo 9
	//@return el mapa cuyo las claves son los paises y los valores son las listas ordenadas por temperatura ademas tiene un parametro n para decir cuando quire
	public SortedMap<String,List<Covid>> getNTempPorPaisOrdenado(Integer n,String country){
		return new TreeMap<String,List<Covid>>(covids.stream().filter(c->c.getCountry().equals(country))
				.collect(Collectors.groupingBy(Covid::getCountry,
						Collectors.collectingAndThen(Collectors.toList(), lista->ordenadoPorTemp(country).subList(0, n)))));
	}
	public List<Covid> ordenadoPorTemp(String country){
		Comparator<Covid> aux = (c1,c2) ->c1.getAverage_temperature().compareTo(c2.getAverage_temperature());
		return this.covids.stream()
				.filter(c -> c.getCountry().equals(country))
				.sorted(aux)
				.collect(Collectors.toList());
	}
	
	//Bloque 2 tipo 10ç
	//@return el mapa cuyo las claves son los paises  y los valores son los nuemros de covids que tiene cada pais.
	public Entry<String,Long> mayorNumeroCovidPorPais(){
		Map<String,Long> aux = this.covids.stream().collect(Collectors.groupingBy(Covid::getCountry,Collectors.counting()));
		return aux.entrySet().stream().max(Comparator.comparing(c ->c.getValue())).get();
	}
	//generar por interface
	public Integer getNumeroCovids() {
		// TODO Auto-generated method stub
		return covids.size();
	}
	public void eliminarCovids(Covid c) {
	     if (!covids.contains(c)) {
	         throw new IllegalArgumentException("La lista no existe");
	     } else {
	      covids.remove(c);
	     }		
	}
	public Map<String, Integer> totalPositivosPorPais() {
		// TODO Auto-generated method stub
		Map<String,Integer> res = new HashMap<String,Integer>();
		for(Covid c:covids) {
			if(!res.containsKey(c.getCountry())){
				res.put(c.getCountry(),c.getPositive());
			}
			else {
				res.put(c.getCountry(),res.get(c.getCountry())+c.getPositive());
			}
		}
		return res;
	}
	
	
}
