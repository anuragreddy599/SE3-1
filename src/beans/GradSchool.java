package beans;

public class GradSchool {
	
	private String name,abbrevation;

	public GradSchool(String name, String abbrevation) {
		super();
		this.name = name;
		this.abbrevation = abbrevation;
	}

	public String getName() {
		return name;
	}

	public String getAbbrevation() {
		return abbrevation;
	}
	
	@Override
	public String toString(){
		return this.name+"\n"+this.abbrevation;
	}

}
