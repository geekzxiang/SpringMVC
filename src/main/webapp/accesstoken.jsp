<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>access_token信息展示</title>
</head>
<body>
	<h2>access_token 信息展示</h2>
	 	<div class="wrapper">
			<ul>
				<li>
				   access_token:<br/>
				   <p>${accessToken }</p>
				</li>
				<li>
					refresh_token：<br/>	
					<p>${refreshToken }</p>
				</li>
				<li>
					session_secret: <br/>
					<p>${sessionSecret}</p>
				</li>
				<li>
					session_key: <br/>
					<p>${sessionKey}</p>
				</li>
			</ul>
		</div>
	
		<c:if test="${!empty user}">
			<ul>
				<li>
				   uid:<br/>
				   <p>${user.uid}</p>
				</li>
				<li>
					uname:：<br/>	
					<p>${user.uname}</p>
				</li>
				<li>
					portrait: <br/>
					<p>${user.portrait}</p>
				</li>
			</ul>
		</c:if>
	<a href="/demosite">返回首页</a>

</body>
</html>