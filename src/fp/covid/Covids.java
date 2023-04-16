package fp.covid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.common.TipoSymptom;

public class Covids {
	//Atributo
	private List<Covid>	covids;

	//Constructores -vacio
	public Covids() {
		this.covids = new ArrayList<>();
	}
	//Constructor Stream de Consola
	public Covids(Stream<Covid> covids) {
		this.covids = covids.collect(Collectors.toList());
	}
	//Metodos basicos
	//Añadir
	public void añadirCovid(Covid c) {
		covids.add(c);
	}
	//Eliminar
	public void eliminarCovids(Covid c) {        //ELIMINAR CAPÍTULO, SI NO EXISTE LANZA EXCEPCIÓN
	     if (!covids.contains(c)) {
	         throw new IllegalArgumentException("La lista no existe");
	     } else {
	      covids.remove(c);
	     }
	 }	
	// nuemro de elementos
	public Integer getNumeroCovids(){
		return covids.size();
	}
	public List<Covid> getCovids(){
		return covids;
	}
	@Override
	public String toString() {
		return "CotenedorCovid [covids=" + covids + "]";
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
		Covids other = (Covids) obj;
		return Objects.equals(covids, other.covids);
	}
	// tipo 1 existe existe pais or no.
	public boolean existeCountry(String country) {
		Boolean res = false;
		for(Covid c: covids) {
			if(c.getCountry().equals(country)) {
				res = true;
				break;
			}
		}
		return res;
	}
	// tipo 2 contador calcular numero de sintomas de fiebre.
	public Integer calcularNumeroDeFiebre(TipoSymptom	symptom) {
		Integer res = 0;
		for(Covid c: this.covids) {
			if(c.getSymptom().equals(symptom))
				res++;
		}
		return res;
	}
	//tipo 3 Filtrar  covid por pais.
	public List<Covid> obtenerCovidsPorPais(String country){
		List<Covid> res = new ArrayList<Covid>();
		for(Covid c : this.covids) {
			if(c.getCountry().equals(country)) {
				res.add(c);
			}
		}
		return res;
	}
	//tipo 4 key : pais value : una lista de tipo covid.
	public Map<String,List<Covid>> calcularConsolaPorPais(){
		Map<String, List<Covid>> res = new HashMap<String, List<Covid>>();
		for(Covid c: covids) {
			if(res.containsKey(c.getCountry())) {
				res.get(c.getCountry()).add(c);
			}
			else {
				List<Covid> aux = new ArrayList<Covid>();
				aux.add(c);
				res.put(c.getCountry(), aux);
			}
		}
		return res;
	}
	//tipo 5 key: pais value : los positivos sumados.
	public Map<String,Integer> totalPositivosPorPais(){
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
