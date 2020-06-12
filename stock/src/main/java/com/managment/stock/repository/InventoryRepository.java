package com.managment.stock.repository;

import com.managment.stock.model.StockDetails;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InventoryRepository extends CrudRepository<StockDetails,Integer> {

    List<StockDetails> findAll(Sort sort);
}
