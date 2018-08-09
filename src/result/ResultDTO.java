package result;

public class ResultDTO {
	private String id;
	private String des;
	private String sol;
	private String link;
	
	public ResultDTO() {
		super();
	}
	
	public ResultDTO(String id, String des, String sol, String link) {
		super();
		this.id = id;
		this.des = des;
		this.sol = sol;
		this.link = link;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getSol() {
		return sol;
	}
	public void setSol(String sol) {
		this.sol = sol;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	
}
