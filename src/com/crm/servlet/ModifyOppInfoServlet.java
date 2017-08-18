package com.crm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.entity.extd.OppInfoEntityExtd;
import com.crm.service.ModifyOppInfoService;

public class ModifyOppInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ModifyOppInfoService modOppInfo=new ModifyOppInfoService();
       
    public ModifyOppInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String crmName=request.getSession().getAttribute("crmName").toString();
		String oppId=request.getParameter("oppId");
		String oppName=request.getParameter("oppName");
		String custName=request.getParameter("custName");
		String ctcName=request.getParameter("ctcName");
		String prodSort=request.getParameter("prodSort");
		String saleStg=request.getParameter("saleStg");
		String oppSrc=request.getParameter("oppSrc");
		String preSaleSum=request.getParameter("preSaleSum");
		String preDealDate=request.getParameter("preDealDate");
		String succPer=request.getParameter("succPer");
		String oppRmk=request.getParameter("oppRmk");
		
		OppInfoEntityExtd oppInfo=new OppInfoEntityExtd();
		
		oppInfo.setCrmName(crmName);
		oppInfo.setOppId(oppId);
		oppInfo.setOppName(oppName);
		oppInfo.setCustName(custName);
		oppInfo.setCtcName(ctcName);
		oppInfo.setProdSort(prodSort);
		oppInfo.setSaleStg(saleStg);
		oppInfo.setOppSrc(oppSrc);
		oppInfo.setPreSaleSum(preSaleSum);
		oppInfo.setPreDealDate(preDealDate);
		oppInfo.setSuccPer(succPer);
		oppInfo.setOppRmk(oppRmk);
		
		modOppInfo.modifyOppInfo(oppInfo);
		
		String forward="/xcrm/opp_mgt/qry_dtl_opp_info_by_id.jsp?oppId="+oppId;
		RequestDispatcher rd=request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

}
