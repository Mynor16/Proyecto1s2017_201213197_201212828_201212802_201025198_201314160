package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class crearactivo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<html>\n");
      out.write("    <head> \n");
      out.write("        <meta charset=\"utf-8\"> \n");
      out.write("        <meta name=\"keywords\" content=\"\"> \n");
      out.write("        <meta name=\"description\" content=\"\"> \n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=0\"> \n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/png\" href=\"favicon.png\"> \n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"./css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"./css/animate.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"./css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"./css/et-line.min.css\"> \n");
      out.write("        <script src=\"./js/jquery-2.1.0.min.js\"></script>\n");
      out.write("        <script src=\"./js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"./js/blocs.min.js\"></script>\n");
      out.write("        <script src=\"./js/jqBootstrapValidation.js\"></script>\n");
      out.write("        <script src=\"./js/formHandler.js\"></script> \n");
      out.write("        <title>CrearActivo</title> <!-- Google Analytics --> <!-- Google Analytics END --> \n");
      out.write("    </head>\n");
      out.write("    <body><!-- Main container -->\n");
      out.write("        <div class=\"page-container\"> <!-- bloc-0 -->\n");
      out.write("            <div class=\"bloc bgc-white l-bloc\" id=\"bloc-0\">\n");
      out.write("                <div class=\"container bloc-sm\">\n");
      out.write("                    <nav class=\"navbar nav-center row\">\n");
      out.write("                        <div class=\"navbar-header\">\n");
      out.write("                            <a class=\"navbar-brand\" href=\"index.jsp\">\n");
      out.write("                                <img src=\"img/logo.png\" alt=\"logo\" /></a>\n");
      out.write("                            <button id=\"nav-toggle\" type=\"button\" class=\"ui-navbar-toggle navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-1\">\n");
      out.write("                                <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                                <span class=\"icon-bar\"></span>\n");
      out.write("                                <span class=\"icon-bar\"></span>\n");
      out.write("                                <span class=\"icon-bar\"></span>\n");
      out.write("                            </button>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"collapse navbar-collapse navbar-1\">\n");
      out.write("                            <ul class=\"site-navigation nav navbar-nav\">\n");
      out.write("                                <li><a href=\"menuusuario.jsp\">Menu Usuario</a></li>\n");
      out.write("                                <li><a href=\"crearactivo.jsp\">Crear</a></li>\n");
      out.write("                                <li><a href=\"eliminaractivo.jsp\">Eliminar</a></li>\n");
      out.write("                                <li><a href=\"modificaractivo.jsp\">Modificar</a></li>\n");
      out.write("                                <li><a href=\"index.jsp\">Salir</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </nav>\n");
      out.write("                </div>\n");
      out.write("            </div><!-- bloc-0 END --><!-- Bloc Group -->\n");
      out.write("            <div class='bloc-group'><!-- bloc-7 -->\n");
      out.write("                <div class=\"bloc bloc-tile-3 bgc-white l-bloc\" id=\"bloc-7\">\n");
      out.write("                    <div class=\"container bloc-lg\"><div class=\"row animated pulse\"><div class=\"col-sm-12\">\n");
      out.write("                                <form action=\"crearactivoservlet\" method=\"get\" id=\"form_8\" novalidate success-msg=\"Activo Creado Exitosamente\" fail-msg=\"Sorry it seems that our mail server is not responding, Sorry for the inconvenience!\">\n");
      out.write("                                    <h2 class=\"mg-md text-center\">Agregar Activo</h2>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <label>Nombre</label>\n");
      out.write("                                        <input name=\"nombreca\" type=\"text\" id=\"nombre\" class=\"form-control\" required />\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <label>Descripción<br></label>\n");
      out.write("                                        <textarea name=\"descripcionca\" id=\"descripcion\" class=\"form-control\" rows=\"4\" cols=\"50\" required></textarea>\n");
      out.write("                                    </div> \n");
      out.write("                                    <button class=\"bloc-button btn btn-d btn-lg btn-block animated puffIn\" type=\"submit\">Agregar Activo</button>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div><!-- bloc-7 END --><!-- bloc-8 -->\n");
      out.write("                <div class=\"bloc l-bloc bgc-white bloc-tile-3\" id=\"bloc-8\">\n");
      out.write("                    <div class=\"container bloc-lg\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-sm-12\"></div>\n");
      out.write("                                \n");
      out.write("                        </div></div></div><!-- bloc-8 END --><!-- bloc-9 -->\n");
      out.write("                        <div class=\"bloc l-bloc bgc-white bloc-tile-3\" id=\"bloc-9\">\n");
      out.write("                            <div class=\"container bloc-lg\">\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-sm-12\"></div>\n");
      out.write("                                        \n");
      out.write("                                </div>\n");
      out.write("                                \n");
      out.write("                            </div>\n");
      out.write("                                    \n");
      out.write("                        </div><!-- bloc-9 END -->\n");
      out.write("            </div><!-- Bloc Group END --><!-- ScrollToTop Button -->\n");
      out.write("            <a class=\"bloc-button btn btn-d scrollToTop\" onclick=\"scrollToTarget('1')\">\n");
      out.write("                <span class=\"fa fa-chevron-up\"></span>\n");
      out.write("            </a><!-- ScrollToTop Button END-->\n");
      out.write("        </div><!-- Main container END --> \n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
