<%-- 
    Document   : fixingHistory
    Created on : Mar 24, 2020, 6:38:31 PM
    Author     : Ngoc Cuong
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fixing History Page</title>
    </head>
    <body>
        <%@include file="sidebarUser.jsp" %>
        <%@include file="header.jsp" %>
        <h1>Hello <font color="red">${sessionScope.USER}</font>
            <s:a action="LogoutAction">Logout</s:a>
            </h1>
            <h2>Số lần sửa chữa của thiết bị có id: ${requestScope.DEVICEX.id} ${requestScope.DEVICEX.deviceName} là: <s:property value="listDeviceFix.size" /></h2>
        <s:if test="%{listDeviceFix.size > 0}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Id</th>
                        <th>Id thiết bị</th>
                        <th>Tên người gửi</th>
                        <th>Thời gian gửi</th>
                        <th>Nội dung yêu cầu</th>
                        <th>Thời gian bắt đầu sửa chữa</th>
                        <th>Thời gian kết thúc</th>
                        <th>Kết quả</th>
                        <th>Tên người sửa chữa</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="listDeviceFix" var="dto" status="counter">
                        <tr>
                            <td>
                                <s:property value="%{#counter.count}" />
                            </td>
                            <td>
                                <s:property value="%{#dto.id}" />
                            </td>
                            <td>
                                <s:property value="%{#dto.deviceId.id}" />
                            </td>
                            <td>
                                <s:property value="%{#dto.userId.username}" />
                            </td>
                            <td>
                                <s:property value="%{#dto.requestTime}" />
                            </td>
                            <td>
                                <s:property value="%{#dto.requestContent}" />
                            </td>
                            <td>
                                <s:property value="%{#dto.timeFixBegin}" />
                            </td>
                            <td>
                                <s:property value="%{#dto.timeFixFinish}" />
                            </td>
                            <td
                                <s:if test="%{#dto.result == true}" > 
                                    <div>Thành công</div>
                                </s:if> <s:else>
                                    <div>Huỷ Bỏ </div>
                                </s:else>
                        </td>
                        <td>
                            <s:property value="%{#dto.userIdFix.username}" />
                        </td>
                    </tr>
                </tbody>
            </s:iterator>
        </table>

    </s:if>
    <div><s:a href="user.jsp"> Back </s:a></div>
    <%@include file="footer.jsp" %>
</body>
</html>
