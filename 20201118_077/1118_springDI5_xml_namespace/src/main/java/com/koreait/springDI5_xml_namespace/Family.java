package com.koreait.springDI5_xml_namespace;

public class Family {

	private String papaName;
	private String mamiName;
	private String sisterName;
	private String brotherName;
	
	public Family() { }
	public Family(String papaName, String mamiName) {
		super();
		this.papaName = papaName;
		this.mamiName = mamiName;
	}
	
	public String getPapaName() {
		return papaName;
	}
	public void setPapaName(String papaName) {
		this.papaName = papaName;
	}
	public String getMamiName() {
		return mamiName;
	}
	public void setMamiName(String mamiName) {
		this.mamiName = mamiName;
	}
	public String getSisterName() {
		return sisterName;
	}
	public void setSisterName(String sisterName) {
		this.sisterName = sisterName;
	}
	public String getBrotherName() {
		return brotherName;
	}
	public void setBrotherName(String brotherName) {
		this.brotherName = brotherName;
	}
	
	@Override
	public String toString() {
		return "Family [papaName=" + papaName + ", mamiName=" + mamiName + ", sisterName=" + sisterName
				+ ", brotherName=" + brotherName + "]";
	}
	
}
