package com.ninglz.bamboo.upms.domain.customer.gateway;

import com.ninglz.bamboo.upms.domain.customer.Customer;

public interface CustomerGateway {
    public Customer getByById(String customerId);
}
