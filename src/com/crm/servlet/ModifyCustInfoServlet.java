package com.crm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.entity.extd.CustInfoEntityExtd;
import com.crm.service.ModifyCustInfoService;

public class ModifyCustInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ModifyCustInfoService modCustInfo=new ModifyCustInfoService();
       
    public ModifyCustInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String crmId=request.getSession().getAttribute("crmId").toString();
		String custId=request.getParameter("custId");
		String custName=request.getParameter("custName");
		String custStatus=request.getParameter("custStatus");
		String custType=request.getParameter("custType");
		String custLvl=request.getParameter("custLvl");
		String custInd=request.getParameter("custInd");
		String custProv=request.getParameter("custProv");
		String custCity=request.getParameter("custCity");
		String custAddr=request.getParameter("custAddr");
		String custRmk=request.getParameter("custRmk");
		
		
		CustInfoEntityExtd custInfo=new CustInfoEntityExtd();
		//11条数据
		custInfo.setCrmId(crmId);
		custInfo.setCustId(custId);
		custInfo.setCustName(custName);
		custInfo.setCustStatus(custStatus);
		custInfo.setCustType(custType);
		custInfo.setCustLvl(custLvl);
		custInfo.setCustInd(custInd);
		custInfo.setCustProv(custProv);
		custInfo.setCustCity(custCity);
		custInfo.setCustAddr(custAddr);
		custInfo.setCustRmk(custRmk);
		modCustInfo.modifyCustInfo(custInfo);
		RequestDispatcher rd = null;
		String forward = "/xcrm/cust_mgt/qry_dtl_cust_info_by_id.jsp?custId="+custId;
		rd=request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

}
