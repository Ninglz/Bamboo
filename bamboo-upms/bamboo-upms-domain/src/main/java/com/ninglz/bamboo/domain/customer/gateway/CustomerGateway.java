package com.ninglz.bamboo.domain.customer.gateway;

import com.ninglz.bamboo.domain.customer.Customer;

public interface CustomerGateway {
    public Customer getByById(String customerId);
}
