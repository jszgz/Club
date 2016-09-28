package xueshe.com.model;

import java.io.Serializable;

public class Club implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String CLno;
	private String CLname;
	private String CLabout;
	public String getCLno() {
		return CLno;
	}
	public void setCLno(String cLno) {
		CLno = cLno;
	}
	public String getCLname() {
		return CLname;
	}
	public void setCLname(String cLname) {
		CLname = cLname;
	}
	public String getCLabout() {
		return CLabout;
	}
	public void setCLabout(String cLabout) {
		CLabout = cLabout;
	}

}
