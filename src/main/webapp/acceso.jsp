<%-- 
    Document   : acceso
    Created on : 11/09/2019, 04:56:11 PM
    Author     : Miguel
--%>

<%@page import="mx.com.SWP.Controller.LoginController"%>
<%@page import="mx.com.SWP.Model.MbdUsuarios"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%
    String Correo = request.getParameter("correo");
    String password = request.getParameter("clave");
    LoginController Log = new MbdUsuarios().buscaUsuario(Correo, password);
    if(Log!=null){
        session.setAttribute("usuarioEnSesion", Log);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Bienvenido!!!</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    </head>
    <body>
        <h1>Bienvenido <%=Correo%>!</h1>
    </body>
</html>
