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
import Proyecto1.Datos;

/**
 *
 * @author lMMl
 */
@WebServlet(name = "servletcrearusuario", urlPatterns = {"/servletcrearusuario"})
public class servletcrearusuario extends HttpServlet {

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
            out.println("<title>Servlet servletcrearusuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletcrearusuario at " + request.getContextPath() + "</h1>");
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
        
        Datos dato = new Datos();
        String Usuario=request.getParameter("usuarionu");
        String pass=request.getParameter("contrasenanu");
        String nom =request.getParameter("nombrenu");
        String depto=request.getParameter("departamentonu");
        String empresa=request.getParameter("empresanu");
        String Rdato = dato.AgregaraMatriz(Usuario, pass, nom, depto, empresa);
        if (Rdato.equals("Usuario insertado con exito!")){
            response.sendRedirect("index.jsp");
            request.getSession().setAttribute("mensajederegistro", "Registro del usuario "+Usuario+" exitoso!");
            request.getSession().setAttribute("llavemensajeregistro", "true");
        }else {
            response.sendRedirect("nuevousuario.jsp");
            request.getSession().setAttribute("mensajederegistro", "Error, intentolo de nuevo!");
            request.getSession().setAttribute("llavederegistro", "true");
        }
        
        System.out.println(Usuario+"    "+pass+"   "+nom+"  "+depto+"   "+empresa);
        
        
        ///processRequest(request, response);
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
