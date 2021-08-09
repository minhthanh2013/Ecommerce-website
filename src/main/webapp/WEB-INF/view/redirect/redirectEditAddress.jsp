<%@ page import="com.doan2.spring.entity.Customer" %>
<%@ page import="com.doan2.spring.entity.supportentity.UserEditAddress" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Redirect</title>
</head>
<body>
<%
    UserEditAddress customer = (UserEditAddress) request.getAttribute("userEditAddress1");
    if (customer != null || !customer.equals(null)){
        response.sendRedirect("/doan2_new_war/dashboard/edit_address?error=false");
    }else {
        response.sendRedirect("/doan2_new_war/dashboard/edit_address?error=true");
    }
%>
</body>
</html>

