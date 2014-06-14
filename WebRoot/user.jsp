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
<title>用户中心</title>
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
<script type="text/javascript" src="js/jquery.smint.js"></script>
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
							<li><a id="person">个人资料</a></li>
							<li><a id="add">添加电影</a></li>
						</ul>
					</div>
				</div>
				<div class="navbar-form navbar-right">
					<form>
						<div class="form-group">
							<input type=button value="退出" id="logout" class="btn btn-deault">
							<input type=button value="首页" id="index" class="btn btn-deault">
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
							<td><a href="getWait.do?id=${item.id}">修改</a>|<a
								href="deleteWait.do?id=${item.id}">删除</a></td>
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
			<div id="personPane" class="person container"
				style="height:550px;width: 50%">
				<form id="updateUser" action="updateUser.do" method="post">
					<fieldset>
						<legend>用户资料更改</legend>
						<div class="form-group">
							<input type="hidden" name="id" value=${user.id}>
						</div>
						<div class="form-group">
							<label for="update-username">姓名:</label> <span
								class="text-danger" id="update-username-error"
								style="display: none">用户名应该在5-15位之间</span> <input type="text"
								id="update-username" name="username" placeholder="请输入注册的用户名"
								class="form-control" required="required" value=${user.username} readonly="readonly">
						</div>
						<div class="form-group">
							<label for="update-password">密码:</label> <span
								class="text-danger" id="update-password-error"
								style="display: none">密码长度不应该小于六位</span> <input type="password"
								id="update-password" name="password" placeholder="请输入密码"
								class="form-control" required="required">
						</div>
						<div class="form-group">
							<label for="update-age">年龄:</label> <input type="number"
								id="update-age" name="age" class="form-control"
								placeholder="请输入年龄" min="5" max="100" required="required"
								value=${user.age}>
						</div>
						<div class="form-group">
							<label for="update-email">E-mail:</label> <span
								class="text-danger" id="update-email-error"
								style="display: none">邮件格式不正确</span> <input type="email"
								id="update-email" name="email" class="form-control"
								placeholder="请输入E-mail" required="required" value=${user.email}>
						</div>
						<div class="form-group">
							<label for="update-love">爱好:</label> <span>(选填)</span> <input
								type="text" name="love" class="form-control"
								placeholder="请输入爱好 用,隔开" value=${user.love}>
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
            $("#update-username").blur(function () {
                if ($(this).parent().hasClass("has-error")) {
                    $(this).parent().removeClass("has-error");
                }
                $("#update-username-error").css("display", "none");
                var username = $("#update-username").val();
                if (username.length < 5 || username.length > 15) {
                    $("#update-username-error").css("display", "inline");
                    $(this).parent().addClass("has-error");
                    $(this).focus();
                }
            });
            $("#update-password").blur(function () {
                if ($(this).parent().hasClass("has-error")) {
                    $(this).parent().removeClass("has-error");
                }
                $("#update-password-error").css("display", "none");
                var password = $("#update-password").val();
                if (password.length < 6) {
                    $("#update-password-error").css("display", "inline");
                    $(this).parent().addClass("has-error");
                    $(this).focus();
                }
            });

            $("#update-email").blur(function () {
                if ($(this).parent().hasClass("has-error")) {
                    $(this).parent().removeClass("has-error");
                }
                $("#update-email-error").css("display", "none");
                var email = $("#update-email").val();
                if (!/^[a-z0-9]([a-z0-9]*[-_]?[a-z0-9]+)*@([a-z0-9]*[-_]?[a-z0-9]+)+[\.][a-z]{2,3}([\.][a-z]{2})?$/.test(email)) {
                    $("#update-email-error").css("display", "inline");
                    $(this).parent().addClass("has-error");
                    $(this).focus();
                }
            });
        });
    </script>
			</div>


			<div id="addPane" class="add container"
				style="height: 620px;width: 50%">
				<form id="addFilm" action="addWait.do" method="post">
					<fieldset>
						<legend>添加电影</legend>
						<div class="form-group">
							<label for="film-name">电影:</label> <span class="text-danger"
								id="film-name-error" style="display: none">电影应该在2-10位之间</span> <input
								type="text" id="film-name" name="name" placeholder="请输入电影名称"
								class="form-control" required="true">
						</div>
						<div class="form-group">
							<label for="film-desc">描述:</label> <span class="text-danger"
								id="film-desc-error" style="display: none">太短了 不应该小于30位</span>
							<textarea id="film-desc" name="desc" placeholder="描述一下这个电影吧"
								rows="3" cols="75" required="required"></textarea>
						</div>
						<div class="form-group">
							<label for="film-url">地址:</label> <input type="url" id="film-url"
								name="url" class="form-control" placeholder="请输入链接地址"
								value="http://" required="required">
						</div>
						<div class="form-group">
							<label for="film-director">导演:</label> <span class="text-danger"
								id="film-director-error" style="display: none">名字不正确</span> <input
								type="text" id="film-director" name="director"
								class="form-control" placeholder="请输入导演名字" required="required">
						</div>
						<div class="form-group">
							<label for="film-watch">观看地址:</label> <span class="text-danger"
								id="film-watch-error" style="display: none">地址不正确</span> <input
								type="url" id="film-watch" name="watch" class="form-control"
								placeholder="请输入观看地址" required="required">
						</div>
						<div class="form-group">
							<label for="film-date">上映时间:</label> <span class="text-danger"
								id="film-date-error" style="display: none">时间格式不正确</span> <input
								type="date" id="film-date" name="date" class="form-control"
								placeholder="请输入上映时间" required="required">
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
            $("#film-name").blur(function () {
                if ($(this).parent().hasClass("has-error")) {
                    $(this).parent().removeClass("has-error");
                }
                $("#film-name-error").css("display", "none");
                var name = $("#film-name").val();
                if (name.length < 2 || name.length > 10) {
                    $("#film-name-error").css("display", "inline");
                    $(this).parent().addClass("has-error");
                    $(this).focus();
                }
            });
            
            $("#film-desc").blur(function () {
                if ($(this).parent().hasClass("has-error")) {
                    $(this).parent().removeClass("has-error");
                }
                $("#film-desc-error").css("display", "none");
                var desc = $("#film-desc").val();
                desc=filterXSS(desc);
                $("#film-desc").val(desc);
                if (desc.length < 30) {
                    $("#film-desc-error").css("display", "inline");
                    $(this).parent().addClass("has-error");
                    $(this).focus();
                }
            });

            $("#film-director").blur(function () {
                if ($(this).parent().hasClass("has-error")) {
                    $(this).parent().removeClass("has-error");
                }
                $("#film-director-error").css("display", "none");
                var director = $("#film-director").val();
                if (director.length<2||director.length>10) {
                    $("#film-director-error").css("display", "inline");
                    $(this).parent().addClass("has-error");
                    $(this).focus();
                }
            });
        });
    </script>
			</div>
		</div>
	</div>
	<footer style="text-align: center;">
		<p>&copy; 电影搜索 2014.All rights reserved</p>
	</footer>

	<script type="text/javascript">
    $(document).ready(function () {
    	var desc=$(".desc");
    	$.each(desc,function(i,item){
    		if(item.length>35){
    			item.html(desc.substr(0,35));
    		}
    		
    	});
        $("#logout").click(function () {
            $.get("logout.do", function (data) {
               location.href="index.html";
            });
        });
        $("#index").click(function () {
               location.href="index.html";
        });
        $('.menu').smint({
            'scrollSpeed': 1000
        });
    });
</script>
	<script>
    $(function () {
        //当滚动条的位置处于距顶部100像素以下时，跳转链接出现，否则消失
        $(function () {
            $(window).scroll(function () {
                if ($(window).scrollTop() > 400) {
                    $("#back-to-top").fadeIn(1000);
                }
                else {
                    $("#back-to-top").fadeOut(1000);
                }
            });
            //当点击跳转链接后，回到页面顶部位置
            $("#back-to-top").click(function () {
                //注意scrollTop 到0即可
                $('body,html').animate({scrollTop: 0}, 1000);
                return false;
            });
        });
    });
</script>
	<p id="back-to-top">
		<a href="#top"><span></span>返回顶部</a>
	</p>
</body>
</html>
