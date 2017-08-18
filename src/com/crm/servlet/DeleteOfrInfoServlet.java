package com.crm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.entity.extd.OfrInfoEntityExtd;
import com.crm.service.DeleteOfrInfoService;

public class DeleteOfrInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeleteOfrInfoService delOfrInfo=new DeleteOfrInfoService();
       
    public DeleteOfrInfoServlet() {
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
			
			String ofrId=request.getParameter("ofrId");
			OfrInfoEntityExtd ofrInfo=new OfrInfoEntityExtd();
			ofrInfo.setOfrId(ofrId);
			delOfrInfo.deleteOfrInfo(ofrInfo);
			
		}else if (delMode.equals("mul")) {
			
			String ofrIds=request.getParameter("ofrIds");
			String ofrIdsList[]=ofrIds.split("#");
			OfrInfoEntityExtd ofrInfo[]=new OfrInfoEntityExtd[ofrIdsList.length];
			for (int i = 0; i < ofrInfo.length; i++) {
				ofrInfo[i]=new OfrInfoEntityExtd();
				ofrInfo[i].setOfrId(ofrIdsList[i]);
			}
			delOfrInfo.deleteMulOfrInfo(ofrInfo);
		}
		
		forward="/xcrm/ofr_mgt/qry_all_ofr_info.jsp";
		rd=request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

}
