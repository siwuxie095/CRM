<%@page import="com.crm.entity.extd.DealInfoEntityExtd"%>
<%@page import="com.crm.dao.impl.DealInfoDaoImpl"%>
<%@page import="com.crm.dao.DealInfoDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.crm.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.crm.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>全部合同订单</title>

</head>
<body>
<%@ include file="/xcrm/bootstrap/nav.jsp" %>

<%
	Connection conn=null;
	conn=ConnectionFactory.getInstance().getConnection();
	
	DealInfoDao dealInfoDao=new DealInfoDaoImpl();
	
	
	ResultSet rs=null;
	
	String crmName=session.getAttribute("crmName").toString();
	
	if(!crmRole.equals("comm")){
		rs=dealInfoDao.getAll(conn);
	}else{
		
		
		DealInfoEntityExtd dealInfo=new DealInfoEntityExtd();
		dealInfo.setCrmName(crmName);
		rs=dealInfoDao.getAllX(conn, dealInfo);
	}
	
	
			
%>


<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
		<div class="btn-group table-bordered">
			<a  href="<%= request.getContextPath() %>/xcrm/deal_mgt/add_deal_info.jsp" class="btn"> <span class="add-on"><i class="icon-plus"></i></span>&nbsp;新建</a>
            <a href="<%= request.getContextPath() %>/xcrm/deal_mgt/qry_all_deal_info.jsp" class="btn"> <span class="add-on"><i class="icon-repeat"></i></span>&nbsp;刷新</a>
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
							合同编号
						</th>
						<th>
							合同主题
						</th>
						<th>
							客户名称
						</th>
						<th>
							签约日期
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
							<label class="checkbox"><input type="checkbox" name="dealId" value="<%= rs.getString("deal_id") %>" /></label>
							<% }else{ %>
							<label class="checkbox"><input type="checkbox" name="dealId" value="<%= rs.getString("deal_id") %>" disabled="disabled" /></label>
							<% } %>
						</td>
						<td>
							<a href="<%= request.getContextPath() %>/xcrm/deal_mgt/qry_dtl_deal_info_by_id.jsp?dealId=<%= rs.getString("deal_id") %>"><% out.print(rs.getString("deal_id")); %></a>
						</td>
						<td>
							<a href="<%= request.getContextPath() %>/xcrm/deal_mgt/qry_dtl_deal_info_by_name.jsp?dealThm=<%= rs.getString("deal_thm") %>"><% out.print(rs.getString("deal_thm")); %></a>
						</td>
						<td>
							<a href="<%= request.getContextPath() %>/xcrm/cust_mgt/qry_dtl_cust_info_by_name.jsp?custName=<%= rs.getString("cust_name") %>"><% out.print(rs.getString("cust_name")); %></a>
						</td>
						<td>
							<% out.print(rs.getString("deal_date")); %>
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
							<a href="<%= request.getContextPath() %>/xcrm/deal_mgt/mod_deal_info.jsp?dealId=<%= rs.getString("deal_id") %>" class="btn"> <span class="add-on"><i class="icon-edit"></i></span>&nbsp;编辑</a>
						    <a href="<%= request.getContextPath() %>/deleteDealInfoServlet?dealId=<%= rs.getString("deal_id") %>&delMode=sgl" class="btn"> <span class="add-on"><i class=" icon-trash"></i></span>&nbsp;删除</a>
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
			var num=$("input[name='dealId']:checked").length;
			if(num==0){
				alert("您尚未选择！请选择后再删除！");
				return false;
			}else{
				var tip="您共选中 "+num+" 记录，确定要删除吗？";
				if(confirm(tip)){
					var checkArr=$("input[name='dealId']:checked").val([]);
					var dealIds="";
					 for(var i=0;i<checkArr.length;i++){  
						 if(i==checkArr.length-1){
			                	dealIds += checkArr[i].value;
			                }else{
			                	 dealIds += checkArr[i].value +"%23";
			                }
			            }  
					 document.location.href="<%= request.getContextPath() %>/deleteDealInfoServlet?dealIds="+dealIds+"&delMode=mul";
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