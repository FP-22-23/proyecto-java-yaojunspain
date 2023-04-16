package fp.covid;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

import fp.common.TipoSymptom;
import fp.utiles.Checkers;

public class FactoriaCovids {
	public static Covids leerCovids(String rutaFichero) {
		Covids res = null;
		try {
			Stream<Covid> sv =
					Files.lines(Paths.get(rutaFichero))
					.skip(1)
					.map(FactoriaCovids::parsearCovid);
			res = new Covids(sv);
		}catch(IOException e) {
			System.out.println("No se ha encontrado el fichero" + rutaFichero);
		}
		return res;
	}
	public static Covid parsearCovid(String lineaCSV) {
		String[] campos = lineaCSV.split(";");
		Checkers.check("La linea debe contener 8 elementos ",campos.length==8);
		Integer age_start = Integer.valueOf(campos[0].trim());
		Integer age_end = Integer.valueOf(campos[1].trim());
		Integer positive = Integer.valueOf(campos[2].trim());
		String country = campos[3].trim();
		LocalDate date = LocalDate.parse(campos[4].trim(), DateTimeFormatter.ofPattern("M/dd/yyyy"));
		Double average_temperature = parseaDouble(campos[5].trim());
		Boolean death_case = Boolean.parseBoolean(campos[6].trim());
		TipoSymptom symptom = TipoSymptom.valueOf(campos[7].trim());
		return new Covid(age_start,age_end,positive,country,date,average_temperature,death_case,symptom);
		
	}
	private static Double parseaDouble(String cadena) {
		String[] cadenas = cadena.split(",");
		String nuevaCadena="";
		if(cadenas.length==1) {
			nuevaCadena=cadenas[0];
		}
		else {
			nuevaCadena=cadenas[0]+"."+cadenas[1];
		}
		return Double.parseDouble(nuevaCadena);
	}
}
