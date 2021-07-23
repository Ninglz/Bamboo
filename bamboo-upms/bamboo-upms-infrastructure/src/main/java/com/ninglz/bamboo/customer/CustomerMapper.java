package com.ninglz.bamboo.customer;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper{

  public CustomerDO getById(String customerId);
}
