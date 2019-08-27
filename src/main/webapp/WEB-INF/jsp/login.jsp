<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${msg}
<form action="login" method="post">
    用户名:<input type="text" name="username"><span></span><br/>
    密码:<input type="password" name="password"><span></span><br/>
    <input type="submit" value="登录"><a href="toregister">注册</a>
</form>
</body>
</html>
