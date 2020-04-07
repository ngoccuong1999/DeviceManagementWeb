<%-- 
    Document   : updateDevice
    Created on : Mar 22, 2020, 8:30:35 PM
    Author     : Ngoc Cuong
--%>

<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update User Page</title>
        <!--        <script type="text/javascript">
                    function validateForm() {
                        var myForm = document.forms["UpdateUserAction"];
                        var role = myForm["role"].value;
                        if(role != "Admin" || role != "User" || role != "Staff") {
                            alert("Chỉ được nhập Admin , User , Staff");
                            myForm["role"].focus();
                            return false;
                        }
                        return true;
                    }
                </script>-->
    </head>
    <body>
        <%@include file="sidebar.jsp" %>
            <%@include file="header.jsp" %>
        <h1>
            <font color="red">Hello ${sessionScope.USER}
            </font>
        </h1>
        <h2>Update Device Page</h2>
        <s:a action="CrudDeviceAction">Back</s:a> <br/>
        <br/>
        <br/>
        <s:form name="UpdateDeviceAction" action="UpdateDeviceAction" method="POST" >
            <s:submit  value="Update" /> 
            <br/>
            <table border="1">
                <thead>
                    <tr>
                        <th>id</th>
                        <th>Device Name</th>
                        <th>Device Description</th>
                        <th>Device Type</th>
                        <th>Device Room Id</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>

                    <tr>

                        <td><s:property value="dev.id" />
                            <input type="hidden" name="id1" value="<s:property value="dev.id"/>"/>
                        </td>
                        <td>
                            <input type="text" name="deviceName" value="<s:property value="dev.deviceName"/>"  required />
                        </td>
                        <td>
                            <input type="text" name="deviceDescription" value="<s:property value="dev.deviceDescription"/>" required />
                        </td>
                        <td>
                            <input type="text" name="deviceType" value="<s:property value="dev.deviceType"/>" required/>
                        </td>
                        <td>
                            <input type="text" name="deviceRoomId" pattern="[0-9]+" value="<s:property value="dev.deviceRoomId.id"/>" title="Có ít nhất 1 số"  required />
                            Change Reason: <input type="text" name="changeReason"  />
                        </td>
                        <td>
                            <input type="text" name="deviceStatus" value="<s:property value="dev.status"/>" pattern="[0-3]+" title="Chỉ được nhập từ 0 - 3. 0 là đang sử dụng, 1 là đang sửa chữa, 2 bị hư, 3 đã xoá" required />
                        </td>

                    </tr>

                </tbody>
            </table><br/>
            
        </s:form>
        <%@include file="footer.jsp" %>
    </body>
</html>

