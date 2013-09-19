<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="datas" scope="request" type="java.util.List"/>
<html>
<head>
    <title>Main</title>
</head>
<body>
<c:if test="${not empty datas}">
    <table border=1>
        <c:forEach items="${datas}" var="datum">
            <tr>
                <td>${datum.id}</td>
                <td>${datum.txt}</td>
                <td>
                    <form action="delete">
                        <input type="submit" name="delete" value="delete"/>
                        <input type="hidden" value="${datum.id}" name="id"/></form>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<form action="add">
    <table>
        <tr>
            <td><label>New Value <input type="text" name="newvalue"></label></td>
            <td><input type="submit"></td>
        </tr>
    </table>
</forM>
</body>
</html>