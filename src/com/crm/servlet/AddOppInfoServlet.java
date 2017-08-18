package com.crm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.entity.extd.CtcInfoEntityExtd;
import com.crm.entity.extd.OppInfoEntityExtd;
import com.crm.service.CommitOppInfoService;

public class AddOppInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommitOppInfoService cmtOppInfo=new CommitOppInfoService();
       
    public AddOppInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String crmName=request.getParameter("crmName");
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
		String  oppRmk=request.getParameter("oppRmk");
		
		String forward=null;
		RequestDispatcher rd=null;
		
		
		CtcInfoEntityExtd ctcInfo=new CtcInfoEntityExtd();
		ctcInfo.setCustName(custName);
		ctcInfo.setCtcName(ctcName);
		boolean bool=cmtOppInfo.checkCustCtc(ctcInfo);
		if (bool) {
			
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
			cmtOppInfo.commitOppInfo(oppInfo);
			
			forward="/xcrm/opp_mgt/add_opp_info_after.jsp?oppId="+oppId;
			
		} else {
			request.setAttribute("msg", "客户名称和联系人不匹配，请重新添加！");
			forward="/xcrm/nav/error.jsp";
		}
		
		rd=request.getRequestDispatcher(forward);
		rd.forward(request, response);
		
	}

}
