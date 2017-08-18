package com.crm.entity.extd;

import com.crm.entity.CrmNameEntity;

public class LogInfoEntityExtd extends CrmNameEntity {
	private String logId;
	private String logThm;
	private String ctcxStyle;
	private String ctcxDate;
	private String custName;
	private String ctcName;
	private String oppId;
	private String nextVistDate;
	private String ctcxDetail;
	
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
	}
	public String getLogThm() {
		return logThm;
	}
	public void setLogThm(String logThm) {
		this.logThm = logThm;
	}
	public String getCtcxStyle() {
		return ctcxStyle;
	}
	public void setCtcxStyle(String ctcxStyle) {
		this.ctcxStyle = ctcxStyle;
	}
	public String getCtcxDate() {
		return ctcxDate;
	}
	public void setCtcxDate(String ctcxDate) {
		this.ctcxDate = ctcxDate;
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
	public String getNextVistDate() {
		return nextVistDate;
	}
	public void setNextVistDate(String nextVistDate) {
		this.nextVistDate = nextVistDate;
	}
	public String getCtcxDetail() {
		return ctcxDetail;
	}
	public void setCtcxDetail(String ctcxDetail) {
		this.ctcxDetail = ctcxDetail;
	}
	@Override
	public String toString() {
		return "LogInfoEntityExtd [logId=" + logId + ", logThm=" + logThm + ", ctcxStyle=" + ctcxStyle + ", ctcxDate="
				+ ctcxDate + ", custName=" + custName + ", ctcName=" + ctcName + ", oppId=" + oppId + ", nextVistDate="
				+ nextVistDate + ", ctcxDetail=" + ctcxDetail + ", crmName=" + crmName + "]";
	}
	
	
}
