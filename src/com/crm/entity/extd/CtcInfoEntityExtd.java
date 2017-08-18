package com.crm.entity.extd;

import com.crm.entity.CrmIdEntity;

public class CtcInfoEntityExtd extends CrmIdEntity {
	private String ctcId;
	private String ctcName;
	private String custName;
	private String ctcTitle;
	private String ctcCel;
	private String ctcTel;
	private String ctcFax;
	private String ctcMail;
	private String ctcProv;
	private String ctcCity;
	private String ctcAddr;
	private String ctcRmk;
	
	public String getCtcId() {
		return ctcId;
	}
	public void setCtcId(String ctcId) {
		this.ctcId = ctcId;
	}
	public String getCtcName() {
		return ctcName;
	}
	public void setCtcName(String ctcName) {
		this.ctcName = ctcName;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCtcTitle() {
		return ctcTitle;
	}
	public void setCtcTitle(String ctcTitle) {
		this.ctcTitle = ctcTitle;
	}
	public String getCtcCel() {
		return ctcCel;
	}
	public void setCtcCel(String ctcCel) {
		this.ctcCel = ctcCel;
	}
	public String getCtcTel() {
		return ctcTel;
	}
	public void setCtcTel(String ctcTel) {
		this.ctcTel = ctcTel;
	}
	public String getCtcFax() {
		return ctcFax;
	}
	public void setCtcFax(String ctcFax) {
		this.ctcFax = ctcFax;
	}
	public String getCtcMail() {
		return ctcMail;
	}
	public void setCtcMail(String ctcMail) {
		this.ctcMail = ctcMail;
	}
	public String getCtcProv() {
		return ctcProv;
	}
	public void setCtcProv(String ctcProv) {
		this.ctcProv = ctcProv;
	}
	public String getCtcCity() {
		return ctcCity;
	}
	public void setCtcCity(String ctcCity) {
		this.ctcCity = ctcCity;
	}
	public String getCtcAddr() {
		return ctcAddr;
	}
	public void setCtcAddr(String ctcAddr) {
		this.ctcAddr = ctcAddr;
	}
	public String getCtcRmk() {
		return ctcRmk;
	}
	public void setCtcRmk(String ctcRmk) {
		this.ctcRmk = ctcRmk;
	}
	
	@Override
	public String toString() {
		return "CtcInfoEntityExtd [ctcId=" + ctcId + ", ctcName=" + ctcName + ", custName=" + custName + ", ctcTitle="
				+ ctcTitle + ", ctcCel=" + ctcCel + ", ctcTel=" + ctcTel + ", ctcFax=" + ctcFax + ", ctcMail=" + ctcMail
				+ ", ctcProv=" + ctcProv + ", ctcCity=" + ctcCity + ", ctcAddr=" + ctcAddr + ", ctcRmk=" + ctcRmk
				+ ", crmId=" + crmId + "]";
	}
	
}
