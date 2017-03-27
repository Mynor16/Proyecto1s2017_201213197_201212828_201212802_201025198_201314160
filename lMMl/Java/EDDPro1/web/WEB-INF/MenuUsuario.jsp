<%-- 
    Document   : MenuUsuario
    Created on : 23-mar-2017, 6:52:08
    Author     : lMMl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        <center>
            <div>
            <form action="#" method="post">
                
                <h3>Usuario</h3>
             
                <script src="js/script.js"></script>
                <p><input  type="button" value="Agregar Activo" onclick="redir1()" /></p>
                <p><input  type="button" value="Eliminar Activo" onclick="redir()" /></p>
                <p><input  type="button" value="Modificar la descripcion de un activo" onclick="redir()" /></p>
            </form>
            
            </div>
        </center>         
               <script type="text/javascript" > 
        function redir1() 
        { 
            location.href="CrearActivo.jsp";
        }
        function redir2(){
            location.href="index.jsp";
        }
        </script>         
        
        
    </body>
</html>
