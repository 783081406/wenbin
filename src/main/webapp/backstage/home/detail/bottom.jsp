<%--
  Created by IntelliJ IDEA.
  首页-》bottom
  User: ccjjltx
  Date: 2018/2/16
  Time: 0:19
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
    <title>bottom</title>
    <meta charset="utf-8">
    <meta name="description" content="学生干部评分管理系统bottom">
    <meta name="author" content="ccj">
    <script type="text/javascript" src="style/js/jquery.js"></script>
    <link href="style/css/common_style_blue.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">
        body {
            margin: 0;
        }

        img {
            vertical-align: inherit;
            border: 0;
        }

        a:link, a:hover, a:visited {
            color: #A9DCFF;
            text-decoration: none;
        }

        #StatusBar {
            background-color: #4386B7;
            border-top: 1px solid #FFFFFF;
            height: 19px;
            width: 100%;
        }

        #StatusBar #StatusBar_Links {
            color: #A9DCFF;
            float: left;
            font-family: "宋体";
            font-size: 12px;
            padding-left: 20px;
            padding-top: 3px;
        }

        #StatusBar #StatusBar_Right {
            color: #A9DCFF;
            float: right;
            font-family: "宋体";
            font-size: 12px;
            padding-right: 20px;
            padding-top: 4px;
        }
    </style>
</head>
<body>
<div id="StatusBar">
    <!-- 链接 -->
    <div id="StatusBar_Links">
        <a href="http://gz.itcast.cn" target="_blank">版权所有：</a>ccj
    </div>
    <!-- 右侧功能按钮 -->
    <div id="StatusBar_Right">
        <!-- 版本 -->
        <a href="javascript:void(0)">
            <img border="0" width="11" height="11" src="style/images/info.gif"/>
            <img border="0" width="40" height="11" src="style/images/version.gif"/>
        </a>
    </div>
</div>
</body>
</html>
