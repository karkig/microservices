package com.managment.stock.services;

import com.managment.stock.dto.ApiResponse;
import com.managment.stock.dto.SearchResponse;
import com.managment.stock.model.StockDetails;
import org.springframework.stereotype.Service;

@Service
public interface StockInventoryService {

    ApiResponse addStock(StockDetails stockDetails);
    ApiResponse updateStock(StockDetails stockDetails);
    SearchResponse get(String orderBy, String sortBy);


}
