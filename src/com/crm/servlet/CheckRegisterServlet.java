package com.crm.servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.entity.extd.CrmPwdxEntityExtd;
import com.crm.service.CheckCrmPwdxService;
import com.crm.service.CommitCrmPwdxService;



public class CheckRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CheckCrmPwdxService ckPwdx=new CheckCrmPwdxService();
    private CommitCrmPwdxService cmtPwdx=new CommitCrmPwdxService();
   
    public CheckRegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String crmId = request.getParameter("crmId");
		String crmPwd = request.getParameter("crmPwd");

		RequestDispatcher rd = null;
		String forward = null;
		
		CrmPwdxEntityExtd crmPwdx=new CrmPwdxEntityExtd();
		
		if (crmId == null || crmPwd == null) {
			
			request.setAttribute("msg", "用户名或密码为空！跳转中...");
			forward="xcrm/register_jump/register_err.jsp";
			
		} else {
			
			if (isContainChinese(crmId)) {
				request.setAttribute("msg", "帐号由三个数字组成，不能包含中文，跳转中...");
				forward = "xcrm/register_jump/register_err.jsp";
			}else if (isContainLetter(crmId)) {
				request.setAttribute("msg", "帐号由三个数字组成，不能包含字母，跳转中...");
				forward = "xcrm/register_jump/register_err.jsp";
			}else if (crmId.length()!=3) {
				request.setAttribute("msg", "帐号由三个数字组成，不能多或少于三个，跳转中...");
				forward = "xcrm/register_jump/register_err.jsp";
			}else if (crmPwd.length()<3) {
				request.setAttribute("msg", "密码不能少于三个字符，跳转中...");
				forward = "xcrm/register_jump/register_err.jsp";
			}else {
				crmPwdx.setCrmId(crmId);
				boolean bool=ckPwdx.checkCrmId(crmPwdx);
				
				if (bool) {
					
					request.setAttribute("msg", "此帐号已注册！跳转中...");
					forward = "xcrm/register_jump/register_err.jsp";
					
				} else {
					
					crmPwdx.setCrmPwd(crmPwd);
					cmtPwdx.commitCrmPwdx(crmPwdx);
					request.setAttribute("msg", "您已注册成功，现在去登录！跳转中...");
					forward = "xcrm/register_jump/register_succ.jsp";

				}
			}
			
		}
		
		rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}
	
	
	  public boolean isContainLetter(String str) {  
	        String regex=".*[a-zA-Z]+.*";  
	        Matcher m=Pattern.compile(regex).matcher(str);  
	        return m.matches();  
	    }  
	  
	  public boolean isContainChinese(String str) {

	        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
	        Matcher m = p.matcher(str);
	        if (m.find()) {
	            return true;
	        }
	        return false;
	    }

}
