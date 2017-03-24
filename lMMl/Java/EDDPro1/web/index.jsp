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
        <center><h1>Renta de activos</h1></center>
       
        
        <center>
            <div>
            <form action="Registrar.jsp" method="post">
                
                <h3>Usuario</h3>
                <input type="text" name="user" id="user"/>
                <h3>Contraseña</h3>
                <p><input type="password" name="pass" id="pass"/></p>
                <h3>Empresa</h3>
                <p><input type="text" name="Empresa" id="Empresa"/></p>
                <h3>Departamento</h3>
                <p><input type="text" name="Departamento" id="Departamento"/></p>
                <p><input type="button" name="Entrar" id="Entrar" value="Login" onclick="redirausuario()"/></p>
                <script src="js/script.js"></script>
                <p><input  type="button" value="Registrar Usuario" onclick="redir()" /></p>
            </form>
            
            </div>
        </center>            
        <script type="text/javascript" > 
        function redir() 
        { 
            location.href="Registrar.jsp";
        }
        function redirausuario() 
        { 
            location.href="MenuUsuario.jsp";
        }
        
        </script>       
    </body>
</html>