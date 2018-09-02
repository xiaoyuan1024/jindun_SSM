<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="yuan.zhang.entity.User"%>
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
<link rel="stylesheet" type="text/css" href="../css/css.css">
<script src="../js/jquery-1.9.1.min.js"></script>
<link href="../css/animate.min.css" rel="stylesheet" />
<style type="text/css">
</style>
</head>
<body>
	<%
		//form表单中action的内容会默认加上当前根目录，以下两行代码避免此情况发生，得到正确的路径。
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
	%>
	<%
		String Month;
		String Month1;
		String Month2;
		String Month3;
		String Month4;

		//String username = (String)session.getAttribute("username");
		Calendar c = Calendar.getInstance();
		String year = String.valueOf(c.get(Calendar.YEAR));
		String month = String.valueOf(c.get(Calendar.MONTH));
		//当前月
		int monthInt = Integer.parseInt(month);
		//前一月
		int monthInt1 = Integer.parseInt(month);
		//前二月
		int monthInt2 = Integer.parseInt(month) - 1;
		//前三月
		int monthInt3 = Integer.parseInt(month) - 2;
		//前四月
		int monthInt4 = Integer.parseInt(month) - 3;
		//判断月份
		if (monthInt < 10) {
			Month = "年0" + monthInt + "月";
		} else {
			Month = "年" + monthInt + "月";
		}
		//判断月份
		if (monthInt1 < 10) {
			Month1 = "年0" + monthInt1 + "月";
		} else {
			Month1 = "年" + monthInt1 + "月";
		}
		//判断月份
		if (monthInt2 < 10) {
			Month2 = "年0" + monthInt2 + "月";
		} else {
			Month2 = "年" + monthInt2 + "月";
		}
		//判断月份
		if (monthInt3 < 10) {
			Month3 = "年0" + monthInt3 + "月";
		} else {
			Month3 = "年" + monthInt3 + "月";
		}
		//判断月份
		if (monthInt1 < 10) {
			Month4 = "年0" + monthInt4 + "月";
		} else {
			Month4 = "年" + monthInt4 + "月";
		}
		//查询月份
		String monthString = year + Month;
		String mothString1 = year + Month1;
		String mothString2 = year + Month2;
		String mothString3 = year + Month3;
		String mothString4 = year + Month4;
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
		<div class="nav_box">
			<div class="container warp">
				<ul class="pull-left">
					<li><a href="../views/index.jsp"> <i class="icon iconfont">&#xe606;</i>
							网站首页
					</a></li>
					<li><a href="../views/serve.jsp"> <i class="icon iconfont">&#xe634;</i>
							服务介绍
					</a></li>
					<li><a href="../views/news.jsp"> <i class="icon iconfont">&#xe6cb;</i>
							新闻资讯
					</a></li>
					<li><a href="../views/contact.jsp"> <i
							class="icon iconfont">&#xe605;</i> 联系我们
					</a></li>
					<li class="ac">
						<%
							//	获取session作用域的user对象
							User user = (User) session.getAttribute("user");
							String username = null;
							if (user != null) {
								username = user.getUsername();
							}
						%> <a
						href="<%=basePath%>record/selectRecord?username=<%=username%>">
							<i class="icon iconfont">&#xe66c;</i> 通行记录
					</a>
					</li>
					<div class="clear"></div>
				</ul>
				<div class="logoin pull-right">
					<%
						if (username == null) {
							out.print("<a href='../views/login.jsp' class='ac'>");
							out.print("<i class='icon iconfont'>&#xe60c;</i>登陆</a>");
							out.print("<a href='../views/enroll.jsp'>");
							out.print("<i class='icon iconfont' >&#xe697;</i>注册</a>");
						} else {
							out.print("<a href='../views/index.jsp' class='ac'>");
							out.print("<i class='icon iconfont'>&#xe60c;</i>");
							out.print(username + "</a>");
							out.print("<a href='../views/login.jsp'");
							out.print("<i class='icon iconfont' >&#xe697;</i>注销</a>");
						}
					%>
				</div>
			</div>
		</div>
	</div>
	<!-- 新闻中心-->
	<div class="container-fluid catalogue">
		<div class="container">
			<!---------------导航------------------>
			<div class="row">
				<div class="col-md-4 col-sm-12 col-xs-12 text-center">
					<p>通行记录</p>
				</div>
				<div class="col-md-8 col-sm-12 col-xs-12 text-center">
					<div class="record">
						<p>通行记录 / 账单查询</p>

					</div>
				</div>
			</div>
		</div>
	</div>
	<!---------------用户信息------------------>
	<div class="container serve_box">
		<div class="row">
			<div class="col-xs-3">
				<div class="serve_lf">
					<ul>
						<li><a href="<%=basePath%>record/selectRecord?username=<%=username%>">用户信息</a></li>
						<li><a href="../views/record_2.jsp" class="ac_s">账单查询</a></li>
						<li><a href="../views/record_3.jsp">修改密码</a></li>
					</ul>
				</div>
			</div>
			<div class="col-xs-9">
				<div class="record_ron">
					<h3>注：请在10-15日，确定上个月账单</h3>
					<div class="table_box">
						<table id="sample-table-1"
							class="table table-striped table-bordered table-hover">
							<tbody>
								<tr class="text-center">
									<td><%=mothString1%>通行账单</td>
									<td>
										<form
											action="<%=basePath%>record/getRecordCurrentPage?starttime=2018/05/&&username=<%=username%>"
											method="post">
											<input type="submit" class="btn btn-xs btn btn-danger"
												value="查看详情">
										</form>
									</td>
									<td>2018年06月01日生成</td>
								</tr>
								<tr class="text-center">
									<td><%=mothString2%>通行账单</td>
									<td>
										<form
											action="<%=basePath%>record/getRecordCurrentPage?starttime=2018/05/&&username=<%=username%>"
											method="post">
											<input type="submit" class="btn btn-xs btn btn-danger"
												value="查看详情">
										</form>
									</td>
									<td>2018年05月01日生成</td>
								</tr>
								<tr class="text-center">
									<td>2018年03月通行账单</td>
									<td>
										<form
											action="<%=basePath%>record/getRecordCurrentPage?starttime=2018/05/&&username=<%=username%>"
											method="post">
											<input type="submit" class="btn btn-xs btn btn-danger"
												value="查看详情">
										</form>
									</td>
									<td>2018年04月01日生成</td>
								</tr>
								<tr class="text-center">
									<td><%=mothString4%>通行账单</td>
									<td>
										<form
											action="<%=basePath%>record/getRecordCurrentPage?starttime=2018/05/&&username=<%=username%>"
											method="post">
											<input type="submit" class="btn btn-xs btn btn-danger"
												value="查看详情">
										</form>
									</td>
									<td>2018年03月01日生成</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>

			</div>

		</div>
	</div>


	<!---------footer-------------->
	<div class="footer ">
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