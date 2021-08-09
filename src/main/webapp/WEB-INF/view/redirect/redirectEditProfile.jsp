<%@ page import="com.doan2.spring.entity.Customer" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Redirect</title>
</head>
<body>
<%
    Customer customer = (Customer) request.getAttribute("Customer");
    if (customer != null || !customer.equals(null)){
        response.sendRedirect("/doan2_new_war/dashboard/edit_profile?error=false");
    }else {
        response.sendRedirect("/doan2_new_war/dashboard/edit_profile?error=true");
    }
%>
</body>
</html>

