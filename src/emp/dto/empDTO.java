package emp.dto;

import java.sql.Date;

public class empDTO {
	private String id;
	private String name;
	private String pass;
	private String urlpath;
	
	public empDTO(String id, String name, String pass, String urlpath) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.urlpath = urlpath;
	}
	
	public String getUrlpath() {
		return urlpath;
	}
	public void setUrlpath(String urlpath) {
		this.urlpath = urlpath;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
}
