package fp.common;

public record CovidDatos(Integer age_start,Integer age_end) {

	public Integer age_start() {
		return age_start;
	}

	public Integer age_end() {
		return age_end;
	}

}
