package com.crm.entity.extd;

import com.crm.entity.CrmNameEntity;

public class DealInfoEntityExtd extends CrmNameEntity {
	private String dealId;
	private String dealThm;
	private String custName;
	private String ctcName;
	private String oppId;
	private String ofrId;
	private String dealStatus;
	private String dealDate;
	private String overDate;
	private String saleSum;
	private String prodSort;
	
	public String getDealId() {
		return dealId;
	}
	public void setDealId(String dealId) {
		this.dealId = dealId;
	}
	public String getDealThm() {
		return dealThm;
	}
	public void setDealThm(String dealThm) {
		this.dealThm = dealThm;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCtcName() {
		return ctcName;
	}
	public void setCtcName(String ctcName) {
		this.ctcName = ctcName;
	}
	public String getOppId() {
		return oppId;
	}
	public void setOppId(String oppId) {
		this.oppId = oppId;
	}
	public String getOfrId() {
		return ofrId;
	}
	public void setOfrId(String ofrId) {
		this.ofrId = ofrId;
	}
	public String getDealStatus() {
		return dealStatus;
	}
	public void setDealStatus(String dealStatus) {
		this.dealStatus = dealStatus;
	}
	public String getDealDate() {
		return dealDate;
	}
	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
	}
	public String getOverDate() {
		return overDate;
	}
	public void setOverDate(String overDate) {
		this.overDate = overDate;
	}
	public String getSaleSum() {
		return saleSum;
	}
	public void setSaleSum(String saleSum) {
		this.saleSum = saleSum;
	}
	public String getProdSort() {
		return prodSort;
	}
	public void setProdSort(String prodSort) {
		this.prodSort = prodSort;
	}
	
	@Override
	public String toString() {
		return "DealInfoEntityExtd [dealId=" + dealId + ", dealThm=" + dealThm + ", custName=" + custName + ", ctcName="
				+ ctcName + ", oppId=" + oppId + ", ofrId=" + ofrId + ", dealStatus=" + dealStatus + ", dealDate="
				+ dealDate + ", overDate=" + overDate + ", saleSum=" + saleSum + ", prodSort=" + prodSort + ", crmName="
				+ crmName + "]";
	}
}
