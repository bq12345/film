<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<title>操作成功</title>
<meta charset="utf-8">
<link href="css/bootstrap.css" rel="stylesheet">
<style>
body,h1,h2,h3,h4,p,div,legend,span {
	font-family: "微软雅黑";
}

#table>tbody>tr>td {
	text-overflow: ellipsis;
}

p#back-to-top {
	position: fixed;
	display: none;
	bottom: 80px;
	right: 80px;
}

p#back-to-top a {
	text-align: center;
	text-decoration: none;
	color: #d1d1d1;
	display: block;
	width: 60px;
	/*使用CSS3中的transition属性给跳转链接中的文字添加渐变效果*/
	-moz-transition: color 0.5s;
	-webkit-transition: color 0.5s;
	-o-transition: color 0.5s;
}

p#back-to-top a:hover {
	color: #979797;
}

p#back-to-top a span {
	background: url(image/top.gif) no-repeat -51px 0;
	border-radius: 6px;
	display: block;
	width: 60px;
	height: 60px;
	margin-bottom: 5px;
	/*使用CSS3中的transition属性给<span>标签背景颜色添加渐变效果*/
	-moz-transition: background 0.2s;
	-webkit-transition: background 0.2s;
	-o-transition: background 0.2s;
}

#back-to-top a:hover span {
	background: url(image/top.gif) no-repeat -113px 0;
}
</style>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
</head>

<body style="background: #dcddcd">

	<div class="navbar navbar-fixed-top"
		style="background:rgba(255, 255, 255, 0.5);height: 50px;">
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<div class="collapse navbar-collapse">
						<ul class="nav navbar-nav top-nav menu">
							<li><a href="index.html">操作成功</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="col-xs-12" id="page"
			style="margin-top:200px;text-align: center;min-height: 400px;">
			<h4 class="text-info text-center" id="jump">J返回主页</h4>

		</div>
	</div>
	<footer style="text-align: center;">
		<p>&copy; 电影搜索 2014.All rights reserved</p>
	</footer>
	<script>
		function countDown(secs) {
			var jumpTo = document.getElementById('jump');
			jumpTo.innerHTML = "正在返回主页，剩余 " + secs
					+ " 秒...";

			if (--secs > 0) {
				setTimeout("countDown(" + secs + ")", 1000);
			} else {
				location.href = "index.html";
			}
		}
		countDown(4);
	</script>
</body>
</html>
