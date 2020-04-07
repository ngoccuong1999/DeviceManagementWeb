<%-- 
    Document   : user
    Created on : Mar 21, 2020, 4:00:48 PM
    Author     : Ngoc Cuong
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
        <script type="text/javascript">
            function annouceFixing(form) {
                var myForm = document.forms["FixAction"];
                alert("Đã báo nhân viên sửa chữa thành công");
                myForm["content"].focus();

                return true;
            }
        </script>
    </head>
    <body>

        <s:if test="%{listDevice == null}" >
            <s:action name="LoadDeviceUserAction" executeResult="true"></s:action>
        </s:if>
        <s:else>
            <%@include file="sidebarUser.jsp" %>
            <%@include file="header.jsp" %>
            <h1>Hello <font color="red">${sessionScope.USER}</font>
                </h1>
            <s:if test="%{listDevice.size > 0}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>ID</th>
                            <th>Tên thiết bị</th>
                            <th>Mô tả thiết bị</th>
                            <th>Loại thiết bị</th>
                            <th>Vị trí</th>
                            <th>Image</th>
                            <th>Ngày mua</th>
                            <th>Thời gian bảo hành</th>
                            <th>Số lần sửa chữa</th>
                            <th>Trạng thái thiết bị</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator var="dto" value="listDevice" status="counter">
                            <tr>
                                <td><s:property value="%{#counter.count}" /></td>
                                <td>
                                    <s:property value="%{#dto.id}" />
                                </td>
                                <td>
                                    <s:property value="%{#dto.deviceName}" />
                                </td>
                                <td>
                                    <s:property value="%{#dto.deviceDescription}" />
                                </td>
                                <td>
                                    <s:property value="%{#dto.deviceType}" />
                                </td>
                                <td>
                                    <div>Đang ở phòng <s:property value="%{#dto.deviceRoomId.id}" /></div>
                                    <s:url action="PositionAction" var="detailLink">
                                        <s:param name="deviceId" value="%{#dto.id}" />

                                    </s:url>
                                    <s:a href="%{detailLink}">Detail</s:a>
                                    </td>

                                    <td>
                                    <s:url action="ImageAction" var="imageLink">
                                        <s:param name="deviceId" value="%{#dto.id}" />

                                    </s:url>
                                    <s:a href="%{imageLink}">Image</s:a>
                                    </td>
                                    <td>
                                    <s:property value="%{#dto.timeBuy}" />
                                </td>
                                <td>
                                    <s:property value="%{#dto.warrantyPeriod}" />
                                </td>
                                <td>
                                    <s:url action="FixHistoryAction" var="historyLink">
                                        <s:param name="deviceId" value="%{#dto.id}" />

                                    </s:url>
                                    <s:a href="%{historyLink}">Detail</s:a>
                                    </td>
                                    <td>
                                    <s:if test="%{#dto.status == 0}">
                                        <div>Còn tốt, đang sử dụng</div>
                                        <s:form name="FixAction" action="FixAction" method="POST" onsubmit="return annouceFixing(this)">
                                            Thông tin hư hại: <input type="text" name="content" required/>
                                            <s:hidden name="deviceId"  value="%{#dto.id}" />
                                            <s:hidden name="usernameLogin" value="%{#session.user}" />
                                            <s:hidden name="listDevice" value="%{#listDevice}" />
                                            <s:submit value="Báo cho nhân viên sửa chữa" />
                                        </s:form>
                                    </s:if> 
                                    <s:elseif test="%{#dto.status == 1}">
                                        <div>Đang sửa chữa</div>
                                    </s:elseif>
                                    <s:elseif test="%{#dto.status == 2}">
                                        <div>Đang bị hư</div> <br/>
                                        <s:form name="FixAction" action="FixAction" method="POST" onsubmit="return annouceFixing(this)">
                                            <s:hidden name="deviceId"  value="%{#dto.id}" />
                                            <s:hidden name="usernameLogin" value="%{#session.user}" />
                                            Thông tin hư hại:<input type="text" name="content" required/>
                                            <s:hidden name="listDevice" value="%{#listDevice}" />
                                            <s:submit value="Báo cho nhân viên sửa chữa" />
                                        </s:form>

                                    </s:elseif>
                                    <s:else>
                                        <div>Đã  xoá</div>
                                    </s:else>
                                </td>
                            </tr>
                        </s:iterator>
                    </s:if>
                <br/>

            </tbody>
        </table>
    </s:else>
        <%@include file="footer.jsp" %>
</body>
</html>
