package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class modificaractivo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>ModificarActivo</title> <!-- Google Analytics --> <!-- Google Analytics END --> \n");
      out.write("    </head>\n");
      out.write("    <body><!-- Main container -->\n");
      out.write("        <div class=\"page-container\"> <!-- bloc-0 -->\n");
      out.write("            <div class=\"bloc bgc-white l-bloc\" id=\"bloc-0\">\n");
      out.write("                <div class=\"container bloc-sm\">\n");
      out.write("                    <nav class=\"navbar nav-center row\">\n");
      out.write("                        <div class=\"navbar-header\">\n");
      out.write("                            <a class=\"navbar-brand\" href=\"index.html\">\n");
      out.write("                                <img src=\"img/logo.png\" alt=\"logo\" /></a>\n");
      out.write("                            <button id=\"nav-toggle\" type=\"button\" class=\"ui-navbar-toggle navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-1\">\n");
      out.write("                                <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                                <span class=\"icon-bar\"></span><span class=\"icon-bar\"></span>\n");
      out.write("                                <span class=\"icon-bar\"></span></button></div>\n");
      out.write("                                <div class=\"collapse navbar-collapse navbar-1\">\n");
      out.write("                                    <ul class=\"site-navigation nav navbar-nav\">\n");
      out.write("                                        <li><a href=\"menuusuario.jsp\">Menu Usuario</a></li>\n");
      out.write("                                        <li><a href=\"crearactivo.jsp\">Crear</a></li>\n");
      out.write("                                        <li><a href=\"eliminaractivo.jsp\">Eliminar</a></li>\n");
      out.write("                                        <li><a href=\"modificaractivo.jsp\">Modificar</a></li>\n");
      out.write("                                        <li><a href=\"index.jsp\">Salir</a></li></ul>\n");
      out.write("                                </div></nav>\n");
      out.write("                </div>\n");
      out.write("            </div><!-- bloc-0 END --><!-- Bloc Group -->\n");
      out.write("            <div class='bloc-group'><!-- bloc-10 -->\n");
      out.write("                <div class=\"bloc l-bloc bgc-white bloc-tile-3\" id=\"bloc-10\">\n");
      out.write("                    <div class=\"container bloc-lg\">\n");
      out.write("                        <div class=\"row animated pulse\">\n");
      out.write("                            <div class=\"col-sm-12\">\n");
      out.write("                                <form id=\"form_13634\" action=\"modificaractivo\" method=\"get\" >\n");
      out.write("                                    <h2 class=\"mg-md text-center\">Modificar Activo</h2>\n");
      out.write("                                    <h3 class=\"mg-md\">ID de Producto</h3>\n");
      out.write("                                   \n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <select name=\"opti\" class=\"form-control\" id=\"select_256\">\n");
      out.write("                                                        <option value=\"0\">Option 1</option>\n");
      out.write("                                                        <option value=\"1\">Option 2</option>\n");
      out.write("                                                        \n");
      out.write("                                                    </select>\n");
      out.write("                                                </div>\n");
      out.write("                                                <input  required name=\"cc1\" class=\"form-control\" id=\"entrarusuario\" required placeholder=\"Código\" />\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <label>Descripción</label>\n");
      out.write("                                        <textarea name=\"descripcionca\" id=\"descripcioneliminar_13634\" class=\"form-control\" rows=\"4\" cols=\"50\" required></textarea>\n");
      out.write("                                    </div> \n");
      out.write("                                        <button class=\"bloc-button btn btn-d btn-lg btn-block animated puffIn\" type=\"submit\">Modificar</button>\n");
      out.write("                                </form>\n");
      out.write("                            </div></div>\n");
      out.write("                    </div></div><!-- bloc-10 END --><!-- bloc-11 -->\n");
      out.write("                                <div class=\"bloc bloc-tile-3 bgc-white l-bloc\" id=\"bloc-11\">\n");
      out.write("                                    <div class=\"container bloc-lg\">\n");
      out.write("                                        \n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"col-sm-12\">\n");
      out.write("                                        \n");
      out.write("                                            </div>\n");
      out.write("                                                \n");
      out.write("                                        </div>\n");
      out.write("                                            \n");
      out.write("                                    </div>\n");
      out.write("                                            \n");
      out.write("                                </div><!-- bloc-11 END --><!-- bloc-12 -->\n");
      out.write("                                            <div class=\"bloc l-bloc bgc-white bloc-tile-3\" id=\"bloc-12\">\n");
      out.write("                                                <div class=\"container bloc-lg\">\n");
      out.write("                                                    <div class=\"row\"><div class=\"col-sm-12\">\n");
      out.write("                                                        \n");
      out.write("                                                        </div>\n");
      out.write("                                                            \n");
      out.write("                                                    </div>\n");
      out.write("                                                            \n");
      out.write("                                                </div></div><!-- bloc-12 END -->\n");
      out.write("            </div><!-- Bloc Group END --><!-- ScrollToTop Button -->\n");
      out.write("            <a class=\"bloc-button btn btn-d scrollToTop\" onclick=\"scrollToTarget('1')\">\n");
      out.write("                <span class=\"fa fa-chevron-up\"></span></a><!-- ScrollToTop Button END-->\n");
      out.write("        </div><!-- Main container END --> </body></html>");
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
