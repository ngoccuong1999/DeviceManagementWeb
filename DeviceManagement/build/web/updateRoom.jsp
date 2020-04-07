<%-- 
    Document   : updateRoom
    Created on : Mar 24, 2020, 10:04:26 AM
    Author     : Ngoc Cuong
--%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Room Page</title>
    </head>
    <body>
        <%@include file="sidebar.jsp" %>
            <%@include file="header.jsp" %>
        <h1>
            <font color="red">Hello ${sessionScope.USER}
            </font>
        </h1>
            <h2>Update Room Page</h2>
            <s:a action="CrudRoomAction">Back</s:a> <br/>
        <br/>
        <br/>
        <s:form name="UpdateRoomAction" action="UpdateRoomAction" method="POST" >
            <s:submit  value="Update" /> 
            <br/>
            <table border="1">
                <thead>
                    <tr>
                        <th>id</th>
                        <th>Device Room Name</th>
                    </tr>
                </thead>
                <tbody>

                    <tr>
                        <td><s:property value="devRoom.id" />
                            <input type="hidden" name="id1" value="<s:property value="devRoom.id"/>"/>
                        </td>
                        <td>
                            <input type="text" name="deviceRoomName" value="<s:property value="devRoom.name"/>"  required />
                        </td>
                    </tr>

                </tbody>
            </table><br/>
            
        </s:form>
            <%@include file="footer.jsp" %>
    </body>
</html>
