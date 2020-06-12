package com.managment.stock.controllers;


import com.managment.stock.constants.AppConstants;
import com.managment.stock.dto.ApiResponse;
import com.managment.stock.dto.SearchResponse;
import com.managment.stock.model.StockDetails;
import com.managment.stock.services.StockInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class StockInventoryController {

    @Autowired
    StockInventoryService inventoryService;

    @PostMapping(value = "/api/stock")
    public ResponseEntity<ApiResponse> addStock(@RequestBody StockDetails stockDetails) {
        return new ResponseEntity<>(inventoryService.addStock(stockDetails), HttpStatus.OK);
    }

    @PutMapping(value = "/api/stock")
    public ApiResponse updateStock(@RequestBody StockDetails stockDetails) {
        return inventoryService.updateStock(stockDetails);
    }

    @GetMapping(value = "/api/stock")
    public SearchResponse search(@RequestParam(value = "order_by", required = false, defaultValue = AppConstants.ORDER_ASC) String orderBy,
                                 @RequestParam(value = "sort_by", required = false,defaultValue = AppConstants.SORT_BY) String sortBy) {
        return inventoryService.get(orderBy,sortBy);

    }
}