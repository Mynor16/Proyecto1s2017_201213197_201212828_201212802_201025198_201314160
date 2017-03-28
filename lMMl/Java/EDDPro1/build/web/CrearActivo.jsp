<%-- 
    Document   : crearactivo.jsp
    Created on : 26-mar-2017, 15:20:06
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
        <script src="./js/jqBootstrapValidation.js"></script>
        <script src="./js/formHandler.js"></script> 
        <title>CrearActivo</title> <!-- Google Analytics --> <!-- Google Analytics END --> 
    </head>
    <body><!-- Main container -->
        <div class="page-container"> <!-- bloc-0 -->
            <div class="bloc bgc-white l-bloc" id="bloc-0">
                <div class="container bloc-sm">
                    <nav class="navbar nav-center row">
                        <div class="navbar-header">
                            <a class="navbar-brand" href="index.jsp">
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
                                <li><a href="menuusuario.jsp">Menu Usuario</a></li>
                                <li><a href="crearactivo.jsp">Crear</a></li>
                                <li><a href="eliminaractivo.jsp">Eliminar</a></li>
                                <li><a href="modificaractivo.jsp">Modificar</a></li>
                                <li><a href="index.jsp">Salir</a></li>
                            </ul>
                        </div>
                    </nav>
                </div>
            </div><!-- bloc-0 END --><!-- Bloc Group -->
            <div class='bloc-group'><!-- bloc-7 -->
                <div class="bloc bloc-tile-3 bgc-white l-bloc" id="bloc-7">
                    <div class="container bloc-lg"><div class="row animated pulse"><div class="col-sm-12">
                                <form action="crearactivoservlet" method="get" id="form_8" novalidate success-msg="Activo Creado Exitosamente" fail-msg="Sorry it seems that our mail server is not responding, Sorry for the inconvenience!">
                                    <h2 class="mg-md text-center">Agregar Activo</h2>
                                    <div class="form-group">
                                        <label>Nombre</label>
                                        <input name="nombreca" type="text" id="nombre" class="form-control" required />
                                    </div>
                                    <div class="form-group">
                                        <label>Descripción<br></label>
                                        <textarea name="descripcionca" id="descripcion" class="form-control" rows="4" cols="50" required></textarea>
                                    </div> 
                                    <button class="bloc-button btn btn-d btn-lg btn-block animated puffIn" type="submit">Agregar Activo</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div><!-- bloc-7 END --><!-- bloc-8 -->
                <div class="bloc l-bloc bgc-white bloc-tile-3" id="bloc-8">
                    <div class="container bloc-lg">
                        <div class="row">
                            <div class="col-sm-12"></div>
                                
                        </div></div></div><!-- bloc-8 END --><!-- bloc-9 -->
                        <div class="bloc l-bloc bgc-white bloc-tile-3" id="bloc-9">
                            <div class="container bloc-lg">
                                <div class="row">
                                    <div class="col-sm-12"></div>
                                        
                                </div>
                                
                            </div>
                                    
                        </div><!-- bloc-9 END -->
            </div><!-- Bloc Group END --><!-- ScrollToTop Button -->
            <a class="bloc-button btn btn-d scrollToTop" onclick="scrollToTarget('1')">
                <span class="fa fa-chevron-up"></span>
            </a><!-- ScrollToTop Button END-->
        </div><!-- Main container END --> 
    </body>
</html>