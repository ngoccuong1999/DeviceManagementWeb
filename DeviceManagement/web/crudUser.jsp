<%-- 
    Document   : crudUser
    Created on : Mar 22, 2020, 3:57:11 PM
    Author     : Ngoc Cuong
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD User Page</title>
    </head>
    <body>
        <%@include file="sidebar.jsp" %>
            <%@include file="header.jsp" %>
        <h1>
            <font color="red">Hello ${sessionScope.USER}
            </font>
           
        </h1>
        <s:if test="%{listUser != null}">
            <s:if test="%{listUser.size > 0}">

                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Full Name</th>
                            <th>Phone_number</th>
                            <th>Online</th>
                            <th>Device Room Id</th>
                            <th>Role</th>
                            <th>Update</th>
                            <td>Delete</th>

                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator var="dto" value="listUser" status="counter">
                            <tr>
                                <td><s:property value="%{#counter.count}" /></td>
                                <td><s:property value="%{#dto.username}" /></td>
                                <td><s:if test="%{#dto.role < 3}">
                                        <s:property value="%{#dto.password}" />
                                    </s:if>
                                    <s:else>
                                        <div>*********</div>
                                    </s:else>
                                </td>
                                <td><s:property value="%{#dto.fullName}" /></td>
                                <td>
                                    <s:property value="%{#dto.phoneNumber}" />
                                </td>
                                <td>
                                    <s:if test="%{#dto.username == userLogin}" >
                                        <div>Online</div>
                                    </s:if>
                                    <s:else>
                                        <div>Offline</div>
                                    </s:else>
                                </td>
                                <td>Phòng <s:property value="%{#dto.deviceRoomId.id}"/></td>
                                <td>
                                    <s:if test="%{#dto.role == 1}">
                                        <div>User</div>
                                    </s:if>
                                    <s:elseif test="%{#dto.role == 2}">
                                        <div>Staff Fixing</div>
                                    </s:elseif>
                                    <s:else>
                                        <div>Admin</div>
                                    </s:else>
                                </td>
                                <td>
                                    <s:if test="%{#dto.role < 3 or #dto.username == userLogin}">
                                        <s:url action="DetailUserAction" var="updateLink">
                                            <s:param name="username" value="%{#dto.username}" />
                                        </s:url>
                                        <s:a href="%{updateLink}">Update</s:a>
                                    </s:if> <s:else>
                                        <div>Không đủ quyền để update admin</div>
                                    </s:else>
                                </td>
                                <td>
                                    <s:if test="%{#dto.role < 3 or #dto.username == userLogin}">
                                        <s:url action="DeleteUserAction" var="deleteLink">
                                            <s:param name="username" value="%{#dto.username}" />
                                        </s:url>
                                        <s:a href="%{deleteLink}">Delete</s:a>
                                    </s:if> <s:else>
                                        <div>Không đủ quyền để delete </div>
                                    </s:else>
                                </td>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>

            </s:if>

        </s:if>
            <br/>
            <br/>
            <a href="createUser.jsp">Create New User</a> <br/>
        <a href="admin.jsp">Back</a>
        <%@include file="footer.jsp" %>
    </body>
</html>
