<%@ page import="com.doan2.spring.entity.TradingPartner" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Redirect</title>
</head>
<body>
<%
    TradingPartner tradingPartner = (TradingPartner) request.getAttribute("trading_partner_fr_id");

    if (tradingPartner != null || !tradingPartner.equals(null)){
        response.sendRedirect("/doan2_new_war/admin/partners?id="+tradingPartner.getIdPartner());
    }else {
        response.sendRedirect("/doan2_new_war/admin/partners");
    }
%>
</body>
</html>

