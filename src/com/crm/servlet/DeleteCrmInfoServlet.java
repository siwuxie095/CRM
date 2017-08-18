package com.crm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.entity.extd.CrmInfoEntityExtd;
import com.crm.entity.extd.CrmPwdxEntityExtd;
import com.crm.service.DeleteCrmInfoService;

public class DeleteCrmInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeleteCrmInfoService delCrmInfo=new DeleteCrmInfoService();
        
    public DeleteCrmInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String delMode=request.getParameter("delMode");
		RequestDispatcher rd = null;
		String forward=null;
		if (delMode.equals("sgl")) {
			String crmId=request.getParameter("crmId");
			CrmInfoEntityExtd crmInfo=new CrmInfoEntityExtd();
			crmInfo.setCrmId(crmId);
			CrmPwdxEntityExtd crmPwdx=new CrmPwdxEntityExtd();
			crmPwdx.setCrmId(crmId);
			delCrmInfo.deleteCrmInfo(crmInfo, crmPwdx);
			
		}else if (delMode.equals("mul")) {
			
			String crmIds=request.getParameter("crmIds");
			String crmIdsList[]=crmIds.split("#");
			CrmInfoEntityExtd crmInfo[]=new CrmInfoEntityExtd[crmIdsList.length];
			CrmPwdxEntityExtd crmPwdx[]=new CrmPwdxEntityExtd[crmIdsList.length];
			for (int i = 0; i < crmInfo.length; i++) {
				crmInfo[i]=new CrmInfoEntityExtd();
				crmInfo[i].setCrmId(crmIdsList[i]);
				crmPwdx[i]=new CrmPwdxEntityExtd();
				crmPwdx[i].setCrmId(crmIdsList[i]);
			}
			delCrmInfo.deleteMulCrmInfo(crmInfo, crmPwdx);
		}
		
		
		String rtnUri=request.getParameter("rtnUri");
		if (rtnUri.indexOf("pwd")!=-1) {
			forward="/xcrm/sys_mgt/crm_pwd_mgt.jsp";
		}else if (rtnUri.indexOf("role")!=-1) {
			forward="/xcrm/sys_mgt/crm_role_mgt.jsp";
		}
		
		
		rd=request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

}
