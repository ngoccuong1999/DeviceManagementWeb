<%-- 
    Document   : error.jsp
    Created on : Mar 21, 2020, 7:52:44 PM
    Author     : Ngoc Cuong
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR Page</title>
    </head>
    <body>
        <h1>
            <font color="red">
            ${sessionScope.ERROR};
            </font>
        </h1>
    </body>
</html>
