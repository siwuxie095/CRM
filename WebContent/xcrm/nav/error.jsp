<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta http-equiv="refresh" content="4;url=<%= request.getContextPath() %>/xcrm/nav/index.jsp" />
<title>错误跳转</title>
</head>
<body>

<%@ include file="/xcrm/bootstrap/nav.jsp" %>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<div class="alert alert-error" align="center">
					<button type="button" class="close" data-dismiss="alert">×</button>
					<h4>error!</h4>
					<br/>
					<strong>警告!</strong>
					<%
						Object objY = request.getAttribute("msg");
						if (objY != null) {
							out.print(objY.toString());
						} else {
							out.print("无");
						}
					%>
				</div>
				
				<div class="progress progress-striped active">
  			<div class="bar bar-danger" id="processbar" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width:0%">
    			<span id="aa">80% 完成</span>
  			</div>
		</div>
	
<script type="text/javascript">
var total=3000;
var breaker=30;
var turn=100/(total/breaker);
var progress=0;
var timer = setInterval(function(){
    progress=progress+turn;
    $("#aa").html(progress+"% 完成");
    $("#processbar").attr("style", "width:"+progress+"%");
    if (progress>=100) {
        clearInterval(timer);
    }
}, breaker);
</script>
				
				
			</div>
		</div>
	</div>

</body>
</html>