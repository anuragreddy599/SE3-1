package beans;

public class Degree {
	
	String code,gradSchool,name,forecast;

	public Degree(String code, String gradSchool, String name, String forecast) {
		super();
		this.code = code;
		this.gradSchool = gradSchool;
		this.name = name;
		this.forecast = forecast;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getGradSchool() {
		return gradSchool;
	}

	public void setGradSchool(String gradSchool) {
		this.gradSchool = gradSchool;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getForecast() {
		return forecast;
	}

	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	
	@Override
	public String toString(){
		return code+"\n"+gradSchool+"\n"+name+"\n"+forecast;
	}

}
