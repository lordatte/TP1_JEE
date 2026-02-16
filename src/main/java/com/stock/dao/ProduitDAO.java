package com.stock.dao;

import com.stock.model.Produit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAO {

    private static final String URL =
            "jdbc:mysql://localhost:3306/stockdb?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

    private static final String USER = "root";
    private static final String PASSWORD = "199719971997aA";

    public List<Produit> findAll() {

        List<Produit> liste = new ArrayList<>();
        String sql = "SELECT * FROM PRODUITS";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produit p = new Produit();
                p.setId(rs.getInt("ID"));
                p.setNom(rs.getString("NOM"));
                p.setPrix(rs.getDouble("PRIX"));
                liste.add(p);
            }

            rs.close();
            ps.close();
            connection.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return liste;
    }
}
