<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 30/07/2021
  Time: 9:02 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>Thành</p>
    <hr>
<%--    Display username and rold--%>
    <p>
        User: <security:authentication property="principal.username"/>
        <br><br>
        Role(s): <security:authentication property="principal.authorities"/>
    </p>
    <hr>
    <hr>
<%--    Add a link to point to /leaders ... this is for managers --%>
    <security:authorize access="hasRole('MANAGER')">
        <p>
            <a href="${pageContext.request.contextPath}/leaders">Leadership meeting</a>
            (Only for Manager peeps)
        </p>
    </security:authorize>

    <security:authorize access="hasRole('ADMIN')">
        <p>
            <a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
            (Only for Admin peeps)
        </p>
    </security:authorize>


    <form:form action="${pageContext.request.contextPath}/logout"
               method="post">
        <input type="submit" value="Logout" />
    </form:form>
</body>
</html>
