<%@ page import="com.ym.pojo.Users" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/16
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            $.post("show",function (data) {
                var result="";
                for(var i=0;i<data.length;i++){
                    result+="<dl>";
                    result+="<dt style='cursor: pointer'>"+data[i].name+"</dt>";
                    for(var j=0;j<data[i].children.length;j++){
                        result+="<dd>"+data[i].children[j].name+"</dd>";
                    }
                    result+="</dl>";
                }
                $("div").html(result+"<a href=\"/logout\">登出</a>");
            });
        });
        $("dt").live("click",function () {
            $(this).siblings().slideToggle(500);
        })
    </script>
</head>
<body>
<% Users users=(Users) session.getAttribute("user");%>
<%=users.getUsername()%>
<div></div>
</body>
</html>
