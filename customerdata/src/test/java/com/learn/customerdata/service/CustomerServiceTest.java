package com.learn.customerdata.service;

import com.learn.customerdata.entities.Customer;
import com.learn.customerdata.repos.CustomerPagingAndSortingRepo;
import com.learn.customerdata.repos.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {
    @Autowired
    CustomerService service;

    @Autowired
    CustomerRepository repository;

    @Autowired
    CustomerPagingAndSortingRepo pagingAndSortingRepo;

    @Test
    public void contextLoad(){

    }

    @Test
    public void test_addCustomer(){
        Customer customer=new Customer();
        customer.setName("Barac Bush");
        customer.setEmail("barac.bush@gmail.com");
        service.addCustomer(customer);

        Customer customer2=new Customer();
        customer2.setName("Tony Walker");
        customer2.setEmail("tony.walker@gmail.com");
        service.addCustomer(customer2);


        Customer customer3=new Customer();
        customer3.setName("Tony3 Walker3");
        customer3.setEmail("tony3.walker3@gmail.com");
        service.addCustomer(customer3);


        Customer customer4=new Customer();
        customer4.setName("Tony Walker4");
        customer4.setEmail("tony4.walker4@gmail.com");
        service.addCustomer(customer4);


        Customer customer5=new Customer();
        customer5.setName("Tony Walker5");
        customer5.setEmail("tony5.walker5@gmail.com");
        service.addCustomer(customer5);


        Customer customer6=new Customer();
        customer6.setName("Tony Walker6");
        customer6.setEmail("tony6.walker6@gmail.com");
        service.addCustomer(customer6);


        Customer customer7=new Customer();
        customer7.setName("Tony Walker7");
        customer7.setEmail("tony7.walker7@gmail.com");
        service.addCustomer(customer7);


        Customer customer8=new Customer();
        customer8.setName("Tony8 Walker8");
        customer8.setEmail("tony8.walker8@gmail.com");
        service.addCustomer(customer8);


        Customer customer9=new Customer();
        customer9.setName("Tony9 Walker9");
        customer9.setEmail("tony9.walker9@gmail.com");
        service.addCustomer(customer9);


        Customer customer10=new Customer();
        customer10.setName("Tony Walker10");
        customer10.setEmail("tony10.walker10@gmail.com");
        service.addCustomer(customer10);

    }

    @Test
    public void test_getCustomerById(){
        Customer customerById = service.getCustomerById(2);
        assertEquals(customerById.getName(),"Tony Walker1");
    }

    @Test
    public void test_updateCustomer(){
        Customer customer2=new Customer();
        customer2.setId(2);
        customer2.setName("Tony Walker1");
        customer2.setEmail("tony.walker1@gmail.com");
        service.updateCustomer(customer2);
    }

    @Test
    public void test_deleteCustomer(){
        service.deleteCustomer(1);
    }

    @Test
    public void test_findByEmailAndName(){
        List<Customer> customers = repository.findByEmailAndName("tony.walker1@gmail.com", "Tony Walker1");
        customers.forEach(customer -> System.out.println(customer.getName()));
    }

    @Test
    public void test_findByEmailIsLike(){
        List<Customer> customers = repository.findByEmailIsLike("tony.walker1@gmail.com");
        customers.forEach(customer -> System.out.println(customer.getName()));
    }

    @Test
    public void test_findByIdIn(){
        List<Customer> customers = repository.findByIdIn(Arrays.asList(4,5,6));
        customers.forEach(customer -> System.out.println(customer.getName()));
    }

    @Test
    @Transactional
    @Rollback(false)
    public void test_updateCustomerEmail(){
        repository.updateCustomerEmail(4,"prasun.saurabh123@gmail.com");
        Optional<Customer> customer = repository.findById(4);
        System.out.println(customer.get());
    }

    @Test
    public void test_findAllCustomers(){
        Pageable pageRequest= PageRequest.of(0,2);
        List<Customer> customers = repository.findAllCustomers();
        customers.forEach(customer -> System.out.println(customer.getName()));
    }

    @Test
    public void test_pagingAndSorting2(){
        Pageable pageRequest= PageRequest.of(0,2);
        List<Customer> customers = pagingAndSortingRepo.findByIdIn(Arrays.asList(2,3,4,5,6,7,8,9,10),pageRequest);
        customers.forEach(customer -> System.out.println(customer.getName()));
    }

    @Test
    public void test_pagingAndSorting5(){
        Pageable pageRequest= PageRequest.of(0,5);
        List<Customer> customers = pagingAndSortingRepo.findByIdIn(Arrays.asList(2,3,4,5,6,7,8,9,10),pageRequest);
        customers.forEach(customer -> System.out.println(customer.getName()));
    }
    @Test
    public void test_sortCustomerByNameInDesc(){
        Pageable pageRequest= PageRequest.of(0,5, Sort.by(new Sort.Order(Sort.Direction.DESC,"name")));
        Page<Customer> allCustomers = pagingAndSortingRepo.findAll(pageRequest);
        Stream<Customer> customers = allCustomers.get();
        customers.forEach(customer -> System.out.println(customer.getName()));
    }

}
