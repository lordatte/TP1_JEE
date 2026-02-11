package com.stock.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet({"/connexion","/login"})
public class FormulaireServlet extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/vues/login.jsp")
                .forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if ("admin".equals(login) && "123".equals(password)) {
            request.getSession().setAttribute("user", "admin");
            response.sendRedirect(request.getContextPath() + "/catalogue");
        } else {
            request.setAttribute("erreur", "Login ou mot de passe incorrect");
            request.getRequestDispatcher("/WEB-INF/vues/login.jsp")
                    .forward(request, response);
        }
    }







}
