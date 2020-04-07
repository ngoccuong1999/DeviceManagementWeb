<%-- 
    Document   : crudDevice
    Created on : Mar 22, 2020, 7:48:24 PM
    Author     : Ngoc Cuong
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crud Device Page</title>
    </head>
    <body>
        <%@include file="sidebar.jsp" %>
            <%@include file="header.jsp" %>
        <h1>
            <font color="red">Hello ${sessionScope.USER}
            </font>
            
        </h1>
        <s:if test="%{listDevice != null}">
            <s:if test="%{listDevice.size > 0}">

                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>id</th>
                            <th>Device Name</th>
                            <th>Device Description</th>

                            <th>Time Buy</th>
                            <th>Warranty Period</th>
                            <th>Device Room Id</th>
                            <th>Device Type</th>
                            <th>Status</th>
                            <th>Vị trí</th>
                            <th>Update</th>
                            <td>Delete</th>

                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator var="dto" value="listDevice" status="counter">
                            <tr>
                                <td><s:property value="%{#counter.count}" /></td>
                                <td><s:property value="%{#dto.id}" /></td>
                                <td>
                                    <s:property value="%{#dto.deviceName}" />


                                </td>
                                <td><s:property value="%{#dto.deviceDescription}" /></td>
                                <td>
                                    <s:property value="%{#dto.timeBuy}" />
                                </td>
                                <td>
                                    <s:property value="%{#dto.warrantyPeriod}" />
                                </td>
                                <td>Phòng <s:property value="%{#dto.deviceRoomId.id}"/></td>
                                <td>
                                    <s:property value="%{#dto.deviceType}" />
                                </td>
                                <td>
                                    <s:if test="%{#dto.status == 0}">
                                        <div>Còn tốt, đang sử dụng</div>
                                    </s:if> 
                                    <s:elseif test="%{#dto.status == 1}">
                                        <div>Đang sửa chữa</div>
                                    </s:elseif>
                                    <s:elseif test="%{#dto.status == 2}">
                                        <div>Đang bị hư</div> <br/>
                                    </s:elseif>
                                    <s:else>
                                        <div>Đã  xoá</div>
                                    </s:else>
                                </td>
                                <td>
                                    <s:url action="PositionAdminAction" var="detailLink">
                                        <s:param name="deviceId" value="%{#dto.id}" />

                                    </s:url>
                                    <s:a href="%{detailLink}">Detail</s:a>
                                    </td>
                                    <td>
                                    <s:if test="%{#dto.status == 3}">
                                        <div>Đã xoá không thể update  </div>
                                    </s:if> <s:else>
                                        <s:url action="DetailDeviceAction" var="updateLink">
                                            <s:param name="id" value="%{#dto.id}" />
                                        </s:url>
                                        <s:a href="%{updateLink}">Update</s:a>
                                    </s:else>
                                </td>
                                <td>
                                    <s:if test="%{#dto.status == 3}">
                                        <div>Đã xoá </div>
                                    </s:if> <s:else>
                                        <s:url action="DeleteDeviceAction" var="deleteLink">
                                            <s:param name="id" value="%{#dto.id}" />
                                        </s:url>
                                        <s:a href="%{deleteLink}">Delete</s:a>
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
        <a href="createDevice.jsp">Create New Device</a> <br/>
        <a href="admin.jsp">Back</a>
        <%@include file="footer.jsp" %>
    </body>
</html>
