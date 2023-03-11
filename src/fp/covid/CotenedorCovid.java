package fp.covid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CotenedorCovid {
	//Atributo
	private List<Covid>	covids;

	//Constructores -vacio
	public CotenedorCovid() {
		this.covids = new ArrayList<>();
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
		CotenedorCovid other = (CotenedorCovid) obj;
		return Objects.equals(covids, other.covids);
	}
	
}
