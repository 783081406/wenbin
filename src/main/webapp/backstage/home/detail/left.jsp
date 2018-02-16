<%--
  Created by IntelliJ IDEA.
  首页-》left
  User: ccjjltx
  Date: 2018/2/16
  Time: 0:10
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
    <title>left</title>
    <meta charset="utf-8">
    <meta name="description" content="学生干部评分管理系统left">
    <meta name="author" content="ccj">
    <script type="text/javascript" src="style/js/jquery.js"></script>
    <script type="text/javascript" src="style/js/page_common.js"></script>
    <link href="style/css/common_style_blue.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript">
        // 显示或隐藏二级菜单
        function menuClick(menuDiv) {
            $(".MenuLevel2").not($(menuDiv).next()).hide();
            $(menuDiv).next().toggle();
        }

        $(function () {
            // 默认只显示第1个二级菜单
            $(".MenuLevel2").hide();
            $(".MenuLevel2:first").show();
        });
    </script>
    <!-- 内容总宽度为 3px边框 * 2 + 155px内容 = 161px; -->
    <style type="text/css">
        <!--
        html {
            height: 100%;
        }

        body {
            background: none repeat scroll 0 0 #D8EDFC;
            margin: 0;
            padding: 0;
        }

        #Menu {
            margin: 0;
            padding: 0;
            width: 155px;
            background: none repeat scroll 0 0 #D8EBF7;
            list-style: none outside none;

            margin-left: 3px;
            border-top: 3px solid #4891C6;
        }

        #Menu .level1 {
            color: #005790;
            font-weight: bold;
            padding-bottom: 1px;
            cursor: pointer;
        }

        #Menu .level1 .level1Style {
            background: url("style/images/img/menu_btn_bg.gif") no-repeat scroll 0 0 transparent;
            height: 23px;
            padding-left: 20px;
            padding-top: 5px;
            width: 135px;
            margin-bottom: -4px
        }

        #Menu .level1 .level1Style .Icon {
            margin-top: -2px;
        }

        #Menu .level1 .MenuLevel2 {
            background: none repeat scroll 0 0 #D8EBF7;
            list-style: none outside none;
            margin: 0;
            padding: 0;
        }

        #Menu .level1 .MenuLevel2 .level2Style {
            color: #005790;
            font-weight: normal;
            border-top: 1px solid #EFF6FB;
            height: 18px;
            padding-left: 43px;
            padding-top: 5px;
            width: 112px;
            background-image: url(style/images/img/menu_arrow_single.gif);
            background-color: #8EC4E9;
            background-repeat: no-repeat;
            background-position: 29px center;
        }

        -->
    </style>
</head>
<body>

<ul id="Menu">
    <li class="level1">
        <div onClick="menuClick(this);" class="level1Style">
            <img src="style/images/func20001.gif" class="Icon"/>
            通用功能
        </div>
        <ul class="MenuLevel2">
            <li class="level2 level2Style">
                <a target="right" href="#">活动汇总</a>
            </li>
            <li class="level2 level2Style">
                <a target="right" href="#">活动申述</a>
            </li>
            <li class="level2 level2Style">
                <a target="right" href="#">修改密码</a>
            </li>
        </ul>
    </li>
    <li class="level1">
        <div onClick="menuClick(this);" class="level1Style">
            <img src="style/images/func20001.gif" class="Icon"/>
            部长职权
        </div>
        <ul class="MenuLevel2">
            <li class="level2 level2Style">
                <a target="right" href="<%=basePath %>cadreentry/getAllUser">干部录入</a>
            </li>
            <li class="level2 level2Style">
                <a target="right" href="#">活动信息</a>
            </li>
        </ul>
    </li>
</ul>
</body>
</html>