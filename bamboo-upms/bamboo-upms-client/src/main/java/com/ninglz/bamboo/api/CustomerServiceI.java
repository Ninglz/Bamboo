package com.ninglz.bamboo.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.ninglz.bamboo.dto.CustomerAddCmd;
import com.ninglz.bamboo.dto.CustomerListByNameQry;
import com.ninglz.bamboo.dto.data.CustomerDTO;

public interface CustomerServiceI {

    public Response addCustomer(CustomerAddCmd customerAddCmd);

    public MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry);
}
