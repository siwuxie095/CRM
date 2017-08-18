package com.crm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.entity.extd.DealInfoEntityExtd;
import com.crm.service.DeleteDealInfoService;

public class DeleteDealInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeleteDealInfoService delDealInfo=new DeleteDealInfoService();
       
    public DeleteDealInfoServlet() {
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
			
			String dealId=request.getParameter("dealId");
			DealInfoEntityExtd dealInfo=new DealInfoEntityExtd();
			dealInfo.setDealId(dealId);
			delDealInfo.deleteDealInfo(dealInfo);
			
		}else if (delMode.equals("mul")) {
			
			String dealIds=request.getParameter("dealIds");
			String dealIdsList[]=dealIds.split("#");
			DealInfoEntityExtd dealInfo[]=new DealInfoEntityExtd[dealIdsList.length];
			for (int i = 0; i < dealInfo.length; i++) {
				dealInfo[i]=new DealInfoEntityExtd();
				dealInfo[i].setDealId(dealIdsList[i]);
			}
			delDealInfo.deleteMulDealInfo(dealInfo);
		}
		
		forward="/xcrm/deal_mgt/qry_all_deal_info.jsp";
		rd=request.getRequestDispatcher(forward);
		rd.forward(request, response);
		
		
	}

}
