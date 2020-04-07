<%-- 
    Document   : crudRoom
    Created on : Mar 24, 2020, 9:55:41 AM
    Author     : Ngoc Cuong
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crud Device Room Page</title>
    </head>
    <body>
        <%@include file="sidebar.jsp" %>
            <%@include file="header.jsp" %>
        <h1>
            <font color="red">Hello ${sessionScope.USER}
            </font>
        </h1>
        <s:if test="%{listDeviceRoom != null}">
            <s:if test="%{listDeviceRoom.size > 0}">

                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Id phòng</th>
                            <th>Tên phòng</th>
                            <th>Update</th>
                            <td>Delete</th>

                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator var="dto" value="listDeviceRoom" status="counter">
                            <tr>
                                <td><s:property value="%{#counter.count}" /></td>
                                <td><s:property value="%{#dto.id}" /></td>
                                <td>
                                    <s:property value="%{#dto.name}" />
                                </td>
                                <td>

                                    <s:url action="DetailRoomAction" var="updateLink">
                                        <s:param name="id" value="%{#dto.id}" />
                                    </s:url>
                                    <s:a href="%{updateLink}">Update</s:a>
                                    </td>
                                    <td>
                                    <s:url action="DeleteRoomAction" var="deleteLink">
                                        <s:param name="id" value="%{#dto.id}" />
                                    </s:url>
                                    <s:a href="%{deleteLink}">Delete</s:a>
                                    </td>
                                </tr>
                        </s:iterator>
                    </tbody>
                </table>

            </s:if>

        </s:if>
        <br/>
        <br/>
        <a href="createRoom.jsp">Create New Room</a> <br/>
        <a href="admin.jsp">Back</a>
        <%@include file="footer.jsp" %>
    </body>
</html>
