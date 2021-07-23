package com.ninglz.bamboo.web;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.ninglz.bamboo.api.CustomerServiceI;
import com.ninglz.bamboo.dto.CustomerAddCmd;
import com.ninglz.bamboo.dto.CustomerListByNameQry;
import com.ninglz.bamboo.dto.data.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerServiceI customerService;

    @GetMapping(value = "/helloworld")
    public String helloWorld(){
        return "Hello, welcome to COLA world!";
    }

    @GetMapping(value = "/customer")
    public MultiResponse<CustomerDTO> listCustomerByName(@RequestParam(required = false) String name){
        CustomerListByNameQry customerListByNameQry = new CustomerListByNameQry();
        customerListByNameQry.setName(name);
        return customerService.listByName(customerListByNameQry);
    }

    @PostMapping(value = "/customer")
    public Response addCustomer(@RequestBody CustomerAddCmd customerAddCmd){
        return customerService.addCustomer(customerAddCmd);
    }
}
