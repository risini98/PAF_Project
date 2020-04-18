package com;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Payment {
	private int paymentId;
	private String patientName;
	private int amout;
	private String type;
	private int date;
	
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getAmout() {
		return amout;
	}
	public void setAmout(int amout) {
		this.amout = amout;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", patientName=" + patientName + ", amout=" + amout + ", type="
				+ type + ", date=" + date + "]";
	}
	

}