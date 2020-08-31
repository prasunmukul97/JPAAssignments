package com.learn.customerdata.service;

import com.learn.customerdata.entities.Customer;
import com.learn.customerdata.repos.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {
    @Autowired
    CustomerService service;

    @Autowired
    CustomerRepository repository;

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


}
