package com.crm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.entity.extd.LogInfoEntityExtd;
import com.crm.service.DeleteLogInfoService;

public class DeleteLogInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeleteLogInfoService delLogInfo=new DeleteLogInfoService();
       
    public DeleteLogInfoServlet() {
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
			
			String logId=request.getParameter("logId");
			LogInfoEntityExtd logInfo=new LogInfoEntityExtd();
			logInfo.setLogId(logId);
			delLogInfo.deleteLogInfo(logInfo);
			
		}else if (delMode.equals("mul")) {
			
			String logIds=request.getParameter("logIds");
			String logIdsList[]=logIds.split("#");
			LogInfoEntityExtd logInfo[]=new LogInfoEntityExtd[logIdsList.length];
			for (int i = 0; i < logInfo.length; i++) {
				logInfo[i]=new LogInfoEntityExtd();
				logInfo[i].setLogId(logIdsList[i]);
			}
			delLogInfo.deleteMulLogInfo(logInfo);
		}
		
		forward="/xcrm/log_mgt/qry_all_log_info.jsp";
		rd=request.getRequestDispatcher(forward);
		rd.forward(request, response);
		
	}

}
