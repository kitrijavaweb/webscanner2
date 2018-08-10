package pattern;

public class PartternDTO {
	private String name; 
	private String pattern;
	
	
	public PartternDTO() {
		super();
	}


	public PartternDTO(String name, String pattern) {
		super();
		this.name = name;
		this.pattern = pattern;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPattern() {
		return pattern;
	}


	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
	
}
