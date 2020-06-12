package com.managment.stock.dto;

import com.managment.stock.model.StockDetails;

import java.util.List;

public class SearchResponse extends ApiResponse {
    List<StockDetails> stocks;

    public List<StockDetails> getStocks() {
        return stocks;
    }

    public void setStocks(List<StockDetails> stocks) {
        this.stocks = stocks;
    }
}
