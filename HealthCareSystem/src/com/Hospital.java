package com;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Hospital {

	@Override
	public String toString() {
		return "Hospital [id=" + id + ", hospitalName=" + hospitalName + ", email=" + email + ", Province=" + Province
				+ ", city=" + city + ", postalCode=" + postalCode + ", phoneNo=" + phoneNo + ", emergencyRoom="
				+ emergencyRoom + ", surgical=" + surgical + ", xray=" + xray + ", laboratory=" + laboratory
				+ ", Goverment=" + Goverment + "]";
	}
	private int id;
	private String hospitalName;
	private String email;
	private String Province;
	private String city;
	private int postalCode;
	private int phoneNo;
	private boolean emergencyRoom,surgical,xray,laboratory;
	private boolean Goverment;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProvince() {
		return Province;
	}
	public void setProvince(String province) {
		Province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	public boolean isEmergencyRoom() {
		return emergencyRoom;
	}
	public void setEmergencyRoom(boolean emergencyRoom) {
		this.emergencyRoom = emergencyRoom;
	}
	public boolean isSurgical() {
		return surgical;
	}
	public void setSurgical(boolean surgical) {
		this.surgical = surgical;
	}
	public boolean isXray() {
		return xray;
	}
	public void setXray(boolean xray) {
		this.xray = xray;
	}
	public boolean isLaboratory() {
		return laboratory;
	}
	public void setLaboratory(boolean laboratory) {
		this.laboratory = laboratory;
	}
	public boolean isGoverment() {
		return Goverment;
	}
	public void setGoverment(boolean goverment) {
		Goverment = goverment;
	}
	
}

