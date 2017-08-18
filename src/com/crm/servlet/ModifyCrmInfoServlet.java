package com.crm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.entity.extd.CrmInfoEntityExtd;
import com.crm.service.ModifyCrmInfoService;

public class ModifyCrmInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ModifyCrmInfoService modCrmInfo=new ModifyCrmInfoService();
       
    public ModifyCrmInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String crmId=request.getParameter("crmId");
		String crmName=request.getParameter("crmName");
		String crmTitle=request.getParameter("crmTitle");
		String crmRole=request.getParameter("crmRole");
		
		request.getSession().setAttribute("crmName", crmName);
		
		String forward=null;
		
		CrmInfoEntityExtd crmInfo=new CrmInfoEntityExtd();
		crmInfo.setCrmId(crmId);
		crmInfo.setCrmName(crmName);
		crmInfo.setCrmTitle(crmTitle);
		crmInfo.setCrmRole(crmRole);
		
		modCrmInfo.modifyCrmInfo(crmInfo);
		
		String modMode=request.getParameter("modMode");
		if (modMode.equals("byAdmin")) {
			forward="/xcrm/sys_mgt/crm_role_mgt.jsp";
		} else {
			request.setAttribute("msg", "修改个人信息成功，正在前往首页...");
			forward="/xcrm/crm_mgt_jump/mod_succ.jsp";
		}
		
		
		RequestDispatcher rd=request.getRequestDispatcher(forward);
		rd.forward(request, response);
		
	}

}
