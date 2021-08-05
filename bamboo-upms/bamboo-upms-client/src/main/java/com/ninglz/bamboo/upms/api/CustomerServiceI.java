package com.ninglz.bamboo.upms.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.ninglz.bamboo.upms.dto.CustomerAddCmd;
import com.ninglz.bamboo.upms.dto.CustomerListByNameQry;
import com.ninglz.bamboo.upms.dto.data.CustomerDTO;

public interface CustomerServiceI {

    public Response addCustomer(CustomerAddCmd customerAddCmd);

    public MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry);
}
