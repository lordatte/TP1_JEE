package com.stock.controller;

import com.stock.model.Produit;
import com.stock.dao.ProduitDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/catalogue")
public class CatalogueServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProduitDAO dao = new ProduitDAO();
        List<Produit> maListe = dao.findAll();

        request.setAttribute("listeProduits", maListe);

        Cookie[] cookies = request.getCookies();
        String lastVisit = null;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("lastVisit".equals(c.getName())) {
                    lastVisit = c.getValue();
                }
            }
        }

        request.setAttribute("lastVisit", lastVisit);

        String dateFormatee = java.time.LocalDateTime.now()
                .format(java.time.format.DateTimeFormatter
                        .ofPattern("dd-MM-yyyy_HH-mm-ss"));

        Cookie newCookie = new Cookie("lastVisit", dateFormatee);

        newCookie.setMaxAge(60 * 60 * 24);
        newCookie.setHttpOnly(true);
        newCookie.setPath("/");

        response.addCookie(newCookie);



        request.getRequestDispatcher("/WEB-INF/vues/catalogue.jsp").forward(request, response);
    }






}