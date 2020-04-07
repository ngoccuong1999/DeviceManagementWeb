<%-- 
    Document   : createRoom
    Created on : Mar 24, 2020, 3:16:14 PM
    Author     : Ngoc Cuong
--%>

<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>Create Room</title>
        <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans:600'><link rel="stylesheet" href="./css/style1.css">
        <!--        <script type="text/javascript">
                    function validateForm() {
                        var myForm = document.forms["CreateUserAction"];
                        var repeatPassword = myForm["repeatPassword"].value;
                        var password = myForm["password"].value;
                        if (repeatPassword !== password) {
                            alert("RepeatPassword khác password. Vui lòng nhập lại!!!");
                            myForm["password"].focus();
                            return false;
                        }
                        return true;
                    }
                </script>-->
    </head>
    <body>
        <div class="login-wrap">
            <div class="login-html">
                <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Create Room</label>
                <input id="tab-1" type="radio" name="tab" class="sign-up"><label for="tab-1" class="tab"></label>

                <div class="login-form">


                    

                        <div class="sign-in-htm">
                            <form name="CreateRoomAction" action="CreateRoomAction" method="POST">
                            <div class="group">
                                <label for="user" class="label">Id</label>
                                <input type="text" required id="user" name="id" class="input" />
                                <%--<s:textfield id="user" name="username"></s:textfield>--%>
                            </div>
                            <div class="group">
                                <label for="pass" class="label">Room Name</label>
                                <input id="pass" type="text" name="roomName" required class="input" >
                            </div>

                            <div class="group">
                                <font color="red">
                                 ${requestScope.INVALID.roomIdError}
                                </font>
                            </div>
                            <div class="group">
                                <input type="submit" class="button" value="Create">
                            </div>
                            <div class="hr"></div>
                            <div class="foot-lnk">
                            </div>
                    </form>
                </div>
                <!--                    <div class="sign-up-htm">
                                        <form name="CreateUserAction" action="CreateUserAction" method="POST" onsubmit="return validateForm()">
                                            <div class="group">
                                                <label for="user" class="label">Username</label>
                                                <input name="username" id="user" required type="text" class="input" >
                                            </div>
                                            <div class="group">
                                                <label for="pass" class="label">Password</label>
                                                <input id="pass" name="password" required type="password" class="input" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                                                       title="Có ít nhất 8 kí tự, ít nhất một chữ hoa, ít nhất một chữ thường" data-type="password" >
                                            </div>
                                            <div class="group">
                                                <label for="pass" class="label">Repeat Password</label>
                                                <input id="pass" name="repeatPassword" type="password" required class="input" data-type="password" >
                                            </div>
                                            <div class="group">
                                                <label for="pass" class="label">Phone Number</label>
                                                <input id="pass" name="phoneNumber" required type="text" class="input" pattern="[0-9]{6,11}" title="Số điện thoại có 6 - 11 số" >
                                            </div>
                                            <div class="group"> 
                                                <label for="pass" class="label">Full Name</label>
                                                <input id="pass" name="fullName" required type="text" required class="input" >
                                            </div>
                
                
                                            <div class="group"> 
                                                <label for="pass" class="label">Role</label>
                                                <input id="pass" name="role" required pattern="[1-3]" title="Chỉ được nhập từ 1 - 3. 1 là user, 2 là staff và 3 là admin " type="text" required class="input" >
                
                                            </div>
                                            <div class="group">
                                                <font color='red'>
                
                </font>
            </div>
            <div class="group">
                <input type="submit" class="button" value="Create User">
            </div>
        </form>
        <div class="hr"></div>

    </div>-->
            </div>
        </div>
    </div>
    <!-- partial -->

</body>
</html>
