<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CRM系统</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- <link rel="stylesheet" href="http://www.bootcss.com/p/layoutit/css/bootstrap-combined.min.css">

<script src="http://www.bootcss.com/p/layoutit/js/jquery-2.0.0.min.js"></script>

<script src="http://www.bootcss.com/p/layoutit/js/bootstrap.min.js"></script> -->


 <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/2.3.2/css/bootstrap.min.css">

<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>

<script src="http://cdn.bootcss.com/bootstrap/2.3.2/js/bootstrap.min.js"></script> 



<%--  <link rel="stylesheet" href="<%= request.getContextPath() %>/xcrm/css/bootstrap.min.css">

<script src="<%= request.getContextPath() %>/xcrm/js/jquery.min.js"></script>

<script src="<%= request.getContextPath() %>/xcrm/js/bootstrap.min.js"></script>  --%>

<style>
.dropdown-menu > li > a:hover {
    background: black;
}

.dropdown-submenu:hover>a {
    background: black;
}


.dropdown-menu > li > a {
    display: block;
    padding: 3px 20px;
    clear: both;
    font-weight: normal;
    line-height: 1.42857;
    color: #333;
    white-space: nowrap;
}

</style>

</head>


<%
	String crmRole="";
	Object objX=session.getAttribute("crmRole");
	if(objX!=null){
		crmRole=objX.toString();
	}

%>

<body onload="startTime()">
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="navbar navbar-inverse">
				<div class="navbar-inner">
					<div class="container-fluid">
						 <a data-target=".navbar-responsive-collapse" data-toggle="collapse" class="btn btn-navbar"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></a> <a href="#" class="brand">Alpha CRM</a>
						<div class="nav-collapse collapse navbar-responsive-collapse">
							<ul class="nav">
								<li class="active"><a href="<%= request.getContextPath() %>/xcrm/nav/index.jsp">系统首页</a></li>
								
								
								<%
								String admin="";
								Object objx=session.getAttribute("crmId");
								if(objx!=null){
									admin=objx.toString();
								}
								if(admin.equals("admin")){
								%>
								 <li class="dropdown">
									 <a data-toggle="dropdown" class="dropdown-toggle" href="#">系统管理<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
										<li>
											<a href="<%= request.getContextPath() %>/xcrm/sys_mgt/crm_role_mgt.jsp">权限管理</a>
										</li>
										<li>
											<a href="<%= request.getContextPath() %>/xcrm/sys_mgt/crm_pwd_mgt.jsp">密码管理</a>
										</li>
									</ul>
								</li>
								
								<%  } %>	
								
								<li class="dropdown">
									 <a data-toggle="dropdown" class="dropdown-toggle" href="#">客户管理<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
									    <li>
											<a href="<%= request.getContextPath() %>/xcrm/cust_mgt/qry_all_cust_info.jsp">全部客户</a>
										</li>
										<li class="dropdown-submenu">
										<a tabindex="-1" href="#">客户状态</a>
													
											<ul class="dropdown-menu">
											
											<li>
											<a href="<%= request.getContextPath() %>/xcrm/cust_mgt/qry_cust_info_by_status.jsp?custStatus=潜在客户">潜在客户</a>
											</li>
											<li>
											<a href="<%= request.getContextPath() %>/xcrm/cust_mgt/qry_cust_info_by_status.jsp?custStatus=意向客户">意向客户</a>
											</li>
											<li>
											<a href="<%= request.getContextPath() %>/xcrm/cust_mgt/qry_cust_info_by_status.jsp?custStatus=成交客户">成交客户</a>
											</li>
											<li>
											<a href="<%= request.getContextPath() %>/xcrm/cust_mgt/qry_cust_info_by_status.jsp?custStatus=流失客户">流失客户</a>
											</li>
										</ul>
												
												
									</li>
										
										<li class="dropdown-submenu">
										<a tabindex="-1" href="#">客户类型</a>
													
											<ul class="dropdown-menu">
											
											<li>
											<a href="<%= request.getContextPath() %>/xcrm/cust_mgt/qry_cust_info_by_type.jsp?custType=小型客户">小型客户</a>
											</li>
											<li>
											<a href="<%= request.getContextPath() %>/xcrm/cust_mgt/qry_cust_info_by_type.jsp?custType=中型客户">中型客户</a>
											</li>
											<li>
											<a href="<%= request.getContextPath() %>/xcrm/cust_mgt/qry_cust_info_by_type.jsp?custType=大型客户">大型客户</a>
											</li>
										</ul>
									</li>
									
									<li class="dropdown-submenu">
										<a tabindex="-1" href="#">客户级别</a>
													
											<ul class="dropdown-menu">
											
											<li>
											<a href="<%= request.getContextPath() %>/xcrm/cust_mgt/qry_cust_info_by_lvl.jsp?custLvl=S 级客户">S 级客户</a>
											</li>
											<li>
											<a href="<%= request.getContextPath() %>/xcrm/cust_mgt/qry_cust_info_by_lvl.jsp?custLvl=A 级客户">A 级客户</a>
											</li>
											<li>
											<a href="<%= request.getContextPath() %>/xcrm/cust_mgt/qry_cust_info_by_lvl.jsp?custLvl=B 级客户">B 级客户</a>
											</li>
											<li>
											<a href="<%= request.getContextPath() %>/xcrm/cust_mgt/qry_cust_info_by_lvl.jsp?custLvl=C 级客户">C 级客户</a>
											</li>
											<li>
											<a href="<%= request.getContextPath() %>/xcrm/cust_mgt/qry_cust_info_by_lvl.jsp?custLvl=D 级客户">D 级客户</a>
											</li>
										</ul>
									</li>
											
																														
									</ul>
								</li>
								
								<li class="dropdown">
									 <a data-toggle="dropdown" class="dropdown-toggle" href="#">联络管理<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
										<li>
											<a href="<%= request.getContextPath() %>/xcrm/ctc_mgt/qry_all_ctc_info.jsp">联系人</a>
										</li>
									</ul>
								</li>
								<li class="dropdown">
									 <a data-toggle="dropdown" class="dropdown-toggle" href="#">销售管理<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
										<li>
											<a href="<%= request.getContextPath() %>/xcrm/opp_mgt/qry_all_opp_info.jsp">销售机会</a>
										</li>
										<li>
											<a href="<%= request.getContextPath() %>/xcrm/ofr_mgt/qry_all_ofr_info.jsp">报价单</a>
										</li>
										<li>
											<a href="<%= request.getContextPath() %>/xcrm/deal_mgt/qry_all_deal_info.jsp">合同订单</a>
										</li>
									</ul>
								</li>
								<li class="dropdown">
									 <a data-toggle="dropdown" class="dropdown-toggle" href="#">日志管理<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
										<li>
											<a href="<%= request.getContextPath() %>/xcrm/log_mgt/qry_all_log_info.jsp">跟踪记录</a>
										</li>
									</ul>
								</li>
								<li><a href="<%= request.getContextPath() %>/xcrm/nav/about.jsp">关于我们</a></li>
							</ul>
							<ul class="nav pull-right">
									<li>
									<a id="txt"></a> 
									</li>
									<li class="divider-vertical">

									<%
 									String flag="";
    							  //从session从获取用户的登录状态
									Object obj=session.getAttribute("flag");
									if(obj!=null){
									flag=obj.toString();
									}
									//如果用户当前处于登录状态  显示一个退出链接
									//如果用户当前处于未登录状态 显示一个登录链接
									if(!flag.equals("login_success")){
									%>		
									<li>
									<a href="<%= request.getContextPath() %>/xcrm/nav/login.jsp">登录</a>
									</li>
									<li class="divider-vertical">
									</li>
									<li>
									<a href="<%= request.getContextPath() %>/xcrm/nav/register.jsp">注册</a>
									</li>
	
	
									<%	}else{  %>
									
									
									
									<li class="dropdown">
									 <a data-toggle="dropdown" class="dropdown-toggle" href="#">
									 
									 <% 
										String crmTitle="";
										String crmName="";
										Object obj1=session.getAttribute("crmTitle");
										Object obj2=session.getAttribute("crmName");
										
										if(obj1!=null&&obj2!=null){
											
											crmTitle=obj1.toString();
											crmName=obj2.toString();
											out.print(crmTitle+"："+crmName);
											
										}else{
											out.print("null");
										}
									%>
									 
									 <strong class="caret"></strong></a>
									<ul class="dropdown-menu">
									
									<% if(objX==null){ %>
										<li>
											<a href="<%= request.getContextPath() %>/xcrm/crm_mgt/add_crm_info.jsp">添加信息</a>
										</li>
										<% }else{ %>
										<li>
											<a href="<%= request.getContextPath() %>/xcrm/crm_mgt/mod_crm_info.jsp">修改信息</a>
										</li>
										<% } %>
										<li>
											<a href="<%= request.getContextPath() %>/xcrm/crm_mgt/mod_crm_pwdx.jsp">修改密码</a>
										</li>
									</ul>
								</li>

									
										<li class="divider-vertical">
										</li>
										<li>
										<a href="<%= request.getContextPath() %>/logoutServlet">退出</a>
										</li>
		
										<%  } %>
								
							</ul>
						</div>
						
					</div>
				</div>
				
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
function startTime()
{
var today=new Date()
var h=today.getHours()
var m=today.getMinutes()
var s=today.getSeconds()
// add a zero in front of numbers<10
m=checkTime(m)
s=checkTime(s)
document.getElementById('txt').innerHTML=h+":"+m+":"+s
t=setTimeout('startTime()',500)
}

function checkTime(i)
{
if (i<10) 
  {i="0" + i}
  return i
}
</script>


</body>
</html>