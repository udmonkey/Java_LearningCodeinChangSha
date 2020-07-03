<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>高级查询</title>
    <link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet"/>
</head>
<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"></td>
    </tr>
</table>
<table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
    <tr>
        <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
        <td width="44%" align="left">[员工管理]</td>
        <td width="52%" align="right">
            <a href="javascript:document.forms[0].submit()">
                <img src="${pageContext.request.contextPath}/images/button/save.gif"/></a>
            <a href="javascript:history.back()">
                <img src="${pageContext.request.contextPath}/images/button/tuihui.gif"/></a>
        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>
</table>
<!--员工新增的表单-->
<form action="${pageContext.request.contextPath}/users?method=findByCondition" method="post" >
    <table width="88%" border="0" class="emp_table" style="width:80%;">
        <tr>
            <td width="10%">姓名：</td>
            <td width="20%"><input type="text" name="searchName"/></td>
            <td width="10%">年龄：</td>
            <td width="20%">
                <select name="searchAge01">
                    <option>0</option>
                    <option>10</option>
                    <option>20</option>
                    <option>30</option>
                </select>岁
                ~
                <select name="searchAge02">
                    <option>10</option>
                    <option>20</option>
                    <option>30</option>
                </select>岁
            </td>

        </tr>
    </table>
</form>
</body>
</html>

