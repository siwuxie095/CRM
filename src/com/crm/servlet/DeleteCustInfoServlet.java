package com.crm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.entity.extd.CustInfoEntityExtd;
import com.crm.service.DeleteCustInfoService;


public class DeleteCustInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeleteCustInfoService delCustInfo=new DeleteCustInfoService();
       
    public DeleteCustInfoServlet() {
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
			
			String custId=request.getParameter("custId");
			CustInfoEntityExtd custInfo=new CustInfoEntityExtd();
			custInfo.setCustId(custId);
			delCustInfo.deleteCustInfo(custInfo);
			
		} else if (delMode.equals("mul")) {
			
			String custIds=request.getParameter("custIds");
			String custIdsList[]=custIds.split("#");
			CustInfoEntityExtd custInfo[]=new CustInfoEntityExtd[custIdsList.length];
			for (int i = 0; i < custInfo.length; i++) {
				custInfo[i]=new CustInfoEntityExtd();
				custInfo[i].setCustId(custIdsList[i]);
			}
			delCustInfo.delMulCustInfo(custInfo);
		}
		
		
		String rtnUri=request.getParameter("rtnUri");
		String param=request.getParameter("param");
		
		
		if (rtnUri.indexOf("status")!=-1) {
			forward=rtnUri.substring(4)+"?custStatus="+param;
		}else if (rtnUri.indexOf("type")!=-1) {
			forward=rtnUri.substring(4)+"?custType="+param;
		}else if (rtnUri.indexOf("lvl")!=-1) {
			forward=rtnUri.substring(4)+"?custLvl="+param;
		}else if (rtnUri.indexOf("fuzzy")!=-1) {
			
			forward="/xcrm/cust_mgt/qry_all_cust_info.jsp";
		}else {
			forward=rtnUri.substring(4);
		}
		
		rd=request.getRequestDispatcher(forward);
		rd.forward(request, response);
		
	}

}
