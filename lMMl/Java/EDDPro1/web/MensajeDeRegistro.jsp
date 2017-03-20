<%-- 
    Document   : intento 2
    Created on : 19-mar-2017, 12:53:49
    Author     : lMMl
--%>
<%@page import="Proyecto1.Datos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
        
        
        <title>EDD</title>
    </head>
    <body>
        
        <center><h1>Mensaje de Registro</h1></center>
        <center>
            
            <% Datos dato = new Datos();
        String respuesta = dato.AgregaraMatriz(request.getParameter("Empresa").toString(), request.getParameter("Departamento").toString(), request.getParameter("user").toString()); %>
        <% out.print("<h2>"+respuesta+"</h2>"); %>
            
        </center>
       
                
        <center> 
            
            <div>
                
            <form action="Registrar.jsp" method="post">
                <p><input  type="button" value="Regreso" onclick="" /></p>
            </form>
            
            </div>
        </center>
                
        
    </body>
</html>
