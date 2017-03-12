<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="js/LightFace.css">
<style>
body {
	font-family: 'Lucida Grande', Verdana, Arial, sans-serif;
}

h1 a {
	text-decoration: none;
	color: #3b5998;
}

h1 a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<input type="hidden" name="user" id="user" value="${user}" />
	<input type="hidden" name="loginUrl" id="loginUrl" value="${loginUrl }" />
    <input type="hidden" name="loginOutUrl" id="loginOutUrl" value="${loginOutUrl }" /> 

	<c:choose>
		<c:when test="${!empty user }">
			<div>
			Login using OAuth 2.0 handled by the JAVA SDK:
			<a id="logoutfrombaidu" href="${loginOutUrl }" >Logout</a>
			</div>
		</c:when>
		<c:otherwise>
				 <a id="loginwithbaidu" href="${loginUrl}" >Login with Baidu</a>
		</c:otherwise>
	</c:choose>

	<c:choose>
		<c:when test="${!empty user }">
			 Current User:
			    <p>${user}</p>
		</c:when>
		<c:otherwise>
			<strong><em>You are not Connected.</em></strong>
		</c:otherwise>
	</c:choose>
	<a href="userService">用户信息类接口调试</a>
	<div id="logindialog"></div>

	<script type="text/javascript" src="js/mootools-1.3.js"></script>
	<script type="text/javascript" src="js/LightFace.js"></script>
	<script type="text/javascript" src="js/LightFace.IFrame.js"></script>
	<script type="text/javascript">
		var user = document.getElementById("user").value;
		var loginUrl = document.getElementById("loginUrl").value;
		//alert(user);
		var loginOutUrl = document.getElementById("loginOutUrl").value;
		if (user == null||user=="") {
			document.id('loginwithbaidu').addEvent('click',function() {
		    	new LightFace.IFrame({height:320, width:560, url: loginUrl}).open();
		    });
		    new LightFace.IFrame({height:320, width:560, url: loginUrl}).open();
		}else{
			 document.id('logoutfrombaidu').addEvent('click', function() {
					document.getElementById('logout_form').submit();
					return false;
			    });
		}
	</script>
	 <script>
 		 baidu.app.autoHeight();
  		 baidu.app.setHeight(400);
  </script>

</body>
</html>