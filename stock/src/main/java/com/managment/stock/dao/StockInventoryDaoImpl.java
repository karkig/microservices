package com.managment.stock.dao;

import com.managment.stock.constants.AppConstants;
import com.managment.stock.model.StockDetails;
import com.managment.stock.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class StockInventoryDaoImpl implements StockInventoryDao {

    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public Optional<StockDetails>  addStock(StockDetails stockDetails) {
        return Optional.of(inventoryRepository.save(stockDetails));
    }

    @Override
    public Optional<StockDetails>  updateStock(StockDetails stockDetails) {
        Optional<StockDetails> stock = inventoryRepository.findById(stockDetails.getStockNumber());
        return stock.map(s->{
            s.setName(stockDetails.getName());
            s.setPurchaseDate(stockDetails.getPurchaseDate());
            s.setPurchaseQuantity(stockDetails.getPurchaseQuantity());
            s.setPurchasePrice(stockDetails.getPurchasePrice());
           return inventoryRepository.save(s);
        });

    }

    @Override
    public  Optional<List<StockDetails>> get(String orderBy,String sortBy) {
        List<StockDetails> stockDetailsList;
        if(AppConstants.ORDER_ASC.equals(orderBy)){
            stockDetailsList = inventoryRepository.findAll(Sort.by(Sort.Direction.ASC, sortBy));
        }else {
            stockDetailsList = inventoryRepository.findAll(Sort.by(Sort.Direction.DESC, sortBy));
        }
        return Optional.of(stockDetailsList);
    }
}