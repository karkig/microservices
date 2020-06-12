package com.stock.managment.search.searchstock.consumer;

import com.stock.managment.search.searchstock.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class JmsConsumer {

    @JmsListener(destination = "${gkz.activemq.queue}", containerFactory="jsaFactory")
    public void receive(Customer customer){
        System.out.println("Recieved Message: " + customer.getFirstname());

    }
}