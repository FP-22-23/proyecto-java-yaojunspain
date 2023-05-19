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
		testCalcularCovidPorPais(covids);
		testTotalPositivosPorPais(covids);		
		System.out.println("Existe este pais?" + covids.existeCountry("Norway") + "\n");
		testCalcularMaxTemperaturaPorPais(covids,"Italy");
		testCalcularMinTemperaturaPorPais(covids,"Italy");
		testObtenerCovidsPorPaisOrdenado(covids ,"Italy");
		testTotalSintomaPorCovid(covids);
		testTemMaxPorPais(covids,"Italy");
		testGetNTempPorPaisOrdenado(covids,"Italy",5);
		testMayorNumeroCovidPorPais(covids);

	}
	private static void testCalcularNumeroDeFiebre(Covids covids,TipoSymptom	symptom)
	{
		System.out.println("TEST de calcularNumeroDeFiebre");
		try {
			System.out.println(covids.calcularNumeroDeFiebre(symptom) + "\n");
		} catch (Exception e) {
			System.out.println("Excepcion Capturada" + e);
		}
		
	}
	
	private static void testObtenerCovidsPorPais(Covids covids, String country) {
		System.out.println("TEST de obtenerCovidsPorPais");
		try {
			System.out.println(covids.obtenerCovidsPorPais(country) + "\n");
		} catch (Exception e) {
			System.out.println("Excepcion Capturada" + e);
		}
		
	}
	
	private static void testCalcularCovidPorPais(Covids covids) {
		System.out.println("TEST de calcularConsolaPorPais");
		try {
			System.out.println(covids.calcularCovidPorPais() + "\n");
		} catch (Exception e) {
			System.out.println("Excepcion Capturada" + e);
		}
		
	}
	
	private static void testTotalPositivosPorPais(Covids covids) {
		System.out.println("TEST de totalPositivosPorPais");
		try {
			System.out.println(covids.totalPositivosPorPais() + "\n");
		} catch (Exception e) {
			System.out.println("Excepcion Capturada" + e);
		}		
	}
	private static void testCalcularMaxTemperaturaPorPais(Covids covids,String country) {
		System.out.println("TEST de calcularMaxTemperaturaPorPais");
		try {
			System.out.println(covids.calcularMaxTemperaturaPorPais(country) + "\n");
		} catch (Exception e) {
			System.out.println("Excepcion Capturada" + e);
		}		
	}
	private static void testCalcularMinTemperaturaPorPais(Covids covids,String country) {
		System.out.println("TEST de calcularMinTemperaturaPorPais");
		try {
			System.out.println(covids.calcularMinTemperaturaPorPais(country) + "\n");
		} catch (Exception e) {
			System.out.println("Excepcion Capturada" + e);
		}		
	}
	private static void testObtenerCovidsPorPaisOrdenado(Covids covids,String country) {
		System.out.println("TEST de obtenerCovidsPorPaisOrdenado");
		try {
			System.out.println(covids.obtenerCovidsPorPaisOrdenado(country) + "\n");
		} catch (Exception e) {
			System.out.println("Excepcion Capturada" + e);
		}		
	}
	private static void testTotalSintomaPorCovid(Covids covids) {
		System.out.println("TEST de totalSintomaPorCovid");
		try {
			System.out.println(covids.totalSintomaPorCovid() + "\n");
		} catch (Exception e) {
			System.out.println("Excepcion Capturada" + e);
		}		
	}
	private static void testTemMaxPorPais(Covids covids,String country) {
		System.out.println("TEST de temMaxPorPais");
		try {
			System.out.println(covids.temMaxPorPais(country) + "\n");
		} catch (Exception e) {
			System.out.println("Excepcion Capturada" + e);
		}		
	}
	private static void testGetNTempPorPaisOrdenado(Covids covids,String country,Integer n) {
		System.out.println("TEST de getNTempPorPais");
		try {
			System.out.println(covids.getNTempPorPaisOrdenado(n,country) + "\n");
		} catch (Exception e) {
			System.out.println("Excepcion Capturada" + e);
		}		
	}
	private static void testMayorNumeroCovidPorPais(Covids covids) {
		System.out.println("TEST de mayorNumeroCovidPorPais");
		try {
			System.out.println(covids.mayorNumeroCovidPorPais() + "\n");
		} catch (Exception e) {
			System.out.println("Excepcion Capturada" + e);
		}		
	}
	

}
