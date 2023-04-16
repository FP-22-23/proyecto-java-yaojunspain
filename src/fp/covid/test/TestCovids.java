package fp.covid.test;

import fp.common.TipoSymptom;
import fp.covid.Covids;
import fp.covid.FactoriaCovids;

public class TestCovids {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Covids covids = FactoriaCovids.leerCovids("data/dataset_covid.csv");
		testCalcularNumeroDeFiebre(covids,TipoSymptom.Fever);
		testObtenerCovidsPorPais(covids,"Italy");
		testCalcularConsolaPorPais(covids);
		testTotalPositivosPorPais(covids);
		System.out.println("Existe este pais?" + covids.existeCountry("Norway") + "\n");
	}
	private static void testCalcularNumeroDeFiebre(Covids covids,TipoSymptom	symptom) {
		// TODO Auto-generated method stub
		System.out.println("TEST de calcularNumeroDeFiebre");
		try {
			System.out.println(covids.calcularNumeroDeFiebre(symptom) + "\n");
		} catch (Exception e) {
			System.out.println("Excepcion Capturada" + e);
		}
		
	}
	
	private static void testObtenerCovidsPorPais(Covids covids, String country) {
		// TODO Auto-generated method stub
		System.out.println("TEST de obtenerCovidsPorPais");
		try {
			System.out.println(covids.obtenerCovidsPorPais(country) + "\n");
		} catch (Exception e) {
			System.out.println("Excepcion Capturada" + e);
		}
		
	}
	
	private static void testCalcularConsolaPorPais(Covids covids) {
		// TODO Auto-generated method stub
		System.out.println("TEST de calcularConsolaPorPais");
		try {
			System.out.println(covids.calcularConsolaPorPais() + "\n");
		} catch (Exception e) {
			System.out.println("Excepcion Capturada" + e);
		}
		
	}
	
	private static void testTotalPositivosPorPais(Covids covids) {
		// TODO Auto-generated method stub
		System.out.println("TEST de totalPositivosPorPais");
		try {
			System.out.println(covids.totalPositivosPorPais() + "\n");
		} catch (Exception e) {
			System.out.println("Excepcion Capturada" + e);
		}
		
	}
	

}
