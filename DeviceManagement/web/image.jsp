<%-- 
    Document   : image
    Created on : Mar 22, 2020, 1:09:04 PM
    Author     : Ngoc Cuong
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Image Page</title>
    </head>
    <body>
        <%@include file="sidebarUser.jsp" %>
            <%@include file="header.jsp" %>
        <h1>Device ${requestScope.DEVICE}</h1> <br/>
        <s:iterator value="listImage" var="dto">
        <tr>
        <img src=' <s:property value="%{#dto.linkImage}"/>' style="height: 300px; image-rendering: pixelated" alt="ManHinh" />
    </tr>
</s:iterator>
<br/>
<div><s:a href="user.jsp"> Back </s:a></div>
<%@include file="footer.jsp" %>
</body>
</html>
