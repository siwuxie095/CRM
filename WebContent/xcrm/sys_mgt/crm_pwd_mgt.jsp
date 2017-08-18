<%@page import="com.crm.dao.impl.CrmPwdxDaoImpl"%>
<%@page import="com.crm.dao.CrmPwdxDao"%>
<%@page import="java.sql.ResultSet"%>
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
<title>密码管理</title>

</head>
<body>
<%@ include file="/xcrm/bootstrap/nav.jsp" %>

<%	if(!crmRole.equals("root")){ %>
	<jsp:forward page="/xcrm/nav/index.jsp"></jsp:forward>
<%	
	}

	Connection conn=null;
	conn=ConnectionFactory.getInstance().getConnection();
	CrmPwdxDao crmPwdxDao=new CrmPwdxDaoImpl();
	ResultSet rs=crmPwdxDao.getAll(conn);
	
	String currentUri=request.getRequestURI();

%>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span4">
		</div>
		<div class="span4">
		<div class="btn-group table-bordered">

            <a href="<%= request.getContextPath() %>/xcrm/sys_mgt/crm_pwd_mgt.jsp" class="btn"> <span class="add-on"><i class="icon-repeat"></i></span>&nbsp;刷新</a>
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
							帐号
						</th>
						<th>
							密码
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<% while(rs.next()){
					if(!rs.getString("crm_id").equals("admin")){
					%>
				<tbody>
					<tr>
						<td>
							<label class="checkbox"><input type="checkbox" name="crmId" value="<%= rs.getString("crm_id") %>" /></label>
						</td>
						
						<td>
							<% out.print(rs.getString("crm_id")); %>
						</td>
						<td>
							<% out.print("*****"+rs.getString("crm_pwd").substring(2, 3)+"*****"); %>
						</td>
						<td>
							<a href="<%= request.getContextPath() %>/xcrm/sys_mgt/mod_pwd.jsp?crmId=<%= rs.getString("crm_id") %>" class="btn"> <span class="add-on"><i class="icon-edit"></i></span>&nbsp;编辑</a>
						    <a href="<%= request.getContextPath() %>/deleteCrmInfoServlet?crmId=<%= rs.getString("crm_id") %>&delMode=sgl&rtnUri=<%= currentUri %>" class="btn"> <span class="add-on"><i class=" icon-trash"></i></span>&nbsp;删除</a>
						</td>
					</tr>
				</tbody>
				<% 
					}
					} %>
			</table>
		</div>
		<div class="span4">
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
					this.checked = true;
				});
				isCheckAll = true;
			}
		}
		
		
		
		function checkNum(){
			var num=$("input[name='crmId']:checked").length;
			if(num==0){
				alert("您尚未选择！请选择后再删除！");
				return false;
			}else{
				var tip="您共选中 "+num+" 记录，确定要删除吗？";
				if(confirm(tip)){
					var checkArr=$("input[name='crmId']:checked").val([]);
					var crmIds="";
					 for(var i=0;i<checkArr.length;i++){  
						 if(i==checkArr.length-1){
			                	crmIds += checkArr[i].value;
			                }else{
			                	 crmIds += checkArr[i].value +"%23";
			                }
			            }  
					 document.location.href="<%= request.getContextPath() %>/deleteCrmInfoServlet?crmIds="+crmIds+"&delMode=mul&rtnUri=<%= currentUri %>";
					return true;
				}else{
					return false;
				}
			}
		}
		
		
		
		
	</script>
	
	
	
</body>
</html>