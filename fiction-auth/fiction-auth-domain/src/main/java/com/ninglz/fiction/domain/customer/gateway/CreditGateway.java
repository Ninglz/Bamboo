package com.ninglz.fiction.domain.customer.gateway;

import com.ninglz.fiction.domain.customer.Customer;
import com.ninglz.fiction.domain.customer.Credit;

//Assume that the credit info is in antoher distributed Service
public interface CreditGateway {
    public Credit getCredit(String customerId);
}
