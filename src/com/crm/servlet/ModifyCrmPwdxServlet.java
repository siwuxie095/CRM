package com.crm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.entity.extd.CrmPwdxEntityExtd;
import com.crm.service.ModifyCrmPwdxService;

public class ModifyCrmPwdxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ModifyCrmPwdxService modCrmPwdx=new ModifyCrmPwdxService();
       
    public ModifyCrmPwdxServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String forward=null;
		
		CrmPwdxEntityExtd crmPwdx=new CrmPwdxEntityExtd();
		
		String modMode=null;
		modMode=request.getParameter("modMode");
		
		
		if (modMode.equals("byAdmin")) {
			
			String crmId=request.getParameter("crmId");
			String crmPwd=request.getParameter("crmPwd");
			crmPwdx.setCrmId(crmId);
			crmPwdx.setCrmPwd(crmPwd);
			modCrmPwdx.modifyCrmPwdx(crmPwdx);
			
			forward="/xcrm/sys_mgt/crm_pwd_mgt.jsp";
			
		} else {
			
			String crmId=request.getSession().getAttribute("crmId").toString();
			String crmPwd=request.getParameter("crmPwd");
			crmPwdx.setCrmId(crmId);
			crmPwdx.setCrmPwd(crmPwd);
			modCrmPwdx.modifyCrmPwdx(crmPwdx);
			
			request.setAttribute("msg", "修改密码成功，正在前往首页...");
			forward="/xcrm/crm_mgt_jump/mod_succ.jsp";
			
		}
		
		RequestDispatcher rd=request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

}
