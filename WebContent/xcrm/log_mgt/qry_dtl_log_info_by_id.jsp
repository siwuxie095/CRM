<%@page import="com.crm.entity.extd.LogInfoEntityExtd"%>
<%@page import="com.crm.dao.impl.LogInfoDaoImpl"%>
<%@page import="com.crm.dao.LogInfoDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.crm.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>日志详细信息</title>
</head>
<body>
<%@ include file="/xcrm/bootstrap/nav.jsp" %>

<%
	Connection conn=null;
	conn=ConnectionFactory.getInstance().getConnection();
	
	LogInfoDao logInfoDao=new LogInfoDaoImpl();
	LogInfoEntityExtd logInfo=new LogInfoEntityExtd();
	String logId=request.getParameter("logId");
	logInfo.setLogId(logId);
	ResultSet rs=logInfoDao.getDtlById(conn, logInfo);
	
	String str[]=new String[9];
	
	while(rs.next()){
		str[0]=rs.getString("log_id");
		str[1]=rs.getString("log_thm");
		str[2]=rs.getString("cust_name");
		str[3]=rs.getString("ctc_name");
		str[4]=rs.getString("opp_id");
		str[5]=rs.getString("ctcx_style");
		str[6]=rs.getString("ctcx_date");
		str[7]=rs.getString("ctcx_detail");
		str[8]=rs.getString("next_visit_date");
	}
			

%>



<div class="container-fluid">
	<div class="row-fluid">
		<div class="span3">
		</div>
		<div class="span6">
		
		
		<div class="btn-group table-bordered">
		    <a  href="<%= request.getContextPath() %>/xcrm/log_mgt/qry_all_log_info.jsp" class="btn"> <span class="add-on"><i class="icon-arrow-left"></i></span>&nbsp;返回列表</a>
		    <a  href="<%= request.getContextPath() %>/xcrm/log_mgt/add_log_info.jsp" class="btn"> <span class="add-on"><i class="icon-plus"></i></span>&nbsp;新建</a>
			<a  href="<%= request.getContextPath() %>/xcrm/log_mgt/mod_log_info.jsp?logId=<%= str[0] %>" class="btn"> <span class="add-on"><i class="icon-edit"></i></span>&nbsp;编辑</a>
		    </div>
		<br/><br/>
		
			
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>
							基本信息
						</th>
					</tr>
				</thead>
				<tbody>
					<tr class="info">
						<td>
							<p class="text-right">日志编号</p>
						</td>
						<td>
							<div class="input-append">
								<input name="logId" value="<%= str[0] %>" type="text" readonly />
							</div>
						</td>
					</tr>
						<tr class="warning">
						<td>
							<p class="text-right">日志主题</p>
						</td>
						<td>
							<div class="input-append">
								<input name="logThm" value="<%= str[1] %>" type="text" readonly />
							</div>
						</td>
					</tr>
					<tr class="success">
						<td>
							<p class="text-right">客户名称</p>
						</td>
						<td>
							<div class="input-append">
								<input name="custName" value="<%= str[2] %>" type="text" readonly />
							</div>				
						</td>	
					</tr>
					<tr class="error">
						<td>
							<p class="text-right">联系人</p>
						</td>
						<td>
							<div class="input-append">
								<input name="ctcName" value="<%= str[3] %>" type="text" readonly />
							</div>			
						</td>
						</tr>
						
						<tr class="info">
						<td>
							<p class="text-right">销售机会</p>
						</td>
						<td>
							<div class="input-append">
								<input name="oppId" value="<%= str[4] %>" type="text" readonly />
							</div>			
						</td>
					</tr>
					<tr class="warning">
						<td>
							<p class="text-right">联系方式</p>
						</td>
						<td>
							<div class="input-append">
								<input name="ctcxStyle" value="<%= str[5] %>" type="text" readonly />
							</div>			
						</td>
					</tr>
					<tr class="success">
						<td>
							<p class="text-right">联系日期</p>
						</td>
						<td>
							<div class="input-append">
								<input name="ctcxDate" value="<%= str[6] %>" type="text" readonly />
							</div>			
						</td>
					</tr>
					<tr class="error">
						<td>
							<p class="text-right">联系详情</p>
						</td>
						<td>
							<div class="input-append">
								<textarea name="ctcxDetail" rows="2" readonly ><%= str[7] %></textarea>
							</div>			
						</td>
					</tr>
						<tr class="info">
						<td>
							<p class="text-right">下次回访日期</p>
						</td>
						<td>
							<div class="input-append">
								<input name="nextVisitDate" value="<%= str[8] %>" type="text" readonly />
							</div>			
						</td>
					</tr>
				</tbody>
				
			</table>
			
			</div>
			<div class="span3">
			</div>
		</div>
	</div>

</body>
</html>