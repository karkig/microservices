package com.managment.stock.dao;

import com.managment.stock.model.StockDetails;

import java.util.List;
import java.util.Optional;

public interface StockInventoryDao {
    Optional<StockDetails> addStock(StockDetails stockDetails);
    Optional<StockDetails>  updateStock(StockDetails stockDetails);
    Optional<List<StockDetails>> get(String orderBy, String sortBy);
}
