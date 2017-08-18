<%@page import="com.crm.dao.CustInfoDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.crm.dao.impl.CustInfoDaoImpl"%>
<%@page import="com.crm.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建客户信息</title>

<link href="<%= request.getContextPath() %>/xcrm/css/main.css" rel="stylesheet">
<script src="<%= request.getContextPath() %>/xcrm/js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="<%= request.getContextPath() %>/xcrm/js/distpicker.data.js"></script>
<script src="<%= request.getContextPath() %>/xcrm/js/distpicker.js"></script>

</head>

<body>
<%@ include file="/xcrm/bootstrap/nav.jsp" %>

	<%
		Connection conn=null;
		conn=ConnectionFactory.getInstance().getConnection();
		CustInfoDao custInfoDao=new CustInfoDaoImpl();
		
		ResultSet rs=custInfoDao.getNum(conn);
		int num=0;
		while(rs.next()){
			num=rs.getInt(1);
		}
		
		
		ResultSet rsx=custInfoDao.getAllId(conn);
		String strx[]=new String[num];
		int numx=0;
		while(rsx.next()){
				strx[numx]=rsx.getString("cust_id");
				numx++;
			}
		
		
		ResultSet rsy = custInfoDao.getAllName(conn);
		String stry[] = new String[num];
		int numy=0;
		while (rsy.next()) {
			stry[numy] = rsy.getString("cust_name");
			numy++;
		}
		
	%>
	

<div class="container-fluid">
	<div class="row-fluid">
		
		<div class="span3">
		</div>
		<div class="span6">
		<form class="form-horizontal"
			action="<%=request.getContextPath()%>/addCustInfoServlet" method="post" name="iForm">
			<div class="btn-group table-bordered">
		    <a  href="<%= request.getContextPath() %>/xcrm/cust_mgt/qry_all_cust_info.jsp" class="btn"> <span class="add-on"><i class="icon-arrow-left"></i></span>&nbsp;返回列表</a>
		</div>
		<br/><br/>
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
							<p class="text-right">客户编号</p>
						</td>
						<td>
							<div class="input-append">
							<%
							String custId="";
							boolean flagx=false;
							for(int i=1;i<1000;i++){
								
								if(i<10){
									custId="CUST00"+i;
								}
								if(i>=10 && i<100){
									custId="CUST0"+i;
								}
								if(i>=100 && i<1000){
									custId="CUST"+i;
								}
								
								if(strx.length==0){
									break;
								}else{
									for(int j=0;j<strx.length;j++){
										if(custId.equals(strx[j])){
											break;
										}
										
										while(j==strx.length-1){
											if(custId!=strx[j]){
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
								<input class="form-control" name="custId" value="<%= custId %>" type="text" placeholder="<%= custId %>" readonly>
							</div>
						</td>
					</tr>
					<tr class="warning">
						<td>
							<p class="text-right">客户名称</p>
						</td>
						<td>
							<div class="input-append">
								<input name="custName" id="custName" type="text" /><button class="btn" type="button" onclick="checkCustName(this)">查重</button>
							</div>
						</td>
					</tr>
					<tr class="success">
						<td>
							<p class="text-right">客户状态</p>
						</td>
						<td>
							<select name="custStatus" class="form-control"> <option value="潜在客户">潜在客户</option> <option value="意向客户">意向客户</option> <option value="成交客户">成交客户</option><option value="流失客户">流失客户</option></select>
						</td>
					</tr>
					<tr class="error">
						<td>
							<p class="text-right">客户类型</p>
						</td>
						<td>
							<select name="custType" class="form-control"> <option value="小型客户">小型客户</option><option value="中型客户">中型客户</option> <option value="大型客户">大型客户</option></select>
						</td>
					</tr>
					<tr class="info">
						<td>
							<p class="text-right">客户级别</p>
						</td>
						<td>
							<select name="custLvl" class="form-control"> <option value="S 级客户">S 级客户</option> <option value="A 级客户">A 级客户</option> <option value="B 级客户">B 级客户</option> <option value="C 级客户">C 级客户</option> <option value="D 级客户">D 级客户</option></select>
						</td>
					</tr>
					<tr class="warning">
						<td>
							<p class="text-right">所属行业</p>
						</td>
						<td>
							<select name="custInd" class="form-control"> <option value="电子">电子</option> <option value="通讯">通讯</option> <option value="咨询">咨询</option> <option value="教育">教育</option> <option value="医药">医药</option> <option value="金融">金融</option> <option value="政府">政府</option> <option value="酒店">酒店</option> <option value="保险">保险</option> <option value="运输">运输</option> <option value="机械">机械</option> <option value="零售">零售</option> <option value="物流">物流</option> <option value="技术">技术</option> <option value="餐饮">餐饮</option> <option value="服装">服装</option> <option value="银行">银行</option> <option value="能源">能源</option> <option value="工程">工程</option> <option value="娱乐">娱乐</option> <option value="环境">环境</option> <option value="卫生保健">卫生保健</option> <option value="食品饮料">食品饮料</option> <option value="休闲娱乐">休闲娱乐</option> <option value="公共事业">公共事业</option> <option value="生物技术">生物技术</option> <option value="园林艺术">园林艺术</option> <option value="其他行业">其他行业</option> </select>
						</td>
					</tr>
				</tbody>
				<thead>
					<tr>
						<th>
							地址信息
						</th>
					</tr>
				</thead>
				
				<tbody   data-toggle="distpicker">
							<tr class="success">
									<td><label  class="sr-only" for="province7"><p class="text-right">省份</p></label> </td>
									<td><select name="custProv" class="form-control" id="province7"></select></td>
								</tr>
								<tr class="error">
								<td><label class="sr-only" for="city7"><p class="text-right">城市</p></label></td> 
								<td><select name="custCity" class="form-control" id="city7"></select></td>
								</tr>
					<tr class="info">
						<td>
							<p class="text-right">详细地址</p>
						</td>
						<td>
							<div class="input-append">
								<input name="custAddr" type="text" />
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
					<tr class="warning">
						<td>
							<p class="text-right">备注</p>
						</td>
						<td>
							<div class="input-append">
							<textarea name="custRmk" rows="2"></textarea>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
			
				
					<div class="control-group">
						<div class="controls">
							 <button class="btn" type="submit" onclick="return check(this);">保存</button> &nbsp;&nbsp;&nbsp;<a href="<%= request.getContextPath() %>/xcrm/cust_mgt/qry_all_cust_info.jsp"><button class="btn" type="button">取消</button></a>
						</div>
					</div>
					
			</form>
			</div>
			
			
			
			<div class="span3">
			</div>
			
			
			
		</div>
	</div>


	<script type="text/javascript">
		function checkCustName(form) {

			var custName = document.forms.iForm.custName.value;
			
			if (custName == "") {
				alert("您尚未输入客户名称，无法查重！");
				document.forms.iForm.custName.focus();
			}else {
				
			var list = new Array();
			
			<% for (int k = 0; k < stry.length; k++) { %>
			
				list[<%=k%>] ='<%=stry[k]%>';
			
			<% } %>
			
			if(list.length==0){
				alert("数据库中无此客户，请点击确定继续添加！");
			}else{
				
			
			for(var i=0;i<list.length;i++){
				if(custName==list[i]){
					alert("该客户已存在，请重新输入！");
					break;
				}
				while(i==list.length-1){
					if(custName!=list[i]){
						alert("数据库中无此客户，请点击确定继续添加！");
						break;
					}
				}
				
			}	
			}
				
				
			}

		}

		function check(form) {
			if (document.forms.iForm.custName.value == "") {
				alert("请输入客户名称！");
				document.forms.iForm.custName.focus();
				return false;
			}
		}
	</script>



</body>
</html>