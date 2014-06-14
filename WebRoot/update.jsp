<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%
	if (session.getAttribute("user") == null) {
		response.sendRedirect("index.html");
	}
%>
<!DOCTYPE HTML>
<html>
<head>
<title>电影资料修改</title>
<meta charset="utf-8">
<link href="css/bootstrap.css" rel="stylesheet">
<style>
body,h1,h2,h3,h4,p,div,legend,span {
	font-family: "微软雅黑";
}
</style>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/xss.js"></script>
</head>

<body style="background: #dcddcd">
	<div class="navbar navbar-fixed-top"
		style="background:rgba(255, 255, 255, 0.5);height: 50px;">
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<div class="collapse navbar-collapse">
						<ul class="nav navbar-nav top-nav menu">
							<li><a href="user.jsp">个人中心</a></li>
						</ul>
					</div>
				</div>
				<div class="col-md-6">
					<div class="collapse navbar-collapse">
						<ul class="nav navbar-nav top-nav menu">
							<li><a href="user.jsp#personPane">个人资料</a></li>
							<li><a href="user.jsp#addPane">添加电影</a></li>
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
				style="position:relative;margin-top: 70px;min-height:600px;"
				id="main">

				<form id="update-film" action="updateWait.do" method="post"
					style="width: 50%;">
					<fieldset>
						<legend>更新电影信息</legend>
						<input type="hidden" name="id" value="${wait.id}">

						<div class="form-group">
							<label for="update-film-name">电影:</label> <span
								class="text-danger" id="update-film-name-error"
								style="display: none">电影应该在5-15位之间</span> <input type="text"
								id="update-film-name" name="name" placeholder="请输入电影名称"
								class="form-control" required="required" value="${wait.name}">
						</div>
						<div class="form-group">
							<label for="update-film-desc">描述:</label> <span
								class="text-danger" id="update-film-desc-error"
								style="display: none">太短了 不应该小于30位</span>
							<textarea id="update-film-desc" name="desc"
								placeholder="描述一下这个电影吧" rows="3" cols="75" required="required">${wait.description}</textarea>
						</div>
						<div class="form-group">
							<label for="update-film-url">地址:</label> <input type="url"
								id="update-film-url" name="url" class="form-control"
								placeholder="请输入链接地址" required="required" value="${wait.url}">
						</div>
						<div class="form-group">
							<label for="update-film-director">导演:</label> <span
								class="text-danger" id="update-film-director-error"
								style="display: none">名字不正确</span> <input type="text"
								id="update-film-director" name="director" class="form-control"
								placeholder="请输入导演名字" required="required"
								value="${wait.director}">
						</div>
						<div class="form-group">
							<label for="update-film-watch">观看地址:</label> <span
								class="text-danger" id="update-film-watch-error"
								style="display: none">地址不正确</span> <input type="url"
								id="update-film-watch" name="watch" class="form-control"
								placeholder="请输入观看地址" required="required" value="${wait.watch}">
						</div>
						<div class="form-group">
							<label for="update-film-date">上映时间:</label> <span
								class="text-danger" id="update-film-date-error"
								style="display: none">时间格式不正确</span> <input type="date"
								id="update-film-date" name="date" class="form-control"
								placeholder="请输入上映时间" required="required" value="${wait.date}">
						</div>
						<br />

						<div class="form-group">
							<input type="submit" value="提交"
								class="btn btn-primary btn-lg btn-block">
						</div>
					</fieldset>
				</form>
				<script>
                $(function () {
                    $("#update-film-name").blur(function () {
                        if ($(this).parent().hasClass("has-error")) {
                            $(this).parent().removeClass("has-error");
                        }
                        $("#update-film-name-error").css("display", "none");
                        var name = $("#update-film-name").val();
                        if (name.length < 5 || name.length > 15) {
                            $("#update-film-name-error").css("display", "inline");
                            $(this).parent().addClass("has-error");
                            $(this).focus();
                        }
                    });

                    $("#update-film-desc").blur(function () {
                        if ($(this).parent().hasClass("has-error")) {
                            $(this).parent().removeClass("has-error");
                        }
                        $("#update-film-desc-error").css("display", "none");
                        var desc = $("#update-film-desc").val();
                        desc=filterXSS(desc);
                        $("#update-film-desc").val(desc);
                        if (desc.length < 30) {
                            $("#update-film-desc-error").css("display", "inline");
                            $(this).parent().addClass("has-error");
                            $(this).focus();
                        }
                    });

                    $("#update-film-director").blur(function () {
                        if ($(this).parent().hasClass("has-error")) {
                            $(this).parent().removeClass("has-error");
                        }
                        $("#update-film-director-error").css("display", "none");
                        var director = $("#update-film-director").val();
                        if (director.length < 5 || director.length > 15) {
                            $("#update-film-director-error").css("display", "inline");
                            $(this).parent().addClass("has-error");
                            $(this).focus();
                        }
                    });
                });
            </script>
			</div>
		</div>
	</div>
</body>
</html>