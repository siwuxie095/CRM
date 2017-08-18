<%@page import="com.crm.entity.extd.DealInfoEntityExtd"%>
<%@page import="com.crm.dao.impl.DealInfoDaoImpl"%>
<%@page import="com.crm.dao.DealInfoDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.crm.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建合同订单</title>
<%-- <link href="<%= request.getContextPath() %>/xcrm/opp_mgt/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">  --%> 
<link href="<%= request.getContextPath() %>/xcrm/date_css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">

</head>
<body>
<%@ include file="/xcrm/bootstrap/nav.jsp" %>
<%
	Connection conn=null;
	conn=ConnectionFactory.getInstance().getConnection();
	
	DealInfoDao dealInfoDao=new DealInfoDaoImpl();
	DealInfoEntityExtd dealInfo=new DealInfoEntityExtd();
	
	String dealId=request.getParameter("dealId");
	dealInfo.setDealId(dealId);
	ResultSet rs=dealInfoDao.getDtlById(conn, dealInfo);	
	String str[]=new String[10];
	while(rs.next()){
		str[0]=rs.getString("deal_id");
		str[1]=rs.getString("deal_thm");
		str[2]=rs.getString("cust_name");
		str[3]=rs.getString("ctc_name");
		str[4]=rs.getString("opp_id");
		str[5]=rs.getString("ofr_id");
		str[6]=rs.getString("prod_sort");
		str[7]=rs.getString("deal_date");
		str[8]=rs.getString("over_date");
		str[9]=rs.getString("sale_sum");
	}

%>



<div class="container-fluid">
	<div class="row-fluid">
		<div class="span3">
		</div>
		<div class="span6">
		<div class="btn-group table-bordered">
		    <a  href="<%= request.getContextPath() %>/xcrm/deal_mgt/qry_all_deal_info.jsp" class="btn"> <span class="add-on"><i class="icon-arrow-left"></i></span>&nbsp;返回列表</a>	
		    <a  href="<%= request.getContextPath() %>/xcrm/deal_mgt/add_deal_info.jsp" class="btn"> <span class="add-on"><i class="icon-plus"></i></span>&nbsp;新建</a>
		</div>
		<br/><br/>
		  <form class="form-horizontal"
			action="<%=request.getContextPath()%>/addDealInfoServlet"
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
							<p class="text-right">合同编号</p>
						</td>
						<td>
							<div class="input-append">
								<input name="dealId" value="<%= str[0] %>" type="text" readonly />
							</div>
						</td>
					</tr>
					<tr class="warning">
						<td>
							<p class="text-right">合同主题</p>
						</td>
						<td>
							<div class="input-append">
								<input name="dealThm" value="<%= str[1] %>" type="text"  />			
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
							<p class="text-right">报价单号</p>
						</td>
						<td>
							<div class="input-append">
								<input name="ofrId" value="<%= str[5] %>" type="text" readonly />
							</div>
						</td>
					</tr>
					
					<tr class="success">
						<td>
							<p class="text-right">产品分类</p>
						</td>
						<td>
							<div class="input-append">
								<input name="prodSort" value="<%= str[6] %>" type="text" readonly />
							</div>
						</td>
					</tr>
					
					<tr class="error">
						<td>
							<p class="text-right">订单状态</p>
						</td>
						<td>
							<select name="dealStatus" class="form-control"><option value="已创建">已创建</option><option value="已审批">已审批</option><option value="已发货">已发货</option><option value="已作废">已作废</option></select>
						</td>
					</tr>
					
					<tr class="info">
						<td>
							<p class="text-right">签约日期</p>
						</td>
						<td>
							 <div class="input-append date form_datetime" data-date="" 
              				  data-date-format="yyyy MM dd" data-link-format="yyyy-mm-dd" data-link-field="dtp_input1">
                  			  <input  value="<%= str[7] %>"  size="16" type="text" readonly>
                 			   <span class="add-on"><i class="icon-remove"></i></span>
								<span class="add-on"><i class="icon-calendar"></i></span>
              				  </div>
                			<input type="hidden" id="dtp_input1" name="dealDate" value="<%= str[7] %>" />
						</td>
					</tr>
					
					<tr class="warning">
						<td>
							<p class="text-right">交付日期</p>
						</td>
						<td>
							 <div class="input-append date form_datetime" data-date="" 
              				  data-date-format="yyyy MM dd" data-link-format="yyyy-mm-dd" data-link-field="dtp_input2">
                  			  <input  value="<%= str[8] %>"  size="16" type="text" readonly>
                 			   <span class="add-on"><i class="icon-remove"></i></span>
								<span class="add-on"><i class="icon-calendar"></i></span>
              				  </div>
                			<input type="hidden" id="dtp_input2" name="overDate" value="<%= str[8] %>" />
						</td>
					</tr>		
					
					<tr class="success">
						<td>
							<p class="text-right">合计</p>
						</td>
						<td>
							<div class="input-append">
								<input name="saleSum" value="<%= str[9] %>" type="text"  />
							</div>
						</td>
					</tr>
					
				</tbody>
			</table>
			        <div class="control-group">
						<div class="controls">
							 <button class="btn" type="submit" onclick="return check(this);">保存</button> &nbsp;&nbsp; <a href="<%= request.getContextPath() %>/xcrm/deal_mgt/qry_all_deal_info.jsp"><button class="btn" type="button">取消</button></a>
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
	if (document.forms.iForm.dealThm.value == "") {
		alert("请输入合同主题！");
		document.forms.iForm.dealThm.focus();
		return false;
	}
	if (document.forms.iForm.dealDate.value == "") {
		alert("请输入签约日期！");
		document.forms.iForm.dealDate.focus();
		return false;
	}
	if (document.forms.iForm.overDate.value == "") {
		alert("请输入交付日期！");
		document.forms.iForm.overDate.focus();
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