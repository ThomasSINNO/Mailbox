<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Erreur</title>
</head>
<body>
informations invalides !
<br>

<%
String lg = (String) request.getAttribute("login");
out.println(lg);
%>
<br>
<%
String pw = (String) request.getAttribute("password");
out.println(pw);
%>
<br>
<a href="Accueil"> back to accueil</a>
</body>
</html>