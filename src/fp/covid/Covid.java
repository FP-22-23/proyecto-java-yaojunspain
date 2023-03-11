package fp.covid;

import java.time.LocalDate;
import java.util.Objects;

import fp.common.TipoSymptom;
import fp.utiles.Checkers;

public class Covid implements Comparable<Covid> {
	//Propiedades
		private Integer age_start;
		private Integer age_end;
		private Integer positive;
		private String country;
		private LocalDate date;
		private Double average_temperature;
		private Boolean death_case;
		private TipoSymptom symptom;
		
		
		
		//Restricciones otra forma para hacerlo pero mejor con checker!!!!
		//R1-age_start tiene que ser un valor entre 0 y 150
		//private Boolean check_age_start(Integer age_start){
		//	Boolean r = true;
		//	if(age_start<0||age_start>150) {
		//		r=false;
		//	}
		//	return r;
	//	}
		//R2-age_end tiene que ser un valor entre 0 y 150
		//private Boolean check_age_end(Integer age_end){
			//Boolean r = true;
			//if(age_end<0||age_end>150) {
		//		r=false;
		//	}
	//		return r;
	//	}
	//	//R3-los tipo de symptom en dataset solamente hay 3
	//	private Boolean check_date(LocalDate date) {
		//	Boolean r = true;
			//if(date.getYear()!=2020) {
			//	r=false;
	//		}
		//	return r;
	//	}
		//Contructores
		//Contructor1
		public Covid(Integer age_start,Integer age_end,Integer positive,String country,LocalDate date,Double average_temperature,Boolean death_case,TipoSymptom symptom) {
			//R1
			//if (check_age_start(age_start) == false) {
			//	throw new IllegalArgumentException("Error de Edad start");
		//	}
			//R2 

			//if (check_age_end(age_end) == false) {
				//throw new IllegalArgumentException("Error de Edad end");
		//	}
			
			
			//R3
			//if (check_date(date) == false) {
				//throw new IllegalArgumentException("El año que tenemos solamente hay 2020");
			//}
			Checkers.check("Error de age_start",age_start>=0);
			Checkers.check("Error de age_end",age_start>=0);
			Checkers.check("Error de num de positivo",positive>=0);
			
			
			this.age_start = age_start;
			this.age_end = age_end;
			this.positive = positive;
			this.country = country;
			this.date = date;
			this.average_temperature = average_temperature;
			this.death_case = death_case;
			this.symptom = symptom;
			
		}
		//Contructor2 añadir valores por defecto en los parametros
		public Covid(Integer age_start,Integer age_end,Integer positive,String country) {
			this.age_start = age_start;
			this.age_end = age_end;
			this.positive = positive;
			this.country = country;
		}
		
		
		public Integer getAge_start() {
			return age_start;
		}
		public void setAge_start(Integer age_start) {
			Checkers.check("Error de age_start", age_start>=0);
			this.age_start = age_start;
		}
		public Integer getAge_end() {
			return age_end;
		}
		public void setAge_end(Integer age_end) {
			Checkers.check("Error de age_end", age_end>=0);
			this.age_end = age_end;
		}
		public Integer getPositive() {
			return positive;
		}
		public void setPositive(Integer positive) {
			Checkers.check("Error de num de positivo", positive>=0);
			this.positive = positive;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public LocalDate getDate() {
			return date;
		}
		public void setDate(LocalDate date) {
			this.date = date;
		}
		public Double getAverage_temperature() {
			return average_temperature;
		}
		public void setAverage_temperature(Double average_temperature) {
			this.average_temperature = average_temperature;
		}
		public Boolean getDeath_case() {
			return death_case;
		}
		public void setDeath_case(Boolean death_case) {
			this.death_case = death_case;
		}
		public TipoSymptom getSymptom() {
			return symptom;
		}
		public void setSymptom(TipoSymptom symptom) {
			this.symptom = symptom;
		}
		//Propiedad Derivada
		public Integer getYear_date() {
			return this.date.getYear();
		}
		public String getTemperatura() {
			if(this.getAverage_temperature() >=39.5) {
				String estado = "peligroso alto";
				return estado;
			}
			else if(this.getAverage_temperature()<=39.5 && this.getAverage_temperature()>=38.5) {
				String estado = "peligroso medio";
				return estado;
			}
			else {
				String estado = "peligroso bajo";
				return estado;				
			}
		}
		
		
		//ToString  una representación como cadena.
		@Override
		public String toString() {
			return "Covid [age_start=" + age_start + ", age_end=" + age_end + ", positive=" + positive + ", country="
					+ country + ", date=" + date + ", average_temperature=" + average_temperature + ", death_case="
					+ death_case + ", symptom=" + symptom + "]";
		}
		//Orden Natural
		public int compareTo(Covid c) {
			int r;
			if (c == null) {
				throw new NullPointerException();
			}
			
			r = this.getAge_start().compareTo(c.getAge_start());
			if (r == 0) {
				r = this.getAge_end().compareTo(c.getAge_end());
				if (r == 0) {
					r = this.getCountry().compareTo(c.getCountry());
				}
			}
					
			return r;
			
		}
		//hashCode criterio de igualidad
		@Override
		public int hashCode() {
			return Objects.hash(age_end, age_start, average_temperature, country, date, death_case, positive, symptom);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Covid other = (Covid) obj;
			return Objects.equals(age_end, other.age_end) && Objects.equals(age_start, other.age_start)
					&& Objects.equals(average_temperature, other.average_temperature)
					&& Objects.equals(country, other.country) && Objects.equals(date, other.date)
					&& Objects.equals(death_case, other.death_case) && Objects.equals(positive, other.positive)
					&& symptom == other.symptom;
		}
		
}
