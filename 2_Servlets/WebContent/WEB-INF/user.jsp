<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User</title>
</head>
<body>


<%--<%--%>
    <%--String userName = null;--%>
    <%--Cookie[] cookies = request.getCookies();--%>
    <%--if(cookies !=null){--%>
        <%--for(Cookie cookie : cookies){--%>
            <%--if(cookie.getName().equals("name")) userName = cookie.getValue();--%>
        <%--}--%>
    <%--}--%>
    <%--if(userName == null) response.sendRedirect("index.jsp");--%>
<%--%>--%>
<h3>Hi ${user.name}! Login successful.</h3>
<br>
<form action="LogoutServlet" method="post">
    <input type="submit" value="Logout" >
</form>

<form action="user" method="UPDATE">
    Id: <input type="text" name="id"/><br />
    Name: <input type="text" name="name"/><br />
    Password: <input type="password" name="password"/><br />
    Email: <input type="text" name="email"/><br />
    <input type="submit" value="Save Changes"/>
</form>

<table>
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Email</th>
    </tr>
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
        </tr>
</table>

</body>
</html>
