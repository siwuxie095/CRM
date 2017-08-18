<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JavaScript 注册·登录校验</title>

</head>
<body>
	<script type="text/javascript">
	function check(form) {
		if (document.forms.iForm.crmId.value == "") {
			alert("请输入帐号！");
			document.forms.iForm.crmId.focus();
			return false;
		}
		if (document.forms.iForm.crmPwd.value == "") {
			alert("请输入密码！");
			document.forms.iForm.crmPwd.focus();
			return false;
		}
	}
</script>
</body>
</html>