<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
<%@ include file="/xcrm/bootstrap/nav.jsp" %>
<%@ include file="/xcrm/js/login_n_register_check.jsp"%>
<div class="container-fluid">
	<div class="row-fluid">
	  <div class="span3">
	  </div>
		<div class="span6">
			<form class="form-horizontal"
			action="<%=request.getContextPath()%>/checkRegisterServlet" method="post" name="iForm">
				<div class="control-group">
					<div class="controls">
					  <div class="input-prepend">
					   <span class="add-on"><i class="icon-user"></i></span>
						<input name="crmId" id="crmId" placeholder="account" type="text" />
					  </div>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
					  <div class="input-prepend">
					   <span class="add-on"><i class="icon-lock"></i></span>
						<input name="crmPwd" id="crmPwd" placeholder="password" type="password" />
					</div>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						 <button class="btn btn-inverse" type="submit" onclick="return check(this);">注册</button>
						 &nbsp;&nbsp;&nbsp;
						  <button type="reset" class="btn">取消</button>
					</div>
				</div>
			</form>
		</div>
		<div class="span3">
	</div>
	</div>
</div>
</body>
</html>