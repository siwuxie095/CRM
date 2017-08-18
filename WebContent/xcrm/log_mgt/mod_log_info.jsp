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
<title>编辑日志记录</title>
<%-- <link href="<%= request.getContextPath() %>/xcrm/opp_mgt/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">  --%> 
<link href="<%= request.getContextPath() %>/xcrm/date_css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">

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
		    </div>
		<br/><br/>
		
				  <form class="form-horizontal"
			action="<%=request.getContextPath()%>/modifyLogInfoServlet" method="post" name="iForm">
			
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
								<input name="logThm" value="<%= str[1] %>" type="text" />
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
							 <div class="input-append date form_datetime" data-date="" 
              				  data-date-format="yyyy MM dd" data-link-format="yyyy-mm-dd" data-link-field="dtp_input1">
                  			  <input  value="<%= str[6] %>" size="16" type="text" readonly>
                 			   <span class="add-on"><i class="icon-remove"></i></span>
								<span class="add-on"><i class="icon-calendar"></i></span>
              				  </div>
                			<input type="hidden" id="dtp_input1" name="ctcxDate" value="<%= str[6] %>" />
						</td>
					</tr>
					<tr class="error">
						<td>
							<p class="text-right">联系详情</p>
						</td>
						<td>
							<div class="input-append">
							<textarea name="ctcxDetail" rows="2"><%= str[7] %></textarea>
							</div>
						</td>
					</tr>
						<tr class="info">
						<td>
							<p class="text-right">下次回访日期</p>
						</td>
						<td>
							 <div class="input-append date form_datetime" data-date="" 
              				  data-date-format="yyyy MM dd" data-link-format="yyyy-mm-dd" data-link-field="dtp_input2">
                  			  <input  value="<%= str[8] %>"  size="16" type="text" readonly>
                 			   <span class="add-on"><i class="icon-remove"></i></span>
								<span class="add-on"><i class="icon-calendar"></i></span>
              				  </div>
                			<input type="hidden" id="dtp_input2" name="nextVisitDate" value="<%= str[8] %>" />
						</td>
					</tr>
				</tbody>
				

			</table>
					<div class="control-group">
						<div class="controls">
							 <button class="btn" type="submit" onclick="return check(this);">保存</button> &nbsp;&nbsp; <a href="<%= request.getContextPath() %>/xcrm/log_mgt/qry_all_log_info.jsp"><button class="btn" type="button">取消</button></a>
						</div>
					</div>
			</form>
			
			</div>
			<div class="span3">
			</div>
		</div>
	</div>
	
	
<%-- <script type="text/javascript" src="<%= request.getContextPath() %>/xcrm/opp_mgt/jquery/jquery-1.8.3.min.js" charset="UTF-8"></script> --%>
<%-- <script type="text/javascript" src="<%= request.getContextPath() %>/xcrm/opp_mgt/bootstrap/js/bootstrap.min.js"></script> --%>
<script type="text/javascript" src="<%= request.getContextPath() %>/xcrm/date_js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/xcrm/date_js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script type="text/javascript">
    $('.form_datetime').datetimepicker({
        language:  'zh-CN',
         weekStart: 0,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
         minView: 2,
        forceParse: 0
       
    });
    
	
</script>



<script type="text/javascript">

function check(form) {
	if (document.forms.iForm.logThm.value == "") {
		alert("请输入日志主题！");
		document.forms.iForm.logThm.focus();
		return false;
	}
	if (document.forms.iForm.ctcxDate.value == "") {
		alert("请输入联系日期！");
		document.forms.iForm.ctcxDate.focus();
		return false;
	}
	if (document.forms.iForm.ctcxDetail.value == "") {
		alert("请输入联系详情！");
		document.forms.iForm.ctcxDetail.focus();
		return false;
	}
	if (document.forms.iForm.nextVisitDate.value == "") {
		alert("请输入下次回访日期！");
		document.forms.iForm.nextVisitDate.focus();
		return false;
	}
}



</script>

</body>
</html>