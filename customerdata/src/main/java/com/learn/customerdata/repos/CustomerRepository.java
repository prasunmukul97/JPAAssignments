package com.learn.customerdata.repos;

import com.learn.customerdata.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer> {

    List<Customer> findByEmailAndName(String email, String name);
    List<Customer> findByEmailIsLike(String key);
    List<Customer> findByIdIn(List<Integer> ids);
}
