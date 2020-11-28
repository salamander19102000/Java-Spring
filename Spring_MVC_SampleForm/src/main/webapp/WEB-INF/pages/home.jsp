<%-- 
    Document   : home
    Created on : Sep 28, 2020, 7:48:56 PM
    Author     : Hi_XV
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List Account</h1>
        <c:if test="${message != null && message !=''}">
            <c:if test ="${type!= null && type!= '' && type=='error'}">
                <p style="color: red">${message}</p>
            </c:if>
            <c:if test ="${type!= null && type!= '' && type=='success'}">
                <p style="color: green">${message}</p>
            </c:if>
        </c:if>
        <button onclick="location.href = '<c:url value="/create-account"/>'">Create Account</button>
        <table>
            <tr>
                <th>Full Name</th>
                <th>Email</th>
                <th>Description</th>
                <th>Country</th>
                <td>Gender</td>
                <th>Smoking</th>
                <th>Action</th>

            </tr>
            <c:forEach items="${accounts}" var="acc">
                <tr>
                    <td>${acc.fullName}</td>
                    <td>${acc.email}</td>
                    <td>${acc.description}</td>
                    <td>${acc.country}</td>
                    <td>${acc.gender}</td>
                    <td>${acc.smoking}</td>
                    <td>
                        <button onclick="location.href = '<c:url value="/update/${acc.id}"/>'">Update</button>
                        <button onclick="location.href = '<c:url value="/delete/${acc.id}"/>'">Delte</button>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
