<%@page import="com.crm.dao.impl.CrmInfoDaoImpl"%>
<%@page import="com.crm.dao.CrmInfoDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.crm.entity.extd.OppInfoEntityExtd"%>
<%@page import="com.crm.dao.impl.OppInfoDaoImpl"%>
<%@page import="com.crm.dao.OppInfoDao"%>
<%@page import="com.crm.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分配销售机会</title>
</head>
<body>
<%@ include file="/xcrm/bootstrap/nav.jsp" %>


<%
	Connection conn=null;
	conn=ConnectionFactory.getInstance().getConnection();
	OppInfoDao oppInfoDao=new OppInfoDaoImpl();
	OppInfoEntityExtd oppInfo=new OppInfoEntityExtd();
	String oppId=request.getParameter("oppId");
	oppInfo.setOppId(oppId);
	ResultSet rs=oppInfoDao.getDtlById(conn, oppInfo);
	String str[]=new String[11];
	while(rs.next()){
		str[0]=rs.getString("opp_id");
		str[1]=rs.getString("opp_name");
		str[2]=rs.getString("cust_name");
		str[3]=rs.getString("ctc_name");
		str[4]=rs.getString("prod_sort");
		str[5]=rs.getString("sale_stg");
		str[6]=rs.getString("opp_src");
		str[7]=rs.getString("pre_sale_sum");
		str[8]=rs.getString("pre_deal_date");
		str[9]=rs.getString("succ_per");
		str[10]=rs.getString("opp_rmk");
	}
	
	
	
	CrmInfoDao crmInfoDao=new CrmInfoDaoImpl();
	ResultSet rsa=crmInfoDao.getAll(conn);
			

%>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span3">
		</div>
		<div class="span6">
		<div class="btn-group table-bordered">
		    <a  href="<%= request.getContextPath() %>/xcrm/opp_mgt/qry_all_opp_info.jsp" class="btn"> <span class="add-on"><i class="icon-arrow-left"></i></span>&nbsp;返回列表</a>
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
							<p class="text-right">编号</p>
						</td>
						<td>
							<div class="input-append">
								<input name="oppId" value="<%= str[0] %>" type="text" readonly />
							</div>
						</td>
					</tr>
					<tr class="warning">
						<td>
							<p class="text-right">销售机会</p>
						</td>
						<td>
							<div class="input-append">
								<input name="oppName" value="<%= str[1] %>" type="text" readonly />			
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
							<p class="text-right">产品分类</p>
						</td>
						<td>
							<div class="input-append">
								<input name="prodSort" value="<%= str[4] %>" type="text" readonly />
							</div>
						</td>
					</tr>
					<tr class="warning">
						<td>
							<p class="text-right">销售阶段</p>
						</td>
						<td>
							<div class="input-append">
								<input name="saleStg" value="<%= str[5] %>" type="text" readonly />
							</div>
						</td>
					</tr>
					<tr class="success">
						<td>
							<p class="text-right">机会来源</p>
						</td>
						<td>
							<div class="input-append">
								<input name="oppSrc" value="<%= str[6] %>" type="text" readonly />
							</div>
						</td>
					</tr>
					<tr class="error">
						<td>
							<p class="text-right">预计成交金额</p>
						</td>
						<td>
							<div class="input-append">
								<input name="preSaleSum" value="<%= str[7] %>" type="text" readonly />
							</div>
						</td>
					</tr>
					<tr class="info">
						<td>
							<p class="text-right">预计成交日期</p>
						</td>
						<td>
							<div class="input-append">
								<input name="preDealDate" value="<%= str[8] %>" type="text" readonly />
							</div>
						</td>
					</tr>
					<tr class="warning">
						<td>
							<p class="text-right">可能性</p>
						</td>
						<td>
							<div class="input-append">
								<input name="succPer" value="<%= str[9] %>" type="text" readonly />
							</div>
						</td>
					</tr>
					<tr class="success">
					
						<td>
							<p class="text-right">销售负责人</p>
						</td>
						<td>
							<div class="input-append">
								<select name="crmName" class="form-control" > 
								<% while(rsa.next()){ %>
								<option value="<%= rsa.getString("crm_name")%>"><%out.print(rsa.getString("crm_title")+"："+rsa.getString("crm_name")); %></option> 
								<% } %>
								</select>
							</div>
						</td>
					</tr>
				</tbody>
				
				<thead>
					<tr>
						<th>
							备注信息
						</th>
					</tr>
				</thead>
				<tbody>
					<tr class="error">
						<td>
							<p class="text-right">备注</p>
						</td>
						<td>
							<div class="input-append">
							<textarea name="oppRmk" rows="2" readonly><%= str[10] %></textarea>
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