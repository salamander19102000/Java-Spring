<%-- 
    Document   : account
    Created on : Sep 28, 2020, 8:17:23 PM
    Author     : Hi_XV
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Account</h1>
        <mvc:form action="${pageContext.request.contextPath}/${action}" method="post" modelAttribute="account">
            <c:if test ="${action=='update'}">
                <input name="id" value="${account.id}" hidden/>
            </c:if> 
            <table>
                <tr>
                    <td><label>Full Name<span style="color: red">(*)</span></label></td>
                    <td><input name="fullName" value="${account.fullName}" required/></td>
                    <td style="color: red"><mvc:errors path="fullName"> </mvc:errors></td>
                    </tr>
                    <tr>
                        <td><label>Email<span style="color: red">(*)</span></label></td>
                        <td><input name="email" value="${account.email}" required/></td>
                        <td style="color: red"><mvc:errors path="email"> </mvc:errors></td>
                    </tr>
                    <tr>
                        <td><label>Pass Word<span style="color: red">(*)</span></label></td>
                        <td><input name="passWork" type="password" value="${account.passWork}" required/></td>
                    <td style="color: red"><mvc:errors path="passWork" > </mvc:errors></td>
                </tr>
                <tr>
                    <td><label>Description</label></td>
                    <td><textarea name="description" row="3" >${account.description}</textarea></td>
                </tr>
                <tr>
                    <td><label>Country</label></td>
                    <td><input name="country" type="text" value="${account.country}" /></td>
                </tr>
                <tr>

                    <td><label>Smoking</label></td>
                    <td>
                        <c:if test="${account.smoking}">
                    <lable><input name="smoking" type="checkbox" checked/>Smoking</lable>
                    </c:if>

                <c:if test="${!account.smoking}">
                    <lable><input name="smoking" type="checkbox"/>Smoking</lable>
                    </c:if>
            </td>
        </tr>
        <tr>
            <td><label>Birth Date</label></td>
            <td><input name="birthDate" type="date" value="${account.birthDate}"></td>
        </tr>
        <tr>
            <td><label>Gender</label></td>
            <td><c:forEach items="${genders}" var="g">

                    <c:if test="${g == account.gender}">
                        <label> <input type="radio" name="gender" value="${g}" checked/>${g}</lable>
                        </c:if>
                        <c:if test="${g != account.gender}">
                            <label><input type="radio" name="gender" value="${g}"/>${g}</lable>
                            </c:if>


                        </c:forEach></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <button type="submit" >Submit </button>
                            </td>
                        </tr>
                        </table>
                    </mvc:form>
                    </body>
                    </html>
