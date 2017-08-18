package com.crm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.entity.extd.CtcInfoEntityExtd;
import com.crm.service.ModifyCtcInfoService;

public class ModifyCtcInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ModifyCtcInfoService modCtcInfo=new ModifyCtcInfoService();
       
    public ModifyCtcInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String crmId=request.getSession().getAttribute("crmId").toString();
		String ctcId=request.getParameter("ctcId");
		String ctcName=request.getParameter("ctcName");
		String ctcTitle=request.getParameter("ctcTitle");
		String ctcCel=request.getParameter("ctcCel");
		String ctcTel=request.getParameter("ctcTel");
		String ctcFax=request.getParameter("ctcFax");
		String ctcMail=request.getParameter("ctcMail");
		String custName=request.getParameter("custName");
		String ctcProv=request.getParameter("ctcProv");
		String ctcCity=request.getParameter("ctcCity");
		String ctcAddr=request.getParameter("ctcAddr");
		String ctcRmk=request.getParameter("ctcRmk");
		
		CtcInfoEntityExtd ctcInfo=new CtcInfoEntityExtd();
		ctcInfo.setCrmId(crmId);
		ctcInfo.setCtcId(ctcId);
		ctcInfo.setCtcName(ctcName);
		ctcInfo.setCtcTitle(ctcTitle);
		ctcInfo.setCtcCel(ctcCel);
		ctcInfo.setCtcTel(ctcTel);
		ctcInfo.setCtcFax(ctcFax);
		ctcInfo.setCtcMail(ctcMail);
		ctcInfo.setCustName(custName);
		ctcInfo.setCtcProv(ctcProv);
		ctcInfo.setCtcCity(ctcCity);
		ctcInfo.setCtcAddr(ctcAddr);
		ctcInfo.setCtcRmk(ctcRmk);
		modCtcInfo.modifyCtcInfo(ctcInfo);
		String forward="/xcrm/ctc_mgt/qry_dtl_ctc_info_by_id.jsp?ctcId="+ctcId;
		RequestDispatcher rd=request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

}
