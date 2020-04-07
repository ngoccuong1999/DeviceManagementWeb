<%-- 
    Document   : constrainRoom
    Created on : Mar 24, 2020, 4:07:36 PM
    Author     : Ngoc Cuong
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Constrain Room Page</title>
    </head>
    <body>
        <%@include file="sidebar.jsp" %>
            <%@include file="header.jsp" %>
        <h1>
            <font color="red">Hello ${sessionScope.USER}
            </font>
            
        </h1>
        <h2>Không thể xoá phòng này bởi vì còn các thực thể sau trong phòng</h2>
        <s:if test="%{listUserInfo.size > 0}">
            User:
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Username</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="listUserInfo" var="dto" status="counter">
                        <tr>
                            <td><s:property value="%{#counter.count}" /></td>
                            <td><s:property value="%{#dto.username}" /></td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>

        </s:if>
        <s:if test="%{listDeviceN.size > 0}">
            Device:
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Id</th>
                        <th>Device Name</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="listDeviceN" var="dto" status="counter">
                        <tr>
                            <td><s:property value="%{#counter.count}" /></td>
                            <td><s:property value="%{#dto.id}" /></td>
                            <td><s:property value="%{#dto.deviceName}" /></td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>

        </s:if>
        <s:if test="%{listDevicePosition.size > 0}">
            Device Position:
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Id</th>
                        <th>Device Id</th>
                        <th>Username</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="listDevicePosition" var="dto" status="counter">
                        <tr>
                            <td><s:property value="%{#counter.count}" /></td>
                            <td><s:property value="%{#dto.id}" /></td>
                            <td><s:property value="%{#dto.deviceId.id}" /></td>
                            <td><s:property value="%{#dto.userId.username}" /></td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>

        </s:if>
        <s:a action="CrudRoomAction">back</s:a>
        <%@include file="footer.jsp" %>
    </body>
</html>
