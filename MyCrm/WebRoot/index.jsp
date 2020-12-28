<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!-->
<html lang="cn">
<!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

<meta charset="utf-8" />

<title>index.jsp</title>

<meta content="width=device-width, initial-scale=1.0" name="viewport" />

<meta content="" name="description" />

<meta content="" name="author" />

<jsp:include page="media/ui_css.jsp"></jsp:include>

<link rel="shortcut icon" href="media/image/favicon.ico" />
<script type="text/javascript">
	function showtime() {
		var today, hour, second, minute, year, month, date;
		var strDate;
		today = new Date();
		var n_day = today.getDay();
		switch (n_day) {
		case 0:
			strDate = "星期日";
			break;
		case 1:
			strDate = "星期一";
			break;
		case 2:
			strDate = "星期二";
			break;
		case 3:
			strDate = "星期三";
			break;
		case 4:
			strDate = "星期四";
			break;
		case 5:
			strDate = "星期五";
			break;
		case 6:
			strDate = "星期六";
			break;
		case 7:
			strDate = "星期日";
			break;
		}
		year = today.getFullYear();
		month = today.getMonth() + 1;
		date = today.getDate();
		hour = today.getHours();
		minute = today.getMinutes();
		second = today.getSeconds();
		if (month < 10)
			month = "0" + month;
		if (date < 10)
			date = "0" + date;
		if (hour < 10)
			hour = "0" + hour;
		if (minute < 10)
			minute = "0" + minute;
		if (second < 10)
			second = "0" + second;
		document.getElementById('time').innerHTML = year + " 年 " + month
				+ " 月 " + date + " 日 " + strDate + " " + hour + ":" + minute
				+ ":" + second; //显示时间 
		setTimeout("showtime();", 1000); //设定函数自动执行时间为 1000 ms(1 s) 
	}
</script>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">
	<jsp:include page="main_pages/top.jsp"></jsp:include>
	<!-- BEGIN 容器 -->
	<div class="page-container row-fluid">
		<jsp:include page="main_pages/left.jsp"></jsp:include>
		<!-- BEGIN 开始页面 -->
		<div class="page-content">
			<!-- ---------------------------------------------- -->
			<!-- BEGIN 页面容器-->
			<div class="container-fluid">
				<!-- BEGIN 页面标题-->
				<div class="row-fluid">
					<div class="span12">
						<!-- BEGIN 风格定制 -->
						<jsp:include page="/main_pages/styleset.jsp"></jsp:include>
						<!-- END 风格定制 --> 
						<!-- BEGIN 网页的标题和面包屑-->
						<h3 class="page-title">
							我的桌面 <small>我的办公信息导航页</small>
						</h3>
						<ul class="breadcrumb">
							<li>
								<i class="icon-home"></i>
								<a href="#">我的桌面</a> 
								<i class="icon-angle-right"></i>
							</li>
						</ul>
						<!-- END 网页的标题和面包屑-->
					</div>
				</div>
				<!-- END 页面标题-->
				<!-- BEGIN 网页内容-->
				<div class="tiles">
					<div class="tile double-down bg-blue">
						<div class="tile-body"><i class="icon-bell"></i></div>
						<div class="tile-object">
							<div class="name">我的便签</div>
							<div class="number">6</div>
						</div>
					</div>
					<div class="tile bg-green">
						<div class="tile-body"><i class="icon-calendar"></i></div>
						<div class="tile-object">
							<div class="name">我的日程</div>
							<div class="number">12</div>
						</div>
					</div>
					<div class="tile double bg-blue">
						<div class="corner"></div>
						<div class="check"></div>
						<div class="tile-body">
							<h4>support@metronic.com</h4>
							<p>Re:  Project Update!</p>
							<p>24 may 2017 12.30PM  the project plan update meeting...</p>
						</div>
						<div class="tile-object">
							<div class="name"> <i class="icon-envelope"></i> </div>
							<div class="number"> 14 </div> 
						</div>
					</div>
					<div class="tile bg-red" url="pages_crm/crm_cont">
						<div class="corner"></div>
						<div class="tile-body">
							<i class="icon-user"></i>
						</div>
						<div class="tile-object">
							<div class="name">我的联系人</div>
							<div class="number">${contNum}</div>
						</div>
					</div>
					<div class="tile double bg-purple" url="pages_crm/ma_contr">
						<div class="corner"></div>
						<div class="tile-body">
							<i class="icon-folder-close"></i>
						</div>
						<div class="tile-object">
							<div class="name">我的合同</div>
							<div class="number">43</div>
						</div>
					</div>
					<div class="tile bg-yellow" url="pages_crm/crm_cust">
						<div class="tile-body"><i class="icon-user-md"></i></div>
						<div class="tile-object">
							<div class="name">我的客户</div>
							<div class="number">121</div>
						</div>
					</div>
					<div class="tile image" url="pages_crm/crm_follow!findAll">
						<div class="tile-body">
							<img src="media/image/image2.jpg" alt="">
						</div>
						<div class="tile-object">
							<div class="name">我的跟进</div>
							<div class="number">12</div>
						</div>
					</div>
					<div class="tile bg-green">
						<div class="tile-body">
							<i class="icon-comments-alt"></i>
						</div>
						<div class="tile-object">
							<div class="name">我签名的发票</div>
							<div class="number">12
							</div>
						</div>
					</div>
					<div class="tile double bg-grey">
						<div class="tile-body">
							<img src="media/image/photo2.jpg" alt="" class="pull-right" style="height:114px;width: 258px;">
						</div>
						<div class="tile-object">
							<div class="name">
								<i class="icon-twitter"></i>
							</div>
							<div class="number"><span id="time"></span></div>
						</div>
					</div>
					<div class="tile bg-blue" url="pages_crm/ma_order?v=0">
						<div class="tile-body">
							<i class="icon-edit"></i>
						</div>
						<div class="tile-object">
							<div class="name">我的订单</div>
							<div class="number">12</div>
						</div>
					</div>
					<div class="tile bg-green" url="pages_crm/crm_receive!findAll">
						<div class="tile-body">
							<i class="icon-bar-chart"></i>
						</div>
						<div class="tile-object">
							<div class="name">我的收款</div>
							<div class="number">3</div>
						</div>
					</div>
					<div class="tile bg-purple" url="pages_public/public_new.jsp">
						<div class="tile-body">
							<i class="icon-briefcase"></i>
						</div>
						<div class="tile-object">
							<div class="name">公司新闻</div>
							<div class="number">11</div>
						</div>
					</div>
					<div class="tile image double">
						<div class="tile-body">
							<img src="media/image/image4.jpg" alt="">
						</div>
						<div class="tile-object">
							<div class="name">公司聊天室</div>
							<div class="number">222</div>
						</div>
					</div>
					<div class="tile bg-purple">
						<div class="tile-body"><i class="icon-plane"></i></div>
						<div class="tile-object">
							<div class="name">公司公告</div>
							<div class="number">34</div>
						</div>
					</div>
					<div class="tile bg-yellow">
						<div class="corner"></div>
						<div class="check"></div>
						<div class="tile-body">
							<i class="icon-cogs"></i>
						</div>
						<div class="tile-object">
							<div class="name">我的设置</div>
						</div>
					</div>
					<div class="tile bg-red">
						<div class="corner"></div>
						<div class="check"></div>
						<div class="tile-body">
							<i class="icon-lock"></i>
						</div>
						<div class="tile-object">
							<div class="name">锁屏</div>
						</div>
					</div>
				</div>
				<br>
				<!-- END 网页内容-->
			</div>
			<!-- END 页面容器-->
			<!-- --------------------------------------------------------- -->
		</div>
		<!-- END 页面 -->
	</div>
	<!-- END 容器 -->
	<jsp:include page="main_pages/foot.jsp"></jsp:include>
	<jsp:include page="media/ui_js.jsp"></jsp:include>
	<script src="media/js/app.js"></script>
	<script>
		jQuery(document).ready(function() {
			App.init();
			showtime();
			$('.tile').click(function(){
				var url=$(this).attr('url');
				location.href=url;
			});
		});
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>