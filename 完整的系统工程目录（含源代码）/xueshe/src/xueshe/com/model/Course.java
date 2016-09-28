package xueshe.com.model;

import java.io.Serializable;

public class Course implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String Cno;
	private String Cname;
	private String Cyear;
	private String Cteacher;
	public String getCno() {
		return Cno;
	}
	public void setCno(String cno) {
		Cno = cno;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public String getCyear() {
		return Cyear;
	}
	public void setCyear(String cyear) {
		Cyear = cyear;
	}
	public String getCteacher() {
		return Cteacher;
	}
	public void setCteacher(String cteacher) {
		Cteacher = cteacher;
	}
}
