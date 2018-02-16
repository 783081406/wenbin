<%--
  Created by IntelliJ IDEA.
  干部录入
  User: ccjjltx
  Date: 2018/2/16
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <title>干部录入</title>
    <meta charset="utf-8">
    <meta name="description" content="干部录入">
    <meta name="author" content="ccj">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="text/javascript" src="style/js/jquery.js"></script>
    <script type="text/javascript" src="style/js/page_common.js"></script>
    <link href="style/css/common_style_blue.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="style/css/index_1.css"/>
</head>
<body>

<!-- 页面标题 -->
<div id="TitleArea">
    <div id="TitleArea_Head"></div>
    <div id="TitleArea_Title">
        <div id="TitleArea_Title_Content">
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 干部录入
        </div>
    </div>
    <div id="TitleArea_End"></div>
</div>

<!-- 过滤条件 -->
<div id="QueryArea">
    <form action="#" method="get">
        <input type="hidden" name="method" value="search">
        <input type="text" name="keyword" title="请输入姓名">
        <input type="submit" value="搜索">
    </form>
</div>


<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <table class="MainArea_Content" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
        <tr align="center" valign="middle" id="TableTitle">
            <td>编号</td>
            <td>干部姓名</td>
            <td>用户名</td>
            <td>密码</td>
            <td>操作</td>
        </tr>
        </thead>
        <!--显示数据列表 -->
        <tbody id="TableData">

        <tr class="TableDetail1">
            <td align="center">1&nbsp;</td>
            <td align="center"> 222&nbsp;</td>
            <td align="center">3333</td>
            <td align="center">44444</td>
            <td>
                <a href="/wirelessplatform/board.html?method=update&id=1&isBook=0" class="FunctionButton">123</a>
                <a href="/wirelessplatform/board.html?method=delete&id=1" onClick="return delConfirm();"
                   class="FunctionButton">删除</a>
            </td>
        </tr>
        </tbody>
    </table>

    <!-- 其他功能超链接 -->
    <div id="TableTail" align="center">
        <div class="FunctionButton"><a href="saveBoard.html">添加</a></div>
    </div>
</div>
</body>
</html>
