package com.learn.customerdata.repos;

import com.learn.customerdata.entities.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer> {

    List<Customer> findByEmailAndName(String email, String name);
    List<Customer> findByEmailIsLike(String key);
    List<Customer> findByIdIn(List<Integer> ids);

    @Modifying
    @Query("update Customer cust set cust.email =:email where cust.id=:id")
    void updateCustomerEmail(@Param("id") int id, @Param("email")String email);

    @Query("from Customer")
    List<Customer> findAllCustomers();
}
