package com.learn.customerdata.service;

import com.learn.customerdata.entities.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {
    @Autowired
    CustomerService service;
    @Test
    public void contextLoad(){

    }

    @Test
    public void test_addCustomer(){
        Customer customer=new Customer();
        customer.setId(1);
        customer.setName("Barac Bush");
        customer.setEmail("barac.bush@gmail.com");
        service.addCustomer(customer);

        Customer customer2=new Customer();
        customer2.setId(2);
        customer2.setName("Tony Walker");
        customer2.setEmail("tony.walker@gmail.com");
        service.addCustomer(customer2);
    }

    @Test
    public void test_getCustomerById(){
        Customer customerById = service.getCustomerById(2);
        assertEquals(customerById.getName(),"Tony Walker");
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


}
