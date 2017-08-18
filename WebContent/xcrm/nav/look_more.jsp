<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alpha CRM 首页</title>
</head>
<body>
<%@ include file="/xcrm/bootstrap/nav.jsp" %>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="hero-unit">
				<h1>
					Welcome to Alpha CRM ！
				</h1>
				<br/>
				<p>
					Alpha CRM 系统作为最懂业务的销售管理平台，为企业用户提供最先进、最全面的销售管理解决方案。互联网与移动互联网平台的多网络模式服务，针对企业业务的特点，在售前、售中、售后三个阶段提供国内最优质的在线客户管理系统服务！<br /><br />Alpha CRM 系统深耕国内中小企业业务特点，致力于为中小企业提供客户关系管理(CRM)和销售管理解决方案， 帮助中小企业提高管理效率、节约运营成本，促进企业成长，为中小企业打造一站式的管理软件服务！
				</p>
				<p>
					<a class="btn btn-inverse btn-large" href="<%= request.getContextPath() %>/xcrm/nav/index.jsp">收起 «</a>
				</p>
			</div>
			
			
						<ul class="thumbnails">
				<li class="span3">
					<div class="thumbnail">
						<img alt="300x200" src="<%= request.getContextPath() %>/xcrm/img/1.png" />
						<div class="caption">
							<h3>
								易学易用，功能强大
							</h3>
							<p>
								它是一个完整的客户关系管理系统，包括市场、销售、服务3大环节，操作简单，功能强大。从客户生命周期的各个阶段获取价值
							</p>
						</div>
					</div>
				</li>
				<li class="span3">
					<div class="thumbnail">
						<img alt="300x200" src="<%= request.getContextPath() %>/xcrm/img/2.png" />
						<div class="caption">
							<h3>
								集成多种营销工具
							</h3>
							<p>
								收集各种途径汇集的潜在客户，手机、电话、邮件...从CRM中跟进，不丢不漏，适应信息化时代新型营销模式
							</p>
						</div>
					</div>
				</li>
				<li class="span3">
					<div class="thumbnail">
						<img alt="300x200" src="<%= request.getContextPath() %>/xcrm/img/3.png" />
						<div class="caption">
							<h3>
								完善销售管理和流程
							</h3>
							<p>
								通过销售机会、报价单、合同订单，实现一站到底的管理模式，并通过日志有条不紊的跟进
							</p>
						</div>
					</div>
				</li>
				<li class="span3">
					<div class="thumbnail">
						<img alt="300x200" src="<%= request.getContextPath() %>/xcrm/img/4.png" />
						<div class="caption">
							<h3>
								优质服务，保证成功应用
							</h3>
							<p>
								从客户流程规划、应用培训到后期回访，我们的客户成功团队为您提供规范化的服务，有效保证您的CRM投资是一次成功的体验
							</p>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</div>
</div>


</body>
</html>