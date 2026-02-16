package com.stock.service;

import com.stock.dao.ProduitDAO;
import com.stock.dao.ProduitDAOImpl;
import com.stock.model.Produit;

import java.util.List;

public class StockServiceImpl implements IStockService {

    // Service talks to DAO
    private ProduitDAO dao = new ProduitDAOImpl();

    @Override
    public List<Produit> recupererCatalogueFiltre() {

        // Here you can add business logic
        // Example: filter products, check stock, etc.

        return dao.findAll();
    }
}
