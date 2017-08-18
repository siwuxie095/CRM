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
<title>添加个人信息</title>



<link href="<%= request.getContextPath() %>/xcrm/css/main.css" rel="stylesheet">
<script src="<%= request.getContextPath() %>/xcrm/js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="<%= request.getContextPath() %>/xcrm/js/role.data.js"></script>
<script src="<%= request.getContextPath() %>/xcrm/js/role.js"></script>


</head>
<body>
<%@ include file="/xcrm/bootstrap/nav.jsp" %>


<%	if(objX!=null){ %>
		
		<jsp:forward page="/xcrm/nav/index.jsp"></jsp:forward>
		
		<% 
	}
	
	String crmId=session.getAttribute("crmId").toString();
	
	Connection conn=null;
	conn=ConnectionFactory.getInstance().getConnection();
	CrmInfoDao crmInfoDao=new CrmInfoDaoImpl();
	
	
	ResultSet rs=crmInfoDao.getNum(conn);
	int num=0;
	while(rs.next()){
		num=rs.getInt(1);
	}
	
	ResultSet rsy=crmInfoDao.getAllName(conn);
	String stry[] = new String[num];
	int numy=0;
	while (rsy.next()) {
		stry[numy] = rsy.getString("crm_name");
		numy++;
	}
	
	

%>


<div class="container-fluid">
	<div class="row-fluid">
		<div class="span3">
		</div>
		<div class="span6">
				  <form class="form-horizontal"
			action="<%=request.getContextPath()%>/addCrmInfoServlet" method="post" name="iForm">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>
							基本信息
						</th>
					</tr>
				</thead>
				<tbody  data-toggle="distpicker">
					<tr class="info">
						<td>
							<p class="text-right">帐号</p>
						</td>
						<td>
							<div class="input-append">
								<input name="crmId" value="<%= crmId %>" type="text" readonly />
							</div>
						</td>
					</tr>
						<tr class="warning">
						<td>
							<p class="text-right">姓名</p>
						</td>
						<td>
							<div class="input-append">
								<input name="crmName" type="text" />
							</div>
						</td>
					</tr>
					
							<tr class="success">
								<td><label class="sr-only" for="province7"><p
											class="text-right">职务</p></label></td>
								<td><select name="crmTitle" class="form-control"
									id="province7"></select></td>
							</tr>
							<tr class="error">
								<td><label class="sr-only" for="city7"><p
											class="text-right">权限</p></label></td>
								<td><select name="crmRole" class="form-control" id="city7"></select></td>
							</tr>
							
				</tbody>
				
			</table>
					<div class="control-group">
						<div class="controls">
							 <button class="btn" type="submit" onclick="return checkCrmName(this);">保存</button> &nbsp;&nbsp; <a href="<%= request.getContextPath() %>/xcrm/nav/index.jsp"><button class="btn" type="button">取消</button></a>
						</div>
					</div>
			</form>
			</div>
			<div class="span3">
			</div>
		</div>
	</div>
	
	
	<script type="text/javascript">
		function checkCrmName(form) {

			var crmName = document.forms.iForm.crmName.value;
			
			if (crmName == "") {
				alert("请输入姓名！");
				document.forms.iForm.custName.focus();
				return false;
			}else {
				
				
			var list = new Array();
			
			<% for (int k = 0; k < stry.length; k++) { %>
			
				list[<%=k%>] ='<%=stry[k]%>';
			
			<% } %>
			
			for(var i=0;i<list.length;i++){
				if(crmName==list[i]){
					alert("该姓名已存在，您可以选择其他如 "+crmName+"1314 的形式");
					return false;
				}
			}	
				
				
			}

		}

	</script>
	
	
</body>
</html>