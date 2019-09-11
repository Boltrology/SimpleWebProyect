<%-- 
    Document   : acceso
    Created on : 11/09/2019, 04:56:11 PM
    Author     : Miguel
--%>

<%@page import="mx.com.SimpleWebLogin.Controller.MbdLuser"%>
<%@page import="mx.com.SimpleWebLogin.Controller"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%
    String Correo = request.getParameter("Correo");
    String password = request.getParameter("Clave");
    
    LoginController usuario = new MbdLuser().buscaUsuario(Correo, password);

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Bienvenido TODO</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    </head>
    <body>

    </body>
</html>
