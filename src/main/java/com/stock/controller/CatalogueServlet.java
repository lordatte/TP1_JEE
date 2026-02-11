package com.stock.controller;

import com.stock.model.Produit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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

        List<Produit> maListe = new ArrayList<>();
        maListe.add(new Produit(1, "Clavier", 25.0));
        maListe.add(new Produit(2, "Souris", 15.0));
        maListe.add(new Produit(3, "Écran", 120.0));

        request.setAttribute("listeProduits", maListe);

        request.getRequestDispatcher("/WEB-INF/vues/catalogue.jsp").forward(request, response);
    }






}