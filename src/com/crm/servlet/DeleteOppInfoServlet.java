package com.crm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.entity.extd.OppInfoEntityExtd;
import com.crm.service.DeleteOppInfoService;

public class DeleteOppInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeleteOppInfoService delOppInfo=new DeleteOppInfoService();
       
    public DeleteOppInfoServlet() {
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
			
			String oppId=request.getParameter("oppId");
			OppInfoEntityExtd oppInfo=new OppInfoEntityExtd();
			oppInfo.setOppId(oppId);
			delOppInfo.deleteOppInfo(oppInfo);
			
		}else if (delMode.equals("mul")) {
			
			String oppIds=request.getParameter("oppIds");
			String oppIdsList[]=oppIds.split("#");
			OppInfoEntityExtd oppInfo[]=new OppInfoEntityExtd[oppIdsList.length];
			for (int i = 0; i < oppInfo.length; i++) {
				oppInfo[i]=new OppInfoEntityExtd();
				oppInfo[i].setOppId(oppIdsList[i]);
			}
			delOppInfo.deleteMulOppInfo(oppInfo);
		}
		
		forward="/xcrm/opp_mgt/qry_all_opp_info.jsp";
		rd=request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

}
