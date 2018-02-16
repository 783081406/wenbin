<%--
  Created by IntelliJ IDEA.
  后台首页
  User: ccjjltx
  Date: 2018/2/15
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <title>学生干部评分管理系统</title>
    <meta charset="utf-8">
    <meta name="description" content="学生干部评分管理系统">
    <meta name="author" content="ccj">
</head>
<frameset rows="100px,*,19px" framespacing="0" border="0" frameborder="0">
    <frame src="./detail/top.jsp" scrolling="no" noresize/>
    <frameset cols="178px,*">
        <frame noresize src="./detail/left.jsp" scrolling="yes"/>
        <frame noresize name="right" src="./detail/right.jsp" scrolling="yes"/>
    </frameset>
    <frame noresize name="status_bar" scrolling="no" src="./detail/bottom.jsp"/>
</frameset>
<noframes>
    <body>
    你的浏览器不支持框架布局，推荐你使用<a href="http://www.firefox.com.cn/download/" style="text-decoration: none;">火狐浏览器</a>,
    <a href="http://www.google.cn/intl/zh-CN/chrome/" style="text-decoration: none;">谷歌浏览器</a>
    </body>
</noframes>
</html>