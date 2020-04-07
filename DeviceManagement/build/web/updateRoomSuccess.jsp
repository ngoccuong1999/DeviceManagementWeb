<%-- 
    Document   : updateRoomSuccess
    Created on : Mar 24, 2020, 11:52:55 AM
    Author     : Ngoc Cuong
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Room Successfully!!</title>
    </head>
    <body>
        <%@include file="sidebar.jsp" %>
            <%@include file="header.jsp" %>
        <h1>Update Room Successfully!</h1>
        <s:a action="CrudRoomAction">back</s:a>
        <%@include file="footer.jsp" %>
    </body>
</html>
