<%@page import="java.sql.ResultSet"%>
<%@page import="com.crm.dao.impl.OppInfoDaoImpl"%>
<%@page import="com.crm.dao.OppInfoDao"%>
<%@page import="com.crm.entity.extd.OppInfoEntityExtd"%>
<%@page import="com.crm.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>全部销售机会</title>

</head>
<body>
<%@ include file="/xcrm/bootstrap/nav.jsp" %>

<div class="container-fluid">

<%
	Connection conn=null;
	conn=ConnectionFactory.getInstance().getConnection();
	OppInfoDao oppInfoDao=new OppInfoDaoImpl();
	
	ResultSet rs=null;
	
	String crmName=session.getAttribute("crmName").toString();
	System.out.println(crmName);
	
	if(!crmRole.equals("comm")){
		rs=oppInfoDao.getAll(conn);
	}else{
		OppInfoEntityExtd oppInfo=new OppInfoEntityExtd();
		oppInfo.setCrmName(crmName);
		rs=oppInfoDao.getAllX(conn, oppInfo);
	}
%>


	<div class="row-fluid">
		<div class="span12">
		<div class="btn-group table-bordered">
			<a  href="<%= request.getContextPath() %>/xcrm/opp_mgt/add_opp_info.jsp" class="btn"> <span class="add-on"><i class="icon-plus"></i></span>&nbsp;新建</a>
            <a href="<%= request.getContextPath() %>/xcrm/opp_mgt/qry_all_opp_info.jsp" class="btn"> <span class="add-on"><i class="icon-repeat"></i></span>&nbsp;刷新</a>
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
							编号
						</th>
						<th>
							销售机会
						</th>
						<th>
							销售阶段
						</th>
						<th>
							机会来源
						</th>
						<th>
							预计成交金额
						</th>
						<th>
							预计成交日期
						</th>
						<th>
							可能性
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
							<label class="checkbox"><input type="checkbox" name="oppId" value="<%= rs.getString("opp_id") %>" /></label>
							<% }else{ %>
							<label class="checkbox"><input type="checkbox" name="oppId" value="<%= rs.getString("opp_id") %>" disabled="disabled" /></label>
							<% } %>
						</td>
						<td>
							<a href="<%=request.getContextPath()%>/xcrm/opp_mgt/qry_dtl_opp_info_by_id.jsp?oppId=<%= rs.getString("opp_id") %>"><% out.print(rs.getString("opp_id")); %></a>
						</td>
						<td>
							<a href="<%=request.getContextPath()%>/xcrm/opp_mgt/qry_dtl_opp_info_by_name.jsp?oppName=<%= rs.getString("opp_name") %>"><% out.print(rs.getString("opp_name")); %></a>
						</td>
						<td>
							<% out.print(rs.getString("sale_stg")); %>
						</td>
						<td>
							<% out.print(rs.getString("opp_src")); %>
						</td>
						<td>
							<% out.print(rs.getString("pre_sale_sum")); %>
						</td>
						<td>
							<% out.print(rs.getString("pre_deal_date")); %>
						</td>						
						<td>
						   <% out.print(rs.getString("succ_per")); %>
						</td>
						
						
						
						
						<% if(!crmRole.equals("comm")){ %>
						<td>
							<% out.print(rs.getString("crm_name")); %>
						</td>
						<% } %>
						
						
						
						
						<td>
						<% if(!crmRole.equals("comm")){ %>
							<a href="<%= request.getContextPath() %>/xcrm/opp_mgt/assign_opp_info.jsp?oppId=<%= rs.getString("opp_id") %>" class="btn"> <span class="add-on"><i class="icon-user"></i></span>&nbsp;分配</a>
							<% } %>
							<% if(crmName.equals(rs.getString("crm_name"))){ %>
							<a href="<%= request.getContextPath() %>/xcrm/opp_mgt/follow_opp_info.jsp?custName=<%= rs.getString("cust_name") %>&ctcName=<%= rs.getString("ctc_name") %>&oppId=<%= rs.getString("opp_id") %>" class="btn"> <span class="add-on"><i class="icon-pencil"></i></span>&nbsp;跟进</a>
							<a href="<%= request.getContextPath() %>/xcrm/opp_mgt/mod_opp_info.jsp?oppId=<%= rs.getString("opp_id") %>" class="btn"> <span class="add-on"><i class="icon-edit"></i></span>&nbsp;编辑</a>
						    <a href="<%= request.getContextPath() %>/deleteOppInfoServlet?oppId=<%= rs.getString("opp_id") %>&delMode=sgl" class="btn"> <span class="add-on"><i class=" icon-trash"></i></span>&nbsp;删除</a>
						    <% } %>
						</td>
					</tr>
				</tbody>
				<% } %>
			</table>
		</div>
	</div>
	</div>
</body>


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
			var num=$("input[name='oppId']:checked").length;
			if(num==0){
				alert("您尚未选择！请选择后再删除！");
				return false;
			}else{
				var tip="您共选中 "+num+" 记录，确定要删除吗？";
				if(confirm(tip)){
					var checkArr=$("input[name='oppId']:checked").val([]);
					var oppIds="";
					 for(var i=0;i<checkArr.length;i++){  
						 if(i==checkArr.length-1){
			                	oppIds += checkArr[i].value;
			                }else{
			                	 oppIds += checkArr[i].value +"%23";
			                }
			            }  
					 document.location.href="<%= request.getContextPath() %>/deleteOppInfoServlet?oppIds="+oppIds+"&delMode=mul";
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




</html>