package com.crm.servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.entity.extd.CtcInfoEntityExtd;
import com.crm.service.QueryCtcInfoService;

public class QueryCtcInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private QueryCtcInfoService qryCtcInfo=new QueryCtcInfoService();  
	
    public QueryCtcInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ctcQry=request.getParameter("ctcQry");
		CtcInfoEntityExtd ctcInfo=new CtcInfoEntityExtd();
		RequestDispatcher rd=null;
		String forward=null;
		String infoList[][];
		
		if (isContainChinese(ctcQry)) {
			ctcInfo.setCtcName(ctcQry);
			infoList=qryCtcInfo.queryCtcInfo(ctcInfo, true);
		} else {
			ctcInfo.setCtcId(ctcQry);
			infoList=qryCtcInfo.queryCtcInfo(ctcInfo, false);
		}
		
		if (infoList==null) {
			request.setAttribute("msg", "数据库中无相关联系人信息，请重新查询...");
			forward="/xcrm/ctc_mgt_jump/qry_err.jsp";
		} else {
			
			String infoListX[]=new String[infoList.length]; 
			
			for (int i = 0; i < infoList.length; i++) {
				
				infoListX[i]="";
				
				for (int j = 0; j < infoList[i].length; j++) {
					if (j==infoList[i].length-1) {
						infoListX[i] += infoList[i][j];
					} else {
						infoListX[i] += infoList[i][j]+"*";
					}
				}
			}
			
			
			String info="";
			
			for (int i = 0; i < infoListX.length; i++) {
				if (i==infoListX.length-1) {
					info += infoListX[i];
				} else {
					info += infoListX[i]+"$";
				}
			}
			
			forward="/xcrm/ctc_mgt/qry_fuzzy_ctc_info.jsp?info="+info;
			
		}
		
		rd=request.getRequestDispatcher(forward);
		rd.forward(request, response);
		
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
