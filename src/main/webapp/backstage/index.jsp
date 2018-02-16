<%--
  Created by IntelliJ IDEA.
  后台首页登录页面
  User: ccjjltx
  Date: 2018/2/15
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>学生干部评分管理系统</title>
    <meta charset="utf-8">
    <meta name="description" content="后台登录界面">
    <meta name="author" content="ccj">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function (c) {
            $('.alert-close').on('click', function (c) {
                $('.message').fadeOut('slow', function (c) {
                    $('.message').remove();
                });
            });
        });
    </script>
</head>
<body>
<div class="message warning">
    <div class="inset">
        <div class="login-head">
            <h1>学生干部评分管理系统</h1>
            <div class="alert-close"></div>
        </div>

        <form method="post" action="<%=basePath %>backstage/index.action">
            <ul>
                <li><input type="text" class="text" name="username" value="用户名" onFocus="this.value = '';"
                           onBlur="if (this.value == '') {this.value = '用户名';}"><a href="#" class=" icon user"></a></li>
                <li><input type="password" name="password" value=""/> <a href="#" class="icon lock"></a></li>
            </ul>

            <div class="submit">
                <input type="submit" value="登录">
                <h4><a href="#">忘记密码?</a></h4>
                <div class="clear"></div>
            </div>
        </form>
    </div>
</div>

<!--- footer --->
<div class="footer">
    <p>Copyright &copy; 2018.</p>
</div>

</body>
</html>
