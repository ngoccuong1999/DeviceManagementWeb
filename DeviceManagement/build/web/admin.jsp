<%-- 
    Document   : admin
    Created on : Mar 21, 2020, 7:52:29 PM
    Author     : Ngoc Cuong
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <s:if test="%{listAnnoucement == null}" >
            <s:action name="LoadAnnoucementAction" executeResult="true"></s:action>
        </s:if> 
        <s:else>
            <%@include file="sidebar.jsp" %>
            <%@include file="header.jsp" %>
            <h1>
                <font color="red">Hello ${sessionScope.USER} 
                </font>
                <
                </h1>
                <div>
                
                </div> <br/>
                <div>
                
                </div> <br/>
                <div>
                
                </div> <br/>

            <s:if test="%{listAnnoucement.size > 0}">

                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Time</th>
                            <th>Content Of Request</th>
                            <th>User Id request</th>
                            <th>Device Id request</th>
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
                            </tr>
                        </s:iterator>
                    </tbody>

                </table>


            </s:if>

        </s:else>
        <%@include file="footer.jsp" %>
    </body>
</html>
