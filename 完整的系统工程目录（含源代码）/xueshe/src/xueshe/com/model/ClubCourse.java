package xueshe.com.model;

import java.io.Serializable;

public class ClubCourse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String CLno;
	private String Cno;
	public String getCLno() {
		return CLno;
	}
	public void setCLno(String cLno) {
		CLno = cLno;
	}
	public String getCno() {
		return Cno;
	}
	public void setCno(String cno) {
		Cno = cno;
	}
}
