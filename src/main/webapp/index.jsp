<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h2>OpenApi 调用演示</h2>
<form action="oauthCode" method="post">
    <label>OAuth2.0授权流程：</label>
    <p>
        OAuth2.0授权流程，应用发起请求，通过用户授权后得到授权码，应用通过授权码进一步获取access_token,并将得到的Token信息存储在cookie中。
    </p>
    <p>
        <input type="submit" value="获取用户授权"/>
    </p>
</form>
<p>应用权限解绑</p>
<p style="color:red">
    到passport.baidu.com进行解绑（个人资料设置------》账号关联），取消对相关应用的授权
</p>
<p style="color:red">请先调用用户授权后在调用用户信息类接口</p>
<a href="/demosite/userService">用户信息类接口调试</a>
</body>
</html>