package fp.covid.test;

import fp.covid.Covids;
import fp.covid.FactoriaCovids;

public class TestFactoriaCovids {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testFactoriaCovids("data/dataset_covid.csv");
	}
	
	private static void testFactoriaCovids(String fichero) {
		System.out.println("\nTestLeerPartidas =============");
		Covids covids = FactoriaCovids.leerCovids(fichero); 
		System.out.println("   Covids : "+ covids+"\n");
	}

}
