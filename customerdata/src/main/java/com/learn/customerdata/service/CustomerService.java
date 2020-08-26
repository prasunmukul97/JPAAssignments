package com.learn.customerdata.service;

import com.learn.customerdata.entities.Customer;
import com.learn.customerdata.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;

    public void addCustomer(Customer customer) {
        repository.save(customer);
    }

    public Customer getCustomerById(Integer customerId) {
        Optional<Customer> customer = repository.findById(customerId);
        return customer.orElse(new Customer());
    }

    public String updateCustomer(Customer customer) {
        Optional<Customer> customerOptional = repository.findById(customer.getId());
        if(customerOptional.isPresent()){
            Customer customerAvailable = customerOptional.get();
            customerAvailable.setEmail(customer.getEmail());
            customerAvailable.setName(customer.getName());
            repository.save(customerAvailable);
        };
        return "Update Successful";
    }


    public void deleteCustomer(Integer customerId) {
         repository.deleteById(customerId);
    }
}
