<%-- 
    Document   : detailPosition
    Created on : Mar 22, 2020, 12:06:08 PM
    Author     : Ngoc Cuong
--%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%--<s:head/>--%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail Position Page</title>
    </head>
    <body>
        <%@include file="sidebarUser.jsp" %>
        <%@include file="header.jsp" %>
        <h1>Device ${requestScope.DEVICE}</h1> <br/>
        <h2>Lịch sử vị trí </h2>
        <s:if test="%{listPosition.size > 0}">
            <table border="1">
                <thead>
                    <tr>
                        <th>Thứ tự</th>
                        <th>Người chuyển</th>
                        <th>Thời gian chuyển</th>
                        <th>Lí do chuyển</th>
                        <th>Chuyển đến phòng nào</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="listPosition" var="dto">
                        <tr>
                            <td><s:property value="%{#dto.no}" /></td>
                            <td><s:property value="%{#dto.userId.username}" /></td>
                            <td>
                                <s:property value="%{#dto.changeTime}"/>
                            </td>
                            <td><s:property value="%{#dto.changeReason}" /></td>
                            <td>Phòng <s:property value="%{#dto.deviceRoomId.id}" /></td>
                        </tr>
                    </s:iterator>
                <br/>
                <div><s:a href="user.jsp"> Back </s:a></div>

                </tbody>
            </table>
    </s:if> 
    <s:else>
        Thiết bị này chưa được chuyển đi lần nào!!!
        <div><s:a href="user.jsp"> Back </s:a></div>
    </s:else>
    <%@include file="footer.jsp" %>
</body>
</html>
