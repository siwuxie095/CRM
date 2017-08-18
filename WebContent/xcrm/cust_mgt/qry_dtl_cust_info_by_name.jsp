<%@page import="com.crm.entity.extd.CustInfoEntityExtd"%>
<%@page import="com.crm.dao.CustInfoDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.crm.dao.impl.CustInfoDaoImpl"%>
<%@page import="com.crm.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户详细信息</title>
</head>
<body>
<%@ include file="/xcrm/bootstrap/nav.jsp" %>
<%
		Connection conn=null;
		conn=ConnectionFactory.getInstance().getConnection();
		CustInfoDao custInfoDao=new CustInfoDaoImpl();
		
		CustInfoEntityExtd custInfo=new CustInfoEntityExtd();
		String custName=request.getParameter("custName");
		custInfo.setCustName(custName);
		ResultSet rs=custInfoDao.getDtlByName(conn, custInfo);
		String str[]=new String[10];
		while(rs.next()){
			str[0]=rs.getString("cust_id");
			str[1]=rs.getString("cust_name");
			str[2]=rs.getString("cust_status");
			str[3]=rs.getString("cust_type");
			str[4]=rs.getString("cust_lvl");
			str[5]=rs.getString("cust_ind");
			str[6]=rs.getString("cust_prov");
			str[7]=rs.getString("cust_city");
			str[8]=rs.getString("cust_addr");
			str[9]=rs.getString("cust_rmk");
		}
		
	%>


<div class="container-fluid">
	<div class="row-fluid">
		<div class="span3">
		</div>
		<div class="span6">
		<div class="btn-group table-bordered">
		    <a  href="<%= request.getContextPath() %>/xcrm/cust_mgt/qry_all_cust_info.jsp" class="btn"> <span class="add-on"><i class="icon-arrow-left"></i></span>&nbsp;返回列表</a>
			<a  href="<%= request.getContextPath() %>/xcrm/cust_mgt/add_cust_info.jsp" class="btn"> <span class="add-on"><i class="icon-plus"></i></span>&nbsp;新建</a>
			<a  href="<%= request.getContextPath() %>/xcrm/cust_mgt/mod_cust_info.jsp?custId=<%= str[0] %>" class="btn"> <span class="add-on"><i class="icon-edit"></i></span>&nbsp;编辑</a>	
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
							<p class="text-right">客户编号</p>
						</td>
						<td>
							<div class="input-append">
								<input  class="form-control" name="custId" value="<%= str[0] %>" type="text" readonly/>
							</div>
						</td>
					</tr>
					<tr class="warning">
						<td>
							<p class="text-right">客户名称</p>
						</td>
						<td>
							<div class="input-append">
								<input  class="form-control" name="custName" value="<%= str[1] %>" type="text" readonly/>
							</div>
						</td>
					</tr>
					<tr class="success">
						<td>
							<p class="text-right">客户状态</p>
						</td>
						<td>
							<div class="input-append">
								<input  class="form-control" name="custStatus" value="<%= str[2] %>" type="text" readonly/>
							</div>
						</td>
					</tr>
					<tr class="error">
						<td>
							<p class="text-right">客户类型</p>
						</td>
						<td>
							<div class="input-append">
								<input  class="form-control" name="custType" value="<%= str[3] %>" type="text" readonly/>
							</div>
						</td>
					</tr>
					<tr class="info">
						<td>
							<p class="text-right">客户级别</p>
						</td>
						<td>
							<div class="input-append">
								<input  class="form-control" name="custLvl" value="<%= str[4] %>" type="text" readonly/>
							</div>
						</td>
					</tr>
					<tr class="warning">
						<td>
							<p class="text-right">所属行业</p>
						</td>
						<td>
							<div class="input-append">
								<input  class="form-control" name="custInd" value="<%= str[5] %>" type="text" readonly/>
							</div>
						</td>
					</tr>

				</tbody>
				<thead>
					<tr>
						<th>
							地址信息
						</th>
					</tr>
				</thead>
				<tbody>
					<tr class="success">
						<td>
							<p class="text-right">省份</p>
						</td>
						<td>
							<div class="input-append">
								<input  class="form-control" name="custProv" value="<%= str[6] %>" type="text" readonly/>
							</div>
						</td>
					</tr>
					<tr class="error">
						<td>
							<p class="text-right">城市</p>
						</td>
						<td>
							<div class="input-append">
								<input  class="form-control" name="custCity" value="<%= str[7] %>" type="text" readonly/>
							</div>
						</td>
					</tr>
					<tr class="info">
						<td>
							<p class="text-right">详细地址</p>
						</td>
						<td>
							<div class="input-append">
								<input  class="form-control" name="custAddr" value="<%= str[8] %>" type="text" readonly/>
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
					<tr class="warning">
						<td>
							<p class="text-right">备注</p>
						</td>
						<td>
							<div class="input-append">
							<textarea class="form-control" name="custRmk" rows="2" readonly><%= str[9] %></textarea>
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