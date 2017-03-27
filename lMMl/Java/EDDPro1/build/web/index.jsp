<%-- 
    Document   : intento 2
    Created on : 19-mar-2017, 12:53:49
    Author     : lMMl
--%>
<%@page import="Proyecto1.Datos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html><html>
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
        <script src="./js/jqBootstrapValidation.js"></script>
        <script src="./js/formHandler.js"></script> 
        <title>Home</title> <!-- Google Analytics --> <!-- Google Analytics END --> 
    </head>
    <body><!-- Main container -->
        <div class="page-container"> <!-- bloc-0 -->
            <div class="bloc bgc-white l-bloc" id="bloc-0">
                <div class="container bloc-sm">
                    <nav class="navbar nav-center row">
                        <div class="navbar-header">
                            <a class="navbar-brand" href="index.html">
                                <img src="img/logo.png" alt="logo" /></a>
                            <button id="nav-toggle" type="button" class="ui-navbar-toggle navbar-toggle" data-toggle="collapse" data-target=".navbar-1">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                        </div>
                        <div class="collapse navbar-collapse navbar-1">
                            <ul class="site-navigation nav navbar-nav">
                                <li><a href="index.jsp">Inicio</a></li>
                                <li><a href="nuevousuario.jsp">Registrar Usuario</a></li>
                        </div></nav></div></div><!-- bloc-0 END --><!-- bloc-1 -->
                        
                            <div class="container bloc-lg">
                                <div class="row">
                                    <div class="col-xs-12 col-md-8 col-md-offset-2 col-sm-12">
                                        <div class="col-sm-6">
                                            <div class="panel animated pulse">
                                                <div class="panel-heading">
                                                    <h2 class="mg-clear text-center">Iniciar Sesión</h2>
                                                </div>
                                                    <div class="panel-body">
                                                        <ul class="list-unstyled list-sp-md">
                                                            <li>
                                                                <h4 class="text-center mg-md">Nombre de Usuario</h4>
                                                                <form action="iniciar" method="get" >
                                                                    
                                                                        <input  name="cc1" class="form-control" id="entrarusuario" required placeholder="usuario_ejemplo" />
                                                                    
                                                                
                                                            
                                                                        <h4 class="text-center mg-md">Contraseña</h4>
                                                                
                                                                   
                                                                        <input tipe="text" name="cc2" class="form-control" id="entrarcontraseña" required placeholder="Contraseña_ejemplo" type="password" />
                                                                        
                                                                        <input class="btn btn-d btn-lg btn-block animated puffIn " id="Entrar" required placeholder="Contraseña_ejemplo" type="submit" />
                                                                        
                                                                </form>
                                                            </li>
                                                        </ul>
                                                    </div>
                                                
                                            </div>
                                        </div></div>
                                </div>
                            </div>
                        <!-- bloc-1 END --><!-- ScrollToTop Button -->
                                                <a class="bloc-button btn btn-d scrollToTop" onclick="scrollToTarget('1')">
                                                    <span class="fa fa-chevron-up"></span>
                                                </a><!-- ScrollToTop Button END-->
        </div><!-- Main container END --> 
    </body></html>
