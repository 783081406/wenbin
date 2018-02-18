<%--
  Created by IntelliJ IDEA.
  活动信息》评分
  User: ccjjltx
  Date: 2018/2/18
  Time: 21:27
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
    <title>评分</title>
    <meta charset="utf-8">
    <meta name="description" content="评分">
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
                 src="<%=basePath %>backstage/home/detail/style/images/title_arrow.gif"/> 活动评分
        </div>
    </div>
    <div id="TitleArea_End"></div>
</div>

<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <table class="MainArea_Content" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
        <tr align="center" valign="middle" id="TableTitle">
            <td>编号</td>
            <td>参与人员名称</td>
            <td>评分</td>
            <td>操作</td>
        </tr>
        </thead>
        <!--显示数据列表 -->
        <tbody id="TableData">
        <s:iterator value="result2" status="si">
            <tr class="TableDetail1">
                <td align="center"><s:property value="#si.index"/>&nbsp;</td>
                <td align="center"><s:property value="user.name"/>&nbsp;</td>
                <td align="center"><s:property value="score"/></td>
                <td>
                    <a href='<%=basePath %>grade/getThisActivityUpdate?aid=<s:property value="activity.aid"/>&gid=<s:property value="gid"/>&name=<s:property value="user.name"/>&score=<s:property value="score"/>'
                       class="FunctionButton">更新</a>
                    <a href='<%=basePath %>grade/getThisActivitydelete?aid=<s:property value="activity.aid"/>&gid=<s:property value="gid"/>' onClick="return delConfirm();" class="FunctionButton">删除</a>
                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
</div>
</body>
</html>
