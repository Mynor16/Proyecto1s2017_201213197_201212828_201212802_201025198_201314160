package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class MenuUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <script src=\"./js/blocs.min.js\"></script> \n");
      out.write("        <title>MenuUsuario</title> <!-- Google Analytics --> <!-- Google Analytics END --> \n");
      out.write("    </head><body><!-- Main container -->\n");
      out.write("        <div class=\"page-container\"> <!-- bloc-0 -->\n");
      out.write("            <div class=\"bloc bgc-white l-bloc\" id=\"bloc-0\">\n");
      out.write("                <div class=\"container bloc-sm\">\n");
      out.write("                    <nav class=\"navbar nav-center row\">\n");
      out.write("                        <div class=\"navbar-header\">\n");
      out.write("                            <a class=\"navbar-brand\" href=\"index.html\"><img src=\"img/logo.png\" alt=\"logo\" /></a>\n");
      out.write("                            <button id=\"nav-toggle\" type=\"button\" class=\"ui-navbar-toggle navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-1\">\n");
      out.write("                                <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                                <span class=\"icon-bar\"></span>\n");
      out.write("                                <span class=\"icon-bar\"></span>\n");
      out.write("                                <span class=\"icon-bar\"></span>\n");
      out.write("                            </button>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"collapse navbar-collapse navbar-1\">\n");
      out.write("                            <ul class=\"site-navigation nav navbar-nav\">\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"index.html\">Inicio</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li><a href=\"registrar-usuario.html\">Registrar Usuario</a></li>\n");
      out.write("                                <li><a href=\"menuusuario.html\">Menu Usuario</a></li>\n");
      out.write("                                <li><a href=\"crearactivo.html\">Crear</a></li>\n");
      out.write("                                <li><a href=\"eliminaractivo.html\">Eliminar</a></li>\n");
      out.write("                                <li><a href=\"modificaractivo.html\">Modificar</a></li>\n");
      out.write("                                <li><a href=\"index.html\">Salir</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </nav>\n");
      out.write("                </div>\n");
      out.write("            </div><!-- bloc-0 END --><!-- bloc-3 -->\n");
      out.write("            <div class=\"bloc l-bloc bgc-white\" id=\"bloc-3\">\n");
      out.write("                <div class=\"container bloc-lg\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-sm-4\">\n");
      out.write("                            <div class=\"text-center\">\n");
      out.write("                                <span class=\"et-icon-pencil icon-round icon-md\"></span>\n");
      out.write("                            </div>\n");
      out.write("                            <a href=\"crearactivo.jsp\" class=\"btn btn-d btn-lg btn-rd btn-block\">Nuevo Activo</a>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-sm-4\">\n");
      out.write("                            <div class=\"text-center\">\n");
      out.write("                                <span class=\"et-icon-tools icon-round icon-md\"></span>\n");
      out.write("                            </div><a href=\"modificaractivo.jsp\" class=\"btn btn-d btn-lg btn-block\">Modificar Activo</a></div><div class=\"col-sm-4\">\n");
      out.write("                                <div class=\"text-center\"><span class=\"et-icon-caution icon-round icon-md\"></span>\n");
      out.write("                                </div><a href=\"eliminaractivo.jsp\" class=\"btn btn-d btn-lg btn-block\">Eliminar Activo</a></div></div></div></div><!-- bloc-3 END --><!-- ScrollToTop Button -->\n");
      out.write("                                <a class=\"bloc-button btn btn-d scrollToTop\" onclick=\"scrollToTarget('1')\"><span class=\"fa fa-chevron-up\"></span></a><!-- ScrollToTop Button END--></div><!-- Main container END --> </body></html>");
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
