<%@page import="com.crm.entity.extd.CtcInfoEntityExtd"%>
<%@page import="com.crm.dao.impl.CtcInfoDaoImpl"%>
<%@page import="com.crm.dao.CtcInfoDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.crm.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>联系人详细信息</title>
</head>
<body>
<%@ include file="/xcrm/bootstrap/nav.jsp" %>


<%
		
		Connection conn=null;
		conn=ConnectionFactory.getInstance().getConnection();
		CtcInfoDao ctcInfoDao=new CtcInfoDaoImpl();
		
		CtcInfoEntityExtd ctcInfo=new CtcInfoEntityExtd();
		String ctcId=request.getParameter("ctcId");
		ctcInfo.setCtcId(ctcId);
		
		
		ResultSet rs=ctcInfoDao.getDtlById(conn, ctcInfo);
		String str[]=new String[12];
		
		while(rs.next()){
			str[0]=rs.getString("ctc_id");
			str[1]=rs.getString("ctc_name");
			str[2]=rs.getString("ctc_title");
			str[3]=rs.getString("ctc_cel");
			str[4]=rs.getString("ctc_tel");
			str[5]=rs.getString("ctc_fax");
			str[6]=rs.getString("ctc_mail");
			str[7]=rs.getString("cust_name");
			str[8]=rs.getString("ctc_prov");
			str[9]=rs.getString("ctc_city");
			str[10]=rs.getString("ctc_addr");
			str[11]=rs.getString("ctc_rmk");
		}
		
	%>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span3">
		</div>
		<div class="span6">
		<div class="btn-group table-bordered">
		    <a  href="<%= request.getContextPath() %>/xcrm/ctc_mgt/qry_all_ctc_info.jsp" class="btn"> <span class="add-on"><i class="icon-arrow-left"></i></span>&nbsp;返回列表</a>
			<a  href="<%= request.getContextPath() %>/xcrm/ctc_mgt/add_ctc_info.jsp" class="btn"> <span class="add-on"><i class="icon-plus"></i></span>&nbsp;新建</a>
			<a  href="<%= request.getContextPath() %>/xcrm/ctc_mgt/mod_ctc_info.jsp?ctcId=<%= str[0] %>" class="btn"> <span class="add-on"><i class="icon-edit"></i></span>&nbsp;编辑</a>	
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
								<input name="ctcId" value="<%= str[0] %>" type="text" readonly />
							</div>
						</td>
					</tr>
					<tr class="warning">
						<td>
							<p class="text-right">姓名</p>
						</td>
						<td>
							<div class="input-append">
								<input name="ctcName" value="<%= str[1] %>" type="text" readonly />			
							</div> 
						</td>
					</tr>
					
					
					<tr class="success">
						<td>
							<p class="text-right">职务</p>
						</td>
						<td>
							<div class="input-append">
								<input name="ctcTitle" value="<%= str[2] %>" type="text" readonly />
							</div>
						</td>
					</tr>
					
					
					
					<tr class="error">
						<td>
							<p class="text-right">手机</p>
						</td>
						<td>
							<div class="input-append">
								<input name="ctcCel" value="<%= str[3] %>" type="text" readonly />
							</div>
						</td>
					</tr>
					<tr class="info">
						<td>
							<p class="text-right">电话</p>
						</td>
						<td>
							<div class="input-append">
								<input name="ctcTel" value="<%= str[4] %>" type="text" readonly />
							</div>
						</td>
					</tr>
					
					<tr class="warning">
						<td>
							<p class="text-right">传真</p>
						</td>
						<td>
							<div class="input-append">
								<input name="ctcFax" value="<%= str[5] %>" type="text" readonly />
							</div>
						</td>
					</tr>
					<tr class="success">
						<td>
							<p class="text-right">邮箱</p>
						</td>
						<td>
							<div class="input-append">
								<input name="ctcMail" value="<%= str[6] %>" type="text" readonly />
							</div>
						</td>
					</tr>
					
					
					
					<tr class="error">
						<td>
							<p class="text-right">客户名称</p>
						</td>
						<td>
							<div class="input-append">
								<input name="custName" value="<%= str[7] %>" type="text" readonly />
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
					<tr class="info">
						<td>
							<p class="text-right">省份</p>
						</td>
						<td>
							<div class="input-append">
								<input name="ctcProv" value="<%= str[8] %>" type="text" readonly />
							</div>
						</td>
					</tr>
					<tr class="warning">
						<td>
							<p class="text-right">城市</p>
						</td>
						<td>
							<div class="input-append">
								<input name="ctcCity" value="<%= str[9] %>" type="text" readonly />
							</div>
						</td>
					</tr>
					<tr class="success">
						<td>
							<p class="text-right">详细地址</p>
						</td>
						<td>
							<div class="input-append">
								<input name="ctcAddr" value="<%= str[10] %>" type="text" readonly />
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
							<textarea name="ctcRmk" rows="2" readonly><%= str[11] %></textarea>
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