package com.crm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.entity.extd.CrmInfoEntityExtd;
import com.crm.entity.extd.CrmPwdxEntityExtd;
import com.crm.service.CheckCrmPwdxService;
import com.crm.service.QueryCrmInfoService;




public class CheckLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CheckCrmPwdxService ckPwdx=new CheckCrmPwdxService();
	private QueryCrmInfoService qrInfo=new QueryCrmInfoService();
	
       
    
    public CheckLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String crmId=request.getParameter("crmId");
		String crmPwd=request.getParameter("crmPwd");
		String returnUri = request.getParameter("returnUri");
		
		RequestDispatcher rd = null;
		String forward = null;
		
		CrmPwdxEntityExtd crmPwdx=new CrmPwdxEntityExtd();
		CrmInfoEntityExtd crmInfo=new CrmInfoEntityExtd();
		
		
		if (crmId == null || crmPwd == null) {
			
			request.setAttribute("msg", "用户名或密码为空！跳转中...");
			forward = "/xcrm/nav/index.jsp";

		} else {
			
			crmPwdx.setCrmId(crmId);
			boolean bool = ckPwdx.checkCrmId(crmPwdx);
			
			if (bool) {
				
				request.getSession().setAttribute("crmId", crmId);
				crmPwdx.setCrmPwd(crmPwd);
				boolean bool2 = ckPwdx.checkCrmPwdx(crmPwdx);
				
				if (bool2) {
					
					request.getSession().setAttribute("flag", "login_success");
					
					crmInfo.setCrmId(crmId);
					String infoList[]=qrInfo.queryCrmInfoX(crmInfo);
					
					if (infoList!=null) {
						request.getSession().setAttribute("crmName", infoList[0]);
						request.getSession().setAttribute("crmTitle", infoList[1]);
						request.getSession().setAttribute("crmRole", infoList[2]);
					}
					
					if (returnUri != null) {						
							forward = returnUri;
					} else {
						forward = "/xcrm/nav/index.jsp";
					}
					
				
					
					
				} else {
					request.setAttribute("msg", "密码输入错误，请重新输入!跳转中...");
					forward = "/xcrm/login_jump/login_err.jsp";
				}

			} else {
				request.setAttribute("msg", "此帐号尚未注册!跳转中...");
				forward = "/xcrm/login_jump/login_err.jsp";
			}
			
		}
		
		rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

}
