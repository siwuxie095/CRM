<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
</head>
<body>
<%@ include file="/xcrm/bootstrap/nav.jsp" %>

<%	if(!crmRole.equals("root")){ %>
	<jsp:forward page="/xcrm/nav/index.jsp"></jsp:forward>
<%	
	}

	String crmId=request.getParameter("crmId");

%>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span3">
		</div>
		<div class="span6">
				  <form class="form-horizontal"
			action="<%=request.getContextPath()%>/modifyCrmPwdxServlet?modMode=byAdmin" method="post" name="iForm">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>
							修改密码
						</th>
					</tr>
				</thead>
				<tbody>
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
							<p class="text-right">新密码</p>
						</td>
						<td>
							<div class="input-append">
								<input name="crmPwd" type="password" />
							</div>
						</td>
					</tr>	
						<tr class="success">
						<td>
							<p class="text-right">再次确认</p>
						</td>
						<td>
							<div class="input-append">
								<input name="crmPwdX" type="password" />
							</div>
						</td>
					</tr>	
				</tbody>
				
			</table>
					<div class="control-group">
						<div class="controls">
							 <button class="btn" type="submit" onclick="return check(this);">确认</button> &nbsp;&nbsp; <a href="<%= request.getContextPath() %>/xcrm/sys_mgt/crm_pwd_mgt.jsp"><button class="btn" type="button">取消</button></a>
						</div>
					</div>
			</form>
			</div>
			<div class="span3">
			</div>
		</div>
	</div>
	
	
	
	
	<script type="text/javascript">
	
	function check(form) {
		if (document.forms.iForm.crmPwd.value == "") {
			alert("请输入新密码！");
			document.forms.iForm.crmPwd.focus();
			return false;
		}
		if (document.forms.iForm.crmPwdX.value == "") {
			alert("请再次确认密码！");
			document.forms.iForm.crmPwdX.focus();
			return false;
		}
		if (document.forms.iForm.crmPwd.value != document.forms.iForm.crmPwdX.value) {
			alert("两次密码输入不一致！");
			document.forms.iForm.crmPwdX.focus();
			return false;
		}
	}
	
	</script>
	

</body>
</html>