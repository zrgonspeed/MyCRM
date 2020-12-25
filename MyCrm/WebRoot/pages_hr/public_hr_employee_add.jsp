<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="cn">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8" />
<title>public_hr_employee_edit.jsp</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<jsp:include page="/media/ui_css.jsp"></jsp:include>
<!-- BEGIN PAGE LEVEL STYLES -->
<link rel="stylesheet" type="text/css" href="<%=basePath%>media/css/select2_metro.css" />
<link rel="stylesheet" href="<%=basePath%>media/css/DT_bootstrap.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>media/css/datepicker.css" />
<link href="<%=basePath%>media/css/search.css" rel="stylesheet" type="text/css" />
<!-- END PAGE LEVEL STYLES -->
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">
	<jsp:include page="/main_pages/top.jsp"></jsp:include>
	<!-- BEGIN 容器 -->
	<div class="page-container row-fluid">
		<jsp:include page="/main_pages/left.jsp"></jsp:include>
		<!-- BEGIN 开始页面 -->
		<div class="page-content">
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
							职务<small>添加职务</small>
						</h3>
						<ul class="breadcrumb">
							<li><i class="icon-home"></i> <a href="index.html">CRM职务管理</a>
								<i class="icon-angle-right"></i> <a href="index.html">职务管理</a> <i
								class="icon-angle-right"></i> <a href="index.html">职务列表</a> <i
								class="icon-angle-right"></i> 添加职务</li>
						</ul>
						<!-- END 网页的标题和面包屑-->
					</div>
				</div>
				<!-- END 页面标题-->
				<!-- BEGIN PAGE CONTENT-->
				<div class="row-fluid">
					<div class="span12">
						<!-- BEGIN SAMPLE FORM PORTLET-->
						<div class="portlet box blue">
							<div class="portlet-title">
								<div class="caption">
									<i class="icon-reorder"></i>添加职务
								</div>
							</div>
							<div class="portlet-body form">
								<!-- BEGIN FORM-->
								<form action="hr_emp!add" method="post" class="form-horizontal">
									<h3 class="form-section">职务信息</h3>
									<input type="hidden" value="<s:property value="#emp.id"/>" name="emp.id"/>
									<div class="row-fluid">
										<div class="span6 ">
											<div class="control-group">
												<label class="control-label">账号：</label>
												<div class="controls">
													<input name="emp.uid" type="text" value=''
													class="m-wrap span12" placeholder="必填">
												</div>
											</div>
										</div>
										<!--/span-->
										<div class="span6 ">
											<div class="control-group">
												<label class="control-label">密码：</label>
												<div class="controls">
													<input name="emp.pwd" readonly="readonly" type="text" value='123456'
													class="m-wrap span12" placeholder="必填">
												</div>
											</div>
										</div>
										<!--/span-->
									</div>
									<div class="row-fluid">
										<div class="span6 ">
											<div class="control-group">
												<label class="control-label">姓名：</label>
												<div class="controls">
													<input name="emp.name"  type="text" value=''
														class="m-wrap span12" placeholder="必填">
												</div>
											</div>
										</div>
										<!--/span-->
										<div class="span6 ">
											<div class="control-group">
												<label class="control-label">生日：</label>
												<div class="controls">
													<div class="input-append date date-picker"
														data-date-format="yyyy-mm-dd" data-date-viewmode="years">
														<input name="emp.birthday"  class="m-wrap m-ctrl-medium date-picker" size="16"
															type="text" placeholder="请选择" value=""/>
															<span class="add-on"><i class="icon-calendar"></i> </span>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="row-fluid">
										<div class="span6 ">
											<div class="control-group">
												<label class="control-label">身份证：</label>
												<div class="controls">
													<input name="emp.idcard" type="text" value=''
														class="m-wrap span12" placeholder="必填">
												</div>
											</div>
										</div>
										<div class="span6 ">
											<div class="control-group">
												<label class="control-label">性别：</label>
												<div class="controls">
												<label class="radio">
													<input name="emp.sex" type="radio" value="先生"
													class="m-wrap span12" checked>先生
												</label>
												<label class="radio">
													<input name="emp.sex" type="radio" value="女士"
													class="m-wrap span12" >女士
												</label>
												</div>
											</div>
										</div>
									</div>
									<div class="row-fluid">
										<div class="span6 ">
											<div class="control-group">
												<label class="control-label">职务岗位：</label>
												<div class="controls">
													<select id="positionselect" name="emp.hrPosition.id" class="m-wrap span6">
														<option value="-1">请选择</option>
													</select>
													<select id="postselect" name="emp.hrPost.postId" class="m-wrap span6">
														<option value="-1">请选择</option>
													</select>
												</div>
											</div>
										</div>
										<div class="span6 ">
											<div class="control-group">
												<label class="control-label">部门：</label>
												<div class="controls">
													<select id="select2_sample_deps" name="emp.hrDepartment.id" class="m-wrap span12">
														<option value="-1">请选择</option>
													</select>
												</div>
											</div>
										</div>
									</div>
									<div class="row-fluid">
										<div class="span6 ">
											<div class="control-group">
												<label class="control-label">邮箱：</label>
												<div class="controls">
													<input name="emp.email" value="" type="text" class="m-wrap span12" placeholder="必填">
												</div>
											</div>
										</div>
										<div class="span6 ">
											<div class="control-group">
												<label class="control-label">电话：</label>
												<div class="controls">
													<input name="emp.telephone" value="" type="text" class="m-wrap span12" placeholder="必填">
												</div>
											</div>
										</div>
									</div>
									<div class="row-fluid">
										<div class="span6 ">
											<div class="control-group">
												<label class="control-label">地址：</label>
												<div class="controls">
													<input name="emp.address" type="text" value=""
													class="m-wrap span12" placeholder="必填">
												</div>
											</div>
										</div>
										<div class="span6 ">
											<div class="control-group">
												<label class="control-label">学历：</label>
												<div class="controls">
													<select id="" name="emp.education" class="m-wrap span12">
														<option value="-1">请选择</option>
														<option value="初中">初中</option>
														<option value="高中">高中</option>
														<option value="专科">专科</option>
														<option value="本科">本科</option>
													</select>
												</div>
											</div>
										</div>
									</div>
									<div class="row-fluid">
										<div class="span6 ">
											<div class="control-group">
												<label class="control-label">专业：</label>
												<div class="controls">
													<input name="emp.professional" type="text" value=""
													class="m-wrap span12" placeholder="必填">
												</div>
											</div>
										</div>
										<div class="span6 ">
											<div class="control-group">
												<label class="control-label">毕业学校：</label>
												<div class="controls">
													<input name="emp.schools" type="text" value=""
													class="m-wrap span12" placeholder="必填">
												</div>
											</div>
										</div>
									</div>
									<h3 class="form-section">入职信息</h3>
									<div class="row-fluid">
										<div class="span6 ">
											<div class="control-group">
												<label class="control-label">入职日期：</label>
												<div class="controls">
													<div class="input-append date date-picker"
														data-date-format="yyyy-mm-dd" data-date-viewmode="years">
														<input name="emp.entrydate"  class="m-wrap m-ctrl-medium date-picker" size="16"
															type="text" placeholder="请选择" value="" /> 
															<span class="add-on"><i class="icon-calendar"></i> </span>
													</div>
												</div>
											</div>
										</div>
										<div class="span6 ">
											<div class="control-group">
												<label class="control-label">是否可以登录：</label>
												<div class="controls">
												<label class="radio">
													<input name="emp.canlogin" type="radio" value="1"
													class="m-wrap span12" checked>是
												</label>
												<label class="radio">
													<input name="emp.canlogin" type="radio" value="0"
													class="m-wrap span12">否
												</label>
												</div>
											</div>
										</div>
									</div>
									<div class="row-fluid">
										<div class="span6 ">
											<div class="control-group">
												<label class="control-label">是否在职：</label>
												<div class="controls">
													<label class="radio">
													<input name="emp.ispost" type="radio" value="1"
													class="m-wrap span12" checked>在职
												</label>
												<label class="radio">
													<input name="emp.ispost" type="radio" value="0"
													class="m-wrap span12" >离职
												</label>
												</div>
											</div>
										</div>
										<div class="span6 ">
											<div class="control-group">
												<label class="control-label">权限角色：</label>
												<div class="controls">
													<select id="roleselect" name="emp.sysRole.roleid" class="m-wrap span12">
														<option value="-1">请选择</option>
													</select>
												</div>
											</div>
										</div>
									</div>
									<div class="row-fluid">
										<div class="span6 ">
											<div class="control-group">
												<label class="control-label">员工级别：</label>
												<div class="controls">
													<select id="emplevel" name="emp.paramSysparam.id" class="m-wrap span12">
														<option value="-1">请选择</option>
													</select>
												</div>
											</div>
										</div>
									</div>
									<div class="row-fluid">
										<div class="span12 ">
											<div class="control-group">
												<label class="control-label">员工备注：</label>
												<div class="controls">
													<textarea rows="3" cols="" name="emp.remarks" class="span12 m-wrap"></textarea>
												</div>
											</div>
										</div>
									</div>
									<div class="form-actions">
										<button type="submit" id="submit-button" class="btn green"><i class="icon-ok"></i>保存</button>
										<button type="reset" class="btn">重置</button>
										<button type="button" onclick="history.back()" class="btn blue">返回</button>
									</div>
								</form>
								<!-- END FORM-->
							</div>
						</div>
						<!-- END SAMPLE FORM PORTLET-->
					</div>
				</div>
				<!-- END PAGE CONTENT-->
			</div>
			<!-- END 页面容器-->
		</div>
		<!-- END 页面 -->
	</div>
	<!-- END 容器 -->
	<jsp:include page="/main_pages/foot.jsp"></jsp:include>
	<jsp:include page="/media/ui_js.jsp"></jsp:include>
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script type="text/javascript" src="<%=basePath%>media/js/DT_bootstrap.js"></script>
	<script type="text/javascript" src="<%=basePath%>media/js/select2.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>media/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="<%=basePath%>media/js/search.js"></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="<%=basePath%>media/js/app.js"></script>
	<script type="text/javascript" src="<%=basePath%>main_pages/selectdepsemps.js"></script>
	<script type="text/javascript" src="<%=basePath%>main_pages/selectposition.js"></script>
	<script type="text/javascript" src="<%=basePath%>main_pages/selectparam.js"></script>
	<script>
		jQuery(document).ready(function() {
			App.init();
			Search.init();
			ajaxLoadPosition($('#positionselect'));
			$('#positionselect').change(function(){
				var id=$(this).val();
				var url="../pages_hr/hr_post!ajaxLoadPostByPositionId?id="+id+"&v="+new Date().valueOf();
				$.getJSON(url,function(d){
					var chtml="";
					for ( var int = 0; int < d.length; int++) {
						chtml+="<option value='"+d[int].postId+"'>"+d[int].postName+"</option>";
					}
					$('#postselect').html(chtml);
				});
			});
			var role = $('#roleselect');
			var roleurl="../pages_sys/sys_role!ajaxLoadSysRole?v="+new Date().valueOf();
			$.getJSON(roleurl,function(d){
				var chtml="";
				for ( var int = 0; int < d.length; int++) {
					chtml+="<option value='"+d[int].roleid+"'>"+d[int].rolename+"</option>";
				}
				role.append(chtml);
			});
			var emplevel = $('#emplevel');
			ajaxLoadParam(emplevel,11);
		});
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>