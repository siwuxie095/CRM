package com.crm.entity.extd;

import com.crm.entity.CrmIdEntity;

public class CustInfoEntityExtd extends CrmIdEntity {
	private String custId;
	private String custName;
	private String custStatus;
	private String custType;
	private String custLvl;
	private String custInd;
	private String custProv;
	private String custCity;
	private String custAddr;
	private String custRmk;
	
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustStatus() {
		return custStatus;
	}
	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}
	public String getCustType() {
		return custType;
	}
	public void setCustType(String custType) {
		this.custType = custType;
	}
	public String getCustLvl() {
		return custLvl;
	}
	public void setCustLvl(String custLvl) {
		this.custLvl = custLvl;
	}
	public String getCustInd() {
		return custInd;
	}
	public void setCustInd(String custInd) {
		this.custInd = custInd;
	}
	public String getCustProv() {
		return custProv;
	}
	public void setCustProv(String custProv) {
		this.custProv = custProv;
	}
	public String getCustCity() {
		return custCity;
	}
	public void setCustCity(String custCity) {
		this.custCity = custCity;
	}
	public String getCustAddr() {
		return custAddr;
	}
	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}
	public String getCustRmk() {
		return custRmk;
	}
	public void setCustRmk(String custRmk) {
		this.custRmk = custRmk;
	}
	@Override
	public String toString() {
		return "CustInfoEntityExtd [custId=" + custId + ", custName=" + custName + ", custStatus=" + custStatus
				+ ", custType=" + custType + ", custLvl=" + custLvl + ", custInd=" + custInd + ", custProv=" + custProv
				+ ", custCity=" + custCity + ", custAddr=" + custAddr + ", custRmk=" + custRmk + ", crmId=" + crmId
				+ "]";
	}
}
