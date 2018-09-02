<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>金盾智联</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="../css/bootstrap.css" rel="stylesheet" />
<link href="../css/css.css" rel="stylesheet" />
<script src="../js/jquery-1.9.1.min.js"></script>
<script src="../js/banner.js"></script>
<link href="../css/animate.min.css" rel="stylesheet" />
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
		function reloadCode(){
			var time = new Date().getTime();
			document.getElementById("imagecode").src="<%=path%>/ImageServlet?d="+time;
		}
	</script>
</head>
<body>
	<%
		String error = (String) request.getAttribute("a");
		if (error != null) {
	%>
	<script type="text/javascript" language="javascript">
alert("<%=error%>");
	</script>
	<%
		}
	%>
	<div class="header">
		<div class="container">
			<div class="row header_box">
				<a href="../views/index.jsp"><img src="../images/logo.png"
					class="pull-left logo" /></a>
				<div class="pull-right call">
					<ul>
						<li class="border_rt"><i class="icon iconfont"></i> 24小时服务热线<br />4000-798-369
						</li>
						<li class="play">微信关注<br />下载APP
							<div class="play_box animated">
								<div class="pull-left box">
									<h4>微信关注</h4>
									<img src="../images/erweima.png" />
								</div>
								<div class="pull-left box">
									<h4>下载APP</h4>
									<img src="../images/mg.png" />
								</div>
								<div class="clear"></div>
								<span></span>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>

	</div>
	<!-------注册/登陆------------->
	<div class="banner_box">
		<div class="container">
			<div class="row">
				<div class="col-xs-4 pull-right">
					<div class="logo_in">
						<form action="<%=basePath%>user/register" method="post">
							<h2>立即注册</h2>
							<ul>
								<li><input type="text" class="form-control" name="username"
									placeholder="设置您的账号（邮箱/手机号/用户名）" required /></li>
								<li><input type="text" class="form-control" name="LTID"
									placeholder="设置您的鲁通卡号" required /></li>
								<li><input type="password" class="form-control"
									name="password" placeholder="设置您的账号密码" /></li>
								<li><input type="password" class="form-control "
									name="password2" placeholder="确认账号密码" /></li>
								<li class="verify"><input type="text" name="checkcode"
									placeholder="请输入右侧验证码" /> <img alt="验证码" id="imagecode"
									src="<%=basePath%>user/imageCheck" /> <a
									href="javascript: reloadCode();">看不清楚</a><br>
									<div class="clear"></div></li>
								<li>
									<div class="pull-right pass">

										<a href="../views/login.jsp" class="last_a">已有账户？去登陆</a>
									</div>
									<div class="clear"></div>
								</li>
								<li>
									<button class="btn btn-danger">立即注册</button> <!--  <input class="btn btn-danger" type="submit" value="立即注册">-->
								</li>
							</ul>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!---------footer-------------->
	<div class="footer" style="margin-top: 0px;">
		<div class="container box">
			<div class="row">
				<div class="col-xs-4">
					<h4>关于我们</h4>
					<a>
						金盾网联是由省有关部门牵头发起面向全省推行的惠民直通车项目，其携手中国银行、中国石化等多家百强企业全新联合打造，为有车一族提供便捷、安全、实惠、省时的客户绿色通道。
					</a>
				</div>
				<div class="col-xs-4">
					<h4>友情链接</h4>
					<a href="http://www.zonuo-china.com/">烟台中诺网络科技有限公司</a> <a
						href="http://www.dotopyun.com/">山东兴鋆网络科技有限公司</a>
				</div>
				<div class="col-xs-4  text-center">
					<div class="pull-left ig_d">
						<h4>微信关注</h4>
						<img src="../images/erweima.png" />
					</div>
					<div class="pull-left ig_d">
						<h4>下载APP</h4>
						<img src="../images/mg.png" />
					</div>


				</div>
			</div>
		</div>
		<div class="copyright">
			<div class="container">
				<div class="row">
					<div class="col-sm-12">
						<span></span> <span>©2005-2015 山东金盾经贸投资有限公司 版权所有
							鲁ICP备12010501号</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
	$(".play").mouseover(function() {
		$(".play_box").addClass("fadeInUp");
	});
</script>
</html>