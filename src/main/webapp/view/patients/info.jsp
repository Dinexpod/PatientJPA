<jsp:useBean id="patient" scope="request" type="mate.academy.jpademo.model.Patient"/>


<%--
  Created by IntelliJ IDEA.
  User: Dinexpod
  Date: 10.01.2019
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="view/style.css">
    <title>Hello DIN!!! This is patient info)</title>
</head>
<body>
<h3>Patient name is ${patient.name} ${patient.lastName}</h3>
<h4>Patient name is ${patient.date}</h4>
</body>
</html>
