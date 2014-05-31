<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>电影搜索</title>
<meta charset="utf-8">
<link href="css/bootstrap.css" rel="stylesheet">
<style>
	body,h1,h2,h3,h4,p,div{
	font-family: ""微软雅黑;
	}
</style>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
</head>

<body style="background: #dcddcd">
	<div class="container">
		<div class="col-xs-12 ">
			<p class="pull-right visible-xs"></p>
			<div class="jumbotron" style="margin-top: 50px;min-height: 500px;">
				<h2 class="text-center">电影搜索</h2>
				<div class="input-group">
					<input type="search" id="text" name="q" class="form-control"
						autocomplete="on" value="" placeholder="搜索">
					<div class="input-group-btn">
						<button type="button" class="btn btn-default" id="search">电影搜索</button>
					</div>
				</div>
				<div id="list" class="list">
					<div id="result"></div>
					<div id="info"></div>
				</div>
			</div>
			<!--/span-->
		</div>
	</div>
	<footer style="text-align: center;">
		<p>&copy; 白强 2014.All rights reserved</p>
	</footer>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#search").click(function() {
				$('#result').html('');
				search();
			});

			$("#text").keydown(function() {
				if (event.keyCode == "13") {//keyCode=13是回车键
					$('#search').click();
				}
			});
		});
		function urldecode(data) {
			return decodeURIComponent(data);
		}
		function search() {
			$
					.ajax({
						url : "search.do?name=" + $('#text').val(),
						type : "get",
						dataType : "json",
						beforeSend : function() {
							$('#list').css('display', 'block');
							$('#info').html('正在请求数据。。');
						},
						success : function(data, status) {
							$('#info').html('');
							console.log(data);
							$("#list").css('display', 'block');
							$
									.each(
											data,
											function(i, item) {
												console.log(item);
												if(item.description==undefined){item.description=""}
												$(
														'<div style="col-xs-12">'
																+ '<h2>'
																+ urldecode(item.name)
																+ ' </h2>'
																+ '<a target="_blank" href="'
																+urldecode(item.filmUrl)
																+'"<h4>'
																+ urldecode(item.filmUrl)
																+ ' </h4></a><p>'
																+ item.description
																+ '</p></div>')
														.appendTo('#result');
											});
						},
						error : function() {
							console.log("error");
							$('#list').css('display', 'none');
							$('#result').html('failed');
						}
					});
		}
	</script>
</body>
</html>
