package com.ninglz.bamboo.auth.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.ninglz.bamboo.auth.dto.CustomerAddCmd;
import com.ninglz.bamboo.auth.dto.CustomerListByNameQry;
import com.ninglz.bamboo.auth.dto.data.CustomerDTO;

public interface CustomerServiceI {

    public Response addCustomer(CustomerAddCmd customerAddCmd);

    public MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry);
}
