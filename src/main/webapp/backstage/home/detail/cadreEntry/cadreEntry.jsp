<%--
  Created by IntelliJ IDEA.
  干部录入
  User: ccjjltx
  Date: 2018/2/16
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
    <script type="text/javascript" src="<%=basePath %>backstage/home/detail/style/js/jquery.js"></script>
    <script type="text/javascript" src="<%=basePath %>backstage/home/detail/style/js/page_common.js"></script>
    <link href="<%=basePath %>backstage/home/detail/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>backstage/home/detail/style/css/index_1.css"/>
</head>
<body>

<!-- 页面标题 -->
<div id="TitleArea">
    <div id="TitleArea_Head"></div>
    <div id="TitleArea_Title">
        <div id="TitleArea_Title_Content">
            <img border="0" width="13" height="13"
                 src="<%=basePath %>backstage/home/detail/style/images/title_arrow.gif"/> 干部录入
        </div>
    </div>
    <div id="TitleArea_End"></div>
</div>

<!-- 过滤条件 -->
<div id="QueryArea">
    <form action="<%=basePath %>cadreentry/searchUser" method="get">
        <input type="text" name="name" placeholder="请输入姓名">
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
            <td>类型</td>
            <td>操作</td>
        </tr>
        </thead>
        <!--显示数据列表 -->
        <tbody id="TableData">
        <s:iterator value="result" status="si">
            <tr class="TableDetail1">
                <td align="center"><s:property value="#si.index"/>&nbsp;</td>
                <td align="center"><s:property value="name"/>&nbsp;</td>
                <td align="center"><s:property value="username"/></td>
                <td align="center"><s:property value="password"/></td>
                <td align="center"><s:property value="type"/></td>
                <td>
                    <a href='<%=basePath %>cadreentry/updateUser?id=<s:property value="id"/>&name=<s:property value="name"/>&username=<s:property value="username"/>&password=<s:property value="password"/>&type=<s:property value="type"/>' class="FunctionButton">更新</a>
                    <a href='<%=basePath %>cadreentry/deleteUser?id=<s:property value="id"/>' onClick="return delConfirm();"
                       class="FunctionButton">删除</a>
                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>

    <!-- 其他功能超链接 -->
    <div id="TableTail" align="center">
        <div class="FunctionButton"><a href="<%=basePath %>cadreentry/addUser">添加</a></div>
    </div>
</div>
</body>
</html>
