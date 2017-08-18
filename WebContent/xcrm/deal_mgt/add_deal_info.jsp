<%@page import="com.crm.entity.extd.OfrInfoEntityExtd"%>
<%@page import="com.crm.dao.impl.OfrInfoDaoImpl"%>
<%@page import="com.crm.dao.OfrInfoDao"%>
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
	
	ResultSet rs=dealInfoDao.getNum(conn);
	int num=0;
	while(rs.next()){
		num=rs.getInt(1);
	}
	
	ResultSet rsx=dealInfoDao.getAllId(conn);
	String strx[]=new String[num];
	int numx=0;
	while(rsx.next()){
		strx[numx]=rsx.getString("deal_id");
		numx++;
	}
	
	OfrInfoDao ofrInfoDao=new OfrInfoDaoImpl();
	OfrInfoEntityExtd ofrInfo=new OfrInfoEntityExtd();
	String crmName=session.getAttribute("crmName").toString();
	ofrInfo.setCrmName(crmName);
	ResultSet rsa=ofrInfoDao.getY(conn, ofrInfo);
	ResultSet rsb=ofrInfoDao.getY(conn, ofrInfo);
	ResultSet rsc=ofrInfoDao.getY(conn, ofrInfo);
	ResultSet rsd=ofrInfoDao.getY(conn, ofrInfo);
	
	int numbera=1;
	int numberb=1;
	int numberc=1;
	int numberd=1;
%>



<div class="container-fluid">
	<div class="row-fluid">
		<div class="span3">
		</div>
		<div class="span6">
		<div class="btn-group table-bordered">
		    <a  href="<%= request.getContextPath() %>/xcrm/deal_mgt/qry_all_deal_info.jsp" class="btn"> <span class="add-on"><i class="icon-arrow-left"></i></span>&nbsp;返回列表</a>	
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
							
							
							
							<%
							String dealId="";
							boolean flagx=false;
							for(int i=1;i<1000;i++){
								
								if(i<10){
									dealId="DEAL00"+i;
								}
								if(i>=10 && i<100){
									dealId="DEAL0"+i;
								}
								if(i>=100 && i<1000){
									dealId="DEAL"+i;
								}
								
								if(strx.length==0){
									break;
								}else{
									for(int j=0;j<strx.length;j++){
										if(dealId.equals(strx[j])){
											break;
										}
										
										while(j==strx.length-1){
											if(dealId!=strx[j]){
												flagx=true;
												break;
											}
										}
										
									}
									
									
									if(flagx){
										break;
									}
								}
								
							}
							
							%>
							
							
							
								<input name="dealId" value="<%= dealId %>" type="text" readonly />
							</div>
						</td>
					</tr>
					<tr class="warning">
						<td>
							<p class="text-right">合同主题</p>
						</td>
						<td>
							<div class="input-append">
								<input name="dealThm" type="text"  />			
							</div> 
						</td>
					</tr>
					<tr class="success">
						<td>
							<p class="text-right">客户名称</p>
						</td>
						 <td>
							<div class="input-append">
								<select name="custName" class="form-control"> 
								<% while(rsa.next()){ %>
								<option value="<%= rsa.getString("cust_name")%>"><%out.print("["+numbera+"] "+rsa.getString("cust_name")); %></option> 
								<% numbera++; } %>
								</select>
							</div>				
						</td>
					</tr>
					
					<tr class="error">
						<td>
							<p class="text-right">联系人</p>
						</td>
							<td>
							<div class="input-append">
								<select name="ctcName" class="form-control"> 
								<% while(rsb.next()){ %>
								<option value="<%= rsb.getString("ctc_name")%>"><%out.print("["+numberb+"] "+rsb.getString("ctc_name")); %></option> 
								<% numberb++; } %>
								</select>
							</div>			
						</td>			
					</tr>
					
					<tr class="info">
						<td>
							<p class="text-right">销售机会</p>
						</td>
						<td>
							<div class="input-append">
								<select name="oppId" class="form-control"> 
								<% while(rsc.next()){ %>
								<option value="<%= rsc.getString("opp_id")%>"><%out.print("["+numberc+"] "+rsc.getString("opp_id")); %></option> 
								<% numberc++; } %>
								</select>
							</div>			
						</td>
					</tr>	
					
					<tr class="warning">
						<td>
							<p class="text-right">报价单号</p>
						</td>
						<td>
							<div class="input-append">
								<select name="ofrId" class="form-control"> 
								<% while(rsd.next()){ %>
								<option value="<%= rsd.getString("ofr_id")%>"><%out.print("["+numberd+"] "+rsd.getString("ofr_id")); %></option> 
								<% numberd++; } %>
								</select>
							</div>			
						</td>
					</tr>
					
					<tr class="success">
						<td>
							<p class="text-right">产品分类</p>
						</td>
						<td>
							<select name="prodSort" class="form-control"><option value="数码">数码</option><option value="服装">服装</option><option value="饮食">饮食</option><option value="手机">手机</option><option value="电脑">电脑</option><option value="家具">家具</option><option value="钟表">钟表</option><option value="汽车">汽车</option><option value="图书">图书</option><option value="玩具">玩具</option></select>
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
                  			  <input  value=""  size="16" type="text" readonly>
                 			   <span class="add-on"><i class="icon-remove"></i></span>
								<span class="add-on"><i class="icon-calendar"></i></span>
              				  </div>
                			<input type="hidden" id="dtp_input1" name="dealDate" value="" />
						</td>
					</tr>
					
					<tr class="warning">
						<td>
							<p class="text-right">交付日期</p>
						</td>
						<td>
							 <div class="input-append date form_datetime" data-date="" 
              				  data-date-format="yyyy MM dd" data-link-format="yyyy-mm-dd" data-link-field="dtp_input2">
                  			  <input  value=""  size="16" type="text" readonly>
                 			   <span class="add-on"><i class="icon-remove"></i></span>
								<span class="add-on"><i class="icon-calendar"></i></span>
              				  </div>
                			<input type="hidden" id="dtp_input2" name="overDate" value="" />
						</td>
					</tr>	
					
					<tr class="success">
						<td>
							<p class="text-right">合计</p>
						</td>
						<td>
							<div class="input-append">
								<input name="saleSum" type="text"  />
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