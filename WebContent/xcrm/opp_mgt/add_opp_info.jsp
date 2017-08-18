<%@page import="com.crm.service.CommitCtcInfoService"%>
<%@page import="com.crm.entity.extd.CtcInfoEntityExtd"%>
<%@page import="com.crm.dao.impl.CrmInfoDaoImpl"%>
<%@page import="com.crm.dao.CrmInfoDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.crm.dao.impl.OppInfoDaoImpl"%>
<%@page import="com.crm.dao.OppInfoDao"%>
<%@page import="com.crm.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.crm.dao.CustInfoDao"%>
<%@page import="com.crm.dao.impl.CustInfoDaoImpl"%>
<%@page import="com.crm.dao.impl.CtcInfoDaoImpl"%>
<%@page import="com.crm.dao.CtcInfoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建销售机会</title>
 
<%-- <link href="<%= request.getContextPath() %>/xcrm/opp_mgt/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">  --%> 
<link href="<%= request.getContextPath() %>/xcrm/date_css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">

</head>
<body>
<%@ include file="/xcrm/bootstrap/nav.jsp" %>

<%

	Connection conn=null;
	conn=ConnectionFactory.getInstance().getConnection();
	OppInfoDao oppInfoDao=new OppInfoDaoImpl();

	ResultSet rs=oppInfoDao.getNum(conn);
	int num=0;
	while(rs.next()){
		num=rs.getInt(1);
	}
	
	ResultSet rsx=oppInfoDao.getAllId(conn);
	String strx[]=new String[num];
	int numx=0;
	while(rsx.next()){
		strx[numx]=rsx.getString("opp_id");
		numx++;
	}
	
	
	
	CustInfoDao custInfoDao=new CustInfoDaoImpl();
	ResultSet rsz=custInfoDao.getNum(conn);
	int count=0;
	while(rsz.next()){
		count=rsz.getInt(1);
	}
	
	ResultSet rsy = custInfoDao.getAllName(conn);
	String stry[] = new String[count];
	int numy=0;
	while (rsy.next()) {
		stry[numy] = rsy.getString("cust_name");
		System.out.print(stry[numy]);
		numy++;
	}
	
	
	
	CrmInfoDao crmInfoDao=new CrmInfoDaoImpl();
	ResultSet rsa=crmInfoDao.getNum(conn);
	int numa=0;
	while(rsa.next()){
		numa=rsa.getInt(1);
	}
	
	ResultSet rsb=crmInfoDao.getAll(conn);
	
	
	CtcInfoDao ctcInfoDao=new CtcInfoDaoImpl();
	ResultSet rsc=ctcInfoDao.getAll(conn);
	ResultSet rsd=ctcInfoDao.getAll(conn);
	
	int numberc=1;
	int numberd=1;
%>
	
	






<div class="container-fluid">
	<div class="row-fluid">
		<div class="span3">
		</div>
		<div class="span6">
		<div class="btn-group table-bordered">
		    <a  href="<%= request.getContextPath() %>/xcrm/opp_mgt/qry_all_opp_info.jsp" class="btn"> <span class="add-on"><i class="icon-arrow-left"></i></span>&nbsp;返回列表</a>	
		</div>
		<br/><br/>
		  <form class="form-horizontal"
			action="<%=request.getContextPath()%>/addOppInfoServlet" method="post" name="iForm">
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
							
							
							<%
							String oppId="";
							boolean flagx=false;
							for(int i=1;i<1000;i++){
								
								if(i<10){
									oppId="OPP00"+i;
								}
								if(i>=10 && i<100){
									oppId="OPP0"+i;
								}
								if(i>=100 && i<1000){
									oppId="OPP"+i;
								}
								
								if(strx.length==0){
									break;
								}else{
									for(int j=0;j<strx.length;j++){
										if(oppId.equals(strx[j])){
											break;
										}
										
										while(j==strx.length-1){
											if(oppId!=strx[j]){
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
							
							
								<input name="oppId" value="<%= oppId %>" type="text" readonly />
							</div>
						</td>
					</tr>
					<tr class="warning">
						<td>
							<p class="text-right">销售机会</p>
						</td>
						<td>
							<div class="input-append">
								<input name="oppName" type="text" />			
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
								<% while(rsc.next()){ %>
								<option value="<%= rsc.getString("cust_name")%>"><%out.print("["+numberc+"] "+rsc.getString("cust_name")); %></option> 
								
								<% numberc++; } %>
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
								<% while(rsd.next()){ %>
								<option value="<%= rsd.getString("ctc_name")%>"><%out.print("["+numberd+"] "+rsd.getString("ctc_name")); %></option> 
								<% numberd++; } %>
								</select>
							</div>			
						</td>
				</tr>
				
				<tr class="info">
						<td>
							<p class="text-right">产品分类</p>
						</td>
						<td>
							<select name="prodSort" class="form-control"><option value="数码">数码</option><option value="服装">服装</option><option value="饮食">饮食</option><option value="手机">手机</option><option value="电脑">电脑</option><option value="家具">家具</option><option value="钟表">钟表</option><option value="汽车">汽车</option><option value="图书">图书</option><option value="玩具">玩具</option></select>					
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
							<select name="oppSrc" class="form-control"> <option value="电话来访">电话来访</option> <option value="公司分配">公司分配</option> <option value="客户介绍">客户介绍</option> <option value="朋友介绍">朋友介绍</option> <option value="独立开发">独立开发</option><option value="广告宣传">广告宣传</option><option value="市场活动">市场活动</option><option value="合作伙伴">合作伙伴</option><option value="公开招标">公开招标</option><option value="老客户">老客户</option><option value="代理商">代理商</option><option value="其他">其他</option></select>
						</td>
					</tr>
					<tr class="error">
						<td>
							<p class="text-right">预计成交金额</p>
						</td>
						<td>
							<div class="input-append">
								<input name="preSaleSum" type="text" />
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
                    <input  value=""  size="16" type="text" readonly>
                    <span class="add-on"><i class="icon-remove"></i></span>
					<span class="add-on"><i class="icon-calendar"></i></span>
                </div>
                <input type="hidden" id="dtp_input1" name="preDealDate" value="" />

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
					<tr class="success">
						<td>
							<p class="text-right">销售负责人</p>
						</td>
						<td>
							<div class="input-append">
								<select name="crmName" class="form-control"> 
								<% while(rsb.next()){ %>
								<option value="<%= rsb.getString("crm_name")%>"><%out.print(rsb.getString("crm_title")+"："+rsb.getString("crm_name")); %></option> 
								<% } %>
								</select>
							</div>
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
					<tr class="error">
						<td>
							<p class="text-right">备注</p>
						</td>
						<td>
							<div class="input-append">
							<textarea name="oppRmk" rows="2"></textarea>
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
	
	
	<script type="text/javascript">
	
	
	function check(form) {
		if (document.forms.iForm.oppName.value == "") {
			alert("请输入销售机会！");
			document.forms.iForm.oppName.focus();
			return false;
		}
		if (document.forms.iForm.preSaleSum.value == "") {
			alert("请输入预计成交金额！");
			document.forms.iForm.preSaleSum.focus();
			return false;
		}
		if (document.forms.iForm.preDealDate.value == "") {
			alert("请输入预计成交日期！");
			document.forms.iForm.preDealDate.focus();
			return false;
		}
	}
	
	
	</script>
	
</body>
</html>