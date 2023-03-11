package fp.covid.test;

import java.time.LocalDate;

import fp.common.TipoSymptom;
import fp.covid.Covid;

public class TestCovid {
	public static void mian(String[] args) {
		Covid c1 = new Covid(0,9,43,"Italy",LocalDate.of(2020,03,11),38.7,false,TipoSymptom.Fever);
		Covid c2 = new Covid(10,19,85,"Italy",LocalDate.of(2020,03,11),39.6,false,TipoSymptom.Fever);
		Covid c3 = new Covid(20,29,296,"Italy",LocalDate.of(2020,03,11),39.8,false,TipoSymptom.Fever);
		Covid c4 = new Covid(20,29,296,"Italy",LocalDate.of(2020,03,11),39.8,false,TipoSymptom.Fever);
		//c1.setAge_start(10);  //Funciona Correctamente
		//c1.setAge_end(20); //Funciona Correctamente
		//c1.setPositive(30); //Funciona Correctamente
		//c1.setCountry("China"); //Funciona Correctamente
		//c1.setDate(LocalDate.of(1994, 3, 30)); //FuncionaCorrectamente
		//c1.setDeath_case("true");//Funciona Correctamente
		//c1.setSymptom("Cough");//Funciona Correctamente
		//c1.setAverage_temperature(38.1);//Funciona Correctamente
		
		//SYSO
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c1.getYear_date());
		System.out.println(c1.getTemperatura());		
		System.out.println(c1.equals(c3)); 
		System.out.println(c1.equals(c4)); 
		System.out.println(c3 == c4); //Identidad
		System.out.println(c1.compareTo(c2)); //CompareTo
		System.out.println(c1.compareTo(c3)); //CompareTo
		
		
		
		
		
		
	}

}
