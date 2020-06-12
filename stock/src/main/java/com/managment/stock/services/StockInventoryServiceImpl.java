package com.managment.stock.services;

import com.managment.stock.dao.StockInventoryDao;
import com.managment.stock.dto.ApiResponse;
import com.managment.stock.dto.SearchResponse;
import com.managment.stock.model.StockDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StockInventoryServiceImpl implements StockInventoryService {

    @Autowired
    StockInventoryDao stockInventoryDao;

    @Override
    public ApiResponse addStock(StockDetails stockDetails) {
        return prepareResponse(stockInventoryDao.addStock(stockDetails));
    }

    @Override
    public ApiResponse updateStock(StockDetails stockDetails) {
        return prepareResponse(stockInventoryDao.updateStock(stockDetails));
    }

    @Override
    public SearchResponse get(String orderBy,String sortBy) {
        Optional<List<StockDetails>> stockDetailsList = stockInventoryDao.get(orderBy, sortBy);
        return prepareSearchResult(stockDetailsList);
    }

    private ApiResponse prepareResponse(Optional<StockDetails> optional) {
        return optional.map(stockDetails ->
                new ApiResponse("Stock saved successfully with id: " + stockDetails.getStockNumber(), true))
                .orElse(new ApiResponse("Unable to add stock", false));
    }
    private SearchResponse prepareSearchResult(Optional<List<StockDetails>> stockDetailsList)
    {
        return stockDetailsList.map(e->{
            SearchResponse searchResponse = new SearchResponse();
            searchResponse.setStocks(e);
            searchResponse.setMessage("Data fetch with size :"+e.size());
            searchResponse.setStatus(true);
            return searchResponse;
        }).orElse(new SearchResponse());
    }
}
