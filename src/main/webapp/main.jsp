<%@ page import="com.shagie.dbtest.db.objects.Data" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    @SuppressWarnings("unchecked")
    List<Data> datas = (List<Data>) request.getAttribute("datas");
%>
<head>
    <title>Main</title>
</head>
<body>
    <table>
        <% for (Data datum : datas) { %>
            <tr>
                <td><%= datum.getId() %></td>
                <td><%= datum.getTxt() %></td>
            </tr>
        <% } %>
    </table>
</body>
</html>