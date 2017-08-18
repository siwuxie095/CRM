<%@page import="java.sql.ResultSet"%>
<%@page import="com.crm.entity.extd.OppInfoEntityExtd"%>
<%@page import="com.crm.dao.impl.OppInfoDaoImpl"%>
<%@page import="com.crm.dao.OppInfoDao"%>
<%@page import="com.crm.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑销售机会</title>
 
<%-- <link href="<%= request.getContextPath() %>/xcrm/opp_mgt/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">  --%> 
<link href="<%= request.getContextPath() %>/xcrm/date_css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">

</head>
<body>
<%@ include file="/xcrm/bootstrap/nav.jsp" %>


<%
	Connection conn=null;
	conn=ConnectionFactory.getInstance().getConnection();
	OppInfoDao oppInfoDao=new OppInfoDaoImpl();
	OppInfoEntityExtd oppInfo=new OppInfoEntityExtd();
	String oppId=request.getParameter("oppId");
	oppInfo.setOppId(oppId);
	ResultSet rs=oppInfoDao.getDtlById(conn, oppInfo);
	String str[]=new String[9];
	while(rs.next()){
		str[0]=rs.getString("opp_id");
		str[1]=rs.getString("opp_name");
		str[2]=rs.getString("cust_name");
		str[3]=rs.getString("ctc_name");
		str[4]=rs.getString("prod_sort");
		str[5]=rs.getString("opp_src");
		str[6]=rs.getString("pre_sale_sum");
		str[7]=rs.getString("pre_deal_date");
		str[8]=rs.getString("opp_rmk");
	}
			

%>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span3">
		</div>
		<div class="span6">
		<div class="btn-group table-bordered">
		    <a  href="<%= request.getContextPath() %>/xcrm/opp_mgt/qry_all_opp_info.jsp" class="btn"> <span class="add-on"><i class="icon-arrow-left"></i></span>&nbsp;返回列表</a>
			<a  href="<%= request.getContextPath() %>/xcrm/opp_mgt/add_opp_info.jsp" class="btn"> <span class="add-on"><i class="icon-plus"></i></span>&nbsp;新建</a>
		</div>
		<br/><br/>
		  <form class="form-horizontal"
			action="<%=request.getContextPath()%>/modifyOppInfoServlet"
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
							<p class="text-right">编号</p>
						</td>
						<td>
							<div class="input-append">
								<input name="oppId" value="<%= str[0] %>" type="text" readonly />
							</div>
						</td>
					</tr>
					<tr class="warning">
						<td>
							<p class="text-right">销售机会</p>
						</td>
						<td>
							<div class="input-append">
								<input name="oppName" value="<%= str[1] %>" type="text" />			
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
							<p class="text-right">产品分类</p>
						</td>
						<td>
							<div class="input-append">
								<input name="prodSort" value="<%= str[4] %>" type="text" readonly />
							</div>
						</td>
					</tr>
					<tr class="warning">
						<td>
							<p class="text-right">销售阶段</p>
						</td>
						<td>
							<select name="saleStg" class="form-control"> <option value="初期沟通">初期沟通</option> <option value="需求分析">需求分析</option> <option value="方案讨论">方案讨论</option> <option value="成交客户">成交客户</option> <option value="失败客户">失败客户</option></select>
						</td>
					</tr>
					<tr class="success">
						<td>
							<p class="text-right">机会来源</p>
						</td>
						<td>
							<div class="input-append">
								<input name="oppSrc" value="<%= str[5] %>" type="text" readonly />
							</div>
						</td>
					</tr>
					<tr class="error">
						<td>
							<p class="text-right">预计成交金额</p>
						</td>
						<td>
							<div class="input-append">
								<input name="preSaleSum" value="<%= str[6] %>" type="text" />
							</div>
						</td>
					</tr>
					<tr class="info">
						<td>
							<p class="text-right">预计成交日期</p>
						</td>
						<td>
							 <div class="input-append date form_datetime" data-date="" 
              				  data-date-format="yyyy MM dd" data-link-format="yyyy-mm-dd" data-link-field="dtp_input1">
                  			  <input  value="<%= str[7] %>"  size="16" type="text" readonly>
                 			   <span class="add-on"><i class="icon-remove"></i></span>
								<span class="add-on"><i class="icon-calendar"></i></span>
              				  </div>
                			<input type="hidden" id="dtp_input1" name="preDealDate" value="<%= str[7] %>" />
						</td>
					</tr>
					<tr class="warning">
						<td>
							<p class="text-right">可能性</p>
						</td>
						<td>
							<select name="succPer" class="form-control"><option value="10%">10%</option><option value="20%">20%</option><option value="30%">30%</option><option value="40%">40%</option><option value="50%">50%</option><option value="60%">60%</option><option value="70%">70%</option><option value="80%">80%</option><option value="90%">90%</option><option value="100%">100%</option></select>
						</td>
					</tr>
				</tbody>
				
				<thead>
					<tr>
						<th>
							备注信息
						</th>
					</tr>
				</thead>
				<tbody>
					<tr class="success">
						<td>
							<p class="text-right">备注</p>
						</td>
						<td>
							<div class="input-append">
							<textarea name="oppRmk" rows="2" ><%= str[8] %></textarea>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
			
			 <div class="control-group">
						<div class="controls">
							 <button class="btn" type="submit" onclick="return check(this);">保存</button> &nbsp;&nbsp; <a href="<%= request.getContextPath() %>/xcrm/opp_mgt/qry_all_opp_info.jsp"><button class="btn" type="button">取消</button></a>
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
	
	
	
	
	
</body>
</html>