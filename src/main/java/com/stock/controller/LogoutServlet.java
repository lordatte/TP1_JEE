package com.stock.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{


    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpServletRequest  req=request;

        HttpSession session = req.getSession(false);
        if(session!=null){
            session.invalidate();
            response.sendRedirect(req.getContextPath() + "/login");
        }



    }







}
