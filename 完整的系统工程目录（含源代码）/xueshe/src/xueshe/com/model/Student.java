package xueshe.com.model;

import java.io.Serializable;

public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String Sno;
	private String Sname;
	private String Ssex;
	private String Spassword;
	public String getSno() {
		return Sno;
	}
	public void setSno(String sno) {
		Sno = sno;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public String getSsex() {
		return Ssex;
	}
	public void setSsex(String ssex) {
		Ssex = ssex;
	}
	public String getSpassword() {
		return Spassword;
	}
	public void setSpassword(String spassword) {
		Spassword = spassword;
	}
}
