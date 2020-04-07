<%-- 
    Document   : login
    Created on : Mar 21, 2020, 8:55:10 AM
    Author     : Ngoc Cuong
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>Login </title>
        <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans:600'><link rel="stylesheet" href="./css/style1.css">
        <script type="text/javascript">
            function validateForm() {
                var myForm = document.forms["SignUpAction"];
                var repeatPassword = myForm["repeatPassword"].value;
                var password = myForm["password"].value;
                if(repeatPassword !== password) {
                    alert("RepeatPassword khác password. Vui lòng nhập lại!!!");
                    myForm["password"].focus();
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body>
        <!-- partial:index.partial.html -->
        <div class="login-wrap">
            <div class="login-html">
                <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Sign In</label>
                <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>

                <div class="login-form">


                    <form action="LoginAction" method="POST">

                        <div class="sign-in-htm">
                            <div class="group">
                                <label for="user" class="label">Username</label>
                                <input type="text" required id="user" name="username" class="input" />
                                <%--<s:textfield id="user" name="username"></s:textfield>--%>
                            </div>
                            <div class="group">
                                <label for="pass" class="label">Password</label>
                                <input id="pass" name="password" required type="password" class="input" data-type="password">
                            </div>

                            <div class="group">
                                <font color='red'>
                                ${requestScope.ERROR}
                                </font>
                            </div>
                            <div class="group">
                                <input type="submit" class="button" value="Sign In">
                            </div>
                            <div class="hr"></div>
                            <div class="foot-lnk">
                            </div>
                    </form>
                </div>
                <div class="sign-up-htm">
                    <form name="SignUpAction" action="SignUpAction" method="POST" onsubmit="return validateForm()">
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
                                <font color='red'>
                                ${requestScope.INVALID.usernameError}
                                </font>
                            </div>
                        <div class="group">
                            <input type="submit" class="button" value="Sign Up">
                        </div>
                    </form>
                    <div class="hr"></div>
                    <div class="foot-lnk">
                        <label for="tab-1">Already Member?</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- partial -->

</body>
</html>
