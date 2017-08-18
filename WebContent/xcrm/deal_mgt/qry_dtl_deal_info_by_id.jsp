<%@page import="com.crm.entity.extd.DealInfoEntityExtd"%>
<%@page import="com.crm.dao.impl.DealInfoDaoImpl"%>
<%@page import="com.crm.dao.DealInfoDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.crm.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>合同订单明细</title>
</head>
<body>
<%@ include file="/xcrm/bootstrap/nav.jsp" %>


<%
	Connection conn=null;
	conn=ConnectionFactory.getInstance().getConnection();
	DealInfoDao dealInfoDao=new DealInfoDaoImpl();
	DealInfoEntityExtd dealInfo=new DealInfoEntityExtd();
	
	String dealId=request.getParameter("dealId");
	dealInfo.setDealId(dealId);
	ResultSet rs=dealInfoDao.getDtlById(conn, dealInfo);
	String str[]=new String[12];
	while(rs.next()){
		str[0]=rs.getString("deal_id");
		str[1]=rs.getString("deal_thm");
		str[2]=rs.getString("cust_name");
		str[3]=rs.getString("ctc_name");
		str[4]=rs.getString("opp_id");
		str[5]=rs.getString("ofr_id");
		str[6]=rs.getString("prod_sort");
		str[7]=rs.getString("deal_status");
		str[8]=rs.getString("deal_date");
		str[9]=rs.getString("over_date");
		str[10]=rs.getString("sale_sum");
		str[11]=rs.getString("crm_name");
	}

%>



<div class="container-fluid">
	<div class="row-fluid">
		<div class="span3">
		</div>
		<div class="span6">
		<div class="btn-group table-bordered">
		    <a  href="<%= request.getContextPath() %>/xcrm/deal_mgt/qry_all_deal_info.jsp" class="btn"> <span class="add-on"><i class="icon-arrow-left"></i></span>&nbsp;返回列表</a>
			<a  href="<%= request.getContextPath() %>/xcrm/deal_mgt/add_deal_info.jsp" class="btn"> <span class="add-on"><i class="icon-plus"></i></span>&nbsp;新建</a>
			<a  href="<%= request.getContextPath() %>/xcrm/deal_mgt/mod_deal_info.jsp?dealId=<%= str[0] %>" class="btn"> <span class="add-on"><i class="icon-edit"></i></span>&nbsp;编辑</a>
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
							<p class="text-right">合同编号</p>
						</td>
						<td>
							<div class="input-append">
								<input name="dealId" value="<%= str[0] %>" type="text" readonly />
							</div>
						</td>
					</tr>
					<tr class="warning">
						<td>
							<p class="text-right">合同主题</p>
						</td>
						<td>
							<div class="input-append">
								<input name="dealThm" value="<%= str[1] %>" type="text" readonly />			
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
							<p class="text-right">报价单号</p>
						</td>
						<td>
							<div class="input-append">
								<input name="ofrId" value="<%= str[5] %>" type="text" readonly />
							</div>
						</td>
					</tr>
					
					<tr class="success">
						<td>
							<p class="text-right">产品分类</p>
						</td>
						<td>
							<div class="input-append">
								<input name="prodSort" value="<%= str[6] %>" type="text" readonly />
							</div>
						</td>
					</tr>	
					
					<tr class="error">
						<td>
							<p class="text-right">订单状态</p>
						</td>
						<td>
							<div class="input-append">
								<input name="dealStatus" value="<%= str[7] %>" type="text" readonly />
							</div>
						</td>
					</tr>

					<tr class="info">
						<td>
							<p class="text-right">签约日期</p>
						</td>
						<td>
							<div class="input-append">
								<input name="dealDate" value="<%= str[8] %>" type="text" readonly />
							</div>
						</td>
					</tr>
					
					<tr class="warning">
						<td>
							<p class="text-right">交付日期</p>
						</td>
						<td>
							<div class="input-append">
								<input name="overDate" value="<%= str[9] %>" type="text" readonly />
							</div>
						</td>
					</tr>	
					
					<tr class="success">
						<td>
							<p class="text-right">合计</p>
						</td>
						<td>
							<div class="input-append">
								<input name="saleSum" value="<%= str[10] %>" type="text" readonly />
							</div>
						</td>
					</tr>
					<% if(!crmRole.equals("comm")){ %>
					<tr class="error">
					
						<td>
							<p class="text-right">销售负责人</p>
						</td>
						<td>
							<div class="input-append">
								<input name="crmName" value="<%= str[11] %>" type="text" readonly />
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