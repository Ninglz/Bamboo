package com.ninglz.fiction.domain.customer.gateway;

import com.ninglz.fiction.domain.customer.Customer;

public interface CustomerGateway {
    public Customer getByById(String customerId);
}
