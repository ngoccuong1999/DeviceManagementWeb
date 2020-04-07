<%-- 
    Document   : updateDeviceSuccess
    Created on : Mar 22, 2020, 9:09:47 PM
    Author     : Ngoc Cuong
--%>

<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Device Successfully!!</title>
    </head>
    <body>
        <%@include file="sidebar.jsp" %>
            <%@include file="header.jsp" %>
        <h1>Update Device Successfully!!</h1>
        <s:a action="CrudDeviceAction">back</s:a>
        <%@include file="footer.jsp" %>
    </body>
</html>
