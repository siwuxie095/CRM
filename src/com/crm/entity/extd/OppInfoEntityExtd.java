package com.crm.entity.extd;

import com.crm.entity.CrmNameEntity;

public class OppInfoEntityExtd extends CrmNameEntity {
	private String oppId;
	private String oppName;
	private String custName;
	private String ctcName;
	private String prodSort;
	private String preDealDate;
	private String preSaleSum;
	private String oppSrc;
	private String saleStg;
	private String succPer;
	private String oppRmk;
	
	public String getOppId() {
		return oppId;
	}
	public void setOppId(String oppId) {
		this.oppId = oppId;
	}
	public String getOppName() {
		return oppName;
	}
	public void setOppName(String oppName) {
		this.oppName = oppName;
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
	public String getProdSort() {
		return prodSort;
	}
	public void setProdSort(String prodSort) {
		this.prodSort = prodSort;
	}
	public String getPreDealDate() {
		return preDealDate;
	}
	public void setPreDealDate(String preDealDate) {
		this.preDealDate = preDealDate;
	}
	public String getPreSaleSum() {
		return preSaleSum;
	}
	public void setPreSaleSum(String preSaleSum) {
		this.preSaleSum = preSaleSum;
	}
	public String getOppSrc() {
		return oppSrc;
	}
	public void setOppSrc(String oppSrc) {
		this.oppSrc = oppSrc;
	}
	public String getSaleStg() {
		return saleStg;
	}
	public void setSaleStg(String saleStg) {
		this.saleStg = saleStg;
	}
	public String getSuccPer() {
		return succPer;
	}
	public void setSuccPer(String succPer) {
		this.succPer = succPer;
	}
	public String getOppRmk() {
		return oppRmk;
	}
	public void setOppRmk(String oppRmk) {
		this.oppRmk = oppRmk;
	}
	
	@Override
	public String toString() {
		return "OppInfoEntityExtd [oppId=" + oppId + ", oppName=" + oppName + ", custName=" + custName + ", ctcName="
				+ ctcName + ", prodSort=" + prodSort + ", preDealDate=" + preDealDate + ", preSaleSum=" + preSaleSum
				+ ", oppSrc=" + oppSrc + ", saleStg=" + saleStg + ", succPer=" + succPer + ", oppRmk=" + oppRmk
				+ ", crmName=" + crmName + "]";
	}
	
}
