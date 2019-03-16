<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page session="true"%>
<%!
    String input = null;
    double resultTemp = 0;
    double sourceTemp = 0;
    String fromUnit = "";
    String toUnit = "";
%>
<%
input = request.getParameter("fTemp");
if (input == null || input.equals("")) {
    response.sendRedirect("errorMsg.jsp?msg=You are missing values.");
    return;
}
try {
    sourceTemp = Integer.parseInt(input);
    if ("cel".equals(request.getParameter("temp"))) {
        resultTemp = (sourceTemp - 32) * (5.0 / 9.0);
        fromUnit = "Fahrenheit";
        toUnit = "Celsius";
    } else {
        resultTemp = (sourceTemp * (9.0 / 5.0)) + 32.0;
        fromUnit = "Celsius";
        toUnit = "Fahrenheit";
    }
} catch (Exception e) {
    response.sendRedirect("errorMsg.jsp?msg=Invalid numbers entered.");
    return;
}
 %>

<p>
    <%= sourceTemp %> degrees <%= fromUnit %> is <%= resultTemp %> degrees <%= toUnit %>
</p>

<p>
    <a href="index.html">Back to calculator</a>
</p>