package com.crm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.entity.extd.CustInfoEntityExtd;
import com.crm.service.CommitCustInfoService;


public class AddCustInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CommitCustInfoService cmtCustInfo=new CommitCustInfoService();
    
    public AddCustInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String custName=request.getParameter("custName");
			
			RequestDispatcher rd = null;
			String forward=null;
			
			CustInfoEntityExtd custInfo=new CustInfoEntityExtd();
			
			
			
			custInfo.setCustName(custName);
			boolean bool=cmtCustInfo.checkCustName(custInfo);
			if (bool) {
				request.setAttribute("msg", "此客户信息已存在！请重新添加!");
				forward="/xcrm/cust_mgt_jump/add_err.jsp";
			} else {
				String crmId=request.getSession().getAttribute("crmId").toString();
				String custId=request.getParameter("custId");
				String custStatus=request.getParameter("custStatus");
				String custType=request.getParameter("custType");
				String custLvl=request.getParameter("custLvl");
				String custInd=request.getParameter("custInd");
				String custProv=request.getParameter("custProv");
				String custCity=request.getParameter("custCity");
				String custAddr=request.getParameter("custAddr");
				String custRmk=request.getParameter("custRmk");
				
				custInfo.setCrmId(crmId);
				custInfo.setCustId(custId);
				custInfo.setCustStatus(custStatus);
				custInfo.setCustType(custType);
				custInfo.setCustLvl(custLvl);
				custInfo.setCustInd(custInd);
				custInfo.setCustProv(custProv);
				custInfo.setCustCity(custCity);
				custInfo.setCustAddr(custAddr);
				custInfo.setCustRmk(custRmk);
				cmtCustInfo.commitCustInfo(custInfo);
				
				forward = "/xcrm/cust_mgt/qry_dtl_cust_info_by_id.jsp?custId="+custId;
			}
		
			
			rd=request.getRequestDispatcher(forward);
			rd.forward(request, response);
	}

}
