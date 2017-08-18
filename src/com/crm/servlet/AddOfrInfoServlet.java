package com.crm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.entity.extd.OfrInfoEntityExtd;
import com.crm.entity.extd.OppInfoEntityExtd;
import com.crm.service.CommitOfrInfoService;

public class AddOfrInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommitOfrInfoService cmtOfrInfo=new CommitOfrInfoService();
       
    public AddOfrInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String crmName=request.getSession().getAttribute("crmName").toString();
		String ofrId=request.getParameter("ofrId");
		String ofrName=request.getParameter("ofrName");
		String custName=request.getParameter("custName");
		String ctcName=request.getParameter("ctcName");
		String oppId=request.getParameter("oppId");
		String ofrStatus=request.getParameter("ofrStatus");
		String ofrVali=request.getParameter("ofrVali");
		String saleDisc=request.getParameter("saleDisc");
		String saleSum=request.getParameter("saleSum");
		
		
		String forward=null;
		RequestDispatcher rd=null;
		
		OppInfoEntityExtd oppInfo=new OppInfoEntityExtd();
		oppInfo.setCustName(custName);
		oppInfo.setCtcName(ctcName);
		oppInfo.setOppId(oppId);
		boolean bool=cmtOfrInfo.checkCustCtcOpp(oppInfo);
		
		if (bool) {
			
			OfrInfoEntityExtd ofrInfo=new OfrInfoEntityExtd();
			
			ofrInfo.setCrmName(crmName);
			ofrInfo.setOfrId(ofrId);
			ofrInfo.setOfrName(ofrName);
			ofrInfo.setCustName(custName);
			ofrInfo.setCtcName(ctcName);
			ofrInfo.setOppId(oppId);
			ofrInfo.setOfrStatus(ofrStatus);
			ofrInfo.setOfrVali(ofrVali);
			ofrInfo.setSaleDisc(saleDisc);
			ofrInfo.setSalcSum(saleSum);
			
			cmtOfrInfo.commitOfrInfo(ofrInfo);
			
			forward="/xcrm/ofr_mgt/qry_dtl_ofr_info_by_id.jsp?ofrId="+ofrId;
			
		} else {

			request.setAttribute("msg", "客户名称、联系人、销售机会不匹配，请重新添加！");
			forward="/xcrm/nav/error.jsp";
		}
		
		
		rd=request.getRequestDispatcher(forward);
		rd.forward(request, response);
		
		
	}

}
