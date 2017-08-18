package com.crm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.entity.extd.CrmInfoEntityExtd;
import com.crm.service.CommitCrmInfoService;

public class AddCrmInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommitCrmInfoService cmtCrmInfo=new CommitCrmInfoService();
       
    public AddCrmInfoServlet() {
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
		
		request.getSession().setAttribute("crmId", crmId);
		request.getSession().setAttribute("crmName", crmName);
		request.getSession().setAttribute("crmTitle", crmTitle);
		request.getSession().setAttribute("crmRole", crmRole);
		
		CrmInfoEntityExtd crmInfo=new CrmInfoEntityExtd();
		crmInfo.setCrmId(crmId);
		crmInfo.setCrmName(crmName);
		crmInfo.setCrmTitle(crmTitle);
		crmInfo.setCrmRole(crmRole);
		cmtCrmInfo.commitCrmInfo(crmInfo);
		request.setAttribute("msg", "添加个人信息成功，正在前往首页...");
		String forward="/xcrm/crm_mgt_jump/add_succ.jsp";
		RequestDispatcher rd=request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

}
