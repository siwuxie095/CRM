<%@page import="java.sql.ResultSet"%>
<%@page import="com.crm.entity.extd.OfrInfoEntityExtd"%>
<%@page import="com.crm.dao.impl.OfrInfoDaoImpl"%>
<%@page import="com.crm.dao.OfrInfoDao"%>
<%@page import="com.crm.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报价单明细</title>
</head>
<body>
<%@ include file="/xcrm/bootstrap/nav.jsp" %>

<%
	Connection conn=null;
	conn=ConnectionFactory.getInstance().getConnection();
	OfrInfoDao ofrInfoDao=new OfrInfoDaoImpl();
	OfrInfoEntityExtd ofrInfo=new OfrInfoEntityExtd();
	
	String ofrId=request.getParameter("ofrId");
	ofrInfo.setOfrId(ofrId);
	ResultSet rs=ofrInfoDao.getDtlById(conn, ofrInfo);
	String str[]=new String[10];
	while(rs.next()){
		str[0]=rs.getString("ofr_id");
		str[1]=rs.getString("ofr_name");
		str[2]=rs.getString("cust_name");
		str[3]=rs.getString("ctc_name");
		str[4]=rs.getString("opp_id");
		str[5]=rs.getString("ofr_status");
		str[6]=rs.getString("ofr_vali");
		str[7]=rs.getString("sale_disc");
		str[8]=rs.getString("sale_sum");
		str[9]=rs.getString("crm_name");
	}

%>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span3">
		</div>
		<div class="span6">
		<div class="btn-group table-bordered">
		    <a  href="<%= request.getContextPath() %>/xcrm/ofr_mgt/qry_all_ofr_info.jsp" class="btn"> <span class="add-on"><i class="icon-arrow-left"></i></span>&nbsp;返回列表</a>	
		    <a  href="<%= request.getContextPath() %>/xcrm/ofr_mgt/add_ofr_info.jsp" class="btn"> <span class="add-on"><i class="icon-plus"></i></span>&nbsp;新建</a>
		    <a href="<%= request.getContextPath() %>/xcrm/ofr_mgt/mod_ofr_info.jsp?ofrId=<%= str[0] %>" class="btn"> <span class="add-on"><i class="icon-edit"></i></span>&nbsp;编辑</a>
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
							<p class="text-right">报价单号</p>
						</td>
						<td>
							<div class="input-append">
								<input name="ofrId" value="<%= str[0] %>" type="text" readonly />
							</div>
						</td>
					</tr>
					<tr class="warning">
						<td>
							<p class="text-right">报价单名</p>
						</td>
						<td>
							<div class="input-append">
								<input name="ofrName" value="<%= str[1] %>" type="text" readonly />			
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
							<p class="text-right">报价单状态</p>
						</td>
						<td>
							<div class="input-append">
								<input name="oppStatus" value="<%= str[5] %>" type="text" readonly />
							</div>				
						</td>
					</tr>
					<tr class="success">
						<td>
							<p class="text-right">报价单有效期</p>
						</td>
						<td>
							<div class="input-append">
								<input name="ofrVali" value="<%= str[6] %>" type="text" readonly />
							</div>
						</td>
					</tr>
					<tr class="error">
						<td>
							<p class="text-right">整单折扣</p>
						</td>
						<td>
							<div class="input-append">
								<input name="saleDisc" value="<%= str[7] %>" type="text" readonly />			
							</div> 
						</td>
					</tr>
					<tr class="info">
						<td>
							<p class="text-right">合计</p>
						</td>
						<td>
							<div class="input-append">
								<input name="saleSum" value="<%= str[8] %>" type="text" readonly />			
							</div> 
						</td>
					</tr>
					
					<% if(!crmRole.equals("comm")){ %>
					<tr class="warning">
					
						<td>
							<p class="text-right">销售负责人</p>
						</td>
						<td>
							<div class="input-append">
								<input name="crmName" value="<%= str[9] %>" type="text" readonly />
							</div>
						</td>
					</tr>
					<% } %>
									
				</tbody>	
					</table>
					
			</div>
			<div class="span3">
			</div>

		</div>
	</div>
</body>
</html>