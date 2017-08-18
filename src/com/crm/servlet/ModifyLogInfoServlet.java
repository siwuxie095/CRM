package com.crm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.entity.extd.LogInfoEntityExtd;
import com.crm.service.ModifyLogInfoService;

public class ModifyLogInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ModifyLogInfoService modLogInfo=new ModifyLogInfoService();
       
    public ModifyLogInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String crmName=request.getSession().getAttribute("crmName").toString();
		String logId=request.getParameter("logId");
		String logThm=request.getParameter("logThm");
		String custName=request.getParameter("custName");
		String ctcName=request.getParameter("ctcName");
		String oppId=request.getParameter("oppId");
		String ctcxStyle=request.getParameter("ctcxStyle");
		String ctcxDate=request.getParameter("ctcxDate");
		String ctcxDetail=request.getParameter("ctcxDetail");
		String nextVisitDate=request.getParameter("nextVisitDate");
		
		LogInfoEntityExtd logInfo=new LogInfoEntityExtd();
		
		logInfo.setCrmName(crmName);
		logInfo.setLogId(logId);
		logInfo.setLogThm(logThm);
		logInfo.setCustName(custName);
		logInfo.setCtcName(ctcName);
		logInfo.setOppId(oppId);
		logInfo.setCtcxStyle(ctcxStyle);
		logInfo.setCtcxDate(ctcxDate);
		logInfo.setCtcxDetail(ctcxDetail);
		logInfo.setNextVistDate(nextVisitDate);
		
		modLogInfo.modifyLogInfo(logInfo);
		
		String forward="/xcrm/log_mgt/qry_dtl_log_info_by_id.jsp?logId="+logId;
		RequestDispatcher rd=request.getRequestDispatcher(forward);
		rd.forward(request, response);
		
	}

}
