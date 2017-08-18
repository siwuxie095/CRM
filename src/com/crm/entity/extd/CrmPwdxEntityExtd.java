package com.crm.entity.extd;

import com.crm.entity.CrmIdEntity;

public class CrmPwdxEntityExtd extends CrmIdEntity {
	private String crmPwd;
	
	public String getCrmPwd() {
		return crmPwd;
	}
	public void setCrmPwd(String crmPwd) {
		this.crmPwd = crmPwd;
	}
	
	@Override
	public String toString() {
		return "CrmPwdxEntityExtd [crmPwd=" + crmPwd + ", crmId=" + crmId + "]";
	}
}
