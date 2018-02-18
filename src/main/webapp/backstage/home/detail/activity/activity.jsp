<%--
  Created by IntelliJ IDEA.
  活动信息
  User: ccjjltx
  Date: 2018/2/18
  Time: 13:56
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
    <title>活动信息</title>
    <meta charset="utf-8">
    <meta name="description" content="活动信息">
    <meta name="author" content="ccj">
    <script type="text/javascript" src="<%=basePath %>backstage/home/detail/style/js/jquery.js"></script>
    <script type="text/javascript" src="<%=basePath %>backstage/home/detail/style/js/page_common.js"></script>
    <link href="<%=basePath %>backstage/home/detail/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>backstage/home/detail/style/css/index_1.css"/>
    <!--人员的弹出框css-->
    <style>
        .black_overlay {
            display: none;
            position: absolute;
            top: 0%;
            left: 0%;
            width: 100%;
            height: 100%;
            background-color: black;
            z-index: 1001;
            -moz-opacity: 0.8;
            opacity: .80;
            filter: alpha(opacity=88);
        }

        .white_content {
            display: none;
            position: absolute;
            top: 25%;
            left: 25%;
            width: 30%;
            height: 50%;
            padding: 20px;
            background-color: white;
            z-index: 1002;
            overflow: auto;
        }
    </style>
</head>
<body>

<!-- 页面标题 -->
<div id="TitleArea">
    <div id="TitleArea_Head"></div>
    <div id="TitleArea_Title">
        <div id="TitleArea_Title_Content">
            <img border="0" width="13" height="13"
                 src="<%=basePath %>backstage/home/detail/style/images/title_arrow.gif"/> 活动信息
        </div>
    </div>
    <div id="TitleArea_End"></div>
</div>

<!-- 过滤条件 -->
<div id="QueryArea">
    <form action="<%=basePath %>cadreentry/searchUser" method="get">
        <input type="text" name="name" placeholder="请输入活动名称">
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
            <td>活动名称</td>
            <td>地点</td>
            <td>时间从</td>
            <td>时间至</td>
            <td>策划书</td>
            <td>操作</td>
        </tr>
        </thead>
        <!--显示数据列表 -->
        <tbody id="TableData">
        <s:iterator value="result" status="si">
            <tr class="TableDetail1">
                <td align="center"><s:property value="#si.index"/>&nbsp;</td>
                <td align="center"><s:property value="name"/>&nbsp;</td>
                <td align="center"><s:property value="place"/></td>
                <td align="center"><s:property value="stime"/></td>
                <td align="center"><s:property value="etime"/></td>
                <td align="center"><s:property value="pdfpath"/></td>
                <td>
                    <a href="javascript:void(0)" class="FunctionButton"
                       onclick="document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block';initccj(
                           <s:property value="aid"/>)">人员</a>
                    <a href='<%=basePath %>cadreentry/updateUser' class="FunctionButton">评分</a>
                    <a href='<%=basePath %>cadreentry/deleteUser'
                       onClick="return delConfirm();"
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

<!--人员弹出框-->
<div id="light" class="white_content">左边为未参与人员,右边为参与本次活动人员
    <form method="post" name="myform">
        <table border="0" width="300">
            <tr>
                <td width="40%">
                    <select style="WIDTH:100%" multiple id="list1" name="list1" size="12"
                            ondblclick="moveOption(document.myform.list1, document.myform.list2)">
                    </select>
                </td>
                <td width="20%" align="center">
                    <input type="button" value=" >> "
                           onclick="moveOption(document.myform.list1, document.myform.list2)">
                    <br/>
                    <br/>
                    <input type="button" value=" << "
                           onclick="moveOption(document.myform.list2, document.myform.list1)">
                </td>
                <td width="40%">
                    <select style="WIDTH:100%" multiple id="list2" name="list2" size="12"
                            ondblclick="moveOption(document.myform.list2, document.myform.list1)">
                    </select>
                </td>
            </tr>
        </table>
    </form>
    <br/>
    <a href="javascript:void(0)" class="FunctionButton" onclick="submitccj()">确定</a>
    <a href="javascript:void(0)" class="FunctionButton"
       onclick="document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'">取消</a>
</div>
<div id="fade" class="black_overlay"></div>

<!--人员选择js-->
<script language="JavaScript">
    function moveOption(e1, e2) {
        try {
            for (var i = 0; i < e1.options.length; i++) {
                if (e1.options[i].selected) {
                    var e = e1.options[i];
                    e2.options.add(new Option(e.text, e.value));
                    e1.remove(i);
                    ii = i - 1
                }
            }
            document.myform.city.value = getvalue(document.myform.list2);
        }
        catch (e) {
        }
    }

    function getvalue(geto) {
        var allvalue = "";
        for (var i = 0; i < geto.options.length; i++) {
            allvalue += geto.options[i].value + ",";
        }
        return allvalue;
    }

    var thisaid;
    //初始化弹出框的数据
    function initccj(aid) {
        thisaid=aid;
        $('#list1').empty();
        //获得为参与项目的人员
        $.ajax({
            url: "<%=basePath %>grade/getNoAttendUser?aid=" + aid,
            type: "get",
            dataType: 'json',
            success: function (data) {
                $.each(data, function (key, value) {
                    $("#list1").append("<option value='" + value.id + "'>" + value.name + "</option>");//新增
                });
            }
        });
        $('#list2').empty();
        //获得参与项目的人员
        $.ajax({
            url: "<%=basePath %>grade/getAttenUser?aid=" + aid,
            type: "get",
            dataType: 'json',
            success: function (data) {
                $.each(data, function (key, value) {
                    $("#list2").append("<option value='" + value.id + "'>" + value.name + "</option>");//新增
                });
            }
        });
    }

    //提交人员名单的数据
    function submitccj(){
        var array = new Array();  //定义数组
        $("#list2 option").each(function(){  //遍历所有option
            var txt = $(this).val();   //获取option值
            if(txt!=''){
                array.push(txt);  //添加到数组中
            }
        })
        alert(array);
    }
</script>
</body>
</html>
