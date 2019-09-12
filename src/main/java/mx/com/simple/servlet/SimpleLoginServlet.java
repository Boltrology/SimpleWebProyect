/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.simple.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RGC
 */
@WebServlet(name = "SimpleLoginServlet", urlPatterns = {"/login.do"})
public class SimpleLoginServlet extends HttpServlet {

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
        String user = request.getParameter("email");
        String password = request.getParameter("password");
        RequestDispatcher rd = request.getRequestDispatcher("response.jsp");

        if (user.equals("rodrigo@garcia.com") && password.equals("holamundo")) {
            request.setAttribute("response", "Bienvenido, Rodrigo!!");
        } else if (user.equals("miguel@angel.com") && password.equals("holamundo")) {
            request.setAttribute("response", "Bienvenido, Miguel Angel!!");
        } else if (user.equals("karen@abigail.com") && password.equals("holamundo")) {
            request.setAttribute("response", "Bienvenido, Karen!!");
        } else {
            request.setAttribute("response", "No se pudo autenticar el usuario");
        }
        
        rd.forward(request, response);
    }

}
