<%@page import="javax.websocket.Session"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="frd.session.SessionManager" %>
<%@ page import="frd.session.UserSession" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Esto es el index</title>
</head>
<body>
	<h1>Pagina principal "Index.JSP"</h1>
	<% SessionManager smgr = new SessionManager(session);%>
	
	<%
		if(!smgr.isActive()){
	%>
			<form method = "GET" action = "login">
				Username : 		<input type = "text" value ="usuario1" name = "username" ><br>
				Password :  	<input type = "password" value ="password1" name = "password"><br>
				<input type = "submit" value ="Procesar">
			</form>
	<%
		}else{
			UserSession usrSess = smgr.getCurentUsr();
			out.println("Ya estas logeado con:");
	%>
			<p>Username --> <%= usrSess.getUsername() 	%></p>
			<p>Nombre: --> <%= usrSess.getNombre() 		%></p>
			<p>Apellido --> <%= usrSess.getApellido()	%></p>
			<p>Rol --> <%= usrSess.getRol() 		%></p>
			<a href="/session/logout">Cerrar Sesion</a>
	<%
		}
	%>
</body>
</html>