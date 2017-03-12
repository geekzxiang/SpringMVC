<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<a href="/demosite">返回首页</a>
<form action="loggedInUser" method="post">
    <p>
        <label>getLoggedInUser 返回当前登录用户的用户名、用户uid、用户头像</label>
    </p>
    <p>
        <a href="http://developer.baidu.com/wiki/index.php?title=Open_API%E6%96%87%E6%A1%A3/passport/users/getLoggedInUser">参考文档</a>
    </p>
    <p>
        <input type="submit" value="测试"/>
    </p>
</form>
<form action="userInfo" method="post">
    <p>
        <label>getIndfo 返回用户的指定信息</label>
    </p>
    <p>
        <a href="http://developer.baidu.com/wiki/index.php?title=Open_API%E6%96%87%E6%A1%A3/passport/users/getInfo">参考文档</a>
    </p>
    <p>
        <label for="uid">uid,为空默认当前用户</label>
        <input type="text" name="uid" id="uid"/>
    </p>
    <p>
        <label for="fields">用户信息列表,为空则返回用户全部信息,多个列表用','分离</label>
        <input type="text" name="fields" id="fields"/>
    </p>

    <input type="submit" value="测试"/>
</form>
<a href="/demosite">返回首页</a>
</body>
</html>