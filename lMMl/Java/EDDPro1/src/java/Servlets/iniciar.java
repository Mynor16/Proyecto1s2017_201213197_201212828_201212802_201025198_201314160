/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Proyecto1.Datos;

/**
 *
 * @author lMMl
 */
@WebServlet(name = "iniciar", urlPatterns = {"/iniciar"})
public class iniciar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
           
        
        
        
        try (PrintWriter out = response.getWriter()) {
            
         
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet iniciar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet iniciar at " + 2+"--"+2 + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String a = request.getParameter("cc1");
        String b = request.getParameter("cc2");
        String c = request.getParameter("cc3");
        String d = request.getParameter("cc4");
        
        Datos dato = new Datos();
        System.out.println(a+"  "+b+"  "+c+"  "+d);
        String verificadoke = dato.VerificarUsuario(a, b, c, d);
        
        if (verificadoke.equals("True")){
            request.getSession().setAttribute("usuariolog", a);
            request.getSession().setAttribute("empresalog", c);
            request.getSession().setAttribute("departamentolog", d);
            response.sendRedirect("menuusuario.jsp");
        } else {
            response.sendRedirect("index.jsp");
            request.getSession().setAttribute("mensajederegistro", "Datos incorrectos, intentelo de nuevo!");
            request.getSession().setAttribute("llavedegistro", "true");
        }
        
        
        
        
        //processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
