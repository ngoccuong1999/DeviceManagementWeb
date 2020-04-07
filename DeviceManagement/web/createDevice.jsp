<%-- 
    Document   : createDevice
    Created on : Mar 22, 2020, 9:43:11 PM
    Author     : Ngoc Cuong
--%>

<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page language="java" %>
<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>Create user</title>
        <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans:600'><link rel="stylesheet" href="./css/style1.css">
        <script language="Javascript">
            var separator = "/";
            var minYear = 1900;
            var maxYear = 2500;

            function isInteger(s) {
                var i;
                for (i = 0; i < s.length; i++) {
// Check that current character is a number or not.
                    var c = s.charAt(i);
                    if (((c < "0") || (c > "9")))
                        return false;
                }
// All characters are numbers.
                return true;
            }

            function stripCharsInBag(s, bag) {
                var i;
                var returnString = "";
// Search through string's characters one by one.
// If character is not in bag, append to returnString.
                for (i = 0; i < s.length; i++) {
                    var c = s.charAt(i);
                    if (bag.indexOf(c) === -1)
                        returnString += c;
                }
                return returnString;
            }

            function daysInFebruary(year) {
// February has 29 days in any year evenly divisible by four,
// EXCEPT for centurial years which are not also divisible by 400.
                return (((year % 4 === 0) && ((!(year % 100 === 0)) || (year % 400 === 0))) ? 29 : 28);
            }
            function DaysArray(n) {
                for (var i = 1; i <= n; i++) {
                    this[i] = 31;
                    if (i === 4 || i === 6 || i === 9 || i === 11) {
                        this[i] = 30;
                    }
                    if (i === 2) {
                        this[i] = 29;
                    }
                }
                return this;
            }

            function isDate(dtStr) {
                var daysInMonth = DaysArray(12);
                var pos1 = dtStr.indexOf(separator);
                var pos2 = dtStr.indexOf(separator, pos1 + 1);
                var strMonth = dtStr.substring(0, pos1);
                var strDay = dtStr.substring(pos1 + 1, pos2);
                var strYear = dtStr.substring(pos2 + 1);
                strYr = strYear;
                if (strDay.charAt(0) === "0" && strDay.length > 1)
                    strDay = strDay.substring(1);
                if (strMonth.charAt(0) === "0" && strMonth.length > 1)
                    strMonth = strMonth.substring(1);
                for (var i = 1; i <= 3; i++) {
                    if (strYr.charAt(0) === "0" && strYr.length > 1)
                        strYr = strYr.substring(1);
                }
                month = parseInt(strMonth);
                day = parseInt(strDay);
                year = parseInt(strYr);
                if (pos1 === -1 || pos2 === -1) {
                    alert("The date format should be : MM/DD/YYYY");
                    return false;
                }
                if (strMonth.length < 1 || month < 1 || month > 12) {
                    alert("Please enter a valid month");
                    return false;
                }
                if (strDay.length < 1 || day < 1 || day > 31 || (month === 2 && day > daysInFebruary(year)) || day > daysInMonth[month]) {
                    alert("Please enter a valid day");
                    return false;
                }
                if (strYear.length !== 4 || year === 0 || year < minYear || year > maxYear) {
                    alert("Please enter a valid 4 digit year between " + minYear + " and " + maxYear);
                    return false;
                }
                if (dtStr.indexOf(separator, pos2 + 1) !== -1 || isInteger(stripCharsInBag(dtStr, separator)) === false) {
                    alert("Please enter a valid date");
                    return false;
                }
                alert("Nhập ngày tháng năm hợp lệ");
                return true;
            }
            function ValidateDate() {
                var dt = document.CreateDeviceAction.timeBuy;
                if (isDate(dt.value) === false) {
                    dt.focus();
                    return false;
                }
                var dt1 = document.CreateDeviceAction.warrantyPeriod;
                 if (isDate(dt1.value) === false) {
                    dt1.focus();
                    return false;
                }
                var startDate = new Date(dt.value);
                var endDate = new Date(dt1.value);
//                if(startDate.getTime() <= endDate.getTime()) {
//                    alert("Ngày bảo hành không được nhỏ hơn ngày mua");
//                    return false;
//                }
                return true;
            }
        </script>
    </head>
    <body>
        <div class="login-wrap">
            <div class="login-html">
                <!--<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Sign In</label>-->
                <input id="tab-1" type="radio" name="tab" class="sign-up"><label for="tab-1" class="tab">Create Device</label>

                <div class="login-form">


                    <!--                    <form action="LoginAction" method="POST">
                    
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
                    
                    </font>
                </div>
                <div class="group">
                    <input type="submit" class="button" value="Sign In">
                </div>
                <div class="hr"></div>
                <div class="foot-lnk">
                </div>
        </form>
    </div>-->
                    <div class="sign-up-htm">
                        <form name="CreateDeviceAction" action="CreateDeviceAction" method="POST" onsubmit="return ValidateDate()">
                            <div class="group">
                                <label for="user" class="label">Id</label>
                                <input name="id" id="user" required pattern="[1-9]*[0-9]+" title="Phải là số nguyên > 0 "type="text" class="input" >
                            </div>
                            <div class="group">
                                <label for="pass" class="label">Device Name</label>
                                <input id="pass" name="deviceName" required type="text" class="input"  >
                            </div>
                            <div class="group">
                                <label for="pass" class="label">Device_Description</label>
                                <input id="pass" name="deviceDescription" type="text" required class="input" >
                            </div>
                            <div class="group">
                                <label for="pass" class="label">Device Type</label>
                                <input id="pass" name="deviceType" required type="text" class="input" >
                            </div>
                            <div class="group"> 
                                <label for="pass" class="label">Time Buy</label>
                                <input id="pass" name="timeBuy" required type="text" required class="input" >
                            </div>


                            <div class="group"> 
                                <label for="pass" class="label">Warranty period</label>
                                <input id="pass" name="warrantyPeriod" required type="text" class="input" >

                            </div>
                            <div class="group">
                                <font color="red">
                                ${requestScope.INVALID.idError}
                                </font>
                            </div>
                            <div class="group">
                                <input type="submit" class="button" value="Create Device">
                            </div>
                        </form>
                        <div class="hr"></div>

                    </div>
                </div>
            </div>
        </div>
        <!-- partial -->

    </body>
</html>

