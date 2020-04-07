<%-- 
    Document   : updateUser
    Created on : Mar 22, 2020, 4:38:35 PM
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
        <h2>Update</h2>
        <s:form name="UpdateUserAction" action="UpdateUserAction" method="POST" >
            <table border="1">
                <thead>
                    <tr>
                        <th>Username</th>
                        <th>Password</th>
                        <th>Full Name</th>
                        <th>Phone_number</th>
                        <th>Device Room Id</th>
                        <th>Role</th>
                    </tr>
                </thead>
                <tbody>

                    <tr>

                        <td><s:property value="usi.username" />
                            <input type="hidden" name="username1" value="<s:property value="usi.username"/>"/>
                        </td>
                        <td>
                            <input type="text" name="password" value="<s:property value="usi.password"/>"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                                   title="Có ít nhất 8 kí tự, ít nhất một chữ hoa, ít nhất một chữ thường" />
                        </td>
                        <td>
                            <input type="text" name="fullName" value="<s:property value="usi.fullName"/>" required />
                        </td>
                        <td>
                            <input type="text" name="phoneNumber" value="<s:property value="usi.phoneNumber"/>" pattern="[0-9]{6,11}" title="Số điện thoại có 6 - 11 số" required/>
                        </td>
                        <td>
                            <input type="text" name="deviceRoomId" pattern="[0-9]+" value="<s:property value="usi.deviceRoomId.id"/>" title="Có ít nhất 1 số"  required />
                        </td>
                        <td>
                            <input type="text" name="role" value="<s:property value="usi.role"/>" pattern="[1-3]+" title="Chỉ được nhập từ 1 - 3. 1 là user, 2 là staff và 3 là admin " required />
                        </td>

                    </tr>

                </tbody>
            </table>
            
            <s:submit  value="Update" />
        </s:form>
<%@include file="footer.jsp" %>
    </body>
</html>
