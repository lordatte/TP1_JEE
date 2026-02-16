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

        System.out.println("🔹 Starting findAll()...");

        try {
            // 1️⃣ Check Driver
            System.out.println("🔹 Loading MySQL Driver...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ Driver loaded successfully!");

            // 2️⃣ Connect
            System.out.println("🔹 Connecting to database...");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Connected to database!");

            // 3️⃣ Execute Query
            System.out.println("🔹 Executing query...");
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println("✅ Query executed successfully!");

            // 4️⃣ Read Results
            while (rs.next()) {
                Produit p = new Produit();
                p.setId(rs.getInt("ID"));
                p.setNom(rs.getString("NOM"));
                p.setPrix(rs.getDouble("PRIX"));

                System.out.println("📦 Found product: " + p.getNom());

                liste.add(p);
            }

            rs.close();
            ps.close();
            connection.close();

            System.out.println("✅ Connection closed.");

        } catch (ClassNotFoundException e) {
            System.out.println("❌ MySQL Driver NOT FOUND!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ SQL ERROR OCCURRED!");
            System.out.println("Message: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());
            e.printStackTrace();
        }

        System.out.println("🔹 findAll() finished.");

        return liste;
    }
}
