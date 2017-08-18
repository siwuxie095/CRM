<%@page import="java.sql.ResultSet"%>
<%@page import="com.crm.entity.extd.OfrInfoEntityExtd"%>
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
<title>编辑报价单</title>

<%-- <link href="<%= request.getContextPath() %>/xcrm/opp_mgt/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">  --%> 
<link href="<%= request.getContextPath() %>/xcrm/date_css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">

</head>
<body>
<%@ include file="/xcrm/bootstrap/nav.jsp" %>

<%
	Connection conn=null;
	conn=ConnectionFactory.getInstance().getConnection();
	OfrInfoDao ofrInfoDao=new OfrInfoDaoImpl();
	OfrInfoEntityExtd ofrInfo=new OfrInfoEntityExtd();
	
	String ofrId=request.getParameter("ofrId");
	ofrInfo.setOfrId(ofrId);
	ResultSet rs=ofrInfoDao.getDtlById(conn, ofrInfo);
	String str[]=new String[8];
	
	while(rs.next()){
		str[0]=rs.getString("ofr_id");
		str[1]=rs.getString("ofr_name");
		str[2]=rs.getString("cust_name");
		str[3]=rs.getString("ctc_name");
		str[4]=rs.getString("opp_id");
		str[5]=rs.getString("ofr_vali");
		str[6]=rs.getString("sale_disc");
		str[7]=rs.getString("sale_sum");
	}

%>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span3">
		</div>
		<div class="span6">
		<div class="btn-group table-bordered">
		    <a  href="<%= request.getContextPath() %>/xcrm/ofr_mgt/qry_all_ofr_info.jsp" class="btn"> <span class="add-on"><i class="icon-arrow-left"></i></span>&nbsp;返回列表</a>	
		    <a  href="<%= request.getContextPath() %>/xcrm/ofr_mgt/add_ofr_info.jsp" class="btn"> <span class="add-on"><i class="icon-plus"></i></span>&nbsp;新建</a>
		</div>
		<br/><br/>
		  <form class="form-horizontal"
			action="<%=request.getContextPath()%>/modifyOfrInfoServlet"
		     method="post" name="iForm">
			<table class="table table-bordered">
			
				<thead>
					<tr>
						<th>
							基本信息
						</th>
					</tr>
				</thead>
				<tbody>
					<tr class="info">
						<td>
							<p class="text-right">报价单号</p>
						</td>
						<td>
							<div class="input-append">
								<input name="ofrId" value="<%= str[0] %>" type="text" readonly />
							</div>
						</td>
					</tr>
					<tr class="warning">
						<td>
							<p class="text-right">报价单名</p>
						</td>
						<td>
							<div class="input-append">
								<input name="ofrName" value="<%= str[1] %>" type="text" />			
							</div> 
						</td>
					</tr>
					<tr class="success">
						<td>
							<p class="text-right">客户名称</p>
						</td>
					    <td>
							<div class="input-append">
								<input name="custName" value="<%= str[2] %>" type="text" readonly />
							</div>				
						</td>
					</tr>	    
					<tr class="error">
						<td>
							<p class="text-right">联系人</p>
						</td>
						<td>
							<div class="input-append">
								<input name="ctcName" value="<%= str[3] %>" type="text" readonly />
							</div>				
						</td>			
					</tr>
								
					<tr class="info">
						<td>
							<p class="text-right">销售机会</p>
						</td>
						<td>
							<div class="input-append">
								<input name="oppId" value="<%= str[4] %>" type="text" readonly />
							</div>				
						</td>
					</tr>
					
					<tr class="warning">
						<td>
							<p class="text-right">报价单状态</p>
						</td>
						<td>
							<select name="ofrStatus" class="form-control"><option value="已创建">已创建</option><option value="已审批">已审批</option><option value="已拒绝">已拒绝</option></select>							
						</td>
					</tr>
					<tr class="success">
						<td>
							<p class="text-right">报价单有效期</p>
						</td>
						<td>
							 <div class="input-append date form_datetime" data-date="" 
              				  data-date-format="yyyy MM dd" data-link-format="yyyy-mm-dd" data-link-field="dtp_input1">
                  			  <input  value="<%= str[5] %>"  size="16" type="text" readonly>
                 			   <span class="add-on"><i class="icon-remove"></i></span>
								<span class="add-on"><i class="icon-calendar"></i></span>
              				  </div>
                			<input type="hidden" id="dtp_input1" name="ofrVali" value="<%= str[5] %>" />
						</td>
					</tr>
					<tr class="error">
						<td>
							<p class="text-right">整单折扣</p>
						</td>
						<td>
							<div class="input-append">
								<input name="saleDisc" value="<%= str[6] %>" type="text" />			
							</div> 
						</td>
					</tr>
					<tr class="info">
						<td>
							<p class="text-right">合计</p>
						</td>
						<td>
							<div class="input-append">
								<input name="saleSum" value="<%= str[7] %>" type="text" />			
							</div> 
						</td>
					</tr>
									
				</tbody>	
					</table>
					
					 <div class="control-group">
						<div class="controls">
							 <button class="btn" type="submit">保存</button> &nbsp;&nbsp; <a href="<%= request.getContextPath() %>/xcrm/ofr_mgt/qry_all_ofr_info.jsp"><button class="btn" type="button">取消</button></a>
						</div>
					</div>
			</form>
			</div>
			<div class="span3">
			</div>

		</div>
	</div>
	
		
<%-- <script type="text/javascript" src="<%= request.getContextPath() %>/xcrm/opp_mgt/jquery/jquery-1.8.3.min.js" charset="UTF-8"></script> --%>
<%-- <script type="text/javascript" src="<%= request.getContextPath() %>/xcrm/opp_mgt/bootstrap/js/bootstrap.min.js"></script> --%>
<script type="text/javascript" src="<%= request.getContextPath() %>/xcrm/date_js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/xcrm/date_js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script type="text/javascript">
    $('.form_datetime').datetimepicker({
        language:  'zh-CN',
         weekStart: 0,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
         minView: 2,
        forceParse: 0
       
    });
    
	
</script>


<script type="text/javascript">

function check(form) {
	if (document.forms.iForm.ofrName.value == "") {
		alert("请输入报价单名！");
		document.forms.iForm.ofrName.focus();
		return false;
	}
	if (document.forms.iForm.ofrVali.value == "") {
		alert("请输入报价单有效期！");
		document.forms.iForm.ofrVali.focus();
		return false;
	}
	if (document.forms.iForm.saleDisc.value == "") {
		alert("请输入整单折扣！");
		document.forms.iForm.saleDisc.focus();
		return false;
	}
	if (document.forms.iForm.saleSum.value == "") {
		alert("请输入合计！");
		document.forms.iForm.saleSum.focus();
		return false;
	}
}



</script>
	
	
</body>
</html>