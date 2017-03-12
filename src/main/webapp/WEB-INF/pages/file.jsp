<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h2>OpenApi 调用演示</h2>
<c:forEach var="file" items="${fileList}">
    <%--用EL表达式调用list对象的属性循环输出对象的各个属性值--%>
    <a href="/demosite/apk/${file}">${file}<a/><br/>
</c:forEach>
</html>