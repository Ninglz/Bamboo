package com.ninglz.bamboo.upms.domain.customer.gateway;

import com.ninglz.bamboo.upms.domain.customer.Credit;

//Assume that the credit info is in antoher distributed Service
public interface CreditGateway {
    public Credit getCredit(String customerId);
}
