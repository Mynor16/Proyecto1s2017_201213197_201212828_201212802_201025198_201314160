<%-- 
    Document   : nuevousuario
    Created on : 26-mar-2017, 15:34:29
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
        <title>Registrar</title> <!-- Google Analytics --> <!-- Google Analytics END --> 
    </head>
    <body><!-- Main container -->
        <div class="page-container"> <!-- bloc-0 -->
            <div class="bloc bgc-white l-bloc" id="bloc-0">
                <div class="container bloc-sm">
                    <nav class="navbar nav-center row">
                        <div class="navbar-header">
                            <a class="navbar-brand" href="index.html"><img src="img/logo.png" alt="logo" /></a>
                            <button id="nav-toggle" type="button" class="ui-navbar-toggle navbar-toggle" data-toggle="collapse" data-target=".navbar-1">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                        </div><div class="collapse navbar-collapse navbar-1">
                            <ul class="site-navigation nav navbar-nav"><li>
                                    <a href="index.jsp">Inicio</a></li>
                                <li><a href="nuevousuario.jsp">Registrar Usuario</a></li>

                            </ul>
                        </div></nav></div></div><!-- bloc-0 END --><!-- bloc-2 -->
                        <div class="bloc bgc-white l-bloc" id="bloc-2">
                            <div class="container bloc-lg">
                                <div class="row">
                                    <div class="col-xs-12 col-md-8 col-md-offset-2">
                                        <div class="col-sm-6"></div>
                                        <div class="col-sm-6">
                                            <div class="panel animated pulse" id="nuevoempresa1">
                                                <div class="panel-heading">
                                                    <h2 class="mg-clear text-center">Nuevo Usuario</h2>
                                                </div>
                                                <div class="panel-body">
                                                    
                                                        <h4 class="text-center mg-md">Nombre Completo</h4>
                                                            
                                                            
                                                        <form action="servletcrearusuario" method="get">
                                                               
                                                            <input type="text" name="nombrenu" class="form-control" id="nuevonombre"  />
                                                                
                                                            
                                                        
                                                        <h4 class="text-center mg-md">Nombre de Usuario</h4>
                                                                   
                                                                       
                                                        <input type="text" name="usuarionu" class="form-control" id="nuevousuario"  />
                                                                        
                                                                    
                                                        
                                                        <h4 class="text-center mg-md">Contraseña</h4>
                                                        
                                                            
                                                                
                                                        <input name="contrasenanu" class="form-control" id="nuevocontraseña" type="password" />
                                                               
                                                           
                                                        
                                                        <h4 class="mg-md text-center">Departamento</h4>
                                                       
                                                            
                                                               
                                                        <input type="text" name="departamentonu" class="form-control" id="nuevodepartamento" />
                                                               
                                                            
                                                            <h4 class="text-center mg-md">Empresa</h4>
                                                       
                                                    
                                                            
                                                        
                                                            <input name="empresanu" class="form-control" id="nuevoempresa"  />
                                                        
                                                            
                                                           
                                                        <input name="" class="btn btn-d btn-lg btn-block animated puffIn " id="Entrar" required placeholder="Contraseña_ejemplo" type="submit" />
                                                           
                                                            
                                                            
                                                            
                                                    </form>
                                                        
                                                        
                                                        
                                                    
                                                    
                                                </div>
                                                
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div><!-- bloc-2 END --><!-- ScrollToTop Button -->
                        <a class="bloc-button btn btn-d scrollToTop" onclick="scrollToTarget('1')">
                            <span class="fa fa-chevron-up"></span></a><!-- ScrollToTop Button END-->
        </div><!-- Main container END --> </body></html>
