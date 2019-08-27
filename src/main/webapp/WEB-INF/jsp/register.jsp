<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/16
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript" src="../../js/jquery-1.7.2.js"></script>
<script>
    $(function () {
        var username = false;
        var password = false;
        var passwordSure = false;
        //用户名验证
        $(":text:eq(0)").blur(function () {
            if($(this).val()==""){
                $(this).next().html("X").css("color","red");
                username = false;
            }else{
                $(this).next().html("✔").css("color","green");
                username = true;
            }
        });
        //密码的验证
        $(":password:eq(0)").blur(function(){
            //在js中要求正则两侧//
            if(!$(this).val().match(/^\w{6,12}$/)){
                $(this).next().css("color","red").html("X");
                password= false;
            }else{
                $(this).next().css("color","green").html("✔");
                password = true;
            }
        });
        //确认密码
        $(":password:eq(1)").blur(function(){
            if($(this).val()==""||$(this).val()!=$(":password:eq(0)").val() || (!$(this).val().match(/^\w{6,12}$/))){
                $(this).next().css("color","red").html("X");
                passwordSure = false;
            }else{
                $(this).next().css("color","green").html("✔");
                passwordSure = true;
            }
        });
        $(":submit").click(function(){
            if(username==false||password==false||passwordSure==false||$(":file").val()==""){
                alert("请添加完整信息");
                return false;
            }
        })
    })
</script>
<body>
${result}
<form action="register" method="post" enctype="multipart/form-data">
    用户名:<input type="text" name="username"><span></span><br/>
    密码:<input type="password" name="password"><span></span><br/>
    重复密码:<input type="password" name="passwordSure"><span></span><br/>
    头像:<input type="file" name="file"><br/>
    <input type="submit" value="注册">
</form>
</body>
</html>
