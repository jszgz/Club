package xueshe.com.model;

import java.io.Serializable;

public class StudentCourse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String Sno;
	private String Cno;
	private double SCgrade;
	public String getSno() {
		return Sno;
	}
	public void setSno(String sno) {
		Sno = sno;
	}
	public String getCno() {
		return Cno;
	}
	public void setCno(String cno) {
		Cno = cno;
	}
	public double getSCgrade() {
		return SCgrade;
	}
	public void setSCgrade(double sCgrade) {
		SCgrade = sCgrade;
	}

}
