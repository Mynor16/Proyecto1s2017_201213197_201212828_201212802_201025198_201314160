<%-- 
    Document   : MenuUsuario
    Created on : 23-mar-2017, 6:52:08
    Author     : lMMl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head> 
        <meta charset="utf-8"> 
        <meta name="keywords" content=""> 
        <meta name="description" content=""> 
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=0"> 
        <link rel="shortcut icon" type="image/png" href="favicon.png"> 
        <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="style.css">
        <link rel="stylesheet" href="./css/animate.min.css">
        <link rel="stylesheet" href="./css/font-awesome.min.css">
        <link rel="stylesheet" href="./css/et-line.min.css"> 
        <script src="./js/jquery-2.1.0.min.js"></script>
        <script src="./js/bootstrap.min.js"></script>
        <script src="./js/blocs.min.js"></script> 
        <title>Usuario</title> <!-- Google Analytics --> <!-- Google Analytics END --> 
    </head><body><!-- Main container -->
        <div class="page-container"> <!-- bloc-0 -->
            <div class="bloc bgc-white l-bloc" id="bloc-0">
                <div class="container bloc-sm">
                    <nav class="navbar nav-center row">
                        <div class="navbar-header">
                            <a class="navbar-brand" href="index.jsp"><img src="img/logo.png" alt="logo" /></a>
                            <button id="nav-toggle" type="button" class="ui-navbar-toggle navbar-toggle" data-toggle="collapse" data-target=".navbar-1">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <h4 class="text-center mg-md"> Usuario Activo: <%=session.getAttribute("usuariolog")%></h4>
                        </div>
                        <div class="collapse navbar-collapse navbar-1">
                            <ul class="site-navigation nav navbar-nav">
                                
                                <li><a href="menuusuario.jsp">Menu Usuario</a></li>
                                <li><a href="crearactivo.jsp">Crear</a></li>
                                <li><a href="eliminaractivo.jsp">Eliminar</a></li>
                                <li><a href="modificaractivo.jsp">Modificar</a></li>
                                <li><a href="index.jsp">Salir</a></li>
                            </ul>
                        </div>
                    </nav>
                </div>
            </div><!-- bloc-0 END --><!-- bloc-3 -->
            <div class="bloc l-bloc bgc-white" id="bloc-3">
                <div class="container bloc-lg">
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="text-center">
                                <span class="et-icon-pencil icon-round icon-md"></span>
                            </div>
                            <a href="crearactivo.jsp" class="btn btn-d btn-lg btn-rd btn-block">Nuevo Activo</a>
                        </div>
                        <div class="col-sm-4">
                            <div class="text-center">
                                <span class="et-icon-tools icon-round icon-md"></span>
                            </div><a href="modificaractivo.jsp" class="btn btn-d btn-lg btn-block">Modificar Activo</a></div><div class="col-sm-4">
                                <div class="text-center"><span class="et-icon-caution icon-round icon-md"></span>
                                </div><a href="eliminaractivo.jsp" class="btn btn-d btn-lg btn-block">Eliminar Activo</a></div></div></div></div><!-- bloc-3 END --><!-- ScrollToTop Button -->
                                <a class="bloc-button btn btn-d scrollToTop" onclick="scrollToTarget('1')"><span class="fa fa-chevron-up"></span></a><!-- ScrollToTop Button END--></div><!-- Main container END --> </body></html>