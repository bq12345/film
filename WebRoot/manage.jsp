<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%
	if (session.getAttribute("admin") == null) {
		response.sendRedirect("admin.html");
	}
%>
<!DOCTYPE HTML>
<html>
<head>
<title>电影资料管理</title>
<meta charset="utf-8">
<link href="css/bootstrap.css" rel="stylesheet">
<style>
body,h1,h2,h3,h4,p,div,legend,span {
	font-family: "微软雅黑";
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
							<li><a href="manage.html">电影管理</a></li>
						</ul>
					</div>
				</div>

				<div class="navbar-form navbar-right">
					<form>
						<div class="form-group">
							<input type=button value="退出" id="logout" class="form-control">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="col-xs-12" id="page" style="position: relative">
			<div class="container"
				style="position:relative;margin-top: 70px;min-height:530px;"
				id="main">
				<table class="table table-hover table-bordered" id="table">
					<tr>
						<th>名称</th>
						<th>描述</th>
						<th>导演</th>
						<th>URL</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${waits}" var="item">
						<tr>
							<td>${item.name}</td>
							<td class="desc">${item.description}</td>
							<td>${item.director}</td>
							<td>${item.url}</td>
							<td><a title="${item.id}">通过</a></td>
						</tr>
					</c:forEach>
				</table>
				<ul class="pagination">
					<li><a href="#">&laquo;</a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">&raquo;</a></li>
				</ul>
			</div>
		</div>
	</div>
	<footer style="text-align: center;">
		<p>&copy; 电影搜索 2014.All rights reserved</p>
	</footer>
	<script type="text/javascript">
		$(function() {
			$("#logout").click(function() {
				$.get("logout.do", function(data) {
					location.href = "index.html";
				});
			});
			$("#table").click(function(e) {

				var target = e.target;
				if (target.nodeName == 'A') {
					console.log(e.target.innerHTML);
					console.log(e.target.path);
					$.get("agree.do?id=" + e.target.title, function(data) {
						console.log(data);
						e.target.innerHTML = "已通过";
						e.target.className += 'btn btn-sm disabled';

					});
					e.preventDefault();
				}
			});
		});
	</script>

</body>
</html>