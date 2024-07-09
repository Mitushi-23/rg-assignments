package com.springbatch.Customer_SpringBatch.config;

import org.springframework.batch.item.ItemProcessor;

import com.springbatch.Customer_SpringBatch.entity.Customer;

public class CustomerProcessor implements ItemProcessor<Customer, Customer>{
    
    @Override
    public Customer process(Customer customer) throws Exception{
        if (customer.getCountry().equals("United States")) {
            return customer;
        }
        else
        {
            return null;
        }
    }
}
