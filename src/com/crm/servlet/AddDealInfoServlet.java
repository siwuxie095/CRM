package com.crm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.entity.extd.DealInfoEntityExtd;
import com.crm.entity.extd.OfrInfoEntityExtd;
import com.crm.service.CommitDealInfoService;

public class AddDealInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommitDealInfoService cmtDealInfo=new CommitDealInfoService();
       
    public AddDealInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String crmName=request.getSession().getAttribute("crmName").toString();
		String dealId=request.getParameter("dealId");
		String dealThm=request.getParameter("dealThm");
		String custName=request.getParameter("custName");
		String ctcName=request.getParameter("ctcName");
		String oppId=request.getParameter("oppId");
		String ofrId=request.getParameter("ofrId");
		String prodSort=request.getParameter("prodSort");
		String dealStatus=request.getParameter("dealStatus");
		String dealDate=request.getParameter("dealDate");
		String overDate=request.getParameter("overDate");
		String saleSum=request.getParameter("saleSum");
		
		
		String forward=null;
		RequestDispatcher rd=null;
		
		OfrInfoEntityExtd ofrInfo=new OfrInfoEntityExtd();
		ofrInfo.setCustName(custName);
		ofrInfo.setCtcName(ctcName);
		ofrInfo.setOppId(oppId);
		ofrInfo.setOfrId(ofrId);
		boolean bool=cmtDealInfo.checkCustCtcOppOfr(ofrInfo);
		if (bool) {
			
			DealInfoEntityExtd dealInfo=new DealInfoEntityExtd();
			
			dealInfo.setCrmName(crmName);
			dealInfo.setDealId(dealId);
			dealInfo.setDealThm(dealThm);
			dealInfo.setCustName(custName);
			dealInfo.setCtcName(ctcName);
			dealInfo.setOppId(oppId);
			dealInfo.setOfrId(ofrId);
			dealInfo.setProdSort(prodSort);
			dealInfo.setDealStatus(dealStatus);
			dealInfo.setDealDate(dealDate);
			dealInfo.setOverDate(overDate);
			dealInfo.setSaleSum(saleSum);
			
			cmtDealInfo.commitDealInfo(dealInfo);
			
			forward="/xcrm/deal_mgt/qry_dtl_deal_info_by_id.jsp?dealId="+dealId;
			
		} else {
			
			request.setAttribute("msg", "客户名称、联系人、销售机会、报价单不匹配，请重新添加！");
			forward="/xcrm/nav/error.jsp";
			
		}
		
		
		rd=request.getRequestDispatcher(forward);
		rd.forward(request, response);
		
		                                      
	}

}
