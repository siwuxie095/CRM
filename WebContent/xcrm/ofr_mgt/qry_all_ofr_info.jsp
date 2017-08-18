<%@page import="com.crm.entity.extd.OfrInfoEntityExtd"%>
<%@page import="java.sql.ResultSet"%>
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
<title>全部报价单</title>

</head>
<body>
<%@ include file="/xcrm/bootstrap/nav.jsp" %>

<%
	Connection conn=null;
	conn=ConnectionFactory.getInstance().getConnection();
	
	OfrInfoDao ofrInfoDao=new OfrInfoDaoImpl();
	
	ResultSet rs=null;
	if(!crmRole.equals("comm")){
		rs=ofrInfoDao.getAll(conn);
	}else{
		
		String crmName=session.getAttribute("crmName").toString();
		OfrInfoEntityExtd ofrInfo=new OfrInfoEntityExtd();
		ofrInfo.setCrmName(crmName);
		rs=ofrInfoDao.getAllX(conn, ofrInfo);
	}
		
	String crmName=session.getAttribute("crmName").toString();

%>


<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
		<div class="btn-group table-bordered">
			<a  href="<%= request.getContextPath() %>/xcrm/ofr_mgt/add_ofr_info.jsp" class="btn"> <span class="add-on"><i class="icon-plus"></i></span>&nbsp;新建</a>
            <a href="<%= request.getContextPath() %>/xcrm/ofr_mgt/qry_all_ofr_info.jsp" class="btn"> <span class="add-on"><i class="icon-repeat"></i></span>&nbsp;刷新</a>
			<a onclick="return checkNum();" class="btn"> <span class="add-on"><i class="icon-trash"></i></span>&nbsp;批量删除</a>
			</div>
			<br/><br/>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>
							<label class="checkbox"><input type="checkbox" onclick="swapCheck()" /></label>
						</th>
						<th>
							报价单号
						</th>
						<th>
							报价单名
						</th>
						<th>
							客户名称
						</th>
						<th>
							联系人
						</th>
						<th>
							整单折扣
						</th>
						<th>
							合计
						</th>
						<% if(!crmRole.equals("comm")){ %>
						<th>
							销售负责人
						</th>
						<% } %>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<% while(rs.next()){ %>
				<tbody>
					<tr>
						<td>
						<% if(crmName.equals(rs.getString("crm_name"))){ %>
							<label class="checkbox"><input type="checkbox" name="ofrId" value="<%= rs.getString("ofr_id") %>" /></label>
							<% }else{ %>
							<label class="checkbox"><input type="checkbox" name="ofrId" value="<%= rs.getString("ofr_id") %>" disabled="disabled" /></label>
							<% } %>
						</td>
						<td>
							<a href="<%= request.getContextPath() %>/xcrm/ofr_mgt/qry_dtl_ofr_info_by_id.jsp?ofrId=<%= rs.getString("ofr_id") %>"><% out.print(rs.getString("ofr_id")); %></a>
						</td>
						<td>
							<a href="<%= request.getContextPath() %>/xcrm/ofr_mgt/qry_dtl_ofr_info_by_name.jsp?ofrName=<%= rs.getString("ofr_name") %>"><% out.print(rs.getString("ofr_name")); %></a>
						</td>
						<td>
							<a href="<%= request.getContextPath() %>/xcrm/cust_mgt/qry_dtl_cust_info_by_name.jsp?custName=<%= rs.getString("cust_name") %>"><% out.print(rs.getString("cust_name")); %></a>
						</td>
						<td>
							<a href="<%= request.getContextPath() %>/xcrm/ctc_mgt/qry_dtl_ctc_info_by_name.jsp?ctcName=<%= rs.getString("ctc_name") %>"><% out.print(rs.getString("ctc_name")); %></a>
						</td>
						<td>
							<% out.print(rs.getString("sale_disc")); %>
						</td>
						<td>
							<% out.print(rs.getString("sale_sum")); %>
						</td>
						<% if(!crmRole.equals("comm")){ %>
						<td>
							<% out.print(rs.getString("crm_name")); %>
						</td>
						<% } %>
						<td>
						<% if(crmName.equals(rs.getString("crm_name"))){ %>
							<a href="<%= request.getContextPath() %>/xcrm/ofr_mgt/mod_ofr_info.jsp?ofrId=<%= rs.getString("ofr_id") %>" class="btn"> <span class="add-on"><i class="icon-edit"></i></span>&nbsp;编辑</a>
						    <a href="<%= request.getContextPath() %>/deleteOfrInfoServlet?ofrId=<%= rs.getString("ofr_id") %>&delMode=sgl"  class="btn"> <span class="add-on"><i class=" icon-trash"></i></span>&nbsp;删除</a>
						    <% } %>
						</td>
					</tr>
				</tbody>
				<% } %>
			</table>
		</div>
	</div>
	</div>
	
	
	
	<script type="text/javascript">
		//checkbox 全选/取消全选  
		var isCheckAll = false;
		function swapCheck() {
			if (isCheckAll) {
				$("input[type='checkbox']").each(function() {
					this.checked = false;
				});
				isCheckAll = false;
			} else {
				$("input[type='checkbox']").each(function() {
					if(!$(this).is(':disabled')){
						this.checked = true;
		            }
				});
				isCheckAll = true;
			}
		}
		
		
		
		function checkNum(){
			var num=$("input[name='ofrId']:checked").length;
			if(num==0){
				alert("您尚未选择！请选择后再删除！");
				return false;
			}else{
				var tip="您共选中 "+num+" 记录，确定要删除吗？";
				if(confirm(tip)){
					var checkArr=$("input[name='ofrId']:checked").val([]);
					var ofrIds="";
					 for(var i=0;i<checkArr.length;i++){  
						 if(i==checkArr.length-1){
			                	ofrIds += checkArr[i].value;
			                }else{
			                	 ofrIds += checkArr[i].value +"%23";
			                }
			            }  
					 document.location.href="<%= request.getContextPath() %>/deleteOfrInfoServlet?ofrIds="+ofrIds+"&delMode=mul";
					return true;
				}else{
					return false;
				}
			}
		}
		
		
		
		
		function check(form) {
			if (document.forms.iForm.oppQry.value == "") {
				alert("请输入后再查找！");
				document.forms.iForm.oppQry.focus();
				return false;
			}
		}
		
	</script>
	
	
	
</body>
</html>