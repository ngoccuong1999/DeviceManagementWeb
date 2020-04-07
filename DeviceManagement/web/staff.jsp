<%-- 
    Document   : staff
    Created on : Mar 21, 2020, 7:52:37 PM
    Author     : Ngoc Cuong
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff Fixing Page</title>
    </head>
    <body>
        <s:if test="%{listAnnoucement == null}" >
            <s:action name="LoadFixAction" executeResult="true"></s:action>
        </s:if> 
        <s:else>
            <%@include file="sidebarUser.jsp" %>
            <%@include file="header.jsp" %>
            <h1>
                <font color="red">Hello ${sessionScope.USER} 
                </font>
                </h1>

            <s:if test="%{listAnnoucement.size > 0}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Time</th>
                            <th>Content Of Request</th>
                            <th>User Id request</th>
                            <th>Device Id request</th>
                            <th>Status Device</th>
                            <th>Fix Status</th>
                            
                        </tr>
                    </thead>

                    <tbody>

                        <s:iterator value="listAnnoucement" var="dto" status="counter"> 
                            <tr>
                                <td><s:property value="%{#counter.count}" /></td>
                                <td><s:property value="%{#dto.time}" /></td>
                                <td><s:property value="%{#dto.annoucementContent}" /></td>
                                <td><s:property value="%{#dto.userIdRequest}" /></td>
                                <td><s:property value="%{#dto.deviceIdRequest}" /></td>
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
                                    <s:form action="FixingAction" method="POST">
                                        <select name="fixStatus">
                                            <option value="fixing" selected="true">Fixing</option>
                                            <option value="done">Done</option>
                                            <option value="cancel">Cancel</option>
                                        </select>
                                        <s:hidden name="id" value="%{#dto.id}" />
                                        <s:hidden name="time" value="%{#dto.time}" />
                                        <s:hidden name="annoucementContent" value="%{#dto.annoucementContent}" />
                                        <s:hidden name="userIdRequest" value="%{#dto.userIdRequest}" />
                                        <s:hidden name="deviceIdRequest" value="%{#dto.deviceIdRequest}" />
                                        <s:if test="%{#dto.status == 2}">
                                            <s:submit value="Submit" />
                                        </s:if> <s:else>
                                            <div>Thiết bị còn tốt hoặc đang sửa chữa không thể sửa </div>
                                        </s:else>
                                    </s:form> 
                                </td>
                            </tr> 

                        </s:iterator>
                    </tbody>

                </table>


            </s:if>

        </s:else>
        <%@include file="footer.jsp" %>
    </body>
</html>
