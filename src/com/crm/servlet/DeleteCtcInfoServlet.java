package com.crm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.entity.extd.CtcInfoEntityExtd;
import com.crm.service.DeleteCtcInfoService;

public class DeleteCtcInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeleteCtcInfoService delCtcInfo=new DeleteCtcInfoService();
       
    public DeleteCtcInfoServlet() {
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
			
			String ctcId=request.getParameter("ctcId");
			CtcInfoEntityExtd ctcInfo=new CtcInfoEntityExtd();
			ctcInfo.setCtcId(ctcId);
			delCtcInfo.deleteCtcInfo(ctcInfo);
			
		}else if (delMode.equals("mul")) {
			
			String ctcIds=request.getParameter("ctcIds");
			String ctcIdsList[]=ctcIds.split("#");
			CtcInfoEntityExtd ctcInfo[]=new CtcInfoEntityExtd[ctcIdsList.length];
			for (int i = 0; i < ctcInfo.length; i++) {
				ctcInfo[i]=new CtcInfoEntityExtd();
				ctcInfo[i].setCtcId(ctcIdsList[i]);
			}
			delCtcInfo.deleteMulCtcInfo(ctcInfo);
		}
		
		forward="/xcrm/ctc_mgt/qry_all_ctc_info.jsp";
		rd=request.getRequestDispatcher(forward);
		rd.forward(request, response);
		
	}

}
