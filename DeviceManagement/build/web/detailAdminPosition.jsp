<%-- 
    Document   : detailAdminPosition
    Created on : Mar 24, 2020, 9:23:25 AM
    Author     : Ngoc Cuong
--%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail Position Page</title>
    </head>
    <body>
        <%@include file="sidebar.jsp" %>
            <%@include file="header.jsp" %>
        <h1>
            <font color="red">Hello ${sessionScope.USER}
            </font> 
        </h1> <br/>
        <h2>Device ${requestScope.DEVICE}</h2> <br/>
        <h3>Lịch sử vị trí </h3>
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
            <div><s:a action="CrudDeviceAction">back</s:a></div>
            <%@include file="footer.jsp" %>
    </body>
</html>
