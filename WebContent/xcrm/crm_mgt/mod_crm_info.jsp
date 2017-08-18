<%@page import="java.sql.ResultSet"%>
<%@page import="com.crm.entity.extd.CrmInfoEntityExtd"%>
<%@page import="com.crm.dao.impl.CrmInfoDaoImpl"%>
<%@page import="com.crm.dao.CrmInfoDao"%>
<%@page import="com.crm.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改个人信息</title>
</head>
<body>
<%@ include file="/xcrm/bootstrap/nav.jsp" %>



<%	request.setAttribute("msg", "禁止修改个人信息，此功能暂时服务..."); %>
<jsp:forward page="/xcrm/nav/error.jsp"></jsp:forward>
<%
	
	String crmId=session.getAttribute("crmId").toString();
	Connection conn=null;
	conn=ConnectionFactory.getInstance().getConnection();
	CrmInfoDao crmInfoDao=new CrmInfoDaoImpl();
	CrmInfoEntityExtd crmInfo=new CrmInfoEntityExtd();
	crmInfo.setCrmId(crmId);
	ResultSet rs=crmInfoDao.get(conn, crmInfo);
	String str[]=new String[4];
	while(rs.next()){
		str[0]=rs.getString("crm_id");
		str[1]=rs.getString("crm_name");
		str[2]=rs.getString("crm_title");
		str[3]=rs.getString("crm_role");
	}
			

%>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span3">
		</div>
		<div class="span6">
				  <form class="form-horizontal"
			action="<%=request.getContextPath()%>/modifyCrmInfoServlet" method="post" name="iForm">
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
							<p class="text-right">帐号</p>
						</td>
						<td>
							<div class="input-append">
								<input name="crmId" value="<%= str[0] %>" type="text" readonly />
							</div>
						</td>
					</tr>
						<tr class="warning">
						<td>
							<p class="text-right">姓名</p>
						</td>
						<td>
							<div class="input-append">
								<input name="crmName" value="<%= str[1] %>" type="text" />
							</div>
						</td>
					</tr>
					<tr class="success">
						<td>
							<p class="text-right">职务</p>
						</td>
						<td>
							<div class="input-append">
								<input name="crmTitle" value="<%= str[2] %>" type="text" readonly />
							</div>
						</td>
					</tr>
					<tr class="error">
						<td>
							<p class="text-right">权限</p>
						</td>
						<td>
							<div class="input-append">
								<input name="crmRole" value="<%= str[3] %>" type="text" readonly />
							</div>
						</td>
					</tr>
				
				</tbody>
				
			</table>
					<div class="control-group">
						<div class="controls">
							 <button class="btn" type="submit">保存</button> &nbsp;&nbsp; <a href="<%= request.getContextPath() %>/xcrm/nav/index.jsp"><button class="btn" type="button">取消</button></a>
						</div>
					</div>
			</form>
			</div>
			<div class="span3">
			</div>
		</div>
	</div>
</body>
</html>