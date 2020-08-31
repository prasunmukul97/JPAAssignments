package com.learn.customerdata.repos;

import com.learn.customerdata.entities.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CustomerPagingAndSortingRepo extends PagingAndSortingRepository<Customer,Integer> {

    List<Customer> findByIdIn(List<Integer> ids, Pageable pageable);
}
