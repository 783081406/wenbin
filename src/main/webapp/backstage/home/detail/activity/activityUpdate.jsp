<%--
  Created by IntelliJ IDEA.
  活动信息更新
  User: ccjjltx
  Date: 2018/2/18
  Time: 21:51
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
    <title>活动信息Update</title>
    <meta charset="utf-8">
    <meta name="description" content="活动信息Update">
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
                 src="<%=basePath %>backstage/home/detail/style/images/title_arrow.gif"/> 更新信息
        </div>
    </div>
    <div id="TitleArea_End"></div>
</div>

<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <!-- 表单内容 -->
    <form action="<%=basePath %>activity/saveUpdate" method="post">
        <!-- 本段标题（分段标题） -->
        <div class="ItemBlock_Title">
            <img width="4" height="7" border="0" src="<%=basePath %>backstage/home/detail/style/images/item_point.gif">
            干部信息&nbsp;
        </div>
        <!-- 本段表单字段 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <div class="ItemBlock2">
                    <table cellpadding="0" cellspacing="0" class="mainForm">
                        <tr>
                            <td width="80px">活动名称</td>
                            <td>
                                <input type="text" name="name" class="InputStyle" value="${name}"/> *
                                <input type="hidden" name="aid" value="${aid}"/>
                            </td>
                        </tr>
                        <tr>
                            <td width="80px">地点</td>
                            <td>
                                <input type="text" name="place" class="InputStyle" value="${place}"/> *
                            </td>
                        </tr>
                        <tr>
                            <td width="80px">时间从</td>
                            <td>
                                <input type="text" name="stime" class="InputStyle" value="${stime}"/> *
                            </td>
                        </tr>
                        <tr>
                            <td width="80px">时间至</td>
                            <td>
                                <input type="text" name="etime" class="InputStyle" value="${etime}"/> *
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>

        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="submit" value="修改" class="FunctionButtonInput">
            <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
        </div>

    </form>
</div>
</body>
</html>
